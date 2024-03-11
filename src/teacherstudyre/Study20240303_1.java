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
                    if(cardnum >= (cardcnt[choice] - 5) && (cardnum <= cardcnt[choice] + 5)) {
                        System.out.println("정답입니다!");
                        flag2 = false;
                        flag = false;
                    }
                    else if(cardcnt[choice] + 5 > cardnum) {
                        System.out.println("up");
                        choicecnt--;
                        if(choicecnt == 3) {
                            hint3(cardcnt,choice);
                        } else if (choicecnt == 2) {
                            hint2(cardcnt,choice);
                        } else if (choicecnt == 1) {
                            hint1(cardcnt,choice);
                        } else if (choicecnt == 0) {
                            System.out.println("모든 기회를 잃었습니다 종료.");
                            System.out.println("정답은" + cardcnt[choice] + "입니다.");
                            flag2 = false;
                            flag = false;
                        }
                    } else if(cardcnt[choice] -5 < cardnum) {
                        System.out.println("down");
                        choicecnt--;
                        if(choicecnt == 3) {
                            hint3(cardcnt,choice);
                        } else if (choicecnt == 2) {
                            hint2(cardcnt,choice);
                        } else if (choicecnt == 1) {
                            hint1(cardcnt,choice);
                        } else if (choicecnt == 0) {
                            System.out.println("모든 기회를 잃었습니다 종료.");
                            System.out.println("정답은" + cardcnt[choice] + "입니다.");
                            flag2 = false;
                            flag = false;
                        }
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

    public static void hint3(int[] cardcnt,int choice) { // ?의 배수
        if(cardcnt[choice] % 2 == 0) {
            System.out.println("2의 배수입니다.");
        } else if(cardcnt[choice] % 3 == 0) {
            System.out.println("3의 배수 입니다.");
        } else if(cardcnt[choice] % 5 == 0) {
            System.out.println("5의 배수 입니다.");
        } else if(cardcnt[choice] % 7 == 0) {
            System.out.println("7의 배수 입니다.");
        }
    }

    public static void hint2(int[] cardcnt,int choice) { // 정확히 ? 자리입니다.
        if(cardcnt[choice] > 999) {
            System.out.println("숫자는 정확히 4자리입니다.");
        } else {
            System.out.println("숫자는 정확히 3자리입니다.");
        }
    }

    public static void hint1(int[] cardcnt,int choice) { // 3의 배수이지만 ? 가 들어가지 않습니다
        if(cardcnt[choice] % 2 == 0) {
            System.out.println("2의 배수이기에 짝수 입니다.");
        } else if (cardcnt[choice] % 3 == 0 && cardcnt[choice] % 2 != 0)  {
            System.out.println("3의 배수이지만 2의 배수가 들어가지 않습니다.");
        } else if (cardcnt[choice] % 5 == 0 && cardcnt[choice] % 7 != 0)  {
            System.out.println("5의 배수이지만 7의 배수가 들어가지 않습니다.");
        } else if (cardcnt[choice] % 3 == 0 && cardcnt[choice] % 7 != 0)  {
            System.out.println("3의 배수이지만 7의 배수가 들어가지 않습니다.");
        }
    }


    }
