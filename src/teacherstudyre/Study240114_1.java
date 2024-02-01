package teacherstudyre;

import java.util.Scanner;

public class Study240114_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int ch = 0;
        int se = 0;
        boolean flag = true;
        boolean flag2 = true;
        System.out.println("사람은 총 몇 명 입니까?");
        int n = sc.nextInt();
        int people[] = new int[n];
        people = peoplemoney(people);
        int peoplecnt = 1;
        int menuprice[] = new int[]{1000, 2000, 3000, 4000, 5000};
        int foodcnt[] = new int[menuprice.length];
        int borrowcount = 0; // 돈 빌리는 횟수 카운트
        int borrowpeople = 0; // 돈 빌려줘야 할 사람
        int menureturn[] = new int[3];
        int receiptlist[] = new int[1000]; // 영수증 리스트 담아줄 수 있게
        int firstmoney = 0; //현재 가지고 있는 돈 담아줄 변수
        int debtmoney = 0; // 빚진 돈
        int debtwpay = 0; // 빚을 청산하고 남은금액
        int debtnotpay = 0; //미납 된 금액
        int borrowmoney = 0; // 빌려준 금액
        // 1.원래가지고 있던 돈 - 1 ,0 firstmoney
        // 2.사먹은 음식 - 5 , 1~5 foodcnt
        // 3.현재 가지고 있는 돈 - 1 , 6 people[peoplecnt]
        // 4.빚 진 금액 - 1 , 7 debtmoney
        // 5.빚을 청산하고 남은 금액 - 1 , 8 debtpay
        // 6.미납 된 금액 - 1 , 9 debtnotpay
        // 7.빌려준금액 - 1 , 10 borrowmoney
        //


        people = peoplemoney(people);
        while (flag) {
            System.out.println(peoplecnt + "번째 손님입니다.");
            borrowcount = 0;
            borrowpeople = 0;

            while(flag2) {
                menu(se); // 손님 제어 후 다음 손님으로 돌아가기 생겨서 인자 전달
                ch = sc.nextInt();
                if (ch <= 5) {
                    if (people[peoplecnt] < 1000) { // 소지금 부족 할 경우
                        System.out.println("소지금이 부족합니다.");
                        System.out.println("다시 선택하시겠습니까? \n1.예 2.아니오");
                        ch = sc.nextInt();
                        if (ch == 2) {
                            receiptlist(); //여기다가 넣어야함 인서트 되는거
                            System.out.println("다음 손님으로 넘어갑니다");
                            peoplecnt++;
                            flag2 = false;
                        } else {
                            borrowcount++;
                            borrowpeople += peoplecnt + borrowcount;
                            people = borrowmoney(peoplecnt, people, borrowpeople);
                        }
                    } else {
                        menureturn = menuchoice(ch, people, peoplecnt, menuprice, borrowpeople, foodcnt);
                        people[peoplecnt] = menureturn[0];
                        people[borrowpeople] = menureturn[1];
                        foodcnt[ch - 1] = menureturn[2];
                    }
                } else if (ch == 6) { // 돈 갚기

                } else if (ch == 7) { // 다음손님
                    peoplecnt++;
                } else if (ch == 8) {
                    System.out.println("몇 번째 손님을 선택하시겠습니까?");
                    peoplecnt = sc.nextInt();
                }
            }
        }
    }


    public static void menu(int se) { // 메뉴
        if (se == 0) {
            System.out.println("1.파스타[1000원] 2.스테이크[2000원] 3.비빔밥[3000원] 4.김치찌개[4000원] 5.오므라이스[5000원] 6.돈 갚기 7.다음손님 8.손님 선택 9.환불 10.종료");
        } else {
            System.out.println("1.파스타[1000원] 2.스테이크[2000원] 3.비빔밥[3000원] 4.김치찌개[4000원] 5.오므라이스[5000원] 6.돈 갚기 7.다음손님 8.손님 선택 9.이전 손님으로 돌아가기 10.환불 11.종료");
        }
    }

    public static int[] peoplemoney(int people[]) {
        System.out.println("사람들이 가진 금액을 입력해주세요");

        for (int j = 0, k = 9; j < 5; j++, k--) {
            people[j + 10] = sc.nextInt();
            people[j] += 20000;
            people[k] += 10000;
        }
        return people;
    }

    // 리턴값 1: 현재사람, 리턴 2 : 돈빌린사람, 리턴 3 : 메뉴갯수
    public static int[] menuchoice(int ch, int people[], int peoplecnt, int menuprice[], int borrowpeople, int foodcnt[]) { // 몇 번째 사람인지 체크해주어야 할 듯
        ch -= 1;

        if (people[peoplecnt] >= menuprice[ch]) {
            people[peoplecnt] -= menuprice[ch];
            foodcnt[ch]++;
            return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[ch]};
        } else {
            System.out.println("금액이 부족합니다.");
            System.out.println("돈을 빌리시겠습니까? \n 1.예 2.아니오");

            ch = sc.nextInt();
            if (ch == 1) {
                people = borrowmoney(peoplecnt, people, borrowpeople);
            }
        }
//        return new int[]{people[peoplecnt], foodcnt[ch]};
        return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[ch]};
    }

    public static int[] borrowmoney(int peoplecnt, int people[], int borrowpeople) { //리턴 되어야하는 값은 돈을 빌려준 사람이 빌려준만큼 빠진돈과 빌린 사람이 가진 돈
        int money = 0;
        System.out.println(borrowpeople + "번 째 손님이 빌려줄 수 있는 돈은" + people[borrowpeople] + "입니다.");
        System.out.println("얼마를 빌리시겠습니까?");
        money = sc.nextInt();

        if (money > people[peoplecnt]) {
            System.out.println(peoplecnt + "번 째 손님이 가진 돈보다 많습니다");
            return people;
        } else {
            people[borrowpeople] -= money;
            people[peoplecnt] += money;
            return people;
        }
    }

    // 영수증을 차곡차곡 쌓아줄 수 있는게 필요함 1번 영수증 그리고 음식 계산한 거 까지
    // 1.원래가지고 있던 돈 - 1
    // 2.사먹은 음식 - 5
    // 3.현재 가지고 있는 돈 - 1
    // 4.빚 진 금액 - 1
    // 5.빚을 청산하고 남은 금액 - 1
    // 6.미납 된 금액 - 1
    // 7.빌려준금액 - 1
    // 총 11칸의 배열이 필요함
    // 1번 손님이 쌓여야되는 리스트를 한 번에 모아서 receipt 함수는 보여주는것만 배열을 모아주는
    // 로직은 밖에서 해야할듯 함
    public static int[] receiptlist() {

    }

    public static int[] receiptinsert(int firstmoney, int foodcnt[], int people[], int debtmoney, int debtpay, int debtnotpay, int borrowmoney, int peoplecnt, int receiptlist[]) { // 영수증에 넣어주는 함수
        if(peoplecnt != 1) {
            for(int i = peoplecnt * 11; i < peoplecnt * 11 + 11; i++) {
                receiptlist[i] = firstmoney;
                receiptlist[i+1] = foodcnt[0];
                receiptlist[i+2] = foodcnt[1];
                receiptlist[i+3] = foodcnt[2];
                receiptlist[i+4] = foodcnt[3];
                receiptlist[i+5] = foodcnt[4];
                receiptlist[i+6] = people[peoplecnt];
                receiptlist[i+7] = debtmoney;
                receiptlist[i+8] = debtpay;
                receiptlist[i+9] = debtnotpay;
                receiptlist[i+10] = borrowmoney;
                return receiptlist;
            }
        } else if(peoplecnt == 1){
            for(int i = 0; i < peoplecnt * 11; i++) {
                receiptlist[i] = firstmoney;
                receiptlist[i+1] = foodcnt[0];
                receiptlist[i+2] = foodcnt[1];
                receiptlist[i+3] = foodcnt[2];
                receiptlist[i+4] = foodcnt[3];
                receiptlist[i+5] = foodcnt[4];
                receiptlist[i+6] = people[peoplecnt];
                receiptlist[i+7] = debtmoney;
                receiptlist[i+8] = debtpay;
                receiptlist[i+9] = debtnotpay;
                receiptlist[i+10] = borrowmoney;
                return receiptlist;
            }
        } else {
            System.out.println("유호범위가 아닌 숫자가 들어왔습니다.");
            return receiptlist;
        }
        return receiptlist;
    }
    // 필요한 매개변수 인자
    // 돈을 갚기 위해 써야 할 돈
    public static int[] paybackmoney() { // 돈 갚는 함수

    }
    /*
    public static int[] foodcnt(int foodcnt[], int ch) {
        if(ch > 0) {
            foodcnt[ch-1]++;
            return foodcnt;
        }
        return foodcnt;
    }
    */

}