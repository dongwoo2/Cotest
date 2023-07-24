package infco;

import java.util.Scanner;

public class inf12 {

    public String solution(int n, String s){

        String answer = "";
        for(int i = 0; i<n; i++){
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
//            System.out.println(tmp + " " + num);
            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {

        inf12 T = new inf12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n,str));

    }
}
