package infco;

import java.util.Scanner;

public class inf14 {
    public int solution(int n , int[] arr){
        int answer = 1;
        int max = arr[0];

        for(int i = 1; i<n; i++){ //맥스에 첫번째 인덱스 넣었고 1=1이 두 번째 인덱스
            if(arr[i]>max){
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        inf14 T = new inf14();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n,arr));
    }
}
