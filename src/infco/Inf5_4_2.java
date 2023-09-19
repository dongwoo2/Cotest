package infco;

import java.util.Scanner;
import java.util.Stack;

public class Inf5_4_2 {

    public static void main(String[] args) {

        select();
    }

    public static void select() {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int answer = 0;
        int a ,b ,c = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(oper(x)) {
                b=stack.pop();
                a=stack.pop();

                c = cal(a,b,x);
                stack.push(c);
            }else {
                stack.push(Character.getNumericValue(x));
            }

        }
        answer = stack.pop();

        return answer;
    }

    public static boolean oper(char x) {
        if(x == '+' || x == '-' || x == '*' || x == '/') {
            return true;
        }else {
            return false;
        }

    }

    public static int cal(int a, int b, char x) {
        int t = -1;

        if(x == '+') {
            return a + b;
        }
        if(x == '-') {
            return a - b;
        }
        if(x == '*') {
            return a * b;
        }
        if(x == '/') {
            return a / b;
        }

        return t;
    }

}
