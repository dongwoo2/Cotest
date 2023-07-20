package infco;

import java.util.Scanner;

public class inf8 {

    public String solution(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        inf8 T = new inf8();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); //한 줄 읽을 때
        System.out.println(T.solution(str));
    }
}
