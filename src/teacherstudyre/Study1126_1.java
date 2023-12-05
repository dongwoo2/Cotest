package teacherstudyre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Study1126_1 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int choice;
        int money = 0;
        int fish = 0, corn = 0, fri =0;
        int cnt = 0;
        int fCount = 0;
        ArrayList<String> array = new ArrayList<>();


        while (cnt != 1) {
            System.out.println("1.장어덮밥(5000원) 2.옥수수콘(10000원) 3.감자튀김(3000원) 4.총 가격");
            System.out.print("선택 할 번호 : ");
            choice = sc.nextInt();
            if(choice == 1) {
                fish++;
            } else if (choice == 2) {
                corn++;
            } else if(choice == 3){
                fri++;
            }
            money = foodchoice(choice,money);
            System.out.println("계속 구매하시겠다면 1번, 아니면 2번을 눌러주세요." );
            choice = sc.nextInt();
            if(choice == 1) {
                cnt = 0;
                System.out.println("계속 진행합니다. ");
            } else if (choice == 2){
                fCount = foodcount(fish,corn,fri);
                if(fCount == 1) {
                    corn++;
                    fri++;
                } else if (fCount == 2) {
                    fri++;
                }
                System.out.println("장어덮밥 : " + fish + " 옥수수콘 : " + corn + " 감자튀김 : " + fri);
                cnt++;
            }

        }


    }


    public static int foodchoice(int choice, int money) {

        if(choice == 1) {
            System.out.println("1번 장어덮밥을 선택하셨습니다.");
            money += 5000;
            return money;
        } else if (choice == 2) {
            System.out.println("2번 옥수수콘을 선택하셨습니다.");
            money += 10000;
            return money;
        } else if (choice == 3) {
            System.out.println("3번 감자튀김을 선택하셨습니다.");
            money += 3000;
            return money;
        } else {
            System.out.println("감사합니다. 총 가격은 " + money + "원 입니다.");
            return money;
        }
    }

    public static ArrayList<String> foodchoice2(int choice) {
        ArrayList<String> take = new ArrayList<>();
        if(choice == 1) {
            take.add("nice");
        }
        return take;
    }


    public static int foodcount(int fish, int corn, int fri) {
        int count = 0;
        if(fish > corn && fish > fri) {
            System.out.println("'장어덮밥을 많이 주문하셨기 때문에 옥수수콘과 감자튀김은 1개씩 무료로 드립니다. ");
            count++;
            return count;

        } else if(corn > fish && corn > fri) {
            System.out.println("'옥수수콘을 많이 주문하셨기 때문에 감자튀김을 1개씩 무료로 드립니다. ");
            count += 2;
            return count;

        } else if(fri > fish && fri > corn) {
            System.out.println("'감자튀김을 많이 주문하셨기 아무것도 없습니다. ");
            count += 3;
            return count;

        }
        return 0;
    }


}
