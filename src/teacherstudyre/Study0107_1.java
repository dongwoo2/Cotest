package teacherstudyre;

import java.util.Scanner;

public class Study0107_1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Study0107_1 T = new Study0107_1();
        T.solution();
    }

    public void solution() {
        int sequence = 1; // 손님 순서
        int allseque = 1;
        int ch1 = 0;
        int foodmenu = 3;
        int pcount = 0;
        int allpcount = 0;
        int f1 = 0, f2 = 0, f3 = 0;
        int fprice[] = new int[foodmenu]; // 푸드메뉴의 가격
        int arr[] = new int[foodmenu+1]; // 돈과 음식갯수 담는 배열
        int se1 = 0; // 이전 된 사람인지 체크
        int se2 = 0;
        int money = 0;
        int month = 1;
        int day = 1;
        int point = 0;
        int k = 0;
        int paymoney = 0;
        int ch4 = 0;
        int gubun = 0;
        boolean flag = true;
        boolean flag2 = true;
        int people[] = new int[1006]; // 사람들이 무엇을 구입했는지 대한 전체적인 정보
        int daypeople[] = new int [300]; // 당일에 온 사람 수
        fprice[0] = 5000; fprice[1] = 3000; fprice[2] = 1000; // 음식가격


        while (flag2 != false) {

            System.out.println(month + "월 " + day + "일");
            System.out.println("손님은 몇 명 입니까?");
            pcount = sc.nextInt();
            allpcount += pcount;
            sequence = 1;
            if(se1 > 0) {
                pcount += se1;
            }
            flag = true;


            while (flag != false) {

                if(gubun == 0) {
                    System.out.println(sequence + "번 째 손님이 가진 돈은 얼마입니까?");
                    arr[0] = sc.nextInt(); //arr[0]은 money
                    money = arr[0]; // 손님이 처음 가지고 있던 돈
                    gubun++;
                    point = 0;
                }
                ch4 = 0;
                menu();
                ch1 = sc.nextInt();
                if(ch1 <= 3) {
                    arr = foodselect(ch1, arr[0], se1, fprice);
                    f1 += arr[1]; // bacon 이 부분 나중에 함수로
                    f2 += arr[2]; // icecream
                    f3 += arr[3]; // gamzacong


                } else if(ch1 == 4 || ch1 == 5) { //4번 다음사람

                    if(f2 % 10 != 0 && arr[0] > 3000) {
                        icecream(f2);
                        ch4++;
                    }
                    if(f3 < f2 && arr[0] > 1000) {
                        gamza(f2,f3);
                        ch4++;
                    }
                    if(sequence == pcount && ch1 == 4) {
                        System.out.println("no person please choose other choice");
                        ch4++;
                    }

                    if(ch1 == 5 && ch4 == 0) {
                        daypeople[day]++;
                        people = insertpeople(f1, f2, f3, money, point, se1, allseque, people,arr);
                        flag = false;
                        flag2 = false;
                        se2++;
                    } else if(ch4 == 0 && ch1 == 4) {
                        people = insertpeople(f1, f2, f3, money, point, se1, allseque, people,arr);

                        f1 = 0;
                        f2 = 0;
                        f3 = 0;
                        gubun = 0;
                        sequence++;
                        allseque++;
                        daypeople[day]++;

                        if(se1 != 0) {
                            se1--;
                            if(se1 < 0) {
                                se1 = 0;
                            }
                        }

                    }



                } else if(ch1 == 6) {
                    paymoney = f1*fprice[0] + f2*fprice[1] + f3*fprice[2];
                    if(paymoney >= 10000) {
                        point = point(paymoney);
                        System.out.println("포인트가" + point + "원 만큼 적립되었습니다.");
                    }else {
                        System.out.println("지불한 금액이 부족하여 포인트 적립이 불가합니다");
                    }
                } else if(ch1 == 7) { // 다음날
                    people = insertpeople(f1, f2, f3, money, point, se1, allseque, people,arr);
                    if(allpcount > allseque) {
                        se1 = allpcount - allseque;
                        System.out.println(se1 + "명 이전되었습니다.");
                    }

                    allseque++;
                    daypeople[day]++;
                    day++;
                    if(day > 30) {
                        month++;
                        day = 1;
                    }
                    flag = false;
                    gubun = 0;
                    f1 = 0;
                    f2 = 0;
                    f3 = 0;
                } else if(ch1 == 8) {
//            	   receipt(people, arr, money, point, fprice);
                    receipt(people, fprice, k, month, day, daypeople);
                }
            }

        }
        if(se2 != 0) {
            last(people, fprice, k, month, day, daypeople);
        }
    }


    public void menu() { // 메뉴 보이게
        System.out.println("1번 베이컨 5000원, 2번 아이스크림 3000원, 3번 감자콩 1000원 4.다음사람 5.종료 6. 포인트 적립 7.다음 날 8.영수증 조회 ");
    }

    public int []foodselect(int choice, int money, int se1, int[]fPrice) {
        int f1 = 0, f2 = 0, f3 = 0;
        int fprice[] = new int [3];
        if(se1 != 0) { // 할인
            int f1Discount = fPrice[0]/100;
            int f2Discount = fPrice[1]/100;
            int f3Discount = fPrice[2]/100;
            fprice[0] = fPrice[0] - (f1Discount * 5);
            fprice[1] = fPrice[1] - (f2Discount * 5);
            fprice[2] = fPrice[2] - (f3Discount * 5);
        } else {
            fprice[0] = fPrice[0];
            fprice[1] = fPrice[1];
            fprice[2] = fPrice[2];
        }
        if(choice == 1 && money >= fprice[0]) { // 베이컨
            money -= fprice[0];
            f1++;
        } else if (choice == 2 && money >= fprice[1]) { // 아이스크림
            money -= fprice[1];
            f2++;
        } else if (choice == 3 && money >= fprice[2]) { // 감자콩
            money -= fprice[2];
            f3++;
        } else {
            System.out.println("돈이 부족합니다");
            return new int[]{money,0,0,0};
        }
        return new int[]{money,f1,f2,f3};
    }

    public int point(int paymoney) {
        int point = 0;
        if(paymoney >= 10000) {
            int t = paymoney/10000;
            point = (t*1000);
        }
        return point;
    }

    public void icecream(int f2) { //icecream check method
        int need = 0;
        int cnt = 0;
        if(f2 < 10) {
            need = 10 - f2;
        } else {
            cnt = (f2 % 10);
            need = 10 - cnt;
        }
        System.out.println("현재 아이스크림의 갯수는 " + f2 + "개 이며 " + need + "개 가 필요합니다.");
    }

    public void gamza(int f2, int f3) { //gamza check method
        int need = f2 -f3;
        System.out.println("현재 감자콩의 갯수는 " + f3 + "개 이며 " + need + "개 가 필요합니다.");
    }

    public int selpeople(int seque) {
        int count = 0;
        if(seque > 10) {
            count++;
        }
        return count;
    }

    public int[] insertpeople(int f1, int f2, int f3, int money, int point, int se1 , int allseque ,int []people,int[]arr) {
        int k = 0;

        if(allseque == 1) {
            k = 0;
        } else {
            k = 7 * (allseque-1);
        }

        for(int i = k; i < k + 7; i+=7) {
            people[i] = money;
            people[i+1] = f1;
            people[i+2] = f2;
            people[i+3] = f3;
            people[i+4] = point;
            people[i+5] = se1;
            people[i+6] = arr[0];
        }
        return people;

    }

    public void receipt(int people[], int fPrice[], int k, int month, int day, int daypeople[]) {
        System.out.println("몇월 몇일자를 조회하시겠습니까?");
        int firstday = 0;
        int lastday = 0;
        int foodsize=fPrice.length+1;
        int daycnt = 0;
        int[]foodcnt = new int[foodsize];
        for(int t = 1, b = 1; t <= day && b <= month; t++) {
            System.out.print(t + " : " + b + "월 " + t + "일  ");
            if(t > 30) {
                t = 1;
                b++;
            }
        }
        k = sc.nextInt();

        if(k != 1){
            for(int i = k; i >= 2; i--) {
                firstday += daypeople[i-1]; //사람 수 시작 체크 3일차를 골랐다면 1,2 일차에 사람이 1일차 4명 2일차 3명 그러면 first에 사람수를 더한다
                // 체크하는 인덱스 처음 시작용 변수
            }
            for(int j = k; j >= 1; j--) { //
                lastday += daypeople[j];
            }
        }
        else {
            firstday = 0;
            lastday = daypeople[1];
        }

        firstday = (firstday*7);
        lastday = (lastday*7)-1;
        for(int i = firstday; i < lastday; i += 7) {
            foodcnt[1] += people[i+1];
            foodcnt[2] += people[i+2];
            foodcnt[3] += people[i+3];
        }
        for(int i = firstday, psun = 1; i < lastday; i += 7,psun++) {
            if(people[i] != 0 || people[i+1] != 0 || people[i+2] != 0 || people[i+3] != 0 || people[i+4] != 0 || people[i+5] != 0){
                if(daycnt == 0) {
                    System.out.println("["+month + "월" + k + "일"+"]");
                    daycnt++;
                    if(foodcnt[1] > 0)
                        System.out.println("베이컨 x " + foodcnt[1] + " = " + fPrice[0]*foodcnt[1]);
                    if(foodcnt[2] > 0)
                        System.out.println("아이스크림 x " + foodcnt[2] + " = " + fPrice[1]*foodcnt[2]);
                    if(foodcnt[3] > 0)
                        System.out.println("감자콩 x " + foodcnt[3] + " = " + fPrice[2]*foodcnt[3]);
                }
                System.out.println("================================================================");
                System.out.println(psun + "번 째 사람");
                if(people[i+5] != 0) {
                    System.out.println("할인 대상입니다!");
                }
                System.out.println("원래가진돈 : "+people[i]);
                System.out.println("베이컨 : "+people[i+1]);
                System.out.println("아이스 : "+people[i+2]);
                System.out.println("감자콩 : "+people[i+3]);
                if(people[i+4] > 0) {
                    System.out.println("포인트 : "+people[i+4]);
                }
                System.out.println("남은금액 : " + people[i+6]);
                System.out.println("================================================================");
            }
        }


    }

    public void last(int people[], int fPrice[], int k, int month, int day, int daypeople[]) {
        int firstday = 0;
        int lastday = 0;
        int x = 0;
        for(int t = 1, b = 1; t <= day && b <= month; t++) {
            System.out.println(b + "월 " + t + "일  :" + daypeople[t] +"명" );

            if(t != 1){
                for(int i = t; i >= 2; i--) {
                    firstday += daypeople[i-1]; //사람 수 시작 체크 3일차를 골랐다면 1,2 일차에 사람이 1일차 4명 2일차 3명 그러면 first에 사람수를 더한다
                    // 체크하는 인덱스 처음 시작용 변수
                }
                for(int j = t; j >= 1; j--) { //
                    lastday += daypeople[j];
                }
            }
            else {
                firstday = 0;
                lastday = daypeople[1];
            }

            firstday = (firstday*7);
            lastday = (lastday*7)-1;
            for(int i = firstday, psun = 1; i < lastday; i+=7, psun++) {
                if(people[i+4] > 0) {
                    System.out.println(psun + "번 째 사람이 포인트를 " + people[i+4]+ " 만 큼 가지고 있습니다.");
                    x += people[i+4];
                }
            }
            System.out.println(b + "월" + t + "일 포인트 총 합계는" + x + "원 입니다." );
            x = 0;
            if(t > 30) {
                t = 1;
                b++;
            }
        }
    }


}
]
