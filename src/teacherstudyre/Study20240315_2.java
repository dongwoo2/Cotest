package teacherstudyre;

import java.util.Scanner;

public class Study20240315_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int test = 0;
        int n[] = new int[test];
        test = sc.nextInt();
        for(int i = 0; i < test; i++) {
            System.out.print(i+1 + "번 째 테스트의 층");
            n[i] = sc.nextInt();
        }

        piramid(n);
    }

    public static void piramid(int n[]) { // 1층 부터
        int ncnt[] = new int[n.length];
        int k = 1;
        for(int i = 0; i < n.length; i++) {
            int nl = n[i];
            k = 1;
            for(int j = 0; j < nl; j++) {
                if(nl == 1) {
                    ncnt[i] = k;
                } else {
                    k += 2;
                    ncnt[i] = k;
                }

            }
            System.out.println(ncnt[i]);

            // 규칙 찾아서 피마리드가 몇개인지 찾아서 해야함
            // 1층에는 1개, 2층은 3개, 3층은 5개, 4층은 7개
            // if(n > 1) n==3 for n<3 n+=2
            // if(n > 1) for(int i = 0; i < n; i++) k+=2;
        }

    }


}
