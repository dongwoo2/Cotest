package teacherstudyre;

import java.util.Scanner;

public class Study1210_3 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("몇 개 까지 있다고 할까요? :" );
        int n = sc.nextInt();
        int k = 0;
        int choice = 0;
        int num = 0;

        int[] array = new int[n];
        System.out.print(1 + "번째 값 : ");
        array[0] = sc.nextInt();
        num = array[0];

        for(int i = 1; i <= n; i++) {

            System.out.println("[다음 값 기준]");
            System.out.println("1.더하기");
            System.out.println("2.빼기");
            System.out.println("3.특정 값 불러오기");
            System.out.print("선택  : ");
            choice = sc.nextInt();

           num = calcu(choice, num, array);
           array[i] = num;


            for (int l = 0; l <= i; l++) {
                System.out.println(l+1+"번 째 값 : "+array[l]);
            }


        }


    }
    public static int calcu(int choice, int num, int[] array) {
        if(choice == 1) {
            System.out.println("숫자입력");
            int plus = sc.nextInt();
            num += plus;
            return num;
        }else if(choice == 2) {
            System.out.println("숫자입력");
            int minus = sc.nextInt();
            num -= minus;
            return num;
        }else if(choice == 3) {
            System.out.println("숫자입력");
            int choice2 = sc.nextInt();
            int i = array[choice2-1];
            return i;
        }
        return 0;
    }

}
