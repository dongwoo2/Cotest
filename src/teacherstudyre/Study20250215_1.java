package teacherstudyre;

import java.util.Scanner;

public class Study20250215_1 {
    static Scanner sc = new Scanner(System.in);
    static String[] SKILL_NAMES = {"", "힘", "지능", "HP", "MP", "민첩", "운", "스피드",
            "검술", "궁술", "마검술", "마창술", "마법", "힐", "정령", "격투", "창술"};
    static String[] CLASS_NAMES = {"", "전사", "격투가", "창술가", "정령사", "힐러", "마법사", "궁수", "마검사", "마창사"};
    static int[] CLASS_SPECIAL_SKILLS = {0, 8, 15, 16, 14, 13, 12, 9, 10, 11};

    public static void main(String[] args) {
        String id = "";
        String pw = "";
        int choice = 0;
        float[][] abilityValues = new float[10][2];
        float[][] skillNeedAblity = new float[10][2];
        String[] idPw = new String[2];
        String[][] characterSkills = new String[10][2];
        float baseDamage = 0;


        idPw = welcomeJoin();
        login(idPw);
        String name = createCharacter();
        displayCharacterClasses();
        choice = selectClass();
        abilityValues = selectAbilities(choice);
        characterSkills = skillNameLevel(choice);
        displayCharacterInfo(name, choice, abilityValues, characterSkills);
        skillNameLevel(choice);
        skillNeedAblity = skillNeedAblity(choice);
    }

    public static String[] welcomeJoin() {
        System.out.println("회원가입을 시작합니다.");
        System.out.println("아이디를 입력해주세요");

        String id = "";
        String pw = "";
        String[] idPw = new String[2];
        boolean isValidInput = false;

        while (!isValidInput) {
            id = sc.next();
            if (id.length() > 4) {
                System.out.println("id 입력 완료");
                idPw[0] = id;

                System.out.println("비밀번호를 입력해주세요");
                while (!isValidInput) {
                    pw = sc.next();
                    if (pw.length() > 6) {
                        System.out.println("비번 입력 완료");
                        idPw[1] = pw;
                        isValidInput = true;
                    } else {
                        System.out.println("6자보다 길게 입력해주세요.");
                    }
                }
            } else {
                System.out.println("4글자보다 길게 입력해주세요.");
            }
        }
        return idPw;
    }

    public static void login(String[] idPw) {
        System.out.println("로그인을 시작합니다.");
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("id를 입력해주세요.");
            String inputId = sc.next();
            System.out.println("pw를 입력해주세요.");
            String inputPw = sc.next();

            if (inputId.equals(idPw[0]) && inputPw.equals(idPw[1])) {
                System.out.println("로그인 성공!");
                isLoggedIn = true;
            } else {
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public static String createCharacter() {
        System.out.println("캐릭터의 이름을 적어주세요.");
        String name = sc.next();
        System.out.println("name = " + name);
        return name;
    }

    public static void displayCharacterClasses() {
        System.out.println("직업을 선택하세요.");
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

    public static int selectClass() {
        int choice = 0;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            choice = sc.nextInt();
            if (choice < 1 || choice > 9) {
                System.out.println("없는 직업입니다 다시 선택해주세요.");
            } else {
                isValidChoice = true;
                System.out.println(CLASS_NAMES[choice] + " 직업을 선택하셨습니다.");
            }
        }
        return choice;
    }

    public static void displayAbilityOptions() {
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
    }

    public static float[][] setupBaseAbilities(int classChoice) {
        float[][] abilities = new float[10][2];
        int abilityCnt = 0;
        int specialSkillId = CLASS_SPECIAL_SKILLS[classChoice];

        if (classChoice >= 1 && classChoice <= 3) {
            abilities[0][0] = 1; // 힘
            abilities[0][1] = 1; // 능력치 값
            abilities[1][0] = 5; // 민첩
            abilities[1][1] = 1; // 능력치 값
            abilityCnt = 4; // 설정 가능한 숫자의 능력치 갯수
        } else if (classChoice >= 4 && classChoice <= 7) {
            abilities[0][0] = 2; // 지능
            abilities[0][1] = 1; // 능력치 값
            abilityCnt = 5;
        } else {
            abilities[0][0] = 2; // 지능
            abilities[0][1] = 1; // 능력치 값
            abilities[1][0] = 4; // MP
            abilities[1][1] = 1; // 능력치 값
            abilities[2][0] = 5; // 민첩
            abilities[2][1] = 1; // 능력치 값
            abilityCnt = 3;
        }

        abilities[9][0] = abilityCnt; // 설정 가능한 능력치 갯수
        abilities[9][1] = specialSkillId; //스페셜 스킬 ID 예) 전사면 검술값이 들어감

        return abilities;
    }

    public static float[][] selectAbilities(int classChoice) {
        float[][] abilities = setupBaseAbilities(classChoice);
        int baseAbilityCount = 0;
        int abilitiesNeeded = 0;
        int specialSkillId = 0;

        for (int i = 0; i < abilities.length-1; i++) {
            if (abilities[i][0] > 0) {
                baseAbilityCount++; // 베이스로 능력치 몇 개 설정되어있는지 확인
            }
        }

        abilitiesNeeded = (int)abilities[9][0]; // 설정 가능한 능력치 갯수
        specialSkillId = (int)abilities[9][1]; // 무슨 스페셜 스킬값이 들어갔는지

        System.out.println("능력치를 선택하세요.");
        System.out.println("추가로 " + abilitiesNeeded + "개를 선택해야 합니다.");
        displayAbilityOptions();

        System.out.println("현재 보유 능력치:");
        displayAbilities(abilities);

        int selectedCount = 0;
        while (selectedCount < abilitiesNeeded) {
            System.out.println((selectedCount+1) + "번째 추가 능력치를 선택하세요:");
            int choice = sc.nextInt();

            // continue를 잘 확인해보자 내가 while을 한 개만 쓸 수 있게 할 수 있는 방법인듯
            if (choice < 1 || choice > 16) {
                System.out.println("잘못된 능력치 번호입니다. 다시 선택해주세요.");
                continue;
            }

            boolean alreadyHas = false;
            for (int i = 0; i < baseAbilityCount + selectedCount; i++) {
                if (abilities[i][0] == choice) {
                    alreadyHas = true;
                    break;
                }
            }

            if (alreadyHas) {
                System.out.println("이미 가지고 있는 능력치입니다. 다시 선택해주세요.");
                continue;
            }

            float value = 0.5f;
            if (choice == specialSkillId) {
                value = 1.0f;
            }

            abilities[baseAbilityCount + selectedCount][0] = choice;
            abilities[baseAbilityCount + selectedCount][1] = value;
            selectedCount++;

            System.out.println("현재 보유 능력치:");
            displayAbilities(abilities);
        }

        System.out.println("능력치 선택이 완료되었습니다!");
        return abilities;
    }

    public static void displayAbilities(float[][] abilities) {
        for (int i = 0; i < abilities.length-1; i++) {
            if (abilities[i][0] > 0) {
                int skillId = (int)abilities[i][0];
                System.out.println(SKILL_NAMES[skillId] + ": " + abilities[i][1]);
            }
        }
        System.out.println("------------------------");
    }

    // 여기서 매개변수를 하나 더 받아서 지금 내 스킬의 레벨의 몇 인지도 확인이 가능하게 만들어지면 좋을 듯
    // 지금은 1로 하드코딩 되어있음
    public static String[][] skillNameLevel(int choice) {
        String[][] skills = new String[10][3];

        System.out.println(CLASS_NAMES[choice] + "의 스킬입니다.");

        switch (choice) {
            case 1:
                skills[0][0] = "방패치기";
                skills[0][1] = "상대를 1초동안 넉백합니다";
                skills[1][0] = "강타";
                skills[1][1] = "기본공격의 2배의 데미지를 입힙니다.";
                break;
            case 2:
                skills[0][0] = "화려한 스텝";
                skills[0][1] = "민첩력이 1올라갑니다.";
                skills[1][0] = "발차기";
                skills[1][1] = "상대를 5m 뒤로 물러나게 합니다.";
                break;
            case 3:
                skills[0][0] = "찌르기";
                skills[0][1] = "상대를 출혈 상태로 만듭니다.";
                skills[1][0] = "약점공격";
                skills[1][1] = "치명타 공격이 적중합니다.";
                break;
            case 4:
                skills[0][0] = "정령의 힘";
                skills[0][1] = "물,불,대지,바람 4개의 정령 1개의 힘을 빌립니다."; // 정령의 스킬 빌리기 가능
                // 물 - 워터젯 - 단일기 , 대지 - 돌 벽 - 방어기, 불 - 파이어스톰 - 광역기, 바람 - 신속의 바람 - 움직이는 속도 up
                skills[1][0] = "정령 강화";
                skills[1][1] = "정령의 30% 능력이 강화됩니다.";
                break;
            case 5:
                skills[0][0] = "힐";
                skills[0][1] = "체력의 50%를 회복합니다.";
                skills[1][0] = "방어막";
                skills[1][1] = "체력의 70%의 방어막이 생성됩니다.";
                break;
            case 6:
                skills[0][0] = "파이어볼";
                skills[0][1] = "상대에게 마법 100% 데미지를 입히고 화상 효과가 적중합니다."; // 화상효과 5초동안 도트뎀 3 - 5초 지속
                skills[1][0] = "텔레포트";
                skills[1][1] = "50m의 거리를 이동합니다.";
                break;
            case 7:
                skills[0][0] = "속사";
                skills[0][1] = "연속 기본공격이 3회 적중합니다.";
                skills[1][0] = "스나이핑";
                skills[1][1] = "3 ~ 5초의 차징시간이 필요하고 상대에게 기본공격의 5배의 데미지를 입힙니다.";
                break;
            case 8:
                skills[0][0] = "마법 부여";
                skills[0][1] = "검에 마법을 부여합니다.";
                skills[1][0] = "베기";
                skills[1][1] = "상대에게 1.5배의 데미지를 입힙니다 검에 부여된 마법에 따라 추가 데미지가 들어갑니다.";
                break;
            case 9:
                skills[0][0] = "마법 부여";
                skills[0][1] = "창에 마법을 부여합니다."; // 불,얼음,전격
                skills[1][0] = "찌르기";
                skills[1][1] = "상대에게 1.5배의 데미지를 입힙니다 창에 부여된 마법에 따라 추가 데미지가 들어갑니다.";
                break;
        }

        for (int i = 0; i < 2; i++) {
            skills[i][2] = "1";
            System.out.println((i+1) + ". " + skills[i][0] + " (레벨 " + skills[i][2] + ")");
        }

        return skills;
    }
    /*
    -스킬 속성-
    이름: 스킬의 명칭 (예: "방패치기")
    설명: 스킬의 작동 방식 및 효과에 대한 설명 - 설명하자 상대를 넉백한다
    필요 능력치: 스킬 사용을 위한 최소 능력치 요구 사항 (예: 힘 10, 민첩 5)  - 함수 완성
    포인트 비용: 스킬을 업그레이드하거나 사용하기 위한 비용 - 돈으로 하자
    효과: 스킬의 게임 내 효과, 예를 들어 피해량 증가, 방어력 향상 등 - 능력치 향상도 중요 순간적으로 능력치가 어떻게 올라가는지
     */
    // 스킬 필요 능력치 셋팅
    // 필요 능력치는 2개만 셋팅 일단
    public static float[][] skillNeedAblity(int choice) {
        float[][] needAbilities = new float[10][2];

        //System.out.println("필요 능력치 입니다.");

        switch (choice) {
            case 1: // 전사
                // 방패치기 , 힘 2, 민첩 2
                needAbilities[0][0] = 1; // 힘
                needAbilities[0][1] = 2; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 강타 , 힘 3, 민첩 1
                needAbilities[2][0] = 1; // 힘
                needAbilities[2][1] = 3; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 1; // 필요한 능력치 값
                break;
            case 2: // 격투가
                // 화려한 스텝 , 스피드 1, 민첩 3
                needAbilities[0][0] = 7; // 스피드
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 3; // 필요한 능력치 값
                // 발차기 , 힘 1, 민첩 3
                needAbilities[2][0] = 1; // 힘
                needAbilities[2][1] = 3; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 3; // 필요한 능력치 값
                break;
            case 3: // 창술사
                // 찌르기 , 창술 1, 민첩 2
                needAbilities[0][0] = 16; // 창술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 약점공격 , 지능 1, 민첩 2
                needAbilities[2][0] = 2; // 지능
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 4: // 정령사
                // 원소 공격 , 정령 1, MP 1
                needAbilities[0][0] = 14; // 정령
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 1; // 필요한 능력치 값
                // 원소 강화 , 정령 1, MP 2
                needAbilities[2][0] = 14; // 정령
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 5: // 힐러
                // 힐 , 힐 1, 마법 1
                needAbilities[0][0] = 13; // 힐
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 12; // 마법
                needAbilities[1][1] = 1; // 필요한 능력치 값
                // 방어막 , 마법 1, MP 2
                needAbilities[2][0] = 12; // 마법
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 6: // 마법사
                // 파이어볼 , 마법 1, MP 2
                needAbilities[0][0] = 12; // 마법
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 텔레포트 , 마법 2, MP 2
                needAbilities[2][0] = 12; // 마법
                needAbilities[2][1] = 2; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 7: // 궁수
                // 속사 , 궁술 1, 민첩 2
                needAbilities[0][0] = 9; // 궁술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 스나이핑 , 궁술 1, 힘 2
                needAbilities[2][0] = 9; // 궁술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 1; // 힘
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 8: // 마검사
                // 마법 부여 , 마검술 1, MP 2
                needAbilities[0][0] = 10; // 마검술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 베기 , 마검술 1, 민첩 2
                needAbilities[2][0] = 10; // 마검술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 9: // 마창사
                // 마법 부여 , 마창술 1, MP 2
                needAbilities[0][0] = 11; // 마창술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 찌르기 , 마창술 1, 민첩 2
                needAbilities[2][0] = 11; // 마창술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
        }
        System.out.println("필요 능력치 입니다.");
        displayAbilities(needAbilities);
        return needAbilities;
    }

    public static float[][] skillLevelUp(int choice, float[][] needAbilities, int[] skillLevel) {
        int money = 0;
        // 니드 어벨리티로 체크
        // skilllevel[0] = 1 번째 스킬 고정되어있음 스킬은 방패치기가 0 번째 레벨도 체크

        // 방패치기 레벨을 중급으로 올리시겠습니까? 그러면 일단 이렇게 상급으로 올리시겠습니까도 한번 올려주고
        // 근데 스킬 1개씩만 올려야되는 경우도 생기겠네
        // 일단 빨리 구현하자
        for(int i = 0; i <= 3; i++) { // 일단 중급일 경우 이런식으로 needablity 올려주고 한 번에 올릴 수 있음
            needAbilities[i][1] += 1;
        }
        // 중급일경우
        for (int i = 0; i < needAbilities.length-1; i++) {
            if (needAbilities[i][0] > 0) {
                int skillId = (int)needAbilities[i][0];
                System.out.println(SKILL_NAMES[skillId] + ": " + needAbilities[i][1]);
            }
        }

        switch (choice) {
            case 1: // 전사
                System.out.println("어떤 스킬을 레벨업 하시겠습니까?");
                System.out.println("1. 방패치기 2. 강타");
                choice = sc.nextInt();
                // 전사라면 방패치기 2렙 힘3,민첩3
                // 방패치기 3렙 힘4, 민첩4 이런식으로
                // 방패치기 , 힘 2, 민첩 2
                needAbilities[0][0] = 1; // 힘
                needAbilities[0][1] = 3; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 3; // 필요한 능력치 값
                // 강타 , 힘 3, 민첩 1
                needAbilities[2][0] = 1; // 힘
                needAbilities[2][1] = 3; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 1; // 필요한 능력치 값

                if(skillLevel[0] == 1) {

                }
                if(choice == 1) {
                    if(skillLevel[choice - 1] == 1)
                    needAbilities[0][0] = 1;
                    needAbilities[0][1] = 3;

                    needAbilities[1][0] = 5;
                    needAbilities[1][1] = 3;
                }
                // 1이 올라가는 기준 스텟? 변경시 ㅇㅇㅇ

                break;
            case 2: // 격투가
                // 화려한 스텝 , 스피드 1, 민첩 3
                needAbilities[0][0] = 7; // 스피드
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 3; // 필요한 능력치 값
                // 발차기 , 힘 1, 민첩 3
                needAbilities[2][0] = 1; // 힘
                needAbilities[2][1] = 3; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 3; // 필요한 능력치 값
                break;
            case 3: // 창술사
                // 찌르기 , 창술 1, 민첩 2
                needAbilities[0][0] = 16; // 창술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 약점공격 , 지능 1, 민첩 2
                needAbilities[2][0] = 2; // 지능
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 4: // 정령사
                // 원소 공격 , 정령 1, MP 1
                needAbilities[0][0] = 14; // 정령
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 1; // 필요한 능력치 값
                // 원소 강화 , 정령 1, MP 2
                needAbilities[2][0] = 14; // 정령
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 5: // 힐러
                // 힐 , 힐 1, 마법 1
                needAbilities[0][0] = 13; // 힐
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 12; // 마법
                needAbilities[1][1] = 1; // 필요한 능력치 값
                // 방어막 , 마법 1, MP 2
                needAbilities[2][0] = 12; // 마법
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 6: // 마법사
                // 파이어볼 , 마법 1, MP 2
                needAbilities[0][0] = 12; // 마법
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 텔레포트 , 마법 2, MP 2
                needAbilities[2][0] = 12; // 마법
                needAbilities[2][1] = 2; // 필요한 능력치 값
                needAbilities[3][0] = 4; // MP
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 7: // 궁수
                // 속사 , 궁술 1, 민첩 2
                needAbilities[0][0] = 9; // 궁술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 5; // 민첩
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 스나이핑 , 궁술 1, 힘 2
                needAbilities[2][0] = 9; // 궁술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 1; // 힘
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 8: // 마검사
                // 마법 부여 , 마검술 1, MP 2
                needAbilities[0][0] = 10; // 마검술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 베기 , 마검술 1, 민첩 2
                needAbilities[2][0] = 10; // 마검술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
            case 9: // 마창사
                // 마법 부여 , 마창술 1, MP 2
                needAbilities[0][0] = 11; // 마창술
                needAbilities[0][1] = 1; // 필요한 능력치 값
                needAbilities[1][0] = 4; // MP
                needAbilities[1][1] = 2; // 필요한 능력치 값
                // 찌르기 , 마창술 1, 민첩 2
                needAbilities[2][0] = 11; // 마창술
                needAbilities[2][1] = 1; // 필요한 능력치 값
                needAbilities[3][0] = 5; // 민첩
                needAbilities[3][1] = 2; // 필요한 능력치 값
                break;
        }
    }

    public static void displayCharacterInfo(String name, int classChoice, float[][] abilities, String[][] skills) {
        System.out.println("\n======= 캐릭터 정보 =======");
        System.out.println("이름: " + name);
        System.out.println("직업: " + CLASS_NAMES[classChoice]);

        System.out.println("\n----- 능력치 -----");
        displayAbilities(abilities);

        System.out.println("\n----- 스킬 -----");
        for (int i = 0; i < 2; i++) {
            if (skills[i][0] != null) {
                System.out.println((i+1) + ". " + skills[i][0] + " (레벨 " + skills[i][1] + ")");
            }
        }
        System.out.println("=======================");
    }
    // 매개변수 1 능력치, 매개변수 2 직업
    /*
        전사, 격투가, 창술가 > 4개 선택 > 힘, 민첩[2개]
        마법사, 궁수, 힐러, 정령사 > 5개 선택 > 지식[1개]
        마검사, 마창사 > 지식, MP, 스피드 > 3개밖에 선택 못함
        1. 힘, 2. 지능, 3. HP , 4. MP, 5. 민첩, 6. 운, 7. 스피드,8. 검술
        9. 궁술, 10 .마검술, 11. 마창술, 12. 마법, 13. 힐, 14. 정령, 15. 격투, 16. 창술
     */

    public static float baseDamageSet(float[][] abilityValues, int choice, float baseDamage) {
        switch (choice) {
            case 1: // 전사 ,전사의 경우 힘1당 기본공격력 5 민첩은 3, 검술 1당 5
                if(abilityValues[0][0] == 1) {
                    baseDamage += abilityValues[0][1] * 5;
                }
                if(abilityValues[1][0] == 5) {
                    baseDamage += abilityValues[0][1] * 3;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 8) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 2: // 격투가 , 격투가의 경우 힘1당 기본공격력 4 민첩은 4, 갹투1당 5
                if(abilityValues[0][0] == 1) {
                    baseDamage += abilityValues[0][1] * 4;
                }
                if(abilityValues[1][0] == 5) {
                    baseDamage += abilityValues[0][1] * 4;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 15) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 3: // 창술사 , 창술가의 경우 힘1당 기본공격력 3 민첩은 5 창술1당 5
                if(abilityValues[0][0] == 1) {
                    baseDamage += abilityValues[0][1] * 3;
                }
                if(abilityValues[1][0] == 5) {
                    baseDamage += abilityValues[0][1] * 5;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 16) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 4: // 정령사
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 10;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 14) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 5: // 힐러
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 10;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 13) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 6: // 마법사
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 10;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 12) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 7: // 궁수
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 10;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 9) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 8: // 마검사
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 3;
                }
                if(abilityValues[1][0] == 7) {
                    baseDamage += abilityValues[0][1] * 5;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 10) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
            case 9: // 마창사
                if(abilityValues[0][0] == 2) {
                    baseDamage += abilityValues[0][1] * 3;
                }
                if(abilityValues[1][0] == 7) {
                    baseDamage += abilityValues[0][1] * 5;
                }
                for(int i = 0; i < abilityValues.length; i++) {
                    if(abilityValues[i][0] == 11) {
                        baseDamage += abilityValues[i][1] * 5;
                    }
                }
                break;
        }
            return baseDamage;
    }
    // 회피율, 명중율, 이런 특성도 만들자 만들 특성
    // 회피, 명중
//
//    Acc(Accuracy)	명중률,
//    Avd(Avoidability) 회피율
    public static float[] accAvd(float[] accAvd, float abilityValues[][], int choice) {
        // 회피먼저 설정하자
        // 회피는 동일하게 해버리자 - 민첩,운,스피드
        //  민첩 운 스피드 5 6 7
        for(int i = 0; i < abilityValues.length; i++) {
            if(abilityValues[i][0] == 5) {
                accAvd[0] += abilityValues[i][1] * 5;
            } else if (abilityValues[i][0] == 6) {
                accAvd[0] += abilityValues[i][1] * 3;
            } else if (abilityValues[i][0] == 7) {
                accAvd[0] += abilityValues[i][1] * 4;
            }
        }

        if(choice <= 3) { //힘3 민첩5 -> 전사, 격투가, 창술가
            for(int i = 0; i < abilityValues.length; i++) {
                if(abilityValues[i][0] == 1) {
                    accAvd[1] += abilityValues[i][1] * 3;
                } else if (abilityValues[i][0] == 5) {
                    accAvd[1] += abilityValues[i][1] * 5;
                }
            }
        } else if(choice <= 7) { // 지능 5, 운4 -> 마법사, 궁수, 힐러, 정령사 운은 필수 스텟이 아니라 1 더 높게
            for(int i = 0; i < abilityValues.length; i++) {
                if(abilityValues[i][0] == 2) {
                    accAvd[1] += abilityValues[i][1] * 5;
                } else if (abilityValues[i][0] == 6) {
                    accAvd[1] += abilityValues[i][1] * 5;
                }
            }
        } else if (choice <= 9) { // 지능 5, 스피드 3 -> 마검사, 마창사
            for(int i = 0; i < abilityValues.length; i++) {
                if(abilityValues[i][0] == 2) {
                    accAvd[1] += abilityValues[i][1] * 5;
                } else if (abilityValues[i][0] == 7) {
                    accAvd[1] += abilityValues[i][1] * 3;
                }
            }
        }
        return accAvd;
    }

    // 스킬 레벨업 만들어야함 업그레이드 가능하게
}