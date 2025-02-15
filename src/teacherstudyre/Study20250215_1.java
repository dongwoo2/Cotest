package teacherstudyre;

import java.util.Scanner;

public class Study20250215_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int choice = 0;
        float choiceArray[][] = new float[10][1];
        characterClass();
        System.out.println("직업을 선택하세요.");
        choice = sc.nextInt();

        choiceArray = showAbility(choice);
    }

    public static void characterClass() { // 직업 보여주기
        System.out.println("1.전사 클래스, (warrior)\n" +
                "2.격투가 클래스, (fighter)\n" +
                "3.창술가 클래스, (spearman)\n" +
                "\n" +
                "4.정령사 클래스, (spiritist)\n" +
                "5.힐러 클래스, (healer)\n" +
                "6.마법사 클래스, (wizard)\n" +
                "7.궁수 클래스, (Archer)\n" +
                "\n" +
                "8.마검사 클래스, (magicwarrior)\n" +
                "9.마창사 클래스, (magicspearman)");
    }

    public static float[][] showAbility(int choice) { // 능력치 선택 choice는 직업
        boolean flag = true;
        System.out.println("능력치를 선택하세요.");//
        // 전사, 격투가, 창술가
        int choice1 = 0;
        int paty = 0; // 자신한테 맞는 능력치
        int[] haveAblity = new int[10];// 가지고 있는 기본 능력치
        int goodCnt = 0;
        // 조건이 2개 들어가야할텐데 8번에서 16번 사이중에
        // 고른 능력치가 8번에서 16번이가 paty가 같다면 1들어가고 아니면 직업이 맞지 않아서 반감된 값이 들어가게
        float choiceArray[][] = new float[10][1];
        int abiltyCnt = 0;
        int cant = 0;
        System.out.println("1.힘\n" +
                "2.지능\n" +
                "3.HP\n" +
                "4.MP\n" +
                "5.민첩\n" +
                "6.운\n" +
                "7.스피드\n" +
                "8.검술\n" +
                "9.궁술\n" +
                "10.마검술\n" +
                "11.마창술\n" +
                "12.마법\n" +
                "13.힐\n" +
                "14.정령\n" +
                "15.격투\n" +
                "16.창술");
        switch (choice) {
            case 1: // 전사
                abiltyCnt = 4;
                paty = 8;
                haveAblity[0] = 1;
                haveAblity[1] = 5;
                break;
            case 2: // 격투가
                abiltyCnt = 4;
                paty = 15;
                haveAblity[0] = 1;
                haveAblity[1] = 5;
                break;
            case 3: // 창술가
                abiltyCnt = 4;
                paty = 16;
                haveAblity[0] = 1;
                haveAblity[1] = 5;
                break;
            case 4: // 정령사
                abiltyCnt = 5;
                paty = 16;
                haveAblity[0] = 2;
                break;
            case 5: // 힐러
                abiltyCnt = 5;
                paty = 13;
                haveAblity[0] = 2;
                break;
            case 6: // 마법사
                abiltyCnt = 5;
                paty = 11;
                haveAblity[0] = 2;
                break;
            case 7: // 궁수
                abiltyCnt = 5;
                paty = 9;
                haveAblity[0] = 2;
                break;
            case 8: // 마검사
                abiltyCnt = 3;
                paty = 10;
                haveAblity[0] = 2;
                haveAblity[1] = 4;
                haveAblity[2] = 5;
                break;
            case 9: // 마창사
                abiltyCnt = 3;
                paty = 11;
                haveAblity[0] = 2;
                haveAblity[1] = 4;
                haveAblity[2] = 5;
                break;

        }

        System.out.println(abiltyCnt + "개를 선택하세요"); // 중복도 다시고려


        while (flag) {
            choice1 = sc.nextInt(); //능력치 선택
            System.out.println(goodCnt+"번 째 능력치 선택");
            for(int j = 0; j < abiltyCnt; j++) { // 이미 가지고 있는 능력치
                if(haveAblity[j] == choice1) {
                    System.out.println("이미 가지고 있는 능력치 입니다. 다시 선택해주세요");
                }
            }
            for(int i = 0; i < abiltyCnt; i++) { // 중복 능력치
                if(i > 0) {
                    if(choiceArray[i][0] == choice1) {
                        System.out.println("중복입니다. 다시 선택해주세요");
                    }
                }
                if(choice > 7 && paty == choice1) { // 기술이면서 자기 직업이랑 부합한 능력치 일 때
                    // 어떤 기술인지는 어떻게 넣지?
                    // 이차원 배열해서 1.기술번호 2. 능력치 이렇게 하자
                    choiceArray[i][0] = 1;
                } else { // 기술이면서 자기 직업이랑 부합한 능력치가 아닐 때
                    choiceArray[i][0] = 0.5f;
                }

            }


            if(goodCnt == abiltyCnt) {
                flag = false;
            }

        }
        // while 로 바꾸자

        return choiceArray;
    }

}
