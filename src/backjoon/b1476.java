package backjoon;

import java.util.Scanner;

public class b1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 0, s = 0, m = 0;
        int year = 0;

        while(true) {

            if(e == E && s == S && m == M ) {
                System.out.println("year = " + year);
                break;
            }
            e++;
            s++;
            m++;
            if(e <= 16){
                e = 1;
            }
            if(s <= 29){
                s = 1;
            }
            if(m <= 19){
                m = 1;
            }
            year++;

        }
        sc.close();

    }
}
