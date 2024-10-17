package teacherstudyre;

import java.util.Scanner;



public class Game2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;
        Game[] games = new Game[5];
        int j = 0;

        // 고정된 게임 정보
        games[0] = new Game("dong1", "레이싱", new String[]{"속도", "부딪힘", "코스 디자인", "차량 종류", "아이템"});
        games[1] = new Game("dong2", "마리오", new String[]{"점프", "속도", "레벨 디자인", "적의 종류", "아이템"});
        games[2] = new Game("dong3", "퍼즐", new String[]{"난이도", "시간 제한", "조작", "아이템", "힌트"});
        games[3] = new Game("dong4", "격투", new String[]{"체력", "파워", "속도", "방어력", "스킬"});
        games[4] = new Game("dong4", "농사", new String[]{"체력", "작물", "상점", "땅 크기", "날씨"});

        // 사용자 입력 받기
        System.out.println("\n모든 게임 정보:");
        for (Game game : games) {
            game.displayInfo();
        }

        System.out.println("이 중 2가지는 직접 수정하시는게 가능합니다. 어떤 게임을 수정하시겠습니까?");


        for (int i = 0; i < 2; i++) {
            flag = true;
            System.out.println(i + 1 + "번 째 게임을 선택해주세요.");
            choice = sc.nextInt();
            System.out.print("개발자 이름을 입력하세요: ");
            games[choice - 1].developer = sc.next();
            System.out.print("게임 종류를 입력하세요: ");
            games[choice - 1].gameType = sc.next();

            // 게임 특성 초기화
            games[choice - 1].attributes = setattri(choice, games[choice - 1].attributes);
            // 능력치 입력 받기
            while (flag) {
                System.out.print("게임특성 " + (j + 1) + " 입력: ");
                games[choice - 1].attributes[j] = sc.nextLine();
                System.out.println("게임 특성을 계속 입력하시겠습니까?\n1.예 2.아니오");
                choice = sc.nextInt();
                if(choice == 1) {
                    flag = true;
                    j++;
                } else if(choice == 2) {
                    flag = false;
                }

            }

        }

        // 모든 게임 정보 출력
        System.out.println("\n모든 게임 정보:");
        for (Game game : games) {
            game.displayInfo();
        }

        sc.close();
    }
    public static String[] setattri(int choice, String[] attributes) {
        for(int i = 0; i < attributes.length; i++) {
            attributes[i] = "";
        }
        // Arrays.fill(attributes, ""); 이걸로 대체도 가능하다고 알려줌
        return attributes;
    }
}
