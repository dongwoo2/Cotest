package teacherstudyre;

import java.util.Scanner;

public class Study20240322_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int age = 0;
        int movein_age = 0;
        int choice = 0;
        int choho = 0;
        int choice1 = 0;
        int choho1 = 0;
        System.out.println("몇 동 까지 있습니까?");
        choice = sc.nextInt();
        choho = choice;
        System.out.println("몇 호 까지 있습니까?");
        choice1 = sc.nextInt();
        choho1 = choice1;
        int[][] apartage = new int[choice][choice1];
        boolean flag = true;


        for (int i = 0; i < apartage.length; i++) {
            for (int j = 0; j < apartage[i].length; j++) {
                System.out.print(i + 1 + "0" + (j + 1) + "호\n사람의 나이:");
                age = sc.nextInt();
                apartage[i][j] = age;
                //System.out.println(apart[i][j]);
            }
        }
        allapart(apartage);
        while (flag) {
            System.out.println("  ");
            System.out.println("[1.이사 2.입주 3.종료]\n무엇을 선택하시겠습니까?");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("몇 층 선택하시겠습니까?");
                choice = sc.nextInt();
                System.out.println("몇 호 선택하시겠습니까?");
                choice1 = sc.nextInt();
                apartage = moveage(apartage, choice, choice1);
                allapart(apartage);
            } else if (choice == 2) {
                System.out.println("몇 층 선택하시겠습니까?");
                choice = sc.nextInt();
                System.out.println("몇 호 선택하시겠습니까?");
                choice1 = sc.nextInt();
                System.out.print("나이:");
                movein_age = sc.nextInt();
                apartage = moveinage(apartage, choice, choice1, movein_age,choho,choho1);
                allapart(apartage);
            } else {
                flag = false;
            }
        }
    }


    public static int[][] moveage(int[][] apartage, int choice, int choice1) {
        apartage[choice - 1][choice1 - 1] = 0;
        return apartage;
    }


    public static int[][] moveinage(int[][] apartage, int choice, int choice1, int movein_age, int choho, int choho1) {
        int length = 0;
        int cnt = movein_age;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int plus = 0;
        int ho = choice1;
        boolean flag = true;
        choice--;
        choice1--;
        int original = apartage[choice][choice1];
        if (apartage[choice].length % 2 != 0) { //홀수 짝수
            length = (apartage[choice].length / 2) + 1;
        } else {
            length = (apartage[choice].length / 2);
        }
        if (ho > length) { // 크면 오른쪽으로
            while (flag) {
                plus++;
                ho++;
                if (plus == 1) { //바꾸는중에 넣어야할 거 같은데 층 바꾸는 걸
                    cnt = apartage[choice][choice1]; // 원래 층
                    apartage[choice][choice1] = movein_age;

                    if(apartage[choice].length >= ho) { // 층 안바꿔도 될 떄
                        apartage[choice][choice1 + 1] = cnt;
                    } else { // 층 바꿔야 할 때
                        choice++;
                        if(choice+1 <= choho) { //층이 제일 높은 층보다 작을 때
                            cnt1 = choice1;
                            choice1 = 0;
                            apartage[choice][choice1] = apartage[choice-1][cnt1];
                            ho = 0;
                        } else {
                            flag = false;
                        }

                    }

                } else { //2번째
                     if(apartage[choice].length >= ho) {
                         choice1++;
                         apartage[choice][choice1] = apartage[choice][choice1-1];
                     } else {
                         if(choice+1 <= choho) {
                             choice++;
                            cnt1 = choice1;
                            choice1 = 0;
                            apartage[choice][choice1] = apartage[choice-1][cnt1];
                            ho = 0;
                         } else {
                             flag = false;
                         }
                     }
                }

            }
        } else { // 같거나 작으면 왼쪽으로
            while (flag) {
                    plus++;
                    ho--;
                    if(ho == 0) {
                        ho = apartage[choice].length;
                    }

                    if(choice1 < 0 && choice >= 1 && cnt2 > 0) { // 층을 바꾸어야 할 때
                        choice--;
                        choice1 = 0;
                        if(plus == 1)  { //처음
                            cnt = movein_age; // 상대를 바뀌게 해주어야하는 값
                            cnt1 = apartage[choice][choice1]; // 바뀐 사람이 가지고있는 원래값
                            apartage[choice][choho1] = cnt;
                            cnt = cnt1;
                            choice1 = apartage[choice].length-1;
                            cnt2 = 0;
                        } else { // 두 번째
                            if(plus > 1) {
                                cnt = cnt1;
                            } else {
                                cnt = apartage[choice+1][choice1];
                            }
                            cnt1 = apartage[choice][choho1-1];
                            apartage[choice][choho1-1] = cnt;
                            cnt = cnt1;
                            choice1 = apartage[choice].length-1;
                            cnt2 = 0;
                        }
                    } else if(choice1 == 0 && choice == 0){ // 끝났을 때
                        flag = false;
                    } else if(choice1 >= 0){ // 층을 안바꾸고 진행가능할 때
                        if(plus == 1) {
                            cnt = movein_age;
                            cnt1 = apartage[choice][choice1];
                            apartage[choice][choice1] = cnt;
                            choice1--;
                            System.out.println("choice1 = " + choice1);
                            System.out.println("apartage[choice] = " + apartage[choice].length);
                            if(choice1 < 0) {
                                cnt2++;
                            }
                        } else {
                            cnt = apartage[choice][choice1];
                            apartage[choice][choice1] = cnt1;
                            cnt1 = cnt;
                            choice1--;
                            System.out.println("choice1 = " + choice1);
                            if(choice1 < 0) {
                                cnt2++;
                            }
                        }

                    }

            }
        }

        //apartage[choice-1][choice1-1] = movein_age;
        return apartage;
    }

    public static void allapart(int[][] apartage) {

        for (int i = 0; i < apartage.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < apartage[i].length; j++) {
                System.out.print((i + 1) + "0" + (j + 1) + "호 나이: " + apartage[i][j] + "  ");
            }
        }
    }

}
