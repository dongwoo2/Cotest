package teacherstudyre;

import java.util.Scanner;

public class Study20250215_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String id = "";
        String pw = "";
        boolean flag = true;
        int choice = 0;
        float choiceArray[][] = new float[10][2];
        String idPw[] = new String[2];
        String havaSkill[][] = new String[10][2];

        // 1. 회원가입
        idPw = welcomeJoin();

        // 2. 로그인
        System.out.println("로그인을 시작합니다.");
        System.out.println("id를 입력해주세요.");
        id = sc.next();
        System.out.println("pw를 입력해주세요.");
        pw = sc.next();

        //3. 캐릭터 이름 선택
        System.out.println("캐릭터의 이름을 적어주세요.");
        String name = sc.next();
        System.out.println("name = " + name);

        //4. 직업 선택
        characterClass();
        System.out.println("직업을 선택하세요.");


        while (flag) {
            choice = sc.nextInt();
            if (choice > 9 || choice < 0) {
                System.out.println("없는 직업입니다 다시 선택해주세요.");
            } else {
                choiceArray = showAbility(choice);
                flag = false;
            }
        }


        // 5. 능력치 선택
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
                cant = 0;
                choice1 = sc.nextInt(); //능력치 선택
                for(int i = 0; i < abiltyCnt + cntHaveAblity; i++) {
                    if(haveAblity[i][0] == choice1) {
                        System.out.println("이미 가지고 있는 능력치 입니다. 다시 선택해주세요");
                        cant++;
                    }
                }
                if (choice > 7 && paty == choice1 && cant == 0) { // 기술이면서 자기 직업이랑 부합한 능력치 일 때
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 1;
                    goodCnt++;
                } else if(choice > 7 && paty != choice1 && cant == 0){ // 기술이면서 자기 직업이랑 부합한 능력치가 아닐 때
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 0.5f;
                    goodCnt++;
                } else if(choice < 7 && paty != choice1 && cant == 0) {
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 0.5f;
                    goodCnt++;
                } else if(choice < 7 && paty == choice1 && cant == 0) {
                    haveAblity[j][0] = choice1;
                    haveAblity[j][1] = 1;
                    goodCnt++;
                }
                strSkillName(haveAblity);
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


            /**"
             * 1.전사 클래스, (warrior)\n" +
                 * - 방패치기 - 힘3, 민첩1
                 * - 강타 - 힘5, 민첩2
             "2.격투가 클래스, (fighter)\n" +
                 * - 화려한 스텝 - 회피 확률을 높여줌
                 * - 발차기
             "3.창술가 클래스, (spearman)\n" +
                 * - 찌르기
                 * - 약점 공격

             "4.정령사 클래스, (spiritist)\n" +
                 * - 원소 공격 - 정령의 기술을 이용가능 - 여러가지 타입이 있을거임 불, 물 , 번개 이런거
                 * - 원소 강화
             "5.힐러 클래스, (healer)\n" +
                 * - 힐
                 * - 방어막
             "6.마법사 클래스, (wizard)\n" +
                 * - 파이어볼
                 * - 텔레포트
             "7.궁수 클래스, (Archer)\n" +
                 * - 속사
                 * - 스나이핑
             "8.마검사 클래스, (magicwarrior)\n" +
                 * - 마법 부여
                 * - 베기
             "9.마창사 클래스, (magicspearman)");
                 * -


             근데 스킬에 전제조건 같은 게 있음 힘 10 민첩 5 이런 거
             전제 조건 값 넣을 방법
             */


    /*
        [0][0] = 스킬 이름
        [0][1] = 스킬 레벨

    */
    public static String[][] skillNameLevel(int choice) {

        String havaSkill[][] = new String[10][2];

        switch (choice) {
            case 1:
                System.out.println("전사의 스킬입니다.");
                System.out.println("방패치기");
                System.out.println("강타");
                havaSkill[0][0] = "방패치기";
                havaSkill[1][0] = "강타";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 2:
                System.out.println("격투사의 스킬입니다.");
                System.out.println("화려한 스텝");
                System.out.println("발차기");
                havaSkill[0][0] = "화려한 스텝";
                havaSkill[1][0] = "발차기";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 3:
                System.out.println("창술가의 스킬입니다.");
                System.out.println("찌르기");
                System.out.println("약점공격");
                havaSkill[0][0] = "찌르기";
                havaSkill[1][0] = "약점공격";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 4:
                System.out.println("정령사의 스킬입니다.");
                System.out.println("원소 공격");
                System.out.println("원소 강화");
                havaSkill[0][0] = "원소 공격";
                havaSkill[1][0] = "원소 강화";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 5:
                System.out.println("힐러의 스킬입니다.");
                System.out.println("힐");
                System.out.println("방어막");
                havaSkill[0][0] = "힐";
                havaSkill[1][0] = "방어막";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 6:
                System.out.println("마법사의 스킬입니다.");
                System.out.println("파이어볼");
                System.out.println("텔레포트");
                havaSkill[0][0] = "파이어볼";
                havaSkill[1][0] = "텔레포트";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 7:
                System.out.println("궁수의 스킬입니다.");
                System.out.println("속사");
                System.out.println("스나이핑");
                havaSkill[0][0] = "속사";
                havaSkill[1][0] = "스나이핑";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 8:
                System.out.println("마검사의 스킬입니다.");
                System.out.println("마법 부여");
                System.out.println("강타");
                havaSkill[0][0] = "마법 부여";
                havaSkill[1][0] = "강타";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
            case 9:
                System.out.println("마창사의 스킬입니다.");
                System.out.println("마법 부여");
                System.out.println("찌르기");
                havaSkill[0][0] = "마법 부여";
                havaSkill[1][0] = "찌르기";
                havaSkill[0][1] = "1";
                havaSkill[1][1] = "1";
                break;
        }
        return havaSkill;

    }


    /*
        매개변수 : 캐릭터 직업, 고른 스킬
        리턴 : 스킬 사용이 가능한지 체크하고, 스킬사용

     */
    public static void useSkill(int cClass, int choice, String[][] haveSkill, int[][] sNeed, float haveAblity[][]) {
        // 일단 스킬 사용시에 스킬을 사용할려면 사용자의 직업을 알아야함
        // 그래서 직업과 매치 시켜야함 클래스의 값에 따라 index가 정해지니 cClass를 인덱스로 넣으면 되잖아
        // cClass의 최소값은 1일테고
        // 사용자의 능력치가 필요함
        // 근데 사용자의 능력치가 그냥 이상하게 들어가있네 이거 수정해야함
        int cant = 0;
        if(cClass > 0) {
            for(int i = 0; i < sNeed[cClass-1].length; i++) {
                for(int j = 0; j < sNeed[cClass-1].length; j++) {
                    if (sNeed[cClass -1][i] != 0) { // 사용자의 i번째 능력치를 가지고 와야함
                        if(haveAblity[j][0] == i) { // 0이 힘 지능 이런거 따지는 순서 1이 그거에 대한 값
                            if(sNeed[cClass-1][i] > haveAblity[j][1]) {
                                System.out.println("스킬 사용 불가");
                                cant++;
                                // 근데 처음에 cant가 0일수도 있으니까 이게 들어갈 수가 있네 스킬 사용가능이
                                // 나는 능력치 전부 다 체크한다음에 해보고 싶은데 그러면 마지막 순번에 하면 되겠네
                            } else if(cant == 0 && sNeed[cClass-1][i] < haveAblity[j][1]) { // 사용자가 가진 능력치가 더 크다면
                                if(i == sNeed[cClass-1].length) { // 마지막일 때
                                    System.out.println("스킬 사용 가능");
                                }
                            }
                        }
                    }
                }

            }
            if(sNeed[cClass-1][0] != 0) {

            }
        }



    }

    // 스킬 제한 능력치를 설정해둬야 하는데
    // 아직 아무 설정이 없음
    //
    /**"
     * 1.전사 클래스, (warrior)\n" +
     * - 방패치기 - 힘3, 민첩1
     * - 강타 - 힘5, 민첩2
     "2.격투가 클래스, (fighter)\n" +
     * - 화려한 스텝 - 회피 확률을 높여줌
     * - 발차기
     "3.창술가 클래스, (spearman)\n" +
     * - 찌르기
     * - 약점 공격

     "4.정령사 클래스, (spiritist)\n" +
     * - 원소 공격 - 정령의 기술을 이용가능 - 여러가지 타입이 있을거임 불, 물 , 번개 이런거
     * - 원소 강화
     "5.힐러 클래스, (healer)\n" +
     * - 힐
     * - 방어막
     "6.마법사 클래스, (wizard)\n" +
     * - 파이어볼
     * - 텔레포트
     "7.궁수 클래스, (Archer)\n" +
     * - 속사
     * - 스나이핑
     "8.마검사 클래스, (magicwarrior)\n" +
     * - 마법 부여
     * - 베기
     "9.마창사 클래스, (magicspearman)");
     * - 마법 부여
     * - 찌르기


     근데 스킬에 전제조건 같은 게 있음 힘 10 민첩 5 이런 거
     전제 조건 값 넣을 방법
     */


    public static int[][] alReadySkill(int cClass) {
        // 전제 조건
        // 일단 최대 필요 조건은 3개
        String sName[][] = new String[100][3];
        int sNeed[][] = new int[100][20];
        // 방패치기
        // 힘이 필요한 걸 어떤 기준으로 알건데?
        /**" 결국 이순서 기준으로 해야함
        1. 힘
        2. 지능
        3. HP
        4. MP
        5. 민첩
        6. 운
        7. 스피드
        8. 검술
        9. 궁술
        10 .마검술
        11. 마창술
        12. 마법
        13. 힐
        14. 정령
        15. 격투
        16. 창술
         haveAblity[j][0] = choice1; // 힘 지능 이런거 이렇게 되어 있음 이거 헷갈려
         haveAblity[j][1] = 1;
         앞에를 전사 기술 이렇게 바꿔버리니까 기준이 너무 헷갈려저 버림
         다시 기준을 만들어야함
         0~10 이렇게 기준 놓는거는 나쁘지 않은데
         결국 내가 가지고 있는 능력치와 스킬 요구 능력치를 비교하는게 어려워서 고민중
         비교를 할 수 있긴 한데 여기 있는 기준을 더 쉽게 바꾸는게 앞으로도 훨씬 쉬워보임
         왜냐면 이미 능력치는 그렇게 셋팅되어 있는게 편하니까 그 기준에 맞춰서 가야함
         근데 굳이 모든 스킬을 셋팅할 필요가 있을까? 일단 자기 직업군에 맞는 스킬만 셋팅해주면 되는거 아닌가?
         하나로 통일시켜서
         다시 자기 직업군에 맞는 스킬만 셋팅하자
         내 직업을 매개변수로 받고 그거에 따라서 switch를 쓰든 if문을 쓰든 하자
         됐다.
         cClass 받아서 셋팅하자
         */
        switch (cClass) { // case 1: 전사 이렇게
            case 1:
                sName[0][0] = "방패치기";
                sName[0][1] = "힘 3";
                sName[0][2] = "민 1";
                sNeed[0][0] = 1; // 사실 이런식으로 되어야하는데 힘이 1번이니까 1
                sNeed[0][1] = 3; // 이게 값 왜냐면 이런식으로 되어있으니까
                sNeed[1][0] = 5;
                sNeed[1][1] = 1; // 이제 그러면 겹침 그리고 값을 어떻게 알건지도 헷갈림 방패치기인거 어떻게 알건데? 잘 모르겠음

                sName[11][0] = "강타";
                sName[11][1] = "힘 5";
                sName[11][2] = "민 2";
                sNeed[11][0] = 1;
                sNeed[11][1] = 5;
                sNeed[12][0] = 5;
                sNeed[12][1] = 2;
                break;
                case 2:

        }
        // 일단 0~10은 전사 기술로 하자
        sName[0][0] = "방패치기";
        sName[0][1] = "힘 3";
        sName[0][2] = "민 1";
        sNeed[0][0] = 1; // 사실 이런식으로 되어야하는데 힘이 1번이니까 1
        sNeed[0][1] = 3; // 이게 값 왜냐면 이런식으로 되어있으니까
        sNeed[1][0] = 5;
        sNeed[1][1] = 1; // 이제 그러면 겹침 그리고 값을 어떻게 알건지도 헷갈림 방패치기인거 어떻게 알건데? 잘 모르겠음
        // 강타
        sName[1][0] = "강타";
        sName[1][1] = "힘 5";
        sName[1][2] = "민 2";
        sNeed[1][1] = 5;
        sNeed[1][5] = 2;

        // 11~20 격투가 클래스로 하자
        
        // 화려한 스텝
        sName[11][0] = "화려한 스텝";
        sName[11][1] = "힘 1";
        sName[11][2] = "민 3";
        sNeed[11][1] = 1;
        sNeed[11][5] = 3;
        // 발차기
        sName[12][0] = "발차기";
        sName[12][1] = "힘 2";
        sName[12][2] = "민 5";
        sNeed[12][1] = 2;
        sNeed[12][5] = 5;

        // 21~30
        //3.창술가 클래스, (spearman)\n" +
        //        * - 찌르기
        //        * - 약점 공격

        // 찌르기
        sName[21][0] = "찌르기";
        sName[21][1] = "스피드 3";
        sName[21][2] = "민첩 1";
        sNeed[21][7] = 3;
        sNeed[21][5] = 1;
        // 약점 공격
        sName[22][0] = "약점 공격";
        sName[22][1] = "지능 3";
        sName[22][2] = "민 5";
        sNeed[22][2] = 3;
        sNeed[22][5] = 5;


//        "4.정령사 클래스, (spiritist)\n" +
//                * - 원소 공격 - 정령의 기술을 이용가능 - 여러가지 타입이 있을거임 불, 물 , 번개 이런거
//                * - 원소 강화

        // 원소 공격
        sName[31][0] = "원소 공격";
        sName[31][1] = "MP 2";
        sName[31][2] = "정령 1";
        sNeed[31][4] = 2;
        sNeed[31][14] = 1;
        // 원소 강화
        sName[32][0] = "원소 강화";
        sName[32][1] = "MP 3";
        sName[32][2] = "정령 2";
        sNeed[32][4] = 3;
        sNeed[32][14] = 2;


        //   "5.힐러 클래스, (healer)\n" +
         //       * - 힐
        //        * - 방어막


        // 힐
        sName[41][0] = "힐";
        sName[41][1] = "MP 3";
        sName[41][2] = "힐 2";
        sNeed[41][4] = 3;
        sNeed[41][13] = 2;
        // 방어막
        sName[42][0] = "방어막";
        sName[42][1] = "MP 3";
        sName[42][2] = "지능 2";
        sNeed[42][4] = 3;
        sNeed[42][2] = 2;

//        "6.마법사 클래스, (wizard)\n" +
//                * - 파이어볼
//                * - 텔레포트
        // 파이어볼
        sName[51][0] = "파이어볼";
        sName[51][1] = "MP 4";
        sName[51][2] = "지능 2";
        sNeed[51][4] = 4;
        sNeed[51][2] = 2;
        // 텔레포트
        sName[52][0] = "텔레포트";
        sName[52][1] = "MP 3";
        sName[52][2] = "지능 4";
        sNeed[52][4] = 3;
        sNeed[52][2] = 4;

//        "7.궁수 클래스, (Archer)\n" +
//                * - 속사
//                * - 스나이핑
        // 속사
        sName[61][0] = "속사";
        sName[61][1] = "민첩 3";
        sName[61][2] = "스피드 2";
        sNeed[61][5] = 3;
        sNeed[61][7] = 2;
        // 스나이핑
        sName[62][0] = "스나이핑";
        sName[62][1] = "민첩 4";
        sName[62][2] = "힘 3";
        sNeed[62][5] = 3;
        sNeed[62][1] = 4;


//        "8.마검사 클래스, (magicwarrior)\n" +
//                * - 마법 부여
//                * - 베기
        // 마법 부여
        sName[71][0] = "마법 부여";
        sName[71][1] = "MP 3";
        sName[71][2] = "마법 2";
        sNeed[71][4] = 3;
        sNeed[71][12] = 2;
        // 베기
        sName[72][0] = "베기";
        sName[72][1] = "힘 3";
        sName[72][2] = "마검술 3";
        sNeed[72][1] = 3;
        sNeed[72][10] = 3;
//        "9.마창사 클래스, (magicspearman)");
//                * - 마법 부여
//                * - 찌르기

        // 마법 부여
        sName[81][0] = "마법 부여";
        sName[81][1] = "MP 3";
        sName[81][2] = "마법 2";
        sNeed[81][4] = 3;
        sNeed[81][12] = 2;
        // 찌르기
        sName[82][0] = "찌르기";
        sName[82][1] = "민첩 3";
        sName[82][2] = "마창술 3";
        sNeed[82][5] = 3;
        sNeed[82][11] = 3;

        return sNeed;
    }



}





