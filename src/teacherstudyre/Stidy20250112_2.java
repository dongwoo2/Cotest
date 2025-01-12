package teacherstudyre;

import java.util.Arrays;

public class Stidy20250112_2 {
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 1, 2, 3};
        int[] arr2 = {6, 2, 3, 1};
        int[] arr3 = {3, 2, 1};
        int[] arr4 = new int[3];

        int n = arr1.length;
        int m = arr2.length;
        int o = arr3.length;





        // 여기서 공통요소만 포함? 어떻게?

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        for(int i : arr1) {
            System.out.println("i = " + i);
        }
        for(int i = 0; i < o; i++) {
            if(arr1[i] == arr2[i] && arr2[i] == arr3[i]) {
                arr4[i] = arr1[i];
            }
        }

        int[] newArray = Arrays.copyOf(arr4, 3);

        for(int j : newArray) {
            System.out.println("j = " + j);
        }

    }
}
