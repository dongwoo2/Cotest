package teacherstudyre;

import java.util.Scanner;

public class Study0107_1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Study0107_1 T = new Study0107_1();
        T.solution();
    }

    public void solution() {
        int sequence = 0; // 손님 순서
        int allseque = 0;
        int ch1 = 0;
        int foodmenu = 3;
        int f1 = 0, f2 = 0, f3 = 0;
        int fprice[] = new int[foodmenu]; // 푸드메뉴의 가격
        int arr[] = new int[foodmenu+1]; // 돈과 음식갯수 담는 배열
        int se1 = 0; // 이전 된 사람인지 체크
        int money = 0;
        int month = 1;
        int day = 1;
        int point = 0;
        int k = 0;
        int gubun = 0;
        boolean flag = true;
        boolean flag2 = true;
        int people[] = new int[1000];
        int daypeople[] = new int [300];
        fprice[0] = 5000; fprice[1] = 3000; fprice[2] = 1000;


        while (flag2 != false) {

            System.out.println(month + "월 " + day + "일");
            sequence = 0;
            flag = true;
            while (flag != false) {
                if(gubun == 0) {
                    System.out.println(sequence + 1 + "번 째 손님이 가진 돈은 얼마입니까?");
                    arr[0] = sc.nextInt(); //arr[0]은 money
                    money = arr[0]; // 손님이 처음 가지고 있던 돈
                    gubun++;
                }
                menu();
                ch1 = sc.nextInt();
                if(ch1 <= 3) {
                    arr = foodselect(ch1, arr[0], se1, fprice);
                    f1 += arr[1]; // bacon 이 부분 나중에 함수로
                    f2 += arr[2]; // icecream
                    f3 += arr[3]; // gamzacong
//                    if(sequence != 1) k = sequence * 50;
                    if(sequence == 0) {
                        k = 0;
                    } else {
                        k = (5 * allseque);
                    }
                    for(int i = k; i < k + (allseque*5); i+=5) {
                        people[i] = money;
                        people[i+1] = f1;
                        people[i+2] = f2;
                        people[i+3] = f3;
                        people[i+4] = point;
                    }
                } else if(ch1 == 4 || ch1 == 5) { //4번 다음사람
                    if(f2 % 10 != 0) {
                        icecream(f2);
                    }
                    if(f2 % 10 == 0 && f3 < f2) {
                        gamza(f2,f3);
                    }
                    else if(ch1 == 5) {
                        flag = false;
                        flag2 = false;
                    }

                    gubun = 0;
                    sequence++;
                    allseque ++;

                } else if(ch1 == 6) {

                } else if(ch1 == 7) { // 다음날



                    daypeople[day] = sequence;
                    day++;
                    if(day > 30) {
                        month++;
                        day = 1;
                    }
                    flag = false;

                } else if(ch1 == 8) {
//            	   receipt(people, arr, money, point, fprice);
                    receipt(people, fprice, k, month, day);
                }
            }

        }
    }


    public void menu() { // 메뉴 보이게
        System.out.println("1번 베이컨 5000원, 2번 아이스크림 3000원, 3번 감자콩 1000원 4.다음사람 5.종료 6. 포인트 적립 7.다음 날 8.영수증 조회 ");
    }

    public int []foodselect(int choice, int money, int se1, int[]fPrice) {
        int f1 = 0, f2 = 0, f3 = 0;

        if(se1 == 1) { // 할인
            int f1Discount = fPrice[0]/100;
            int f2Discount = fPrice[1]/100;
            int f3Discount = fPrice[2]/100;
            fPrice[0] = fPrice[0] - (f1Discount * 5);
            fPrice[1] = fPrice[1] - (f2Discount * 5);
            fPrice[2] = fPrice[2] - (f3Discount * 5);
        }
        if(choice == 1) { // 베이컨
            money -= fPrice[0];
            f1++;
        } else if (choice == 2) { // 아이스크림
            money -= fPrice[1];
            f2++;
        } else if (choice == 3) { // 감자콩
            money -= fPrice[2];
            f3++;
        }
        return new int[]{money,f1,f2,f3};
    }

    public int point(int paymoney) {
        int point = 0;
        if(paymoney >= 100000) {
            int t = paymoney/100000;
            point = (t*1000);
        }
        return point;
    }

    public void icecream(int f2) {
        int need = (f2 % 10);
        System.out.println("현재 아이스크림의 갯수는 " + f2 + "개 이며" + need + "개 가 필요합니다.");
    }

    public void gamza(int f2, int f3) {
        int need = f2 -f3;
        System.out.println("현재 감자콩의 갯수는 " + f3 + "개 이며" + need + "개 가 필요합니다.");
    }

    public int selpeople(int seque) {
        int count = 0;
        if(seque > 10) {
            count++;
        }
        return count;
    }

    public void receipt(int people[], int fPrice[], int k, int month, int day) {
        System.out.println("몇월 몇일자를 조회하시겠습니까?");

        for(int t = 1, b = 1; t <= day && b <= month; t++) {
            System.out.print(t + " : " + b + "월 " + t + "일  ");
            if(t > 30) {
                t = 1;
                b++;
            }
        }
        k = sc.nextInt();

        if(k != 1){
            k = k * 50;
        } else if(k == 1) {
            k = 0;
        }
        for(int i = k , psun = 1; i < k + 50; i+=5, psun++) {
//        	people[k] = money;
//        	people[k+1] = f1;
//        	people[k+2] = f2;
//        	people[k+3] = f3;
//        	people[k+4] = point;
            if(people[i] != 0 || people[i+1] != 0 || people[i+2] != 0 || people[i+3] != 0 ){
                System.out.println(psun + "번 째 사람");
                System.out.println("원래가진돈 : "+people[i]);
                System.out.println("베이컨 : "+people[i+1]);
                System.out.println("아이스 : "+people[i+2]);
                System.out.println("감자콩 : "+people[i+3]);
                System.out.println("================================================================");
            }
        }
//    	int allbacon = fPrice[0] * arr[1];
//    	int allice = fPrice[1] * arr[2];
//    	int allpotato = fPrice[2] * arr[3];
//    	int allprice = allbacon + allice + allpotato;
//    	int minusmoney = money - allprice;
//    	System.out.println("originally money : " + money + "won" );
//    	System.out.println("Bacon : " + allbacon + "won");
//    	System.out.println("ice : " + allice + "won");
//    	System.out.println("potato : " + allpotato + "won");
//    	System.out.println("now money : " + minusmoney + "won");
    }


}

