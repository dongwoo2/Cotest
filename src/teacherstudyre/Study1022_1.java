package teacherstudyre;

import java.util.Scanner;

public class Study1022_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int money = 0;
        int n = 10;
        int k = 10;
        int choice = 0;
        int choice2 = 0;

        for(int i = 1; i < n; i ++) {
            System.out.println(i + " 번 째 손님입니다.");

            money = 0;
            for (int j = 1; j < k; j++) {
                System.out.println("1.장어덮밥(5000원) 2.옥수수콘(10000원) 3.감자튀김(3000원) 4.총 가격");
                choice = sc.nextInt();
                if (choice == 1) {
                    money += 5000;
                    System.out.println("감사합니다. 총 가격은 " + money + " 원 입니다.");
                } else if (choice == 2) {
                    money += 10000;
                    System.out.println("감사합니다. 총 가격은 " + money + " 원 입니다.");
                } else if (choice == 3) {
                    money += 3000;
                    System.out.println("감사합니다. 총 가격은 " + money + " 원 입니다.");
                } else if (choice == 4) {
                    System.out.println("총 가격은 " + money + " 원 입니다.");
                } else {
                    System.out.println("없는 번호입니다.");
                }
                System.out.println("계속 구매하시겠다면 1번 아니면 2번을 눌러주세요");
                choice2 = sc.nextInt();

                if (choice2 == 1) {
                    j = j - 1;
                } else {
                    j = k;
                }
            }
        }
    }

}
