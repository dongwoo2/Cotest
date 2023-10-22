//for문과 if문을 활용하여 구구단 2단부터 40단까지 나타내고, 각 홀수의 단수는 출력되지 않게 하라.
//
//        [문제출제 1 : 구구단이 다음 구구단으로 넘어갈 때마다 구분선을 지어주시오.]
//
//        문제출제1 예시)
//	==========구구단 2단======
//
//            2 x 1 = 2;
//
//            .
//
//            .
//
//            .
//
//            2 x 9 = 18;
//
//            =========구구단 4단=========
package teacherstudyre;

public class Study1022_2 {

    public static void main(String[] args) {
        int num = 0;
        int num2 = 0;

        for (int i = 2; i <= 40; i++) {
            int k = i % 2; // 나머지
            int t = i;
            int y = i % 10;

            if (i == 4 || i == 8 || i == 14) { // 건너뛰기
                k = +1;
            }
            if (i == 18 && num == 0) {
                t += 100;
                num++;
            } else if (i == 20 && num2 == 0) {
                t += 200;
                num2++;
            } // 221

            if (y == 0 && i != 20) {
                t = t + 1;
            }
            if (k == 0 || i == 21) {
                System.out.println("===========================구구단 " + t + "단");
            }
            for (int j = 1; j <= 9; j++) {

                int s = t * j;

                if (k == 0 || i == 21) {
                    System.out.println(t + " * " + j + " = " + s);
                }
//                if(t == 118 && num == 1) {
//                    i = i - 1;
//                    num++;
//                }
//                if(t == 220 && num2 == 1) {
//                    i = i - 1;
//                    num2++;
//                }

            }
        }

    }
}
