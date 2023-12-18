package teacherstudyre;

import java.util.Scanner;

public class Study1217_1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        System.out.println("손님 수 : ");
        int n = sc.nextInt();
        int choice = 0;
        int money = 0;
        int allmoney = 0;
        int summoney = 0;
        int[] p = new int[n];
        int[] pp = new int[n];
        int[] count = new int[2];
        boolean flag = true;

        while (flag) {
            for (int i = 0; i < n; i++) {
                System.out.println(i + 1 + "번째 손님 추가할 금액 : ");
                money = sc.nextInt();
                p[i] = p[i] + money;
                pp[i] += money;
                summoney += money;
            }
            howmoney(p);
            System.out.println("누구 돈을 빼겠습니까?");
            choice = sc.nextInt();
            System.out.println("얼마를 빼겠습니까? ");
            money = sc.nextInt();
            if (choice == 0 && money == 0) {
                System.out.println("프로그램이 종료됩니다.");
                flag = false;
            } else {
                p = outmoney(choice, money, p);
                howmoney(p);
                count = allmoney(p);

                System.out.println("마지막 남은 돈은 얼마입니까? : " + count[0]);
                System.out.println("현 재 몇 번 까지 존재합니까? " + count[1]);
                System.out.println("처음에 3명이 가지고 있었던 금액은 얼마입니까?");
                for (int i = 0; i < pp.length; i++) {
                    System.out.println(i + 1 + "번째 손님의 처음 금액 : " + pp[i]);
                }

                System.out.println("현재 가지고 있는 금액은 " + count[0] + "원 이고 최초금액은 " + summoney + "원 입니다");
                summoney -= count[0];
                System.out.println("차액은 : " + summoney + "원 입니다");



            }
        }
    }
    public static void howmoney(int[]p) {
        for(int i = 0; i < p.length; i++) {
            if(p[i] != 0) {
                System.out.println(i + 1 + "번째 손님이 가진 금액 : " + p[i]);
            }
        }
    }

    public static int [] outmoney(int choice, int money, int[]p) {
        if(choice != 0) {
            choice -= 1;
        }
        p[choice] = p[choice] - money;
        if(p[choice] == 0) {
            p[choice] = p[choice + 1];
            p[choice + 1] = 0;

            // 3번째 인덱스가 2번째 인덱스로 이동하는 로직이 없음
            // 1번째꺼를 빼면 2번째는 이동하는데 그 다음은 이동하지 않음
            //
        }


        return p;
    }

    public static int[] allmoney(int[]p) {
        int money = 0;
        int cnt = 0;
        int []arr = new int[2];
        for(int i = 0; i < p.length; i++) {
            money += p[i];
            if(p[i] != 0) {
                cnt++;
            }
        }
        arr[0] = money;
        arr[1] = cnt;

        return arr;
    }


}
