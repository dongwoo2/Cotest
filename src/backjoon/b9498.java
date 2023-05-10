package backjoon;

import java.util.Scanner;

public class b9498 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int X;
        X = sc.nextInt();

        if(X>=90 && X<=100){
            System.out.println("A");
        } else if (X<90 && X >=80) {
            System.out.println("B");

        } else if (X<80 && X>=70) {
            System.out.println("C");
        }else {
            System.out.println("D");
        }


    }
}
