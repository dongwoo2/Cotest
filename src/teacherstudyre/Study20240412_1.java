package teacherstudyre;


import java.util.Scanner;

public class Study20240412_1 {
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
        boolean flag = true;
        int choice = 0;
        int allmoney = 0; // 수입;
        System.out.println("오늘 손님은 몇 명 입니까?");
        int people = sc.nextInt();
        int people1 = 0;
        int check = 0;
        int check2 = 0;

        weaponsort = weaponkind(weaponsort);
        weaponitem = weaponset(weaponsort,weaponitem);

        wdurability = wdurability(wdurability,weaponsort);
        wspeed = wspeed(wspeed,weaponsort);
        wweight = wweight(wweight,weaponsort);
        wpower = wpower(wpower,weaponsort);
        wprice = wprice(wprice, wdurability, wspeed, wweight, wpower);



        while (flag) {
            allweapon(weaponitem,wprice);
            if(check == 0) {
                System.out.println(people1+1 + "번 째 손님입니다.");
                check = 0;
            }
            if(check2 == 0) {
                for (int i = 0; i < wdurability.length; i++) {
                    for (int j = 0; j < wdurability.length; j++) {
                        if (wprice[i][j] < 3) {
                            wprice[i][j] += 1;
                            if (wprice[i][j] == 3) {
                                wprice[i][j] = wprice2[i][j];
                                weaponitem[i][j] = weaponitem2[i][j];
                            }
                        }
                    }
                }
                check2 = 0;
            }
            System.out.println("어떤 무기를 구입하시겠습니까?");
            choice = sc.nextInt();
            choice--;
            int c1 = choice/10;
            int c2 = choice%10;
            if(weaponitem[c1][c2].equals("판매완료")) {
                System.out.println("판매완료된 상품입니다."); //판매완료된 상품일 때도 카운트가 올라가는 문제 이것도 체크로 해결
                check2++;
            } else {
                weaponitem2[c1][c2] = weaponitem[c1][c2]; // 대체
                wprice2[c1][c2] = wprice[c1][c2]; // 대체
                weaponitem[c1][c2] = "판매완료";
                wprice[c1][c2] = 0;
                allmoney += wprice2[c1][c2];
                System.out.println("주문이 완료되었습니다. 추가 주문하시겠습니까? 1.예 2.아니오");
                int choice2 = sc.nextInt();
                if(choice2 == 1) {
                    check++;
                } else {
                    people1++;
                    if(people1 == people) {
                        flag = false;
                        System.out.println("오늘 하루 총 판매액은 " + allmoney +"원 입니다.");
                    } else {
                        System.out.println("다음 손님으로 넘어갑니다.");
                    }
                }
            }



        }

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

    public static int[][] wspeed(int wspeed[][], String weaponsort[]){ // 스피드
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

    public static int[][] wdurability(int wdurability[][], String weaponsort[]){ // 내구도
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

    public static int[][] wweight(int wweight[][], String weaponsort[]){ // 스피드
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
    public static int[][] wpower(int wpower[][], String weaponsort[]){ // 공격력
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

    public static void weaponbuy(String[][] weaponitem, int[][] wprice, int choice) {
        int c1 = choice/10;
        int c2 = choice%10;
        weaponitem[c1][c2] = "판매완료";
        wprice[c1][c2] = 0;
    }
}


