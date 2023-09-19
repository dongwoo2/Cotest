package infco;

import java.util.Scanner;
import java.util.Stack;

public class Inf5_4 {

    public static void main(String[] args) {
        Inf5_4 T = new Inf5_4();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }

    public int solution(String str){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) {
                stack.push(Character.getNumericValue(x));
                //stack.push(x - '0') 이게 원래소스인데 무슨의도인지 모르겠음 아스키코드때매 그런가?
            } else {
                int a = stack.pop();
                int b = stack.pop();

                switch (x) {
                    case '+' :
                        stack.push(b+a);
                        break;

                    case '-' :
                        stack.push(b-a);
                        break;

                    case '*' :
                        stack.push(b*a);
                        break;

                    case '/' :
                        stack.push(b/a);
                        break;

                    default:
                        break;
                }
            }
        }
        answer = stack.pop();

        return answer;
    }

}