package teacherstudyre;

import java.util.Scanner;

class Game2 {
    String developer;
    String gameType;
    String[] attributes;

    public Game2(String developer, String gameType, String[] attributes) {
        this.developer = developer;
        this.gameType = gameType;
        this.attributes = attributes;
    }

    public void displayInfo() {
        System.out.println("개발자: " + developer);
        System.out.println("게임 종류: " + gameType);
        System.out.print("능력치: ");
        for (String attribute : attributes) {
            System.out.print(attribute + " ");
        }
        System.out.println("\n");
    }
}

public class GameDevelopment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game2[] games = new Game2[5];

        // 고정된 게임 정보
        games[0] = new Game2("Alice", "레이싱", new String[]{"속도", "부딪힘", "코스 디자인", "차량 종류", "아이템"});
        games[1] = new Game2("Bob", "플랫폼", new String[]{"점프", "속도", "레벨 디자인", "적의 종류", "아이템"});
        games[2] = new Game2("Charlie", "퍼즐", new String[]{"난이도", "시간 제한", "조작", "아이템", "힌트"});

        // 사용자 입력 받기
        for (int i = 3; i < 5; i++) {
            System.out.print("개발자 이름을 입력하세요: ");
            String developer = scanner.nextLine();
            System.out.print("게임 종류를 입력하세요: ");
            String gameType = scanner.nextLine();
            String[] attributes = new String[5];

            // 능력치 입력 받기
            for (int j = 0; j < 5; j++) {
                System.out.print("능력치 " + (j + 1) + " 입력: ");
                attributes[j] = scanner.nextLine();
            }

            games[i] = new Game2(developer, gameType, attributes);
        }

        // 모든 게임 정보 출력
        System.out.println("\n모든 게임 정보:");
        for (Game2 game : games) {
            game.displayInfo();
        }

        scanner.close();
    }
}
