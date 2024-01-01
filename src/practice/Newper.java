package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Newper {

    public static void main(String[] args) {
        String q = "json";

        int a = 0;
        int b = 1;

        int t = a > b ? a : b;


        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list = " + list);

        list.forEach(i -> System.out.print(i+","));
        System.out.println();

        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println("list = " + list);

        list.replaceAll(i -> i*10);
        System.out.println("list = " + list);

        Map<String, String> dongmap = new HashMap<>();
        dongmap.put("1", "1ong");
        dongmap.put("2", "2ong");
        dongmap.put("3", "3ong");
        dongmap.put("4", "4ong");

        dongmap.forEach((k,v) -> System.out.println("{"+k+","+v+"},"));
    }
    
}
