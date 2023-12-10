package teacherstudyre;

import java.util.Scanner;

public class Study1210_4 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int []array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for(int j = n; j > 0; j--) {
            System.out.println(array[j-1]);
        }



    }
}
