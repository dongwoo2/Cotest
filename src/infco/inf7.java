package infco;

import java.util.Scanner;

public class inf7 {

    public String solution(String str){
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        inf7 T = new inf7();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
