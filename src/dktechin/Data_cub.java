package dktechin;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Data_cub {
    private static Data_cub instance;
    // 데이터를 저장하는 맵(알파벳-숫자 쌍)
    private final List<ConcurrentHashMap.Entry<String, Integer>> dataList = Collections.synchronizedList(new ArrayList<>());
    // 사용된 알파벳을 추적하는 세트
    private final Set<String> usedAlphabets = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
    // 동기화를 위한 락
    private final Lock lock = new ReentrantLock();
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

    public List<Map.Entry<String, Integer>> getDataList() {
        return dataList;
    }
}



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

            if (uniqueStrings.add(alphabet)) {
                try {
                    queue.put(new AbstractMap.SimpleEntry<>(alphabet, number));
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
    private volatile boolean done = false;

    public Consumer(BlockingQueue<Map.Entry<String, Integer>> queue, CountDownLatch latch) {
        this.queue = queue;
        this.storage = Data_cub.getInstance();
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            while (!done || !queue.isEmpty()) {
                Map.Entry<String, Integer> entry = queue.poll(100, java.util.concurrent.TimeUnit.MILLISECONDS);
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


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        // 블로킹 큐 생성
        BlockingQueue<Map.Entry<String, Integer>> queue = new LinkedBlockingQueue<>();
        int totalDataCount = 7000000;
        CountDownLatch latch = new CountDownLatch(totalDataCount);

        // 생산자 및 소비자 쓰레드 생성
        Thread producerThread = new Thread(new Producer(queue,latch,totalDataCount));
        Thread consumerThread = new Thread(new Consumer(queue,latch));

        int choice = 0;
        System.out.println("저장한 데이터에서 특정 문자열을 입력하세요.");
        // 쓰레드 시작
        producerThread.start();
        consumerThread.start();

        // 생산자 쓰레드가 작업을 완료할 때까지 대기
        producerThread.join();
        // 소비자 쓰레드 인터럽트(강제 종료)
        latch.await();
        consumerThread.interrupt();
        consumerThread.join();

        // 데이터 저장소 인스턴스 가져오기
        Data_cub storage = Data_cub.getInstance();
        // 생성된 데이터 크기 출력
        System.out.println("Generated data size: " + storage.getDataList().size());
        System.out.println("저장한 데이터에서 특정 문자열을 입력하세요:");
        String input = sc.nextLine();

        // 입력한 문자열 값에 매칭된 숫자 찾기
        List<Integer> results = storage.getData(input);
        if (!results.isEmpty()) {
            System.out.println("추출된 결과 값: " + results);
        } else {
            System.out.println("일치하는 값이 없습니다.");
        }
    }
}
