package dktechin;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Data_cub {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        BlockingQueue<Map.Entry<String, Integer>> queue = new LinkedBlockingQueue<>();
        int totalDataCount = 7000000; // 총 7백만개

        CountDownLatch latch = new CountDownLatch(totalDataCount); // 7백만개 만큼 반복

        // 데이터생성 쓰레드 및 데이터 옮김 쓰레드 생성
        Thread createDataThread = new Thread(new CreateData(queue, latch, totalDataCount));
        Thread moveDataThread = new Thread(new MoveData(queue, latch));

        // 쓰레드 시작
        long createDataStartTime = System.currentTimeMillis();
        createDataThread.start();
        moveDataThread.start();
        long moveDataStartTime = System.currentTimeMillis();
        // 생산자 쓰레드가 작업을 완료할 때까지 메인쓰레드가 대기 생산자가 끝난 후 다음 코드들 실행
        createDataThread.join();
        long createDataEndTime = System.currentTimeMillis();

        System.out.println("데이터 생성 쓰레드 시간 : " + (createDataEndTime - createDataStartTime) + " ms");

        // 데이터 이동 시작 시간 기록

        latch.await(); // 모든 데이터가 처리될 때 까지 대기

        moveDataThread.interrupt(); // 소비자 쓰레드 인터럽트 종료신호 종료유도
        moveDataThread.join(); // 소비자 쓰레드가 끝날 때 까지 메인 쓰레드가 대기
        long moveDataEndTime = System.currentTimeMillis(); // 소비자 종료 시간 기록

        System.out.println("데이터 옮기기 쓰레드 시간: " + (moveDataEndTime - moveDataStartTime) + " ms");

        // 데이터 저장소 인스턴스 가져오기
        Data_cub storage = Data_cub.getInstance(); // 데이터 저장소에는 이미 데이터가 다 들어간 상태
        // 생성된 데이터 크기 출력
        System.out.println("Generated data size: " + storage.getDataList().size());

        while (true) {
            System.out.println("1. 저장한 데이터에서 특정 문자열을 입력 2.저장한 데이터에서 임의의 숫자를 입력하여 해당하는 문자열 찾기 3.prefix 4.데이터 전체보기(오래걸립니다)");
            choice = 0;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                sc.next(); // 잘못된 입력을 스킵
                continue;  // 루프의 다음 반복으로 넘어감
            }

            if (choice == 1) {
                System.out.println("저장한 데이터에서 특정 문자열을 입력하세요:");
                String input = "";
                long startTime = System.currentTimeMillis();
                try {
                    input = sc.next();
                } catch (NoSuchElementException e) {
                    System.out.println("입력 오류가 발생했습니다. 다시 시도하세요.");
                    sc.next(); // 잘못된 입력을 스킵
                    continue;  // 루프의 다음 반복으로 넘어감
                } catch (IllegalStateException e) {
                    System.out.println("Scanner가 닫혀 있습니다. 프로그램을 종료합니다.");
                    break;  // 프로그램을 종료
                }

                // 입력한 문자열 값에 매칭된 숫자 찾기
                List<Integer> results = storage.getData(input);
                long endTime = System.currentTimeMillis();
                System.out.println("문제 2번 로직 시간: " + (endTime - startTime) + " ms");

                if (!results.isEmpty()) {
                    System.out.println("추출된 결과 값: " + results);
                } else {
                    System.out.println("일치하는 값이 없습니다.");
                }

            } else if (choice == 2) {
                System.out.println("저장한 데이터에서 특정 숫자를 입력하세요:");
                int input = 0;
                long startTime = System.currentTimeMillis();

                try {
                    input = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    sc.next(); // 잘못된 입력을 스킵
                    continue;  // 루프의 다음 반복으로 넘어감
                }

                List<String> results = storage.getString(input);
                long endTime = System.currentTimeMillis();
                System.out.println("문제 3번 로직 시간: " + (endTime - startTime) + " ms");
                if (!results.isEmpty()) {
//                    Collections.sort(results);
                    results.sort(Comparator.comparingInt(String::length)); // 문자열 길이를 기준으로 정렬
                    System.out.println("추출된 결과 값: " + results);
                } else {
                    System.out.println("일치하는 값이 없습니다.");
                }

            } else if (choice == 3) {
                System.out.println("저장한 데이터에서 접두사에 매칭되는 문자열을 입력하세요:");
                String input = "";

                long startTime = System.currentTimeMillis();
                try {
                    input = sc.next();
                } catch (NoSuchElementException e) {
                    System.out.println("입력 오류가 발생했습니다. 다시 시도하세요.");
                    sc.next(); // 잘못된 입력을 스킵
                    continue;  // 루프의 다음 반복으로 넘어감
                } catch (IllegalStateException e) {
                    System.out.println("Scanner가 닫혀 있습니다. 프로그램을 종료합니다.");
                    break;  // 프로그램을 종료
                }
                List<String> results = storage.getMatchKeys(input); // 맞는 key 값을 가져옴

                long endTime = System.currentTimeMillis();
                System.out.println("문제 4번 로직 시간: " + (endTime - startTime) + " ms");

                Map<Integer, Long> countMap = new HashMap<>();
                Map<String, List<Integer>> resultMap = new HashMap<>();

                for (String key : results) {
                    List<Integer> values = storage.getData(key);
                    resultMap.put(key, values);
                    for (Integer value : values) {
                        countMap.put(value, countMap.getOrDefault(value, 0L) + 1); // 갯수 체크
                    }
                }

                List<String> sortedKeys = new ArrayList<>(resultMap.keySet());
                sortedKeys.sort(Comparator.comparingInt(String::length)); // 정렬

                System.out.println("추출된 결과 값:");
                for (String key : sortedKeys) {
                    for (Integer value : resultMap.get(key)) {
                        System.out.println(key + " - " + value);
                    }
                }

                System.out.println("숫자별 개수:");
                for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue() + "개");
                }
            } else if (choice == 4) {
                for (ConcurrentHashMap.Entry<String, Integer> entry : storage.dataList) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            } else {
                System.out.println("1 ~ 4 번만 입력해주세요.");
            }
        }
    }

    // 싱글톤 - 인스턴스
    private static Data_cub instance;
    // 데이터를 저장하는 맵(알파벳-숫자 쌍)
    private final List<ConcurrentHashMap.Entry<String, Integer>> dataList = Collections.synchronizedList(new ArrayList<>());
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

    /* lock , unlock 설명
    1. lock.lock()
    lock.lock() 호출 시 현재 스레드는 락을 획득하려고 시도합니다.
    만약 다른 스레드가 이미 락을 획득한 상태라면, 락이 해제될 때 까지 현재 스레드는 대기합니다.
    락을 성공적으로 획득하면 이후의 코드 블록(try 블록 내의 코드)을 실행할 수 있습니다.

    2. try-finally 블록
    락을 획득한 후, try 블록 내의 코드를 실행합니다. 여기서 try내의 dataList.add(new AbstractMap.SimpleEntry<>(alphabet, number));
    코드가 실행됩니다.
    finally 블록은 try 블록의 코드가 정상적으로 실행되든, 예외가 발생하든 상관없이 항상 실행됩니다.
    이는 예외가 발생하더라도 반드시 락을 해제(lock.unlock())하도록 보장합니다.

    결론
    lock.lock()은 특정 자원에 대한 접근을 제어하기 위해 락을 획득하는 메서드입니다.
    이를 통해 여러 스레드가 동시에 동일한 자원에 접근하는 것을 방지할 수 있습니다.
    try-finally 블록을 사용하여 예외가 발생하더라도 락이 반드시 해제되도록 보장하는 것이 중요합니다.
    이로써 동시성 문제를 예방하고 안전하게 공유 자원에 접근할 수 있습니다.
     */
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
        lock.lock(); // 동기화 시작
        try {
            List<Integer> results = new ArrayList<>();
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                if (entry.getKey().equals(alphabet)) {
                    results.add(entry.getValue());
                }
            }
            return results;
        } finally {
            lock.unlock(); // 동기화 종료
        }
    }

    public List<String> getString(int num) {
        lock.lock(); // 동기화 시작
        try {
            List<String> results = new ArrayList<>();
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                if (entry.getValue().equals(num)) {
                    results.add(entry.getKey());
                }
            }
            return results;
        } finally {
            lock.unlock(); // 동기화 종료
        }
    }

    public synchronized List<String> getMatchKeys(String input) { // 맞는 키 값 가져오기
        List<String> match = new ArrayList<>();
        synchronized (dataList) {
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                String key = entry.getKey();
                if (input.equals(key)) {
                    // 들어가면 안됨
                } else if (input.startsWith(key)) {
                    match.add(entry.getKey());
                }

            }
        }
        return match;
    }

    // 모든 키를 반환하는 메서드
    public List<String> getAllKeys() {
        lock.lock(); // 동기화 시작
        try {
            List<String> keySet = new ArrayList<>();
            for (ConcurrentHashMap.Entry<String, Integer> entry : dataList) {
                keySet.add(entry.getKey());
            }
            return keySet;
        } finally {
            lock.unlock(); // 동기화 종료
        }
    }

    // dataList를 반환하는 메서드
    public List<ConcurrentHashMap.Entry<String, Integer>> getDataList() {
        lock.lock(); // 동기화 시작
        try {
            // 새로운 리스트에 복사하여 반환
            return new ArrayList<>(dataList);
        } finally {
            lock.unlock(); // 동기화 종료
        }
    }
}


// 데이터 생성 쓰레드 클래스
class CreateData implements Runnable {
    private final BlockingQueue<Map.Entry<String, Integer>> queue; // 쓰레드간 동기화 매커니즘을 이용하는 블로킹 큐 생성
    private final CountDownLatch latch;
    private final int totalDataCount; // 총 만들어야 할 데이터 갯수
    private final HashSet<String> uniqueAlpahbet; // 알파벳이 겹치지 않게 하기위해 Set을 이용
    private final Random random;

    // 생성자
    public CreateData(BlockingQueue<Map.Entry<String, Integer>> queue, CountDownLatch latch, int totalDataCount) {
        this.queue = queue;
        this.latch = latch;
        this.totalDataCount = totalDataCount;
        this.uniqueAlpahbet = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public void run() {
        // 7000000번 반복하여 랜덤 데이터 생성 및 큐에 삽입
        while (uniqueAlpahbet.size() < totalDataCount) {
            String alphabet = generateRandomString(52); // 랜덤 알파벳 받아오고
            int number = random.nextInt(10000); // 0 ~ 9999 랜덤 숫자 생성하고

            // 중복되지 않을 경우 큐에 데이터 삽입
            if (uniqueAlpahbet.add(alphabet)) {
                try {
                    queue.put(new AbstractMap.SimpleEntry<>(alphabet, number)); // 큐에 맵처럼 키와 값을 함께 저장하기 위해 AbsrtactMap 이용
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

// 데이터 옮기기 쓰레드 클래스
class MoveData implements Runnable {
    private final BlockingQueue<Map.Entry<String, Integer>> queue;
    private final Data_cub storage; // 인스턴스 불러오고
    private final CountDownLatch latch;
    private volatile boolean done = false; // 변수의 최신값을 모든 스레드가 일관되게 볼 수 있게 volatile 씀 재정렬을 방지함
    // cpu같은 애들이 프로세스를 재정렬 할 경우가 있을 수도 있기에 그것을 미연에 방지

    public MoveData(BlockingQueue<Map.Entry<String, Integer>> queue, CountDownLatch latch) {
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
                // 최대 100밀리초 동안 큐에서 데이터를 기다림, 만약 큐에 데이토가 있으면 즉시 반환하고, 없으면 100밀리초 대기후 null을 반환합니다.
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
