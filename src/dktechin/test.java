package dktechin;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    private static final int TARGET_COUNT = 7000000; // 목표 데이터 개수
    private static final int MAX_STRING_LENGTH = 4;  // 문자열의 최대 길이
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 사용할 문자 집합
    private static final Random random = new Random(); // 랜덤 생성기

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis(); // 시작 시간 기록

        // 생산자-소비자 패턴을 위한 큐
        BlockingQueue<Map.Entry<String, Integer>> queue = new ArrayBlockingQueue<>(100);
        // 생성된 문자열을 저장할 집합 (중복 방지)
        Set<String> generatedStrings = Collections.synchronizedSet(new HashSet<>());
        // 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // 생산자 작업 정의
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (generatedStrings.size() < TARGET_COUNT) {
                    String str = generateRandomString(); // 랜덤 문자열 생성
                    synchronized (generatedStrings) {
                        if (!generatedStrings.contains(str) && generatedStrings.size() < TARGET_COUNT) {
                            generatedStrings.add(str); // 집합에 문자열 추가
                            try {
                                queue.put(new AbstractMap.SimpleEntry<>(str, random.nextInt(10000))); // 큐에 데이터 삽입
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        };

        // 소비자 작업 정의
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 큐에서 데이터 가져오기
                        Map.Entry<String, Integer> entry = queue.take();
                        // 데이터 저장소에 저장
                        DataStore.getInstance().store(entry.getKey(), entry.getValue());
                        // 목표 개수에 도달하면 종료
                        if (DataStore.getInstance().size() >= TARGET_COUNT) break;
                    } catch (InterruptedException e) {
                        // 인터럽트가 발생하면 현재 스레드를 인터럽트 상태로 설정
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        // 생산자 및 소비자 스레드 실행
        executorService.submit(producer);
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executorService.submit(consumer);
        }

        // 스레드 풀 종료 및 작업 완료 대기
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        long endTime = System.currentTimeMillis(); // 종료 시간 기록
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
        System.out.println("Generated " + DataStore.getInstance().size() + " unique strings.");
    }

    // 랜덤 문자열 생성 메소드
    private static String generateRandomString() {
        int length = random.nextInt(MAX_STRING_LENGTH) + 1; // 1~4 길이의 문자열 생성
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}

// 싱글톤 패턴을 적용한 데이터 저장소 클래스
class DataStore {
    private static DataStore instance;
    private final Map<String, Integer> data = new ConcurrentHashMap<>(); // 안전한 동시 접근을 위한 ConcurrentHashMap
    private final AtomicInteger count = new AtomicInteger(0); // 저장된 데이터 개수

    private DataStore() {}

    // 싱글톤 인스턴스 반환 메소드
    public static synchronized DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    // 데이터 저장 메소드
    public void store(String key, int value) {
        data.put(key, value);
        count.incrementAndGet();
    }

    // 저장된 데이터 개수 반환 메소드
    public int size() {
        return count.get();
    }
}