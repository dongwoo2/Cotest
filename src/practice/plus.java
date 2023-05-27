package practice;

import java.util.Scanner;


public class plus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(pl(n,k));
        System.out.println(mi(n,k));
//
//        int sum = 0;
//
//        for(int i = 0 ; i <= n; i++) {
//            sum = sum + i;
//        }
//        System.out.println("sum = " + sum);
    }

    public static int pl(int x,int y) {
       int t = x+y;
       int v = x-y;
        return t + v;
    }

    public static int mi(int x,int y){
        return x-y;
    }
}
