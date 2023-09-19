package infco;

import java.util.Scanner;
import java.util.Stack;

public class Inf5_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(solu(str));
    }

    public static String solu(String str) {
        String answer = "NO";
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) {
                    return answer;
                }

                stack.pop();
            }
        }

        if(stack.isEmpty()){
            return "YES";
        } else{
            return answer;
        }

    }

}

