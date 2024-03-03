package teacherstudyre;
import java.util.Random;
import java.util.Scanner;

public class Study20240303_1 {

    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int n = random.nextInt(50) + 50;
        int ch = random.nextInt(3) + 1;
        int k = n/3;
        int t = 0;
        int cardcnt[] = new int[n];
        for(int i = 0; i < cardcnt.length; i++) {
            cardcnt[i] = random.nextInt(9999) + 1;
            System.out.println("i = " + i);
            System.out.println(cardcnt[i]);
        }
        if(ch == 1) { // 3으로 나눠서 앞 부분만
            //while (k % 4 != 0 || k % 5 != 0 || k % 6 != 0) {
            //    k++;
            //}
            t = random.nextInt(k);
            t = sc.nextInt();
            if(t > k) { // 크면 안됨 앞 부분이니까

            }
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] != 0)) {
               t = random.nextInt(k);
            }
        } else if (ch == 2) { // 얘는 중간 부분만
            t = sc.nextInt();
            if(t < k && t > k * 2) { // 중간 부분이니까 크면 안되고

            }
            t = random.nextInt(k) + k; // 그리고 앞 부분 빼기 다시 k로 빼기
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] != 0)) {
                t = random.nextInt(k) + k;
            }
        } else { // 얘는 끝 부분만
            t = random.nextInt(k) + k * 2;
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] != 0)) {
                t = random.nextInt(k) + k * 2;
            }
            // 앞에 두 부분 빼면됨
        }



    }
}
