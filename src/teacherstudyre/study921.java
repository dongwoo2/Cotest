package teacherstudyre;

import java.util.Scanner;

public class study921 {

    public static void main(String[] args) {

        solution();
    }



    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int people = 1;
        int money = 0;
        System.out.println("1.타코야키 : 2000원");
        System.out.println("2.해물찜  : 7000원");
        System.out.println("3.튀김요리 : 5000원");
        System.out.println("4.자동차기름 : 12000원");
        System.out.println("5 . 종료");

        while (true) {
            int choice = sc.nextInt();
            System.out.println(people + "번 쩨 손님 선택" + choice);

            if(choice == 1) {
                money += 2000;
                System.out.println(people + "번 째 손님이 타코야끼를 주문하셔서 현재 누적금액" + money + " 원 입니다." );
            } else if (choice ==2) {
                money += 7000;
                System.out.println(people + "번 째 손님이 해물찜을 주문하셔서 현재 누적금액" + money + " 원 입니다." );
            } else if (choice ==3) {
                money += 5000;
                System.out.println(people + "번 째 손님이 튀김요리를 주문하셔서 현재 누적금액" + money + " 원 입니다." );
            } else if (choice ==4) {
                money += 12000;
                System.out.println(people + "번 째 손님이 자동차기름을 주문하셔서 현재 누적금액" + money + " 원 입니다." );
            } else if (choice ==5) {
                System.out.println(people + "번 째 손님이 종료를 누르셔서 프로그램을 종료합니다 오늘의 매출은" + money + " 원 입니다." );
                break;
            } else {
                System.out.println("잘못된선택");
                break;
            }
            people++;


        }
    }
}
