package infco;

import java.util.Scanner;

public class inf23 {

    public int solution(int n, int m, int[][]arr) {

        int answer = 0;
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                int cnt = 0;
                for(int k =0; k<m; k++){ //k는 테스트번호
                    int pi = 0;
                    int pj = 0;
                    for(int s = 0; s<n; s++){ //s는 등수
                        if(arr[k][s]==i){
                            pi = s;
                        }
                        if(arr[k][s]==j){
                            pj = s;
                        }
                        if(pi < pj){
                            cnt++;
                        }
                        if(cnt == m){
                            answer++;
                        }
                    }
                }
            }
        }
        return  answer;
    }

    public static void main(String[] args) {
        inf23 T = new inf23();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]arr =new int[m][n]; //테스트 몇 등 했는지 정보 m이 열 테스트 3번
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n,m,arr));
    }
}
