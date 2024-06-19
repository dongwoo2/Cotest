package teacherstudyre;

import java.util.Scanner;

/*
문제: 1부터 100까지의 자연수를 원소로 갖는 배열 arr이 있습니다. 이 배열에서 가장 긴 증
가하는 부분 수열의 길이를 구하는 프로그램을 작성하세요. 단, 가장 긴 증가하는 부분 수열
이란 배열에서 연속적으로 증가하는 수열 중 가장 긴 것을 말합니다. (예: [1, 2, 3, 5, 7]은
가장 긴 증가하는 부분 수열입니다.)

입력:
배열 arr의 크기와 각 원소를 입력으로 받습니다. 배열의 크기는 100 이하의 자연수입니다. 출력:
arr에서 가장 긴 증가하는 부분 수열의 길이를 출력합니다. 입력:
10
1 2 3 2 3 4 5 6 7 8
출력:
7

 */
public class Study20240619_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        int maxcnt = 1;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for(int j = 0; j < arr.length-1; j++) {
            if(arr[j] < arr[j+1]) {
                cnt++;
                if(cnt > maxcnt){
                    maxcnt = cnt;
                }
            } else if(arr[j] > arr[j+1]){
                cnt = 1;
            }
        }
        System.out.println("maxcnt = " + maxcnt);
    }
}
