package teacherstudyre;

import java.util.Scanner;

public class Study1001_1_2 {

    public static void main(String[] args) {

    }
        public static void select() {
            Scanner sc = new Scanner(System.in);

            System.out.print(" 첫 번째 사람 이름 : ");
            String onePerson = sc.next();
            System.out.print(onePerson + " 이 받은 점수 입력 : ");
            int oneScore = sc.nextInt();

            System.out.print(" 두 번째 사람 이름 : ");
            String twoPerson = sc.next();
            System.out.print(twoPerson + " 이 받은 점수 입력 : ");
            int twoScore = sc.nextInt();

            System.out.print(" 세 번째 사람 이름 : ");
            String threePerson = sc.next();
            System.out.print(threePerson + " 이 받은 점수 입력 : ");
            int threeScore = sc.nextInt();

            System.out.print(" 네 번째 사람 이름 : ");
            String fourPerson = sc.next();
            System.out.print(fourPerson + " 이 받은 점수 입력 : ");
            int fourScore = sc.nextInt();
    }

    public static void solution(int one, int two, int three, int four, String man1, String man2, String man3, String man4) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. " + man1);
            System.out.println("2. " + man2);
            System.out.println("3. " + man3);
            System.out.println("4. " + man4);
            System.out.println("5. 종료");

            System.out.println("누구와 누구를 대조하시겠습니까?" );
            System.out.print(" 첫 번째 사람 입력 : ");
            int choice = sc.nextInt();
            System.out.print(" 두 번째 사람 입력 : ");
            int choice2 = sc.nextInt();

            if(choice == 5 && choice2 == 5) {
                break;
            } else if(choice == 5 && choice2 != 5) {
                System.out.println(" 잘못된 입력입니다. ");
            } else if (choice != 5 && choice2 == 5) {
                System.out.println(" 잘못된 입력입니다. ");
            }
        }
    }
}
