package infco;

import java.util.ArrayList;
import java.util.Scanner;

public class inf4 {

    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str){
            String tmp = new StringBuilder(x).reverse().toString(); //리버스 뒤집기 그다음에 string 형변환 해서 담아야함
            answer.add(tmp);
        }

        return answer;
    }
    public static void main(String[] args) {
        inf4 T = new inf4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i = 0; i<n; i++) {
            str[i] = kb.next();
        }

        for (String x : T.solution(n,str)){
            System.out.println("x = " + x);
        }
    }
}
