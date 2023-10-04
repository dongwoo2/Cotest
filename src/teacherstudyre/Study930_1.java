package teacherstudyre;

import java.util.Scanner;

public class Study930_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int f = 0;
        int count = 0;

        while (f <= 1000) {

            if(f < 1000 && count == 0) {
                f += 10;
                System.out.println(f);
                if(f == 1000) {
                    count++;
                }
            }

            if(count == 1) {
                if(f > 500) {
                    f -= 10;
                    System.out.println(f);
                }
            }
        }


    }
}
//
//	기본적으로 0의 숫자를 가지고 있는 f가 있다.
//            f는 10씩 증가하며, 총 1000까지만 늘어난다
//            그 다음, f가 500까지 다시 10씩 떨어지는 상황을
//            출력하시오.
//            단, 풀 수 있는 방식이 두 가지이니 첫 번쨰 방법으로 풀 경우,
//            강사가 피드백을 드릴 겁니다.