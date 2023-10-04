package teacherstudyre;

import java.util.Scanner;

public class Study1001_1 {

    public static void main(String[] args) {
        select();
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


        while(true) {
            String Man1 = "";
            String Man2 = "";
            System.out.println("1. " + onePerson);
            System.out.println("2. " + twoPerson);
            System.out.println("3. " + threePerson);
            System.out.println("4. " + fourPerson);
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

            if(choice == 1) {
                choice = oneScore;
                Man1 = onePerson;
            } else if (choice == 2) {
                choice = twoScore;
                Man1 = twoPerson;
            } else if (choice == 3) {
                choice = threeScore;
                Man1 = threePerson;
            } else if (choice == 4) {
                choice = fourScore;
                Man1 = fourPerson;
            }

            if(choice2 == 1) {
                choice2 = oneScore;
                Man2 = onePerson;
            } else if (choice2 == 2) {
                choice2 = twoScore;
                Man2 = twoPerson;
            } else if (choice2 == 3) {
                choice2 = threeScore;
                Man2 = threePerson;
            } else if (choice2 == 4) {
                choice2 = fourScore;
                Man2 = fourPerson;
            }

            if(choice > choice2 && choice != 5 && choice2 != 5) {
                System.out.println(Man1 + " 점수가 " + Man2 + "의 점수보다 더 큽니다.");
            } else if (choice2 > choice && choice != 5 && choice2 != 5) {
                System.out.println(Man2 + " 점수가 " + Man1 + "의 점수보다 더 큽니다.");
            }

        }
    }

    public static void solution(int choice,int choice2,String Man1,String Man2) {

        while (true) {
            if(choice > choice2) {

            }
        }
    }
}
