package teacherstudyre;

import java.util.Scanner;

public class Study1126_2 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int chance = 0;
        int correct1 = 0;
        int age = 0;
        String sex = "";
        int phone = 0;
        String jumin = "";
        int password = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("성별 : ");
        sex = sc.next();
        while (true) {

            if(chance ==0) {
                System.out.println("주민번호 : ");
                jumin = sc.next();
                int jl = jumin.length();
                if (jl == 6) {
                    correct1++;
                } else {
                    //System.out.println(" ");
                    chance += 3;
                    if (jl < 6) {
                        chance += 2;
                    } else {
                        chance++;
                    }
                }

            }
            if(correct1 == 1) {
                System.out.println("카드 비번 : ");
                password = sc.nextInt();
            }

        }

    }

    public static void people() {

    }


}
