package teacherstudyre;

import java.util.Scanner;

public class Study1203_1 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int one = 0;
        int two = 0;
        int solu = 0;
        int chan = 0;
        String giho = "";
        Scanner sc = new Scanner(System.in);

        System.out.print(" 첫 번째 숫자 : ");
        one = sc.nextInt();
        while (true) {

            System.out.print(" 기호 : ");
            giho = sc.next();
            System.out.print(" 두 번째 숫자 : ");
            two = sc.nextInt();
            if(chan == 0) {
                solu = gesan(one, giho, two);
                chan++;
            } else if (chan != 0) {
                solu = gesan(solu,giho,two);
            }

        }
    }

    public static int gesan(int one, String giho, int two) {
        int answer = 0;
        if(giho.equals("+")) {
            answer = one + two;
            System.out.println(one + " + " + two + " = " + answer);
            return answer;
        } else if (giho.equals("-")) {
            answer = one - two;
            System.out.println(one + " - " + two + " = " + answer);
            return answer;
        } else if (giho.equals("*")) {
            answer = one * two;
            System.out.println(one + " * " + two + " = " + answer);
            return answer;
        } else if (giho.equals("/")) {
            answer = one/two;
            System.out.println(one + " / " + two + " = " + answer);
            return answer;
        }
        return 0;
    }

}

