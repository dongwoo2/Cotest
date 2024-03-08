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
        int k = n / 3; // 홀수 일 경우 짝수 일 경우 생각해야함
        int t = 0;
        int removecnt = 0;
        int choice = 0;
        int cardnum = 0;
        int choicecnt = 8;
        int cardcnt[] = new int[n];
        boolean flag = true;
        boolean flag2 = true;
        for (int i = 0; i < cardcnt.length; i++) {
            cardcnt[i] = random.nextInt(9999) + 1;
            System.out.println("i = " + i);
            System.out.println(cardcnt[i]);
        }

        cardcnt = removecard(cardcnt, removecnt, k);

        for(int i = 0; i < cardcnt.length; i++){
            if(cardcnt[i] != 0) {
                System.out.println(i + "번 째 카드가 남아있습니다.");
            }
        }

        System.out.println("카드를 선택하세요");
        choice = sc.nextInt();
        while (flag) {
            if (cardcnt[choice] == 0) {
                System.out.println("잘못된 선택 다시선택하십쇼");
                choice = sc.nextInt();
            } else {
                while(flag2) {
                    System.out.println("숫자를 찍아보시오");
                    cardnum = sc.nextInt();
                    if(cardcnt[choice] < cardnum) {
                        System.out.println("down");
                        choicecnt--;
                        if(choicecnt == 3) {

                        } else if (choicecnt == 2) {

                        }
                    } else if(cardcnt[choice] < cardnum) {
                        System.out.println("up");
                        choicecnt--;
                        if(choicecnt == 3) {

                        } else if (choicecnt == 2) {

                        }
                    } else {
                        System.out.println("정답입니다!");
                        flag2 = false;
                        flag = false;
                    }
                }
            }

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

    public static int hint3(int[] cardcnt,int choice) {
        return choice;
    }

    public static int hint2(int[] cardcnt,int choice) {
        return choice;
    }


    }
