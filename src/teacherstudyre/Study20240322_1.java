package teacherstudyre;

import java.util.Scanner;

public class Study20240322_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        String name ="";
        int age = 0;
        String movein_name ="";
        int movein_age = 0;
        int choice = 0;
        int choice1 = 0;
        System.out.println("몇 동 까지 있습니까?");
        choice = sc.nextInt();
        System.out.println("몇 호 까지 있습니까?");
        choice1 = sc.nextInt();
        String[][]apartname = new String[choice][choice1];
        int[][] apartage = new int[choice][choice1];
        boolean flag = true;


        for(int i = 0; i< apartname.length; i++) {
            for(int j = 0; j < apartname[i].length; j++) {
                System.out.print(i+1 + "0"+ (j+1) +"호\n사람의 이름:");
                name = sc.next();
                apartname[i][j] = name;
                System.out.print("사람의 나이:");
                age = sc.nextInt();
                apartage[i][j] = age;
                //System.out.println(apart[i][j]);
            }
        }
        allapart(apartname,apartage);
        while (flag) {
            System.out.println("  ");
            System.out.println("[1.이사 2.입주 3.종료]\n무엇을 선택하시겠습니까?");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("몇 층 선택하시겠습니까?");
                choice = sc.nextInt();
                System.out.println("몇 호 선택하시겠습니까?");
                choice1 = sc.nextInt();
                apartname = movename(apartname, choice, choice1);
                apartage = moveage(apartage, choice, choice1);
                allapart(apartname,apartage);
            } else if(choice == 2){
                System.out.println("몇 층 선택하시겠습니까?");
                choice = sc.nextInt();
                System.out.println("몇 호 선택하시겠습니까?");
                choice1 = sc.nextInt();
                System.out.print("성함:");
                movein_name = sc.next();
                System.out.print("나이:");
                movein_age = sc.nextInt();
                apartname = moveinname(apartname, choice, choice1, movein_name);
                apartage = moveinage(apartage, choice, choice1, movein_age);
                allapart(apartname,apartage);
            } else {
                flag = false;
            }
        }
    }

    public static String[][] movename(String[][]apartname, int choice, int choice1) {
           apartname[choice-1][choice1-1] = "";
           return apartname;
    }
    public static int[][] moveage(int[][]apartage, int choice, int choice1) {
            apartage[choice-1][choice1-1] = 0;
            return apartage;
    }

    public static String[][] moveinname(String[][]apartname, int choice, int choice1, String movein_name) {
        apartname[choice-1][choice1-1] = movein_name;
        return apartname;
    }

    public static int[][] moveinage(int[][]apartage, int choice, int choice1, int movein_age) {
        apartage[choice-1][choice1-1] = movein_age;
        return apartage;
    }

    public static void allapart(String[][]apartname, int [][] apartage) {

        for (int i = 0; i < apartname.length; i++) {
            System.out.println(" ");
            for(int j = 0; j < apartname[i].length; j++) {
                System.out.print((i+1) + "0"+ (j+1) +"호 이름: " + apartname[i][j] + " 나이: " + apartage[i][j]+ "  ");
            }
        }
    }

}
