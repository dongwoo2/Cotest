package infco;

import java.util.Scanner;

public class inf28 {

    public int solution(int n){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n/2 + 1;
        int[] arr = new int[m];

        for(int i = 0; i<m; i++){
            arr[i] = i + 1;
        }
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n){
                answer++;
            }
            while (sum >= n) {
                sum -=arr[lt++];
                if(sum==n){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        inf28 T = new inf28();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
