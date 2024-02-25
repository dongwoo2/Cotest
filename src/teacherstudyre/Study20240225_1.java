package teacherstudyre;

import java.util.Scanner;

public class Study20240225_1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int TAGG = 0;
        int CCAG = 0;
        int AGCC = 0;
        int i = 0;
        
        String [] cas = new String[5];
        String cas2 = "";
        for(int a = 0; a < cas.length; a++) {
            cas[a] = "";
        }

        String tt = "";
        tt = sc.nextLine();
        String  [] tt2 = new String[tt.length()+1];

        for(int a = 0; a < tt2.length; a++) {
            tt2[a] = "";
        }
        for(char x : tt.toCharArray()) {
            System.out.print(x);
            System.out.println("String.valueOf(x) = " + String.valueOf(x));
            tt2[i] = String.valueOf(x);
            i++;
        }
        System.out.println("tt2 = " + tt2[i-1]);

        cas[0] += tt2[0];
        cas[1] += tt2[1];
        cas[2] += tt2[2];
        cas[3] += tt2[3];
        for(int j = 3, s = 3; j < tt2.length; j++) {
            int k = 0;
            k++;
            if(k > 1) {
                if (!cas[s].equals("")) {
                    for (int t = 1; t <= 4; t++) {
                        if(t == 4) {
                            cas[t - 1] = tt2[j];
                        } else if (t < 4) {
                            cas[t - 1] = cas[t];
                        }
                        System.out.println("cas[t] = " + cas[t]);
                    }
//                    cas[3] = tt2[j];
                }
            }
            for(int f = 0; f < 4; f++) {
                cas2 += cas[f];
                System.out.println("cas2 = " + cas2);
            }

            cas2 = "";
            if(cas2.equals(TAGG)){
                TAGG++;
            } else if(cas2.equals(CCAG)) {
                CCAG++;
            } else if (cas2.equals(AGCC)) {
                AGCC++;
            }

            cas2 = "";
        }
        System.out.println("TAGG = " + TAGG);
        System.out.println("CCAG = " + CCAG);
        System.out.println("AGCC = " + AGCC);
    }
}
