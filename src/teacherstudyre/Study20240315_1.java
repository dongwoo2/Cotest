package teacherstudyre;

import java.util.Scanner;

public class Study20240315_1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {

        int[][] ba1 = new int[3][4];
        int[][] ba1c = new int[3][4];
        System.out.println("ba1.length = " + ba1.length);
        for(int i = 0; i < ba1.length; i++) {
            for(int j = 0; j < ba1[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "] 에 숫자를 입력해주세요 : ");
                ba1[i][j] = sc.nextInt();
            }
        }
        System.out.println("숫자가 저장되었습니다. 답변자는 지금부터 문제에 대한 답변을 해주세요.");
        checkarray(ba1c,ba1);
        problemcheck(ba1,ba1c);
    }


    public static void allarray(int ba1[][]) {
        for (int i = 0; i < ba1.length; i++) {
            System.out.println();
            for (int j = 0; j < ba1[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "] : " + ba1[i][j] + " ");
            }
        }
    }

    public static void checkarray(int ba1c[][],int ba1[][]) {
        for (int i = 0; i < ba1c.length; i++) {
            System.out.println();
            for (int j = 0; j < ba1c[i].length; j++) {
                if(ba1c[i][j] != 0) {
                    System.out.print("[" + i + "]" + "[" + j + "] : " + ba1[i][j] + " ");
                } else {
                    System.out.print("[" + i + "]" + "[" + j + "] : ? ");
                }
            }
        }
    }

    public static void problemcheck(int ba1[][],int ba1c[][]) {
        int x = 0;
        int y = 0;
        int check = 0;
        int chcount = 0;
        int solucount = 0;
        int lastcheck = 0;
        int lastcheck1[][] = new int[3][4];
        int lastcheck2 = 0;
        int lastc = 0;
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("답변을 맞추고 싶으시다면 열과 행을 입력해주세요. \n입력 할 열과 행 >>");
            x = sc.nextInt();
            y = sc.nextInt();

            System.out.println(x + "행과" + y + "열을 입력하였습니다. 정답은 무엇입니까?");
            check = sc.nextInt();
            if(check == ba1[x][y]) {
                solucount++;
                System.out.println("정답입니다.");
                lastcheck += ba1[x][y];
                if(lastcheck2 != 0) {
                    System.out.println("2번이상 틀린문제의 합과 정답의 합이 얼마인지 입력해주세요 : ");
                    lastc = sc.nextInt();
                    if(lastcheck == lastc) {
                        System.out.println("정답입니다!");
                        lastcheck = 0;
                        lastcheck2 = 0;
                        for (int i = 0; i < lastcheck1.length; i++) {
                            for (int k = 0; k < lastcheck1[i].length; k++) {
                                lastcheck1[i][k] = 0;
                            }
                        }
                    } else {
                        System.out.println("오답입니다! 정답은 " + lastcheck + "입니다.");
                        lastcheck = 0;
                        lastcheck2 = 0;
                        for (int i = 0; i < lastcheck1.length; i++) {
                            for (int k = 0; k < lastcheck1[i].length; k++) {
                                lastcheck1[i][k] = 0;
                            }
                        }
                    }
                }
                ba1c = arraysolu(ba1c,x,y);
                chcount = 0;
                checkarray(ba1c,ba1);
                if(solucount == 3) {
                    System.out.println("정답을 모두 맞추셨기 때문에 우승하셨습니다!");
                    flag = false;
                }
            } else {
                chcount++;
                System.out.println(chcount + "번 째 기회입니다. 10회가 넘어 갈 경우 답변자님 패배입니다.");
                if(chcount > 2 && lastcheck1[x][y] == 0) {
                    lastcheck1[x][y] = 1;
                    lastcheck += ba1[x][y];
                    lastcheck2++;
                }
                if(chcount < 11){
                    checkarray(ba1c,ba1);
                }
            }
            if(chcount > 10) {
                allarray(ba1);
                flag = false;
            }
        }
    }

    public static int[][] arraysolu(int[][]ba1c, int x, int y) {
        ba1c[x][y] = 1;
        return ba1c;
    }

}

