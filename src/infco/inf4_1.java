package infco;

import java.util.Scanner;

public class inf4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
    }
    private int solution(int n, int k ,int []arr){
        inf4_1 T = new inf4_1();
        int answer = 0;
        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt<n; rt++){
            if(arr[rt] == 0){
                cnt++;
            }
            while (k<cnt){
                if(arr[lt] == 0){
                    cnt--;
                }
                    lt++;
            }
        answer = rt -lt +1;
        }
        return answer;
    }
}
