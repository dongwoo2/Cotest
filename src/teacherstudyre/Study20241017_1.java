package teacherstudyre;

import java.util.Arrays;
import java.util.Scanner;

public class Study20241017_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        int k = 0;
        int k2 = 0;
        int arrays[] = new int[n];
        for(int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        k = Arrays.stream(arrays).min().getAsInt();
        k2 = Arrays.stream(arrays).max().getAsInt();
        System.out.println(k);

        for(int j = 0; j < n; j++) {
            if(arrays[j] > k) {
                k2 = Math.min(k2, arrays[j]);
            }
        }
        System.out.println(k2);
    }
}
