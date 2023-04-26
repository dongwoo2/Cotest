package backjoon;

import java.util.Scanner;

public class study25 {

    public static int addNum(int a, int b) {
        int result = a + b;
        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int plus = x+y;
        int sub = x-y;
        int mult = x*y;
        int mod = x%y;

        System.out.println("plus = " + plus);
        System.out.println("sub = " + sub);
        System.out.println("mult = " + mult);
        System.out.println("mod = " + mod);

        System.out.println("addNum(5,8) = " + addNum(5,8));


    }
}
