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
        int k = n/3; // 홀수 일 경우 짝수 일 경우 생각해야함
        int t = 0;
        int removecnt = 0;
        int cardcnt[] = new int[n];
        for(int i = 0; i < cardcnt.length; i++) {
            cardcnt[i] = random.nextInt(9999) + 1;
            System.out.println("i = " + i);
            System.out.println(cardcnt[i]);
        }

        cardcnt = removecard(cardcnt, removecnt, k);

        int cardcnt2[] = new int[k];
        for(int j = 0; j < cardcnt.length; j++) {
            if (cardcnt[j] != 0) {

            }
        }

        if(ch == 1) { // 3으로 나눠서 앞 부분만
            System.out.println("앞 쪽 3분의 1부분만 남았습니다.");
            System.out.println("몇 번째 카드를 고르시겠습니까?");
            t = sc.nextInt();
            if(t > k) { // 크면 안됨 앞 부분이니까
                System.out.println("잘못된 카드를 고르셨습니다. ");
            } else {

            }
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] % 6 != 0)) {
               t = random.nextInt(k);
            }
        } else if (ch == 2) { // 얘는 중간 부분만
            t = sc.nextInt();
            if(t < k && t > k * 2) { // 중간 부분이니까 크면 안되고

            }
            t = random.nextInt(k) + k; // 그리고 앞 부분 빼기 다시 k로 빼기
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] % 6 != 0)) {
                t = random.nextInt(k) + k;
            }
        } else { // 얘는 끝 부분만
            t = random.nextInt(k) + k * 2;
            while(cardcnt[t] < 100 && cardcnt[t] > 8000 && (cardcnt[t] % 4 != 0 || cardcnt[t] % 5 != 0 || cardcnt[t] % 6 != 0)) {
                t = random.nextInt(k) + k * 2;
            }
            // 앞에 두 부분 빼면됨
        }




    }

    public static int[] removecard(int cardcnt[], int removecnt, int k) {
        for(int j = 0; j < cardcnt.length; j++) { //카드제거
            if(cardcnt[j] < 100 && cardcnt[j] > 8000 && (cardcnt[j] % 4 != 0 || cardcnt[j] % 5 != 0 || cardcnt[j] % 6 != 0) && removecnt < (k*2)) {
                cardcnt[j] = 0;
                removecnt++;
            }
        }
        if(removecnt < k*2) { // 조건에 따라 제거한 카드가 제거되어야 할 양보다 작을 떄 추가로 제거
            for(int q = 0; removecnt < k * 2; q++,removecnt++) {
                cardcnt[q] = 0;
            }
        }
        return cardcnt;
    }

}
