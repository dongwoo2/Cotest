package infco;

import java.util.HashMap;
import java.util.Scanner;

public class Inf4_4 {

    public static void main(String[] args) {

        Inf4_4 TT = new Inf4_4();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(TT.solution(s, t));

    }

    public int solution(String S, String T){

        HashMap<Character,Integer> am = new HashMap<Character, Integer>();
        HashMap<Character,Integer> bm = new HashMap<Character, Integer>();
        int count = 0;
        int lt = 0;
        int L = T.length()-1;

//		for(int i = 0; i<L; i++) {
//			am.put(T.charAt(i), am.getOrDefault(T.charAt(i), 0) +1);
//		}
        for(char x : T.toCharArray()) {
            am.put(x, am.getOrDefault(x,0) +1);
        }

        for(int j = 0; j < L; j++) {
            bm.put(S.charAt(j), bm.getOrDefault(S.charAt(j), 0) +1);
        }

        for(int rt = L; rt < S.length(); rt++) {
            bm.put(S.charAt(rt), bm.getOrDefault(S.charAt(rt), 0) +1);
            if(am.equals(bm)) {
                count++;
            }
            bm.put(S.charAt(lt), bm.get(S.charAt(lt))-1);
            if(bm.get(S.charAt(lt))==0) {
                bm.remove(S.charAt(lt));
            }
            lt++;
        }
        return count;

    }
}

