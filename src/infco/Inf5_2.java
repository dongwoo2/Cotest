package infco;

import java.util.Scanner;
import java.util.Stack;

public class Inf5_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solu(str));
    }

    public static String solu(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<Character>();

        for(char x : str.toCharArray()){
            if(x == ')'){
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

}
