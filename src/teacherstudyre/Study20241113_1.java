package teacherstudyre;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Study20241113_1 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
        //Arrays.sort(arr);

        for(int i : arr) {
            System.out.println("i = " + i);
        }

        Integer[] arr2 = {3, 1, 4, 2, 5};
        Arrays.sort(arr2, Comparator.reverseOrder()); // 내림차순으로 정렬
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr, 1,4);

        for(int i : arr) {
            System.out.println("i = " + i);
        }

        String[] arr3 = {"apple", "banana", "cherry", "data", "elderberry"};
        Arrays.sort(arr3, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr3));

        People[] person =  {new People("dong",26), new People("jang",25), new People("kane", 28)};
        //Arrays.sort(person);
        //System.out.println(Arrays.toString(person));

        Arrays.sort(person, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.getName().compareTo(o1.getName()); // 알파벳 역순 정렬
            }
        });
        System.out.println(Arrays.toString(person));
    }

}
