package infco;

import java.util.Scanner;

public class inf10 {
    public int[] solution(String s, char t){
        int[] answer = new int[s.length()]; //문자열 s의 길이만큼 int answer 배열의 길이를 잡음 인덱스
        int p = 1000;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t){
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for(int i = s.length()-1; i >= 0; i--){ // 렝스는 1부터 시작 i는 배열이라 0부터 시작
            if(s.charAt(i) == t){
                p = 0;
            }
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        inf10 T = new inf10();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0); //문자 한 개를 읽을 때
        for(int x : T.solution(str,c)){
            System.out.print(x + " ");
        }
    }
}
