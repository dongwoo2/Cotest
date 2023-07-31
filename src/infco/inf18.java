package infco;

import java.util.Scanner;

public class inf18 {
    public int solution(int n, int[] arr) {
        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt = 0;
            } else {
                cnt++;
                answer += cnt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        inf18 T = new inf18();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n,arr));
    }
}
