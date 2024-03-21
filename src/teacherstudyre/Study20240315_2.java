package teacherstudyre;

import java.util.Scanner;

public class Study20240315_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int test = sc.nextInt();
        int n[] = new int[test];
        int k[] = new int[test];
        for(int i = 0; i < test; i++) {
            System.out.print(i+1 + "번 째 테스트의 층");
            n[i] = sc.nextInt();
        }

        k = piramid(n);
        piramidsolution(k,n);
    }

    public static int[] piramid(int n[]) { // 층 갯수
        int ncnt[] = new int[n.length];
        int k = 1;
        for(int i = 0; i < n.length; i++) {
            int nl = n[i];
            k = 1;
            for(int j = 0; j < nl; j++) {
                if(nl == 1) {
                    ncnt[i] = k;
                } else if(j >= 1){
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
        return ncnt;
    }

    public static void piramidsolution(int[] k, int [] n) {
        int left = 1;
        int right = 1;
        int cnt = 0;
        for(int i = 0; i < n.length; i++) {
            for(int j = 0; j <= n[i] ; j++) {
                if(n[i] == 1) {
                    System.out.println(i+1 + "   " + left + "  " + right);
                    break;
                } else if(n[i] == 2){
                    left += 2;
                    right = 3 + (2 * n[i]);
                    System.out.println(i+1 + "   " + left + "  " + right);
                    break;
                } else if(n[i] > 2 && j > 2) {
                    if(j == 3) {
                        left = 9;
                        right = 17;
                    } else {
                        left = right + 2;
                        right = right + ((k[i] - ((n[i] -j) * 2)) * 2);
                    }
                }
                if(n[i]  == j) {
                    System.out.println(i+1 + "   " + left + "  " + right);
                    break;
                }
            }
        }
    }

       /*     if(k[i] == 1) {
        System.out.println(i+1+ "   " + left + "  " + right);
    } else {
        left = right + 2;
        right = right + (2 * k[i]);
    } */

}
