package dktechin;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Data_cub {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        // 블로킹 큐 생성
        BlockingQueue<Map.Entry<String, Integer>> queue = new LinkedBlockingQueue<>();
        int totalDataCount = 7000000;
        CountDownLatch latch = new CountDownLatch(totalDataCount);

        // 생산자 및 소비자 쓰레드 생성
        Thread producerThread = new Thread(new Producer(queue, latch, totalDataCount));
        Thread consumerThread = new Thread(new Consumer(queue, latch));

        int choice = 0;
        // 쓰레드 시작
        long producerStartTime = System.currentTimeMillis();
        producerThread.start();
        consumerThread.start();

        // 생산자 쓰레드가 작업을 완료할 때까지 대기
        producerThread.join();
        long producerEndTime = System.currentTimeMillis();
        System.out.println("Producer thread execution time: " + (producerEndTime - producerStartTime) + " ms");
        long consumerStartTime = System.currentTimeMillis();
        latch.await(); // 모든 데이터가 처리될 때 까지 대기
        consumerThread.interrupt(); // 소비자 쓰레드 인터럽트 (강제종료)
        consumerThread.join(); // 소비자 쓰레드가 끝날 때 까지 대기
        long consumerEndTime = System.currentTimeMillis(); // 소비자 종료 시간 기록
        System.out.println("Consumer thread execution time: " + (consumerEndTime - consumerStartTime) + " ms");

        // 데이터 저장소 인스턴스 가져오기
        Data_cub storage = Data_cub.getInstance();
        // 생성된 데이터 크기 출력
        System.out.println("Generated data size: " + storage.getDataList().size());
        while (true) {
            System.out.println("1. 저장한 데이터에서 특정 문자열을 입력 2.저장한 데이터에서 임의의 숫자를 입력하여 해당하는 문자열 찾기 3.prefix");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("저장한 데이터에서 특정 문자열을 입력하세요:");
                String input = sc.next();

                // 입력한 문자열 값에 매칭된 숫자 찾기
                long startTime = System.currentTimeMillis();
                List<Integer> results = storage.getData(input);
                long endTime = System.currentTimeMillis();
                System.out.println("Execution time for choice 2: " + (endTime - startTime) + " ms");

                if (!results.isEmpty()) {
                    System.out.println("추출된 결과 값: " + results);
                } else {
                    System.out.println("일치하는 값이 없습니다.");
                }
            } else if (choice == 2) {
                System.out.println("저장한 데이터에서 특정 숫자를 입력하세요:");
                int input = sc.nextInt();
                List<String> results = storage.getString(input);
                if (!results.isEmpty()) {
                    System.out.println("추출된 결과 값: " + results);
                } else {
                    System.out.println("일치하는 값이 없습니다.");
                }
            }else if (choice == 3) {
                System.out.println("저장한 데이터에서 접두사에 매칭되는 문자열을 입력하세요:");
                String input = sc.next();
                long startTime = System.currentTimeMillis();
                Map<Integer, Long> countMap = new HashMap<>();
                Map<String, List<Integer>> resultMap2 = new HashMap<>();
                List<Integer> results = new ArrayList<>();

                for (String key : storage.getAllKeys()) {
                    if (input.startsWith(key)) {
                        List<Integer> values = storage.getData(key);
                        resultMap2.put(key, values);
                        for (Integer value : values) {
                            countMap.put(value, countMap.getOrDefault(value, 0L) + 1);
                        }
                    }
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Execution time for choice 2: " + (endTime - startTime) + " ms");
                List<String> sortedKeys = new ArrayList<>(resultMap2.keySet());
                sortedKeys.sort(Comparator.comparingInt(String::length));

                System.out.println("추출된 결과 값:");
                for (String key : sortedKeys) {
                    for (Integer value : resultMap2.get(key)) {
                        System.out.println(key + " - " + value);
                    }
                }
                //    for (Map.Entry<String, List<Integer>> entry : resultMap2.entrySet()) {
                //         for (Integer value : entry.getValue()) {
                //            System.out.println(entry.getKey() + " - " + value);
                //         }
                //       }

                System.out.println("숫자별 개수:");
                for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue() + "개");
                }
            }
        }
    }


    private static Data_cub instance;
    // 데이터를 저장하는 맵(알파벳-숫자 쌍)
    private final List<ConcurrentHashMap.Entry<String, Integer>> dataList = Collections.synchronizedList(new ArrayList<>());
    // 사용된 알파벳을 추적하는 세트
    private final Set<String> usedAlphabets = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
    // 동기화를 위한 락
    private final Lock lock = new ReentrantLock();
    private Map<String ,List<Integer>> dataMap;
    private Data_cub() { // 생성자

    }
    public static Data_cub getInstance() {
        if (instance == null) { // 초기화되지 않았는지 확인
            synchronized (Data_cub.class) { // 다중 스레드 환경에서 동기화 블록을 사용하여 한 번에 하나의 스레드만 instance를 초기화 할 수 있도록 합니다.
                if (instance == null) { // 이중검사
                    instance = new Data_cub(); // 인스턴스 초기화
                }
            }
        }
        return instance; // 초기화된 인스턴스 반환
    }

    public void addData(String alphabet, int number) {
        lock.lock(); // 동기화 시작 락 걸어서 막고
        try {
            dataList.add(new AbstractMap.SimpleEntry<>(alphabet, number));
        } finally {
            lock.unlock(); // 동기화 종료 다 하면 락 풀고
        }
    }
    // 특정 문자열 값에 매칭된 숫자를 반환하는 메서드 추가
    public List<Integer> getData(String alphabet) {
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dataList) {
            if (entry.getKey().equals(alphabet)) {
                results.add(entry.getValue());
            }
        }
        return results;
    }

    public void printData() {
        synchronized (dataList) {
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }
    public List<String> getString(int num) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dataList) {
            if (entry.getValue().equals(num)) {
                results.add(entry.getKey());
            }
        }
        return results;
    }

    public synchronized Set<String> getAllKeys() {
        Set<String> keySet = new HashSet<>();

        synchronized (dataList) {
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                keySet.add(entry.getKey());
            }
        }

        return keySet;
    }

    public List<Map.Entry<String, Integer>> getDataList() {
        return dataList;
    }
}


/* 문자 4번 쓰레드 이용해서 같이 작업하기 진행중
class Proset implements Runnable {
    private final Set<String> keySet = new HashSet<>();


    @Override
    public void run() {
        synchronized (dataList) {
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                keySet.add(entry.getKey());
            }
        }
    }
}
*/
// 생산자 쓰레드 클래스
class Producer implements Runnable {
    private final BlockingQueue<Map.Entry<String, Integer>> queue;
    private final CountDownLatch latch;
    private final int totalDataCount;
    private final Set<String> uniqueStrings;
    private final Random random;

    // 생성자
    public Producer(BlockingQueue<Map.Entry<String, Integer>> queue, CountDownLatch latch, int totalDataCount) {
        this.queue = queue;
        this.latch = latch;
        this.totalDataCount = totalDataCount;
        this.uniqueStrings = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public void run() {
        // 7000000번 반복하여 랜덤 데이터 생성 및 큐에 삽입
        while (uniqueStrings.size() < totalDataCount) {
            String alphabet = generateRandomString(52);
            int number = random.nextInt(10000); // 0 ~ 9999

            // 중복되지 않을 경우 큐에 데이터 삽입
            if (uniqueStrings.add(alphabet)) {
                try {
                    queue.put(new AbstractMap.SimpleEntry<>(alphabet, number)); // 큐에 데이터 삽입
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // 작업완료 신호
                }
            }
        }
    }
    private String generateRandomString(int maxLength) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = random.nextInt(maxLength) + 1; // 1에서 maxLength 사이의 길이
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Map.Entry<String, Integer>> queue;
    private final Data_cub storage; // 인스턴스 불러오고
    private final CountDownLatch latch;
    private volatile boolean done = false; // 변수의 최신값을 모든 스레드가 일관되게 볼 수 있게 volatile 씀 재정렬을 방지함

    public Consumer(BlockingQueue<Map.Entry<String, Integer>> queue, CountDownLatch latch) {
        this.queue = queue;
        this.storage = Data_cub.getInstance();
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // done이 false이거나 큐가 비어있지 않다면 반복
            while (!done || !queue.isEmpty()) {
                Map.Entry<String, Integer> entry = queue.poll(100, java.util.concurrent.TimeUnit.MILLISECONDS); //큐에서 데이터 가져오기
                if (entry != null) {
                    storage.addData(entry.getKey(), entry.getValue());
                }
                if (latch.getCount() == 0) {
                    done = true;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("소비자 종료");
        }
    }

}
