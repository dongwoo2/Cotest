package teacherstudyre;

import java.util.Scanner;

public class Study1222_2 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();

    }

    public static void solution() {
        System.out.println("배열 갯수 입력:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[n];
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        for(int i = 1; i <= arr.length; i++) {
            brr = cutmethod(arr, i);
            answer = Math.max(arrsum(brr), answer);
        }
        System.out.println(answer);


    }

    public static int[] cutmethod(int[]arr, int cut) {
        int right = arr.length - cut;
        int brr[] = new int[arr.length];

        if(arr.length > cut) {
            for(int i = 0, j = cut; j < arr.length; i++,j++) {
                brr[i] = arr[j];
            }
            for(int i = right, j = 0; i < arr.length; i++, j++) {
                brr[i] = arr[j];
            }
        } else if(arr.length == cut) {
            return arr;
        }
        return brr;

    }

    public static int arrsum(int[]arr) {
        int max = 0;
        int realmax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = 0;
            for(int j = i; j < arr.length; j++) {
                max += arr[j];
                realmax = Math.max(max, realmax);
            }
        }
        return realmax;

    }

}

