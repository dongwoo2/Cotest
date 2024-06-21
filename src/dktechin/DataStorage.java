package dktechin;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// 싱글톤 데이터 저장소를 하나 만들어야함
public class DataStorage {
    public static void main(String[] args) {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        ArrayList<ConcurrentHashMap<String,Integer>> concurrentHashMaps = new ArrayList<>();

        for(int i = 0; i < 7000000; i++) {
            int index = random.nextInt(alphabet.length()); // 알파벳 길이만큼 랜덤으로 길이 추출
            char randomChar = alphabet.charAt(index); // 그 랜덤길이 알파벳으로 뽑기
            sb.append(randomChar);
//            concurrentHashMaps = random.
        }
    }
}
