package teacherstudyre;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class Study20240703_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 팔린 잔수와 이름 설정 해야함 함수로 만들어야함 그래서 목록을 보여줄 수 있음

        String[] coffee_names = new String[10]; // 커피 이름
        String[] day_sell_coffee = new String[5]; // 하루에 5종류만 팔 거니까 그에 맞게 매일 다른 게 들어감
        int[] coffee_time = new int[5];
        int[][] coffee_count_price = new int[2][5]; // 잔수와 가격 1은 잔수 2는 가격
        int[] coffee_count = new int[5];
        int[] coffee_price = new int[5];
        int[] coffee_happy = new int[5]; // 만족도 만들기
        boolean flag = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        int choice = 0;
        int[] coffee_select = new int[5];
        int hour = 0;
        int minute = 0;
        int day_alltime = 0;
        int[] coffee_event = new int[2]; // 1은 인원 2는 시간
        int[][] event_coffeename_count = new int[2][5]; // 이벤트커피 1은 메뉴 2는 잔수
        //1에 대응되는 day_sell_coffee에 대응되는 번호가 들어가있음
        String[] event_coffeename = new String[5]; // 1메뉴가 여기 들어감
        int[] event_coffeetime = new int[5]; // 이벤트 커피 걸리는시간
        int[] event_coffeecount = new int[5]; // 이벤트 잔수
        int[][] people_happy = new int[100][100]; // 손님 만족도
        int event_flag = 0;
        // (7/10)
        int event_get = 0; // 손님이 이벤트 잔 받았는지 안받았는지 확인 이벤트 잔은 손님당 1잔
        int people = 0; // 하루 온 손님
        int daypeople = 0; // 와야 할 손님
        int people_flag = 0; // 당일에 남은 손님이 없다면 0 손님이 있다면  1
        int coffee_event_man = 0;
        int coffee_event_time = 0;
        int month = 0;
        int day = 0;
        int money = 0;
        int[] daymoney = new int[100];
        int coffee_or_event = 0; // 이벤트용 주문인지 아닌지 0이면 일반주문 1이면 이벤트주문
        int want_event_menu = 1; // 이벤트 메뉴중에서 원하는 메뉴였는지
        String[] day_selled_coffee = new String[5];
        int[] day_sell_count = new int[5];


        coffeeName(coffee_names);

        while (flag) { // 장사 셋팅
            System.out.println("장사 시간을 정해주세요");
            day_alltime = dayHour(hour, minute);
            showMenu(coffee_names);
            System.out.println("커피 5가지를 고르세요");
            for (int i = 0; i < coffee_select.length; i++) {
                choice = sc.nextInt();
                if (choice > 0 && choice < 11) {
                    coffee_select[i] = choice;
                } else {
                    System.out.println("잘못 선택하셨습니다 번호를 다시 골라주세요");
                    i--;
                }
            }
            day_sell_coffee = daySellCoffee(coffee_names, day_sell_coffee, coffee_select); // 하루 커피 종류 정하기
            coffee_time = daySellCoffeeTime(day_sell_coffee, coffee_select, coffee_time, day_alltime); // 커피 시간 정하기
            coffee_count_price = coffeeCountPrice(coffee_count_price); // 커피 잔수와 가격 정하기
            coffee_count = coffeeCountSet(coffee_count_price, coffee_count); // 잔수 배열 하나로 보기 쉽게 세팅
            coffee_price = coffeePriceSet(coffee_count_price, coffee_price); // 가격 배열 하나로 보기 쉽게
            coffee_happy = coffeeHappySet(coffee_price, coffee_happy); // 만족도 배열 하나로 보기 쉽게

            computer1(day_alltime,coffee_time,day_sell_coffee);

            System.out.println("1. 이벤트 설정 2. 넘어가기"); // 만약 이벤트를 안하고 지나간다면 다 초기화를 해주어야함
            choice = sc.nextInt();
            if (choice == 1) {
                coffee_event = coffeeEvent1(day_alltime); // coffee_event의 0은 인원, 1은 시간
                event_coffeename_count = coffeeEvent2(coffee_event, day_sell_coffee,coffee_price,coffee_count);
                for (int i = 0; i < event_coffeename_count.length - 1; i++) { // 얘도 함수로 뺴야함
                    for (int j = 0; j < event_coffeename_count[i].length; j++) {
                        if (event_coffeename_count[i][j] != 0) {
                            event_coffeename[i] = day_sell_coffee[event_coffeename_count[i][j]];
                            event_coffeecount[i] = event_coffeename_count[i + 1][j];
                            event_coffeetime[i] = event_coffeename_count[i + 2][j];
                        }
                    }

                }
                eventcomputer1(coffee_event_time,event_coffeetime,event_coffeename);
            }
            flag = false;
        }

        flag = true;

        while (flag) { // 손님 받는 거
            System.out.println((day + 1) + "번 째 날 " + (people + 1) + "번 째 손님입니다.");
            if (coffee_event[0] > 0) { // 이벤트 설정한 게 있다면 이벤트는 장사 시작과 동시에 하자
                while (flag2) {
                    coffee_event_man = coffee_event[0]; // 이벤트 인원
                    coffee_event_time = coffee_event[1]; // 이벤트 시간 설정
                    System.out.printf("이벤트 시간 %d분 진행합니다. 남은 인원 %d명 입니다.", coffee_event_man, coffee_event_time);

                    // 이벤트 메뉴 보여주어야함
                    System.out.println("어떤 음료가 드시고 싶으십니까?");
                    eventShowMenu(event_coffeename, event_coffeecount);

                    choice = sc.nextInt();

                    if (event_coffeecount[choice - 1] == 0) { // 품절
                        System.out.println("품절입니다. 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 안 고를시 일반 주문으로 넘어감
                        choice = sc.nextInt();

                        if (choice == 2) {
                            System.out.println("일반 주문으로 넘어갑니다. \n1. 메뉴보기 2. 나가기");

                            if (choice == 1) {
                                while (flag3) {
                                    System.out.println("메뉴를 골라주세요.");
                                    dailyShowMenu(day_sell_coffee, coffee_count, coffee_price);
                                    choice = sc.nextInt();
                                    if (coffee_count[choice - 1] == 0) { // 품절일 때 시간 없을 때 고려해야함 시간도
                                        System.out.println("품절입니다. 다른 음료를 고르시겠습니까?");
                                        System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                                        if (choice == 2) {
                                            people_flag = peopleFlag(daypeople,people_flag);
                                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                                day++;
                                                // 여기서 데이피플 정할건지
                                                people = 0;
                                                flag3 = false;
                                            } else {
                                                daypeople--;
                                                people++;
                                                flag3 = false;
                                            }
                                        }
                                    } else if(coffee_count[choice - 1] > day_alltime) { // 시간 없을 때
                                        System.out.println("시간이 부족합니다 다른 음료를 고르시겠습니까?");
                                        System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                                        if (choice == 2) {
                                            people_flag = peopleFlag(daypeople,people_flag);
                                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                                day++;
                                                // 여기서 데이피플 정할건지
                                                people = 0;
                                                flag3 = false;
                                            } else {
                                                daypeople--;
                                                people++;
                                                flag3 = false;
                                            }
                                        }
                                    }else { //1. 메뉴 추가 주문도 생각하기, 일반 주문이 잘 들어갔다면 돈, 무슨 커피를 팔았는지
                                        System.out.println(day_sell_coffee[choice - 1] + " 이 장바구니에 담겼습니다 추가 주문하시겠습니까?");
                                        coffee_count[choice-1]--;
                                        daymoney[day] = daymoney[day] + coffee_price[choice - 1]; //
                                        day_alltime = day_alltime - coffee_count[choice - 1]; // 시간 빼기
                                        System.out.println("1. 예 2. 아니오");
                                        choice = sc.nextInt();
                                        if(choice == 2) { // 주문을 그만 한다면
                                            flag3 = false;
                                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                                day++;
                                                // 여기서 데이피플 정할건지
                                                people = 0;
                                                flag3 = false;
                                            } else {
                                                daypeople--;
                                                people++;
                                                flag3 = false;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (choice == 2) {
                            flag2 = false;
                            flag = false;
                            people_flag = peopleFlag(daypeople,people_flag);
                            if (people_flag == 0) { // 하루 손님의 수
                                day++;
                                // 여기서 데이피플 정할건지
                                people = 0;
                            } else {
                                daypeople--;
                                people++;
                            }
                        }
                    } else if(coffee_event[1] < event_coffeetime[choice - 1]) { // 시간 부족할 때
                        System.out.println("시간이 부족합니다 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                        if (choice == 2) {
                            people_flag = peopleFlag(daypeople,people_flag);
                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                day++;
                                // 여기서 데이피플 정할건지
                                people = 0;
                                flag3 = false;
                            } else {
                                daypeople--;
                                people++;
                                flag3 = false;
                            }
                        }
                        want_event_menu = 0; // 여기서 이미 원하는 메뉴가 아니기에 세팅이 끝나야함
                    } else { // System.out.println("모든 조건이 충족한다면");
                        if(want_event_menu == 0) {
                            want_event_menu = 0;
                        } else {
                            want_event_menu = 1;
                        }
                    }

                }

                // 장바구니로 선택하는 느낌으로 하자
                // 메뉴가 없습니다 메뉴가 없으면 그냥 모달창 느낌으로 메뉴가 없어 한 다음에
                //
                for (int i = 0; i < event_coffeecount.length; i++) { // 이벤트 잔이 다 떨어지는거 확인용
                    if (event_coffeecount[i] != 0) {
                        event_flag = 1;
                    } else {
                        if (event_flag == 1) {
                            event_flag = 1;
                        } else {
                            event_flag = 0;
                        }
                    }
                }
                if (coffee_event_man == 0 || coffee_event_time == 0 || event_flag == 0) {
                    flag2 = false;
                }
            } else { // 이벤트 설정한 게 없다면
                while (flag3) {
                    System.out.println("메뉴를 골라주세요.");
                    dailyShowMenu(day_sell_coffee, coffee_count, coffee_price);
                    choice = sc.nextInt();
                    if (coffee_count[choice - 1] == 0) { // 품절일 때 시간 없을 때 고려해야함 시간도
                        System.out.println("품절입니다. 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                        if (choice == 2) {
                            people_flag = peopleFlag(daypeople,people_flag);
                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                day++;
                                // 여기서 데이피플 정할건지
                                people = 0;
                                flag3 = false;

                            } else {
                                daypeople--;
                                people++;
                                flag3 = false;
                            }
                        }
                    } else if(coffee_count[choice - 1] > day_alltime) { // 시간 없을 때
                        System.out.println("시간이 부족합니다 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                        if (choice == 2) {
                            people_flag = peopleFlag(daypeople,people_flag);
                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                day++;
                                // 여기서 데이피플 정할건지
                                people = 0;
                                flag3 = false;
                            } else {
                                daypeople--;
                                people++;
                                flag3 = false;
                            }
                        }
                    }else { //1. 메뉴 추가 주문도 생각하기, 일반 주문이 잘 들어갔다면 돈, 무슨 커피를 팔았는지
                        System.out.println(day_sell_coffee[choice - 1] + " 이 장바구니에 담겼습니다 추가 주문하시겠습니까?");
                        coffee_count[choice-1]--;
                        daymoney[day] = daymoney[day] + coffee_price[choice - 1]; //
                        day_alltime = day_alltime - coffee_count[choice - 1]; // 시간 빼기
                        System.out.println("1. 예 2. 아니오");
                        choice = sc.nextInt();
                        if(choice == 2) { // 주문을 그만 한다면
                            flag3 = false;
                            if (people_flag == 0) { // 하루 손님의 수 마지막 손님이었다면
                                day++;
                                // 여기서 데이피플 정할건지
                                people = 0;
                                flag3 = false;
                            } else {
                                daypeople--;
                                people++;
                                flag3 = false;
                            }
                        }
                    }
                }
            }
        }

    }

    public static int peopleFlag(int daypeople, int people_flag) {
        if(daypeople != 0) {
            System.out.println("다음 손님으로 넘어갑니다.");
            people_flag = 1;
        } else { // day피플이 없다면
            System.out.println("다음 날로 넘어갑니다.");
            people_flag = 0;
        }
        return people_flag;
    }


    public static int[] coffeeCountSet(int[][] coffee_count_price, int[] coffee_count) {
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < coffee_count.length; j++) {
                coffee_count[j] = coffee_count_price[i][j];
            }
        }
        return coffee_count;
    }

    public static int[] coffeePriceSet(int[][] coffee_count_price, int[] coffee_price) {
        for(int i = 1; i < 2; i++) {
            for(int j = 0; j < coffee_price.length; j++) {
                coffee_price[j] = coffee_count_price[i][j];
            }
        }
        return coffee_price;
    }

    public static int[] coffeeHappySet(int[] coffee_price, int[] coffee_happy) { // 가격은 0원에서 10000원
        for(int i = 0; i < coffee_price.length; i++) {
            if(coffee_price[i] < 1000 && coffee_price[i] > 0) { // 0 ~ 999 5로 고정
                coffee_happy[i] = 5;
            } else if(coffee_price[i] > 1000 && coffee_price[i] < 10000) {
                coffee_happy[i] = (coffee_price[i]/100);
            }
        }
        return coffee_happy;
    }


    public static int[][] peopleHappy(int[][] people_happy, int[] coffee_happy, int coffee_or_event, int day, int people, int choice, int want_event_menu) { // 손님들 만족도 일반 주문용 이벤트용
        if(coffee_or_event != 0) { // 이벤트 주문이라면
            if(want_event_menu != 0) { // 원하는 메뉴였다면 1이니까
                if((people_happy[day][people] + 70) < 100) {
                    people_happy[day][people] += 70;
                } else { // 100보다 크면 그냥 100으로 셋팅
                    people_happy[day][people] = 100;
                }
            }
        } else { // 이벤트 주문이 아니라면
            if((people_happy[day][people] + coffee_happy[choice - 1]) < 100) {
                people_happy[day][people] += coffee_happy[choice - 1];
            } else {
                people_happy[day][people] = 100;
            }
        }
        return people_happy;
    }

    public static int[][] coffeeCountPrice(int[][] coffee_count_price) {
        for(int i = 0; i < coffee_count_price.length; i++) {
            for(int j = 0; j < coffee_count_price[i].length; j++) {
                if(i == 0) { // 첫 번째는 잔수
                    System.out.println((j+1) + "번 째 메뉴의 잔수를 설정해주세요");
                    coffee_count_price[i][j] = sc.nextInt();
                } else { // 두 번째는 가격
                    System.out.println((j+1) + "번 째 메뉴의 가격을 설정해주세요");
                    coffee_count_price[i][j] = sc.nextInt();
                }
            }
        }
        return coffee_count_price;
    }

    public static String[] coffeeName(String [] coffee_names) { // 커피 종류 지정하는 거
        for(int i = 0; i < 1; i++) {
            coffee_names[i] = "아이스 아메리카노";
            coffee_names[i+2] = "핫 아메리카노";
            coffee_names[i+3] = "아이스 초코";
            coffee_names[i+4] = "핫 초코";
            coffee_names[i+5] = "아이스 카페라떼";
            coffee_names[i+6] = "핫 카페라떼";
            coffee_names[i+7] = "석류 에이드";
            coffee_names[i+8] = "녹차 프라푸치노";
            coffee_names[i+9] = "아이스크림";
            coffee_names[i+10] = "쌍화차";
        }
        return coffee_names;
    }

    public static void showMenu(String [] coffee_names) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i+1) + " : " + coffee_names[i]);
            i++;
            if(i == coffee_names.length) {
                flag = false;
            }
        }
    }

    public static void dailyShowMenu(String [] day_sell_coffee, int[] coffee_count, int [] coffee_price) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i+1) + ". " + day_sell_coffee[i] + ": " + coffee_price[i] + "원 " + "( " + coffee_count[i] + " ) 잔 남았습니다." );
            i++;
            if(i == day_sell_coffee.length) {
                flag = false;
            }
        }
    }

    public static void eventShowMenu(String [] event_coffeename,int[] event_coffeecount) { // 이름 뿐만 아니라 남은 잔수도 보여주는게 더 편할 듯
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i+1) + " : " + event_coffeename[i] + " 남은 잔 수 : " + event_coffeecount[i]);
            i++;
            if(i == event_coffeename.length) {
                flag = false;
            }
        }
    }


    public static int[] coffeeCount(int[] coffee_count) { // 커피 하루 재고 입력
        for(int i = 0; i < 5; i++) {
            coffee_count[i] = sc.nextInt();
        }
        return coffee_count;
    }

    public static String[] daySellCoffee(String [] coffee_names, String [] day_sell_coffee, int[] coffee_select) { // 하루 메뉴 선정하는 함수
        int choice = 0;
        boolean flag = true;

        for(int i = 0; i < coffee_select.length; i++) {
            day_sell_coffee[i] = coffee_names[coffee_select[i]];
        }
        return day_sell_coffee;
    }

    public static int[] daySellCoffeeTime(String [] day_sell_coffee,int[] coffee_select, int[] coffee_time, int day_alltime) { // 커피 시간 정하기
        int choice = 0;
        for(int i = 0; i < coffee_select.length; i++) {
            System.out.println((i+1) + "번째 메뉴인 "+day_sell_coffee[i] + " 의 시간을 골라주세요");
            coffee_time[i] = sc.nextInt();
            if(coffee_time[i] > day_alltime) {
                System.out.println("영업 시간 보다 길게 할 수 없습니다.");
                i--;
            }
        }
        return coffee_time;
    }

    public static int dayHour(int hour, int minute) { // 1. 영업 전체시간, 2.영업 시작 시간, 3.영업 끝나는 시간
        boolean flag = true;
        boolean flag2 = true;
        int start_hour = 0;
        int start_minute = 0;
        int alltime = 0;
        while (flag) {
            System.out.println("영업을 몇 시 부터 시작하시겠습니까? 시간은 0~23 숫자로 입력해주시고, 분은 0~59 숫자로 입력해주세요");
            start_hour = sc.nextInt();
            start_minute = sc.nextInt();
            if (hour > 23 || minute > 59 || hour < 0 || minute < 0) {
                System.out.println("0 ~ 23 내의 시간만 가능합니다. 다시 입력해주세요.");
            } else {
                while (flag2) {
                    System.out.println("하루 영업시간을 정해주세요");
                    System.out.print("시간 :");
                    hour = sc.nextInt();
                    System.out.print("분 :");
                    minute = sc.nextInt();
                    if (hour > 11 && minute > 0) {
                        System.out.println("하루 영업시간은 총 12시간을 넘길 수 없습니다.");
                    } else {
                        System.out.println("영업시간은");
                        if(start_minute+minute > 60) {
                            hour++;
                            minute = (start_minute + minute - 60);
                        }
                        if(start_hour + hour > 24) {
                            System.out.printf("전 날 : %d시 %d분 부터 다음날 : %d시 %d분 까지 입니다.", start_hour, start_minute, (start_hour+hour-24), minute);
                            flag = false;
                            flag2 = false;
                        } else {
                            System.out.printf("%d시 $d분 부터 ~ %d시 %d분 까지 입니다.", start_hour,start_minute,hour,minute);
                            flag = false;
                            flag2 = false;
                        }

                    }
                }

            }
        }
        alltime = (hour*60) + minute;
        return alltime;
    }

    public static int[] coffeeEvent1(int day_alltime) { // 리턴값 1은 인원 2는 시간
        int[] allset = new int[2];
        int event_people = 0;
        int event_time = 0;
        int choice = 0;
        System.out.println("이번트 인원을 몇 명 하시겠습니까?");
        event_people = sc.nextInt();
        allset[0] = event_people;
        System.out.println("이번트 시간은 몇 분 하시겠습니까?");
        choice = sc.nextInt();
        if(choice > day_alltime) {
            System.out.println("영업시간 보다 길 수 없습니다.");
        } else {
            event_time = choice;
            allset[1] = event_time;
        }

        return allset;
    }
    public static int[][] coffeeEvent2(int[]coffee_evnet, String []day_sell_coffee , int[] coffee_price, int[] coffee_count) { // 커피 메뉴 , 수량 고르기 1 메뉴 2 수량
        int choice = 0;
        boolean flag = true;
        int i = 0;
        int j = 0;

        int[][] event_coffeename_count = new int[3][5];
        for(int t = 0; t < event_coffeename_count.length; t++) { // 0으로 초기화
            for(int k = 0; k < event_coffeename_count[t].length; k++) {
                event_coffeename_count[t][k] = 0;
            }
        }
        while (flag) {
            System.out.println("1. 이벤트 메뉴추가 2.나가기");
            choice = sc.nextInt();
            if(choice == 1) {
                dailyShowMenu(day_sell_coffee,coffee_count,coffee_price);
                System.out.println("메뉴를 골라주세요");
                choice = sc.nextInt();
                event_coffeename_count[i][j] = choice - 1; // 함수밖으로 나가서 day_sellcoffee로부터 이름 받을수 있게
                System.out.printf("잔 수를 설정해주세요");
                choice = sc.nextInt();
                event_coffeename_count[i+1][j] = choice;
                event_coffeename_count[i+2][j] = coffee_count[choice - 1];
                j++;
                if(j == day_sell_coffee.length) {
                    System.out.println("이벤트 메뉴가 가득 찼습니다.");
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        return event_coffeename_count;

    }



    public static void computer1(int day_alltime, int[]coffee_time, String []day_sell_coffee) { // 효율성 따지는 친구 얘는 시간내에 몇 잔을 팔아야 이득인지 알려주는애
        int [] coffeename_count = new int[2];
        String name = "";
        int max = 0;
        int t = 0;
        for(int i = 0; i < coffee_time.length; i++) {
            t = coffee_time[i]/day_alltime;
            if(t > max) {
                max = t;
                name = day_sell_coffee[i]; // 커피종류 알 수 있게
                coffeename_count[1] = max; // 갯수
            }
        }
        System.out.println(name+ "를 " + coffeename_count[1]+ "개 팔아요 제일 효율적입니다.");
    }



    public static void eventcomputer1(int coffee_event_time, int [] event_coffeetime, String [] event_coffee_name) { // 얘는 이벤트 시간내에 몇 잔을 팔아야 이득인지 알려주는 애
        int [] coffeename_count = new int[2];
        String name = "";
        int max = 0;
        int t = 0;
        for(int i = 0; i < event_coffeetime.length; i++) {
            t = event_coffeetime[i]/coffee_event_time;
            if(t > max) {
                max = t;
                name = event_coffee_name[i]; // 커피종류 알 수 있게
                coffeename_count[1] = max; // 갯수
            }
        }
        System.out.println(name + "를 " + coffeename_count[1]+ "개 팔아요 제일 효율적입니다.");
    }

    public static void dayset(int people, int day, int [] daymoney, int [][] people_happy, String[] day_selled_coffee, int[] day_sell_count) { // 하루 정리 마감 보면서 얼마 벌었는지 그런 목록들 보여주는거
        int happy = 0;
        for(int t = 0; t < day_selled_coffee.length; t++) { // 커피 판 거 정리
            System.out.println((t+1) + ": " + day_selled_coffee[t] + " " + day_sell_count + "잔");
        }
        for(int i = day-1; i < day; i++) { // 만족감
            for(int j = 0; j < people; j++) {
                happy += people_happy[i][j];
            }
        }
        System.out.println(people+1 + "명 의 총 만족감 : " + happy);

        System.out.println("하루 총 수익 : " + daymoney[day]);
    }

    public static String[] daysellmenuname(String[] day_sell_coffee, int choice, String[] day_selled_coffee) { // 팔린 거 이름
        for(int i = 0; i < day_selled_coffee.length; i++) {
            if(day_selled_coffee[i].equals(day_sell_coffee[choice-1])) {

            } else {
                day_selled_coffee[i] = day_sell_coffee[choice - 1];
            }
        }
        return day_selled_coffee;
    }

    public static int[] daysellmenucount(String[] day_sell_coffee, int choice, String[] day_selled_coffee, int[] day_sell_count) { // 팔린 거 갯수
        for(int i = 0; i < day_selled_coffee.length; i++) {
            if(day_selled_coffee[i].equals(day_sell_coffee[choice-1])) {
                day_sell_count[i]++;
            } else {
                day_selled_coffee[i] = day_sell_coffee[choice - 1];
                day_sell_count[i]++;
            }
        }
        return day_sell_count;
    }
}
