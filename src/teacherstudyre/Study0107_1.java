package teacherstudyre;

import java.util.Scanner;

public class Study0107_1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public void solution() {
        int sequence = 0; // 손님 순서
        int ch1 = 0;
        int foodmenu = 4;
        int f1 = 0, f2 = 0, f3 = 0;
        int arr[] = new int[foodmenu];
        int se1 = 0; // 이전 된 사람인지 체크
        int money = 0;
        int month = 1;
        int day = 1;



        while (sequence == 10) {
            System.out.println(month + "월 " + day + "일");
            System.out.println("손님은 총 몇 명입니까?");
            int people = sc.nextInt();
            sequence ++;
            System.out.println(sequence + "번 째 손님이 가진 돈은 얼마입니까?");
            arr[0] = sc.nextInt();
            while (true) {
                menu();
                ch1 = sc.nextInt();
                if(ch1 <= 3) {
                    arr = foodselect(ch1,arr[0],se1);
                    f1 += arr[1]; // 이 부분 나중에 함수로
                    f2 += arr[2];
                    f3 += arr[3];
                } else if(ch1 == 4 || ch1 == 5) {
                    if(f2 % 10 != 0) {
                        icecream(f2);
                    }
                    if(f2 % 10 == 0 && f3 < f2) {
                        gamza(f2,f3);
                    }
                    day++;
                    if(day > 30) {
                        month++;
                        day = 1;
                    }
                }
            }

        }
    }


    public void menu() { // 메뉴 보이게
        System.out.println("1번 베이컨 5000원, 2번 아이스크림 3000원, 3번 감자콩 1000원 4.다음사람 5.종료 6. 포인트 적립 7.다음 날 8.영수증 조회 ");
    }

    public int []foodselect(int choice, int money, int se1) {
        int f1 = 0, f2 = 0, f3 = 0;
        int f1Price = 5000, f2Price = 3000 ,f3Price = 1000;
        if(se1 == 1) { // 할인
            int f1Discount = f1Price/100;
            int f2Discount = f2Price/100;
            int f3Discount = f3Price/100;
            f1Price = f1Price - (f1Discount * 5);
            f2Price = f2Price - (f2Discount * 5);
            f3Price = f3Price - (f3Discount * 5);
        }
        if(choice == 1) { // 베이컨
            money -= f1Price;
            f1++;
        } else if (choice == 2) { // 아이스크림
            money -= f2Price;
            f2++;
        } else if (choice == 3) { // 감자콩
            money -= f3Price;
            f3++;
        }
        return new int[]{money,f1,f2,f3};
    }

    public int point(int paymoney) {
        int point = 0;
        if(paymoney >= 100000) {
            int t = paymoney/100000;
            point = (t*1000);
        }
        return point;
    }

    public void icecream(int f2) {
        int need = (f2 % 10);
        System.out.println("현재 아이스크림의 갯수는 " + f2 + "개 이며" + need + "개 가 필요합니다.");
    }

    public void gamza(int f2, int f3) {
        int need = f2 -f3;
        System.out.println("현재 감자콩의 갯수는 " + f3 + "개 이며" + need + "개 가 필요합니다.");
    }


}
