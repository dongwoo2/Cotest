package teacherstudyre;

import java.util.Scanner;

public class Game1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Game_farm farm = new Game_farm();
        Game_lolchess lolchess = new Game_lolchess();
        Game_fight fight = new Game_fight();
        Game_rpg rpg = new Game_rpg();
        Game_Racing racing = new Game_Racing();

        int [] choice = new int[2];

        System.out.println("총 5개의 게임이 있습니다.");
        System.out.println("1.농사 2.롤토체스 3.격투 4.RPG 5.레이싱\n 이중 2개의 게임을 골라 직접 셋팅해주세요.");
        choice[0] = sc.nextInt();
        choice[1] = sc.nextInt();

        switch (choice[0]) {
            case 1:
                System.out.println("1. 개발자 이름 2. 캐릭터이름 3.농사 체력 4.작물종류 3개 5. 작물 씨 가격 6. 작물 파는 가격 7.초기자금 을 설정해주세요");
                farm.developer = sc.nextLine();
                farm.name = sc.nextLine();
                farm.stamina = sc.nextInt();

                for (int i = 0; i < 3; i++) {
                    farm.crop[i] = sc.nextLine();
                    farm.cropseed_buy_money[i] = sc.nextInt();
                    farm.crop_sell_money[i] = sc.nextInt();
                }
                farm.money = sc.nextInt();
                break;
            case 2:
                System.out.println("1. 개발자 이름 2. 캐릭터이름 3.기물 이름 3개 4.기물 등급 3개 5. 기물 특성 3개 6. 게임 시즌 특성 3개 7. 레벨");
                lolchess.developer = sc.nextLine();
                lolchess.name = sc.nextLine();

                for (int i = 0; i < 3; i++) {
                    lolchess.chess_name[i] = sc.nextLine();
                    lolchess.chess_grade[i] = sc.nextInt();
                    lolchess.chess_property[i] = sc.nextLine();
                    lolchess.property[i] = sc.nextLine();
                }
                lolchess.level = sc.nextInt();
                break;
            case 3:
                System.out.println("1. 개발자 이름 2. 캐릭터이름 3.체력  4.힘 5. 속도 6. 방어력");
                fight.developer = sc.nextLine();
                fight.name = sc.nextLine();
                fight.stamina = sc.nextInt();
                fight.power = sc.nextInt();
                fight.speed = sc.nextInt();
                fight.defense = sc.nextInt();
                break;
        }

    }



}
