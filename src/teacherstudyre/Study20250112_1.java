package teacherstudyre;

import java.util.Arrays;

public class Study20250112_1 {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] newArray = Arrays.copyOf(originalArray, 3);

        String[] originalStringArray = {"a", "b", "c"};
        String[] newStringArray = Arrays.copyOf(originalStringArray, 5);

        for(int i : newArray) {
            System.out.println("i = " + i);
        }

        for(String i : newStringArray) {
            System.out.println("i = " + i);
        }
    }
}
