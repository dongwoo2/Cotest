package infco;

import java.util.Scanner;

public class Inf6_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int []arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x :solution(size, arr)) {
            System.out.print(x + " ");
        }


    }

    public static int[] solution(int size, int []arr) {

        int min;
        int temp;

        for(int i = 0; i < size-1; i++) {
            min = i;
            for(int j = i+1; j < size; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;

    }

}
