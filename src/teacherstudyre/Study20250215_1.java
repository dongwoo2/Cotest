package teacherstudyre;

import java.util.Scanner;

public class Study20250215_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int choice = 0;
        float choiceArray[][] = new float[10][2];
        String idPw[] = new String[2];
        idPw = welcomeJoin();
        System.out.println("캐릭터의 이름을 적어주세요.");
        String name = sc.next();
        characterClass();
        System.out.println("직업을 선택하세요.");
        choice = sc.nextInt();

        choiceArray = showAbility(choice);

        System.out.println("name = " + name);
        strSkillName(choiceArray);
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


    // float[무슨 능력][값 0.5 또는 1]
    public static float[][] showAbility(int choice) { // 능력치 선택 choice는 직업
        boolean flag = true;
        // 전사, 격투가, 창술가
        int choice1 = 0;
        int paty = 0; // 자신한테 맞는 능력치
        float[][] haveAblity = new float[10][2];// 가지고 있는 기본 능력치
        int cntHaveAblity = 0;
        int goodCnt = 0;
        // 조건이 2개 들어가야할텐데 8번에서 16번 사이중에
        // 고른 능력치가 8번에서 16번이가 paty가 같다면 1들어가고 아니면 직업이 맞지 않아서 반감된 값이 들어가게
        //float choiceArray[][] = new float[10][1]; // 이 친구 안써도 될 듯
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
                haveAblity[0][0] = 1; // 스킬 이름
                haveAblity[0][1] = 1; // 스킬 값
                haveAblity[1][0] = 5; // 스킬 이름
                haveAblity[1][1] = 1; // 스킬 값
                cntHaveAblity = 2;
                break;
            case 2: // 격투가
                abiltyCnt = 4;
                paty = 15;
                haveAblity[0][0] = 1;
                haveAblity[0][1] = 1;
                haveAblity[1][0] = 5;
                haveAblity[1][1] = 1;
                cntHaveAblity = 2;
                break;
            case 3: // 창술가
                abiltyCnt = 4;
                paty = 16;
                haveAblity[0][0] = 1;
                haveAblity[0][1] = 1;
                haveAblity[1][0] = 5;
                haveAblity[1][1] = 1;
                cntHaveAblity = 2;
                break;
            case 4: // 정령사
                abiltyCnt = 5;
                paty = 16;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                cntHaveAblity = 1;
                break;
            case 5: // 힐러
                abiltyCnt = 5;
                paty = 13;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                cntHaveAblity = 1;
                break;
            case 6: // 마법사
                abiltyCnt = 5;
                paty = 11;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                cntHaveAblity = 1;
                break;
            case 7: // 궁수
                abiltyCnt = 5;
                paty = 9;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                cntHaveAblity = 1;
                break;
            case 8: // 마검사
                abiltyCnt = 3;
                paty = 10;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                haveAblity[1][0] = 4;
                haveAblity[1][1] = 1;
                haveAblity[2][0] = 5;
                haveAblity[2][1] = 1;
                cntHaveAblity = 3;
                break;
            case 9: // 마창사
                abiltyCnt = 3;
                paty = 11;
                haveAblity[0][0] = 2;
                haveAblity[0][1] = 1;
                haveAblity[1][0] = 4;
                haveAblity[1][1] = 1;
                haveAblity[2][0] = 5;
                haveAblity[2][1] = 1;
                cntHaveAblity = 3;
                break;

        }
        System.out.println("능력치를 선택하세요.");
        System.out.println(abiltyCnt + "개를 선택하세요"); // 중복도 다시고려


        while (flag) {
            for(int j = cntHaveAblity; j < abiltyCnt + cntHaveAblity; j++) { // 이미 가지고 있는 능력치
                System.out.println((goodCnt+1)+"번 째 능력치 선택");
                choice1 = sc.nextInt(); //능력치 선택
                strSkillName(haveAblity);
                for(int i = 0; i < abiltyCnt + cntHaveAblity; i++) {
                    if(haveAblity[i][0] == choice1) {
                        System.out.println("이미 가지고 있는 능력치 입니다. 다시 선택해주세요");
                        cant++;
                    }
                }
                if (choice > 7 && paty == choice1 && cant == 0) { // 기술이면서 자기 직업이랑 부합한 능력치 일 때
                    // 어떤 기술인지는 어떻게 넣지?
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 1; // haveAblity 대신 딴 거 들어가야함
                    goodCnt++;
                } else { // 기술이면서 자기 직업이랑 부합한 능력치가 아닐 때
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 0.5f;
                    goodCnt++;
                }
                System.out.println("haveAblity : " + j + haveAblity[j][0]);
                if(cntHaveAblity + goodCnt > 6) {
                    System.out.println("능력치 선택이 끝났습니다.");
                    flag = false;
                }
            }

            if(goodCnt == abiltyCnt) {
                flag = false;
            }

        }
        // while 로 바꾸자

        return haveAblity;
    }

    public static void strSkillName(float haveAblity[][]) {
        for(int i = 0; i < haveAblity.length; i++) {
            if(haveAblity[i][0] == 1) {
                System.out.println("힘");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 2) {
                System.out.println("지능");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 3) {
                System.out.println("HP");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 4) {
                System.out.println("MP");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 5) {
                System.out.println("민첩");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 6) {
                System.out.println("운");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 7) {
                System.out.println("스피드");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 8) {
                System.out.println("검술");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 9) {
                System.out.println("궁술");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 10) {
                System.out.println("마검술");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 11) {
                System.out.println("마창술");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 12) {
                System.out.println("마법");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 13) {
                System.out.println("힐");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 14) {
                System.out.println("정령");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 15) {
                System.out.println("격투");
                System.out.println(haveAblity[i][1]);
            } else if (haveAblity[i][0] == 16) {
                System.out.println("창술");
                System.out.println(haveAblity[i][1]);
            } else {
                System.out.println("오류");
            }

            
        }
        
    }

    public static String[] welcomeJoin() {
        System.out.println("회원가입을 시작합니다.");
        System.out.println("아이디를 입력해주세요");
        boolean flag = true;
        String id = sc.next();
        String pw = "";
        String idPw[] = new String[2];
        while (flag) {
            if(id.length() > 4) {
                System.out.println("id 입력 완료");
                idPw[0] = id;
                while (flag) {
                    System.out.println("비밀번호를 입력해주세요");
                    pw = sc.next();
                    if (pw.length() > 6) {
                        System.out.println("비번 입력 완료");
                        idPw[1] = pw;
                        flag = false;
                    } else {
                        System.out.println("6자보다 길게 입력해주세요.");
                        flag = true;
                    }
                }
            } else {
                System.out.println("4글자보다 길게 입력해주세요.");
                flag = true;
                id = sc.next();
            }
        }
        return idPw;
    }

}

