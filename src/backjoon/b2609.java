package backjoon;

import java.util.Scanner;

public class b2609 {

    //최대공약수 구하는식
    //a= 1255, b=25
    //ex) 1255 % 25 = 5 (나머지가 5)
    // 25 % 5 = 0 , 5가 최대공약수 최대공약수가 c
    //최소공배수 구하는 식
    // a*b%c
    //ex) (1255*5/5) = 6275
    //LCM(a,b) = (a*b) / GCD(최대공약수)

    public static int gcd (int a, int b) { //유클리드 호제법

        if(b == 0) {
            return a;
        }else {
            return gcd(b , a%b);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        int getgcd;

        if(a >= b) {
            getgcd = gcd(a,b);
        }else {
            getgcd = gcd(b,a);
        }

        System.out.println(getgcd); //최대공약수
        System.out.println(a*b/getgcd); //최소공배수

    }

}

