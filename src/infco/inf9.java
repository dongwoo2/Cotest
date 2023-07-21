package infco;

import backjoon.Main;

import java.util.Scanner;

public class inf9 {
    public int solution(String s){
        String answer = "";
        for(char x : s.toCharArray()){
            if(Character.isDigit(x)) {
                answer += x;
            }

        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {

        inf9 T = new inf9();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
