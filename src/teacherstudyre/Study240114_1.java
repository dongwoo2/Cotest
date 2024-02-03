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
        boolean flag3 = true;
        System.out.println("사람은 총 몇 명 입니까?");
        int n = sc.nextInt();
        int people[] = new int[n];
        int peopledebt[] = new int[n]; // 빚진금액
        int borrowpe[] = new int[n]; //사람 마다 얼마 빌린지 체크
        int debtwpay[] = new int[n]; // 빚을 청산하고 남은금액
        people = peoplemoney(people);
        int otherman = 0;
        int peoplecnt = 1;
        int menuprice[] = new int[]{1000, 2000, 3000, 4000, 5000};
        int foodcnt[] = new int[100];
        int borrowcount = 0; // 돈 빌리는 횟수 카운트
        int borrowpeople = 0; // 돈 빌려줘야 할 사람
        int menureturn[] = new int[5];
        int receiptlist[] = new int[1000]; // 영수증 리스트 담아줄 수 있게
        int firstmoney = 0; //현재 가지고 있는 돈 담아줄 변수
        int debtmoney = 0; // 빚진 돈 - 필요없음
        int t = 0;
        int debtnotpay = 0; //미납 된 금액
        int borrowmoney = 0; // 빌려준 금액
        int foodch = 0;
        int arr[] = new int[50];
        int brr[] = new int[50];
        int vrr[] = new int[50];

        String menuname[] = new String[]{"파스타","스테이크","비빔밥","김치찌개","오므라이스"};
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
            peoplecnt--;
            borrowpeople = peoplecnt+1;
            if(se == 0) { //손님 제어 안했을 시
                firstmoney = people[peoplecnt];
            }
            borrowcount = 0;
<<<<<<< HEAD
=======
            borrowpeople = 0;
            firstmoney = people[peoplecnt];
            // 음식갯수도 사람마다 다를거니까 초기화
            // 근데 다른 사람을 제어한다는 과정이 있을 때는 초기화 되어서는 안됨
            // 다른 사람으로 갔을 떄도 foodcnt가 되어야 하는데 이게 쪼금 어렵네
            // 다른 사람 제어로 이동했을 경우에 그 사람도 음식을 주문할 수 있는데 음식을 그냥 초기화시키지말고 음식의 갯수도
            // 배열순서대로 넣어서 고정값으로 해버릴까 그게 나을수도 있겠다
            // 근데 영수증에 한 사람 한 사람 씩 넣을려고 하다보니까 그것도 어렵네
            // 그렇지만 음식만큼은 따로 계산해서 넣으면 될 거 같다
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d

            // 음식갯수도 사람마다 다를거니까 초기화
            // 근데 다른 사람을 제어한다는 과정이 있을 때는 초기화 되어서는 안됨
            // 다른 사람으로 갔을 떄도 foodcnt가 되어야 하는데 이게 쪼금 어렵네
            // 다른 사람 제어로 이동했을 경우에 그 사람도 음식을 주문할 수 있는데 음식을 그냥 초기화시키지말고 음식의 갯수도
            // 배열순서대로 넣어서 고정값으로 해버릴까 그게 나을수도 있겠다
            // 근데 영수증에 한 사람 한 사람 씩 넣을려고 하다보니까 그것도 어렵네
            // 그렇지만 음식만큼은 따로 계산해서 넣으면 될 거 같다
            t = 0;
            while(flag2) {
                menu(se); // 손님 제어 후 다음 손님으로 돌아가기 생겨서 인자 전달
                ch = sc.nextInt();
                if (ch <= 5) {
                    if (people[peoplecnt] < 1000) { // 소지금 부족 할 경우
                        System.out.println("소지금이 부족합니다.");
                        System.out.println("다시 선택하시겠습니까? \n1.예 2.아니오");
                        ch = sc.nextInt();
<<<<<<< HEAD
                        if(ch != 1 && se != 0) {
                            System.out.println("다음 손님으로 넘어갈 수 없습니다.");
                            System.out.println("이전 손님으로 돌아가기밖에 선택하실 수 없습니다.");
                        } else if(ch == 2 && se == 0) {
                            receiptlist = receiptinsert(firstmoney, foodcnt, people, peopledebt, debtwpay, borrowpe, peoplecnt, receiptlist);
=======
                        if (ch == 2) {
                            receiptinsert(firstmoney,foodcnt,people,debtmoney,debtwpay,debtnotpay,borrowmoney,peoplecnt,receiptlist); //여기다가 넣어야함 인서트 되는거
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
                            System.out.println("다음 손님으로 넘어갑니다");
                            peoplecnt++;
                            flag2 = false;
                        } else {
                            System.out.println("다시 선택");
                        }


                    } else { // 소지금이 최저금액보다 높을경우
                        if(people[peoplecnt] < menuprice[ch-1]) { // 고른 메뉴가 가지고있는 돈 보다 비쌀 경우
                            System.out.println("돈이 부족합니다.\n 돈을 빌리시겠습니까?\n 1.예 2.아니오");
                            ch = sc.nextInt();
                            while (flag3) {
                                if(ch == 1) {
                                    if(borrowcount != 0) {
                                        System.out.println("1.더 빌린다 2.안빌린다");
                                        ch = sc.nextInt();
                                    }
                                    if(ch==1) {
                                        borrowcount++;
                                        arr = borrowmoney(peoplecnt, people, borrowpeople, peopledebt, borrowpe);
                                        people[peoplecnt] = arr[0]; //현재돈
                                        people[borrowpeople] = arr[1]; // 빌려준사람돈
                                        peopledebt[peoplecnt] = arr[2]; // 현재 빚
                                        borrowpe[borrowpeople] = arr[3]; // 빌려준 사람이 얼마나 빌려줬는지 알려주는 변수
                                        if (people[peoplecnt] >= menuprice[0]) {
                                            for (int i = 0; i < menuprice.length; i++) {
                                                if (people[peoplecnt] >= menuprice[i]) {
                                                    System.out.println(menuname[i] + "를 사먹을 수 있습니다.");
                                                }
                                            }
                                        }
                                    }
                                } else if(ch == 2) {
                                    System.out.println("다시 메뉴로");
                                    flag3 = false;
                                }

                            }
                        } else {
                            //return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[foodch]};
                            menureturn = menuchoice(ch, people, peoplecnt, menuprice, foodcnt, menuname);
                            people[peoplecnt] = menureturn[0];
                            if (peoplecnt != 0) { //foodcnt 사람마다 움식 인덱스 갯수 맞추기 한사람당 5개
                                foodch = (peoplecnt * 5) + (ch - 1);
                            } else { // 1번째 사람일 때만
                                foodch = (ch - 1);
                            }
                            foodcnt[foodch] = menureturn[1];
                        }
<<<<<<< HEAD
=======
                    } else {
                        menureturn = menuchoice(ch, people, peoplecnt, menuprice, borrowpeople, foodcnt);
                        people[peoplecnt] = menureturn[0];
                        people[borrowpeople] = menureturn[1];
                        foodcnt[(ch - 1) * peoplecnt] = menureturn[2];
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
                    }
                } else if (ch == 6) { // 돈 갚기
                    //return new int[]{people[peoplecnt], peopledebt[peoplecnt]};
                    if(t == 0) {
                        debtwpay[peoplecnt] = peopledebt[peoplecnt];
                        t++;
                    }
                    brr = paybackmoney(people,debtwpay,peoplecnt);
                    people[peoplecnt] = brr[0];
                    debtwpay[peoplecnt] = brr[1];

                } else if (ch == 7) { // 다음손님
                    if(se != 0) {
                        System.out.println("이전 손님으로 돌아가기밖에 선택하실 수 없습니다.");
                    } else {
                        peoplecnt++;
<<<<<<< HEAD
                        receiptlist = receiptinsert(firstmoney, foodcnt, people, peopledebt, debtwpay, borrowpe, peoplecnt, receiptlist);
                    }

=======
                    }
                    
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
                } else if (ch == 8) { // 손님제어
                    System.out.println("몇 번째 손님을 선택하시겠습니까?");
                    otherman = peoplecnt;
                    peoplecnt = sc.nextInt();
                    se++;
<<<<<<< HEAD
                } else if (ch == 9) {
                    //환불
                } else if(ch == 10) {
                    //종료
                    receiptlist = receiptinsert(firstmoney, foodcnt, people, peopledebt, debtwpay, borrowpe, peoplecnt, receiptlist);
                    allmoney(people);
                    flag2 = false;
                }
                else if(ch == 11) { //이전 손님으로 돌아가기
=======
                } else if(ch == 11) { //이전 손님으로 돌아가기
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
                    peoplecnt = otherman;
                    flag2 = false;
                    se = 0;
                }
            }
        }
    }


    public static void menu(int se) { // 메뉴
        if (se == 0) {
            System.out.println("1.파스타[1000원] 2.스테이크[2000원] 3.비빔밥[3000원] 4.김치찌개[4000원] 5.오므라이스[5000원] 6.돈 갚기 7.다음손님 8.손님 선택 9.환불 10.종료");
        } else {
            System.out.println("1.파스타[1000원] 2.스테이크[2000원] 3.비빔밥[3000원] 4.김치찌개[4000원] 5.오므라이스[5000원] 6.돈 갚기 7.다음손님 8.손님 선택 9. 환불 10.종료 11.이전손님으로 돌아가기");
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
    public static int[] menuchoice(int ch, int people[], int peoplecnt, int menuprice[], int foodcnt[],String menumane[]) { // 몇 번째 사람인지 체크해주어야 할 듯
        ch -= 1;
        int foodch = 0;
        int chcount = 0;

        if (people[peoplecnt] >= menuprice[ch]) {
            people[peoplecnt] -= menuprice[ch];
<<<<<<< HEAD
            if(peoplecnt != 0) {
                foodch = (peoplecnt * 5) + ch;
                foodcnt[foodch]++;
            } else {
                foodch = ch;
                foodcnt[foodch]++;
=======
            foodcnt[ch*peoplecnt]++;
            return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[ch*peoplecnt]};
        } else {
            System.out.println("금액이 부족합니다.");
            System.out.println("돈을 빌리시겠습니까? \n 1.예 2.아니오");

            ch = sc.nextInt();
            if (ch == 1) {
                people = borrowmoney(peoplecnt, people, borrowpeople);
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
            }

            return new int[]{people[peoplecnt], foodcnt[foodch]};
        } else {
            return new int[]{people[peoplecnt], foodcnt[foodch]};
        }
<<<<<<< HEAD

     //   return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[foodch],peopledebt[peoplecnt]};

=======
//        return new int[]{people[peoplecnt], foodcnt[ch]};
        return new int[]{people[peoplecnt], people[borrowpeople], foodcnt[ch*peoplecnt]};
>>>>>>> 17af90ca396f5afa218ada8f884f96ef49d9bc9d
    }

    public static int[] borrowmoney(int peoplecnt, int people[], int borrowpeople, int peopledebt[], int borrowpe[]) { //리턴 되어야하는 값은 돈을 빌려준 사람이 빌려준만큼 빠진돈과 빌린 사람이 가진 돈
        int money = 0;
        System.out.println(borrowpeople + "번 째 손님이 빌려줄 수 있는 돈은" + people[borrowpeople] + "입니다.");
        System.out.println("얼마를 빌리시겠습니까?");
        money = sc.nextInt();

        if (money > people[peoplecnt]) {
            System.out.println(peoplecnt + "번 째 손님이 가진 돈보다 많습니다");
            return new int[]{people[peoplecnt],people[borrowpeople],peopledebt[peoplecnt]};
        } else {
            people[borrowpeople] -= money;
            //borrowpe = brcheck(people,money,borrowpe,borrowpeople);
            borrowpe[borrowpeople] += money;
            // 빌려준사람 돈 체크해야함
            people[peoplecnt] += money; // 더 해진 금액

            peopledebt[peoplecnt] += money; // 빚진 금액
            return new int[]{people[peoplecnt],people[borrowpeople],peopledebt[peoplecnt],borrowpe[borrowpeople]};
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

    public static void printReceipt(int[] receiptlist, int peoplecnt,int menuprice[]) {
        // ===주문표===
        System.out.println("===주문표===");

        // 각 손님의 정보 출력
        for (int i = 0; i < peoplecnt; i++) {
            int startIndex = i * 11;

            // 메뉴 정보 출력
            if(receiptlist[startIndex + 1] > 0)
                System.out.println("파스타 x " + receiptlist[startIndex + 1] + " = " + menuprice[0] * receiptlist[startIndex + 1] + "원");

            if(receiptlist[startIndex + 2] > 0)
                System.out.println("스테이크 x " + receiptlist[startIndex + 2] + " = " + menuprice[1] * receiptlist[startIndex + 2] + "원");

            if(receiptlist[startIndex + 3] > 0)
                System.out.println("비빔밥 x " + receiptlist[startIndex + 3] + " = " + menuprice[2] * receiptlist[startIndex + 3] + "원");

            if(receiptlist[startIndex + 4] > 0)
                System.out.println("김치찌개 x " + receiptlist[startIndex + 4] + " = " + menuprice[3] * receiptlist[startIndex + 4] + "원");

            if(receiptlist[startIndex + 5] > 0)
                System.out.println("오므라이스 x " + receiptlist[startIndex + 5] + " = " + menuprice[4] * receiptlist[startIndex + 5] + "원");

            // 손님 정보 출력
            System.out.println("\n=== " + (i+1) + "번째 손님 ===");
            System.out.println("원래 가지고 있던 금액: " + receiptlist[startIndex] + "원");

            if(receiptlist[startIndex + 1] > 0)
            System.out.println("파스타 x " + receiptlist[startIndex + 1] + " = " + menuprice[0] * receiptlist[startIndex + 1] + "원");
            if(receiptlist[startIndex + 2] > 0)
            System.out.println("스테이크 x " + receiptlist[startIndex + 2] + " = " + menuprice[1] * receiptlist[startIndex + 2] + "원");
            if(receiptlist[startIndex + 3] > 0)
            System.out.println("비빔밥 x " + receiptlist[startIndex + 3] + " = " + menuprice[2] * receiptlist[startIndex + 3] + "원");
            if(receiptlist[startIndex + 4] > 0)
            System.out.println("김치찌개 x " + receiptlist[startIndex + 4] + " = " + menuprice[3] * receiptlist[startIndex + 4] + "원");
            if(receiptlist[startIndex + 5] > 0)
            System.out.println("오므라이스 x " + receiptlist[startIndex + 5] + " = " + menuprice[4] * receiptlist[startIndex + 5] + "원");

            System.out.println("현재 가지고 있는 금액: " + receiptlist[startIndex + 6] + "원");
            System.out.println("빚 진 금액: " + receiptlist[startIndex + 7] + "원");
            System.out.println("빚을 청산하고 남은 금액: " + receiptlist[startIndex + 8] + "원");
            System.out.println("미납된 금액: " + receiptlist[startIndex + 9] + "원");
            System.out.println("빌려준 금액: " + receiptlist[startIndex + 10] + "원");
        }
    }

    public static int[] receiptinsert(int firstmoney, int foodcnt[], int people[], int peopledebt[], int debtpay[], int borrowpe[], int peoplecnt, int receiptlist[]) { // 영수증에 넣어주는 함수
        if(peoplecnt != 1) {
            for(int i = peoplecnt * 11; i < peoplecnt * 11 + 1; i++) {
                receiptlist[i] = firstmoney;
                receiptlist[i+1] = foodcnt[i];
                receiptlist[i+2] = foodcnt[i+1];
                receiptlist[i+3] = foodcnt[i+2];
                receiptlist[i+4] = foodcnt[i+3];
                receiptlist[i+5] = foodcnt[i+4];
                receiptlist[i+6] = people[peoplecnt];
                receiptlist[i+7] = peopledebt[peoplecnt];
                receiptlist[i+8] = debtpay[peoplecnt];
                receiptlist[i+9] = debtpay[peoplecnt];
                receiptlist[i+10] = borrowpe[peoplecnt];
                return receiptlist;
            }
        } else if(peoplecnt == 1){
            for(int i = 0; i < peoplecnt * 11; i +=11) {
                receiptlist[i] = firstmoney;
                receiptlist[i+1] = foodcnt[i];
                receiptlist[i+2] = foodcnt[i+1];
                receiptlist[i+3] = foodcnt[i+2];
                receiptlist[i+4] = foodcnt[i+3];
                receiptlist[i+5] = foodcnt[i+4];
                receiptlist[i+6] = people[peoplecnt];
                receiptlist[i+7] = peopledebt[peoplecnt];
                receiptlist[i+8] = debtpay[peoplecnt];
                receiptlist[i+9] = debtpay[peoplecnt];
                receiptlist[i+10] = borrowpe[peoplecnt];
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
    public static int[] paybackmoney(int people[], int peopledebt[], int peoplecnt) { // 돈 갚는 함수
        System.out.println("얼마를 갚겠습니까?");
        System.out.println("갚아야 할 돈은" + peopledebt[peoplecnt] + "원 입니다.");
        int money = sc.nextInt();

        if(people[peoplecnt] > money && money < peopledebt[peoplecnt]) {
            people[peoplecnt] = people[peoplecnt] - money;
            peopledebt[peoplecnt] = peopledebt[peoplecnt] - money;
        }
        return new int[]{people[peoplecnt], peopledebt[peoplecnt]};
    }

    public static int[] refund(int foodcnt[],int ch, int people[],int peoplecnt, int menuprice[]) {
        int chfood = 0;
        if(ch <= 5) {
            ch -= 1;
            chfood = ch + (peoplecnt * 5);
            foodcnt[chfood]--;
            people[peoplecnt] += menuprice[ch];
            return new int[]{people[peoplecnt],foodcnt[chfood]};
        }
        chfood = ch + (peoplecnt * 5);
        return new int[]{people[peoplecnt],foodcnt[chfood]};
    }


    public static void allmoney(int people[]) {
        int sum = 0;
        for(int i = 0; i < people.length; i++) {
            sum += people[i];
        }
        System.out.println("총 가지고 있는 돈은" + sum + "원 입니다.");
    }




}