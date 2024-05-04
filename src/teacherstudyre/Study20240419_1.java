package teacherstudyre;


import java.util.Scanner;


public class Study20240419_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();

    }


    public static void solution() {
        String weaponsort[] = new String[10];
        String weaponitem[][] = new String[10][10];
        String weaponitem2[][] = new String[10][10]; // 대체품
        int wdurability[][] = new int[10][10]; // 내구도
        int wspeed[][] = new int[10][10]; // 스피드
        int wweight[][] = new int[10][10]; // 무게
        int wpower[][] = new int[10][10]; // 공격력
        int wprice[][] = new int[10][10]; // 무기 가격
        int wprice2[][] = new int[10][10]; // 무기 가격
        int wamount[][] = new int[10][10]; // 무기 수량
        int manspeed = 0; // 민첩성 - 스피드
        int manstamina = 0; // 지구력 - 무게
        int manpower = 0;  // 힘 - 공격력
        boolean flag = true;
        int choice = 0;
        int allmoney = 0; // 수입;
//        System.out.println("오늘 손님은 몇 명 입니까?");
//        int people = sc.nextInt();
        int people1 = 0;
        int check = 0;
        int check2 = 0;
        int login = 0;

        weaponsort = weaponkind(weaponsort);
        weaponitem = weaponset(weaponsort,weaponitem);

        wdurability = wdurability(wdurability);
        wspeed = wspeed(wspeed);
        wweight = wweight(wweight);
        wpower = wpower(wpower);
        wprice = wprice(wprice, wdurability, wspeed, wweight, wpower);
        wamount = wamount(wamount); // 이제 물품이 0개가 되면 3턴뒤에 다시 생기는 걸로 만들기

        // 구매자 스텟 만들기 힘,민첩성,지구력


        System.out.println("1.판매자 로그인 2.구매자 로그인");
        choice = sc.nextInt();
        if(choice == 1) {
            while (flag) { // 판매자

            }
        } else {
            while (flag) { // 구매자

            }
        }
    }


    public static void manstat(int manpower, int manspeed, int manstamina) { // 구매자 스텟 확인

    }

    public static String[] weaponkind(String weaponsort[]) {

        for(int i = 0; i < 1; i++) {
            weaponsort[0] = "한손검";
            weaponsort[1] = "도끼";
            weaponsort[2] = "철퇴";
            weaponsort[3] = "활";
            weaponsort[4] = "석궁";
            weaponsort[5] = "창";
            weaponsort[6] = "건틀릿";
            weaponsort[7] = "단검";
            weaponsort[8] = "랜스";
            weaponsort[9] = "양손검";
        }
        return weaponsort;

    }
    public static String[][] weaponset(String weaponsort[],String weaponitem[][]) {

        for(int i = 0; i < weaponsort.length; i++) {
            for(int j = 0; j < 1; j++) {
                weaponitem[i][j] = "나무";
                weaponitem[i][j] = weaponitem[i][j] + weaponsort[i];
                weaponitem[i][j+1] = "돌";
                weaponitem[i][j+1] = weaponitem[i][j+1] + weaponsort[i];
                weaponitem[i][j+2] = "철";
                weaponitem[i][j+2] = weaponitem[i][j+2] + weaponsort[i];
                weaponitem[i][j+3] = "은";
                weaponitem[i][j+3] = weaponitem[i][j+3] + weaponsort[i];
                weaponitem[i][j+4] = "금";
                weaponitem[i][j+4] = weaponitem[i][j+4] + weaponsort[i];
                weaponitem[i][j+5] = "한철";
                weaponitem[i][j+5] = weaponitem[i][j+5] + weaponsort[i];
                weaponitem[i][j+6] = "미스릴";
                weaponitem[i][j+6] = weaponitem[i][j+6] + weaponsort[i];
                weaponitem[i][j+7] = "다이아";
                weaponitem[i][j+7] = weaponitem[i][j+7] + weaponsort[i];
                weaponitem[i][j+8] = "오르하르콘";
                weaponitem[i][j+8] = weaponitem[i][j+8] + weaponsort[i];
                weaponitem[i][j+9] = "운철";
                weaponitem[i][j+9] = weaponitem[i][j+9] + weaponsort[i];
            }
        }
        return weaponitem;
    }

    public static void allweapon(String[][] weapon, int[][]wprice) {

        for (int i = 0; i < weapon.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < weapon[i].length; j++) {
                if(i == 0) {
                    System.out.print((j+1) + ". " + weapon[i][j] +" : " + wprice[i][j] + " ");
                } else if(i == 1) {
                    if(j == 9) {
                        System.out.print((i+1) +"0" + ". " + weapon[i][j] + " : " + wprice[i][j] + " ");
                    } else {
                        System.out.print((i) + "" + (j + 1) + ". " + weapon[i][j] + " : " + wprice[i][j] + " ");
                    }
                } else {
                    if(j == 9) {
                        System.out.print((i+1) +"0" + ". " + weapon[i][j] + " : " + wprice[i][j] + " ");
                    } else {
                        System.out.print((i) + "" + (j + 1) + ". " + weapon[i][j] + " : " + wprice[i][j] + " ");
                    }
                }
            }
        }
    }

    public static int[][] newweapon1(String[][] weapon, int[][]wprice, int choice) { //항목추가 가격
       // allweapon(weapon,wprice);
       // System.out.println("어떤 항목을 추가하시겠습니까?");
        System.out.println("순서대로 스피드, 내구성, 무게, 파워 설정을 해주십시오");
        int speed = sc.nextInt();
        int dura = sc.nextInt();
        int wweight = sc.nextInt();
        int power = sc.nextInt();

        choice--;
        int c1 = choice/10;
        int c2 = choice%10;
        wprice[c1][c2] = wprice2(dura,speed,wweight,power);
//        wprice[c1][c2] = 0;
        return wprice;
    }

    public static String[][] newweapon2(String[][] weapon, int[][]wprice, int choice) { //항목추가 이름 이름 추가가 먼저 되어야함1
        System.out.println("무기 이름을 지어주세요.");
        choice--;
        int c1 = choice/10;
        int c2 = choice%10;
        weapon[c1][c2] = sc.next();
        return weapon;
    }

    public static int[][] outweapon1(String[][] weapon, int[][]wprice, int choice) { //항목제거 가격
        choice--;
        int c1 = choice/10;
        int c2 = choice%10;
        wprice[c1][c2] = 0;
        return wprice;
    }

    public static String[][] outweapon2(String[][] weapon, int[][]wprice, int choice) { //항목제거 이름
        choice--;
        int c1 = choice/10;
        int c2 = choice%10;
        weapon[c1][c2] = "";
        return weapon;
    }

    public static int[][] amountweapon1(int[][] wamount, int choice) { //재고업데이트 밖에서 어떤 물품의 재고를 바꾸시겠습니까? 하고 오류제어도 다 해야함
        choice--;
        int c1 = choice/10;
        int c2 = choice%10;
        System.out.println("물품의 갯수를 몇개로 바꾸시겠습니까?");
        int amount = sc.nextInt();
        wamount[c1][c2] = amount;
        return wamount;
    }

    public static int[][] wspeed(int wspeed[][]){ // 스피드
        int k = 0;
        for(int i = 0; i < wspeed.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 2;
                    break;
                case 1: // 도끼
                    k = 2;
                    break;
                case 2: // 철퇴
                    k = 3;
                    break;
                case 3: // 활
                    k = 2;
                    break;
                case 4: // 석궁
                    k = 2;
                    break;
                case 5: // 창
                    k = 2;
                    break;
                case 6: // 건틀릿
                    k = 1;
                    break;
                case 7: // 단검
                    k = 1;
                    break;
                case 8: // 랜스
                    k = 4;
                    break;
                case 9: // 양손검
                    k = 4;
                    break;
            }
            for(int j = 0; j < wspeed.length; j++) {
                wspeed[i][j] = k;
            }
        }
        return wspeed;
    }

    public static int[][] wdurability(int wdurability[][]){ // 내구도
        int k = 0;
        for(int i = 0; i < wdurability.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 60;
                    break;
                case 1: // 도끼
                    k = 80;
                    break;
                case 2: // 철퇴
                    k = 100;
                    break;
                case 3: // 활
                    k = 70;
                    break;
                case 4: // 석궁
                    k = 90;
                    break;
                case 5: // 창
                    k = 80;
                    break;
                case 6: // 건틀릿
                    k = 90;
                    break;
                case 7: // 단검
                    k = 40;
                    break;
                case 8: // 랜스
                    k = 95;
                    break;
                case 9: // 양손검
                    k = 120;
                    break;
            }
            for(int j = 0; j < wdurability.length; j++) {
                wdurability[i][j] = k;
                k+=50;
            }
        }
        return wdurability;
    }

    public static int[][] wweight(int wweight[][]){ // 스피드
        int k = 0;
        for(int i = 0; i < wweight.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 1;
                    break;
                case 1: // 도끼
                    k = 2;
                    break;
                case 2: // 철퇴
                    k = 3;
                    break;
                case 3: // 활
                    k = 1;
                    break;
                case 4: // 석궁
                    k = 2;
                    break;
                case 5: // 창
                    k = 3;
                    break;
                case 6: // 건틀릿
                    k = 1;
                    break;
                case 7: // 단검
                    k = 1;
                    break;
                case 8: // 랜스
                    k = 5;
                    break;
                case 9: // 양손검
                    k = 4;
                    break;
            }
            for(int j = 0; j < wweight.length; j++) {
                wweight[i][j] = k;
            }
        }
        return wweight;
    }
    public static int[][] wpower(int wpower[][]){ // 공격력
        int k = 0;
        for(int i = 0; i < wpower.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 80;
                    break;
                case 1: // 도끼
                    k = 90;
                    break;
                case 2: // 철퇴
                    k = 100;
                    break;
                case 3: // 활
                    k = 70;
                    break;
                case 4: // 석궁
                    k = 90;
                    break;
                case 5: // 창
                    k = 100;
                    break;
                case 6: // 건틀릿
                    k = 70;
                    break;
                case 7: // 단검
                    k = 40;
                    break;
                case 8: // 랜스
                    k = 130;
                    break;
                case 9: // 양손검
                    k = 120;
                    break;
            }
            for(int j = 0; j < wpower.length; j++) {
                wpower[i][j] = k;
                k+=50;
            }
        }
        return wpower;
    }

    public static int[][] wprice(int wprice[][],int wdurablity[][], int wspeed[][], int wweight[][], int wpower[][]){ // 무기 가격설정
        int kspeed = 0;
        int kweight = 0;
        int allstat[][] = new int[10][10];
        for(int i = 0; i < wprice.length; i++) {
            switch (wspeed[i][i]) {
                case 1:
                    kspeed = 600;
                    break;
                case 2:
                    kspeed = 500;
                    break;
                case 3:
                    kspeed = 400;
                    break;
                case 4:
                    kspeed = 300;
                    break;
                case 5:
                    kspeed = 200;
                    break;
            }
            switch (wweight[i][i]) {
                case 1:
                    kweight = 600;
                    break;
                case 2:
                    kweight = 500;
                    break;
                case 3:
                    kweight = 400;
                    break;
                case 4:
                    kweight = 300;
                    break;
                case 5:
                    kweight = 200;
                    break;
            }
            for(int j = 0; j < wprice.length; j++) {
                allstat[i][j] = wdurablity[i][j] + wpower[i][j] + kspeed + kweight;
                wprice[i][j] = allstat[i][j] * 3;
            }

        }
        return wprice;
    }

    public static int wprice2(int wdurablity, int wspeed, int wweight, int wpower){ // 무기 가격 단일설정
        int kspeed = 0;
        int kweight = 0;
        int allstat = 0;
        int wprice = 0;

            switch (wspeed) {
                case 1:
                    kspeed = 600;
                    break;
                case 2:
                    kspeed = 500;
                    break;
                case 3:
                    kspeed = 400;
                    break;
                case 4:
                    kspeed = 300;
                    break;
                case 5:
                    kspeed = 200;
                    break;
            }
            switch (wweight) {
                case 1:
                    kweight = 600;
                    break;
                case 2:
                    kweight = 500;
                    break;
                case 3:
                    kweight = 400;
                    break;
                case 4:
                    kweight = 300;
                    break;
                case 5:
                    kweight = 200;
                    break;
            }

                allstat = wdurablity + wpower + kspeed + kweight;
                wprice = allstat * 3;



        return wprice;
    }

    public static void weaponbuy(String[][] weaponitem, int[][] wprice, int choice) {
        int c1 = choice/10;
        int c2 = choice%10;
        weaponitem[c1][c2] = "판매완료";
        wprice[c1][c2] = 0;
    }

    public static int[][] wamount(int wamount[][]){ // 공격력
        int k = 0;
        for(int i = 0; i < wamount.length; i++) {
            for(int j = 0; j < wamount.length; j++) {
                wamount[i][j] = 1;
            }
        }
        return wamount;
    }
}


