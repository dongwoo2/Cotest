package infco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inf6_6 {

    public static void main(String[] args) {

        Inf6_6 T = new Inf6_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //System.out.println(T.solution(n,arr));
        for(int x : T.solution(n,arr)) {
            System.out.print(x + " ");
        }
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
}
