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
        int check = 0;
        int[] p = new int[n];
        int[] pp = new int[n];
        int[] count = new int[2];
        int totalamount = 0;
        boolean flag = true;

        while (flag) {
            if(check == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.println(i + 1 + "번째 손님 추가할 금액 : ");
                    money = sc.nextInt();
                    p[i] = p[i] + money;
                    pp[i] = pp[i] + p[i]; //초기 값 p[i] 가 중간에 값이 바뀌기에 초기값이 필요함
                    summoney += pp[i]; // 최초금액
                }
            }
            check++;
            howmoney(p);
            System.out.println("1.돈 빼기 2.금액확인");
            choice = sc.nextInt();
            if(choice == 1) {
            System.out.println("누구 돈을 빼겠습니까?");
            choice = sc.nextInt();
            System.out.println("얼마를 빼겠습니까? ");
            money = sc.nextInt();
                p = outmoney(choice, money, p);
                if (choice == 0 && money == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    flag = false;
                }
            }
                 else if(choice == 2) {

                howmoney(p);
                count = allmoney(p);

                System.out.println("마지막 남은 돈은 얼마입니까? : " + count[0]);
                System.out.println("현 재 몇 번 까지 존재합니까? " + count[1]);
                System.out.println("처음에 " + n + "명이 가지고 있었던 금액은 얼마입니까?");
                for (int i = 0; i < pp.length; i++) {
                    System.out.println(i + 1 + "번째 손님의 처음 금액 : " + pp[i]);
                }

                System.out.println("현재 가지고 있는 금액은 " + count[0] + "원 이고 최초금액은 " + summoney + "원 입니다");
                totalamount = summoney -= count[0];
                System.out.println("차액은 : " + totalamount + "원 입니다");
                totalamount = 0;
                summoney = 0;
                for(int i = 0; i < pp.length; i++) {
                    pp[i] = 0;
                }


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

    public static int [] outmoney(int choice, int money, int[]p) { // 돈 빠진거 리턴
        if(choice != 0) {
            choice -= 1;
        }
        p[choice] = p[choice] - money;
        if(p[choice] == 0 || p[choice] < 0) {
            for (int i = choice; i < p.length - 1; i++) {
                p[i] = p[i + 1];
            }
            p[p.length - 1] = 0;

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
//        arr[0] = money;
//        arr[1] = cnt;

        return new int[]{money,cnt};
    }


}
