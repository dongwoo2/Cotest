package infco;

import java.util.Scanner;

public class inf5 {
    public String solution(String str){
        String answer;
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;
        while (lt < rt){
            //알파벳이 아닐 때 참 알파벳이 아닌건 기호같은거
            if(!Character.isAlphabetic(s[lt])){
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            }else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;


    }

    public static void main(String[] args) {

        inf5 T = new inf5();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
