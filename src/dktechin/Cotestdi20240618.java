package dktechin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* 필요한 것들
1.700만개 카운트
2.알파벳 소문자 대문자롬나 이루어진 문자열 - 중복x
3.임의의 숫자 1~4자리로 랜덤하게 생성해야함
4.문자열에 매칭된 숫자는 중복될 수 있음

중복x니까 set 그리고 kv 형태로 가야하니까 map

ExecutorService - 병렬 작업 시 여러 개의 작업을 효율적으로 처리하기 위해 제공되는 JAVA 라이브러리

 */
public class Cotestdi20240618 {
    private static final int total_count = 7000000;
    private static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int thread_count = 8;
    private static Random random = new Random(); // 랜덤 문자열 생성읋 위한 Random 객체를 생성합니다.

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 시작 시간을 기록
        long startTime = System.currentTimeMillis();
        // 스레드 풀을 생성
        ExecutorService executor = Executors.newFixedThreadPool(thread_count);
        // Future 객체를 저장할 리스트를 생성
        List<Future<Void>> futures = new ArrayList<>();

        

    }

}
