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
        int[][] event_coffeename_count_time = new int[3][5]; // 이벤트커피 1은 메뉴 2는 잔수 3은 시간
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
        String[] day_selled_coffee = new String[5]; // 하루중에 팔린커피 목록
        int[] day_sell_count = new int[5]; // 하루 팔린 커피 몇 잔인지 다음 날 눌러지면 초기화되게 셋팅
        int event_choice = 0;
        int event_people = 0;


        coffeeName(coffee_names);

        while (flag) { // 장사 셋팅
            System.out.println("장사 시간을 정해주세요");
            day_alltime = dayHour(hour, minute);

            if (day == 0) {
                System.out.println("손님 수를 고르세요");
                daypeople = sc.nextInt();
            }
            showMenu(coffee_names);
            System.out.println("커피 5가지를 고르세요");
            for (int i = 0; i < coffee_select.length; i++) {
                choice = sc.nextInt();
                if (choice > 0 && choice < 11) {
                    coffee_select[i] = choice - 1;
                } else {
                    System.out.println("잘못 선택하셨습니다 번호를 다시 골라주세요");
                    i--;
                }
            }
            day_sell_coffee = daySellCoffee(coffee_names, day_sell_coffee, coffee_select); // 하루 커피 종류 정하기
            coffee_time = daySellCoffeeTime(day_sell_coffee, coffee_select, coffee_time, day_alltime); // 커피 시간 정하기
            coffee_count_price = coffeeCountPrice(coffee_count_price, coffee_time, day_alltime); // 커피 잔수와 가격 정하기 time은 예외적용에 필요 alltime도 마찬가지
            coffee_count = coffeeCountSet(coffee_count_price, coffee_count); // 잔수 배열 하나로 보기 쉽게 세팅
            coffee_price = coffeePriceSet(coffee_count_price, coffee_price); // 가격 배열 하나로 보기 쉽게
            coffee_happy = coffeeHappySet(coffee_price, coffee_happy); // 만족도 배열 하나로 보기 쉽게

            computer1(day_alltime, coffee_time, day_sell_coffee, coffee_count);

            System.out.println("1. 이벤트 설정 2. 넘어가기"); // 만약 이벤트를 안하고 지나간다면 다 초기화를 해주어야함
            choice = sc.nextInt();
            if (choice == 1) {
                coffee_event = coffeeEvent1(day_alltime); // coffee_event의 0은 인원, 1은 시간
                event_coffeename_count_time = coffeeEvent2(coffee_event, day_sell_coffee, coffee_price, coffee_count, coffee_time);
                for (int i = 0; i < 1; i++) { // 얘도 함수로 뺴야함
                    for (int j = 0; j < event_coffeename_count_time[i].length; j++) {
                        if (event_coffeename_count_time[i][j] != 0) { //
                            event_coffeename[i] = day_sell_coffee[(event_coffeename_count_time[i][j] - 1)];
                            event_coffeecount[i] = event_coffeename_count_time[i + 1][j];
                            event_coffeetime[i] = event_coffeename_count_time[i + 2][j];
                        }
                    }
                }
                eventcomputer1(coffee_event_time, event_coffeetime, event_coffeename, coffee_count, day_alltime);

            } else if (choice == 2) { // 이벤트 설정을 하지 않을 떄 이벤트 관련된 것들 리셋
                event_coffeename_count_time = eventResetNameCount(event_coffeename_count_time);
                event_coffeename = eventResetName(event_coffeename);
                event_coffeecount = eventResetCount(event_coffeecount);
                event_coffeetime = eventResetTime(event_coffeetime);
            }
            flag = false;
        }

        flag = true;

        while (flag) { // 손님 받는 거
            System.out.println((day + 1) + "번 째 날 " + (people + 1) + "번 째 손님입니다.");
            if (coffee_event[0] > 0) { // 이벤트 설정한 게 있다면 이벤트는 장사 시작과 동시에 하자
                coffee_or_event = 1;
                while (flag2) {
                    coffee_event_man = coffee_event[0]; // 이벤트 인원
                    coffee_event_time = coffee_event[1]; // 이벤트 시간 설정
                    System.out.printf("이벤트 시간 %d분 진행합니다. 남은 인원 %d명 입니다.", coffee_event_time, coffee_event_man);

                    // 이벤트 메뉴 보여주어야함
                    System.out.println("어떤 이벤트 음료가 드시고 싶으십니까?");
                    eventShowMenu(event_coffeename, event_coffeecount);

                    choice = sc.nextInt();

                    if (event_coffeecount[choice - 1] == 0 || coffee_event[1] < event_coffeetime[choice - 1]) { // 품절 또는 시간부족
                        System.out.println("메뉴를 고를 수 없습니다. 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 안 고를시 일반 주문으로 넘어감
                        choice = sc.nextInt();

                        if (choice == 1) {
                            flag2 = true;
                            want_event_menu = 0;
                        } else if (choice == 2) { // 일반주문으로 넘어갔을 때
                            System.out.println("일반 주문으로 넘어갑니다. \n1. 메뉴보기 2. 나가기");
                            int[][] originre = new int[day_sell_coffee.length + 2][1];
                            originre = sellMenu(day_sell_coffee, coffee_count, coffee_price, day, people, coffee_time, day_alltime, money, people_happy, coffee_happy);
                            for (int x = 0; x < originre.length; x++) {
                                for (int y = 0; y < 1; y++) {
                                    coffee_count[x] = originre[x][y];
                                }
                            }
                            for (int i = 0; i < 1; i++) {
                                for (int j = originre.length; j < originre.length + 1; j++) {
                                    money = originre[j][i];
                                    people_happy[day][people] = originre[j + 1][i];
                                    day_alltime = originre[j + 2][i];
                                }
                            }
                            people++;
                            daypeople--;
                            coffee_event_man--; // event 항목이니까 지나가야됨
                            if (daypeople == 0) {
                                day++;
                            }
                        } else {
                            flag2 = true;
                        }
                    } else { // 이벤트 주문이 가능 할 때
                        if (want_event_menu == 0) { // 원하는 잔인지 아닌지 판별용
                            want_event_menu = 0;
                        } else {
                            want_event_menu = 1;
                        }

                        people_happy = eventpeopleHappy(people_happy, coffee_happy, coffee_or_event, day, people, choice, want_event_menu);
                        event_coffeecount[choice - 1]--; // 한 잔 줄이고 그리고 이벤트는 1잔이 맥시멈
                        coffee_event_man--;
                        System.out.println("이벤트는 1인 1잔이 맥시멈입니다. 일반 메뉴로 이동하시겠습니까? \n 1.예 2.아니오");
                        choice = sc.nextInt();
                        if (choice == 2) { // 일반 메뉴로 이동하지 않고 이벤트 끝 사람도 끝
                            people++; // 사람 올려서 사람 바꿔주고
                            coffee_event_man--;
                            daypeople--;
                            if (daypeople == 0) {
                                day++;
                                people = 0;
                            }
                        } else if (choice == 1) {
                            // 기본 메뉴판으로 가야함
                            int[][] originre = new int[day_sell_coffee.length + 3][1];
                            originre = sellMenu(day_sell_coffee, coffee_count, coffee_price, day, people, coffee_time, day_alltime, money, people_happy, coffee_happy);
                            for (int x = 0; x < originre.length; x++) {
                                for (int y = 0; y < 1; y++) {
                                    coffee_count[x] = originre[x][y];
                                }
                            }
                            for (int i = 0; i < 1; i++) {
                                for (int j = originre.length; j < originre.length + 1; j++) {
                                    money = originre[j][i];
                                    people_happy[day][people] = originre[j + 1][i];
                                    day_alltime = originre[j + 2][i];
                                }
                            }
                            people++;
                            daypeople--;
                            if (daypeople == 0) {
                                day++;
                                people = 0;
                            }

                        } else {
                            // 예외처리
                        }
                        // 근데 여기서 고민되는거 하나 이벤트 한 사람이
                    }

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

                    if (coffee_event_man == 0 || coffee_event_time == 0 || event_flag == 0) { // 커피 이벤트 타임이 제일 적은 메뉴보다 시간이 적을시에 flag2 = false로 바꿔야함
                        flag2 = false;
                    }

                }


            } else { // 이벤트 설정한 게 없다면

                int[][] originre = new int[day_sell_coffee.length + 3][1];
                originre = sellMenu(day_sell_coffee, coffee_count, coffee_price, day, people, coffee_time, day_alltime, money, people_happy, coffee_happy);
                for (int x = 0; x < originre.length; x++) {
                    for (int y = 0; y < 1; y++) {
                        coffee_count[x] = originre[x][y];
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = originre.length; j < originre.length + 1; j++) {
                        money = originre[j][i];
                        people_happy[day][people] = originre[j + 1][i];
                        day_alltime = originre[j + 2][i];
                    }
                }
                people++;
                daypeople--;
                if (daypeople == 0) {
                    day++;
                    people = 0;
                }
            }
        }

    }

    //        String[] day_selled_coffee = new String[5]; // 하루중에 팔린커피 목록
    //        int[] day_sell_count = new int[5]; // 하루 팔린 커피 몇 잔인지 다음 날 눌러지면 초기화되게 셋팅

    //리턴목록
    // 1~5. 줄어든 커피메뉴, 6. 올라간 돈 , 7. 마지막 손님인지 아닌지. 8. 사람 행복도 9. 날짜

    // 이벤트용도 하나 만들어야함 이벤트를 같이 쓸 순 없음
    // 딱 한사람의 주문 한 사람의 주문이 끝나면 다음 사람으로 넘어감
    public static int[][] sellMenu(String[] day_sell_coffee, int[] coffee_count, int[] coffee_price, int day, int people, int[] coffee_time, int day_alltime, int money, int[][] people_happy, int[] coffee_happy) {
        // 장바구니 시스템이다 보니까 그냥 주문 취소하면 원래꺼 리턴할게 있어야함
        int[][] changere = new int[day_sell_coffee.length + 3][1]; // 얘가 바뀐거 보낼 return
        int[][] originre = new int[day_sell_coffee.length + 3][1]; // 얘가 원래 return
        int coffee_choice = 0;
        int coffeecountindex = 0;
        int peopleflagindex = 0;
//        int coffeechoiceindex = 0;
        int peoplehappyindex = 0;
        int dayalltimeindex = 0;
        int moneyindex = 0;
        int peopleindex = 0;
        int dayindex = 0;
        int buycount = 0; // 손님이 하나도 안샀으면 origin 리턴 하나라도 샀으면 changere 리턴

        for (int i = 0; i < day_sell_coffee.length + 2; i++) {
            for (int j = 0; j < 1; j++) { // 커피 갯수 일단 집어넣고
                originre[i][j] = coffee_count[j];
                changere[i][j] = coffee_count[j];
            }

        }
        for (int k = 0; k < 1; k++) {
            for (int t = day_sell_coffee.length; t < day_sell_coffee.length + 1; t++) {
                originre[t][k] = money;
                changere[t][k] = money;
                moneyindex = t;

                originre[t + 1][k] = people_happy[day][people - 1];
                changere[t + 1][k] = people_happy[day][people - 1];
                peoplehappyindex = t + 1;


                originre[t + 2][k] = day_alltime;
                changere[t + 2][k] = day_alltime;
                dayalltimeindex = t + 2;

            }
        }

        boolean flag1 = true;
        boolean flag3 = true;
        int choice = 0;
        while (flag1) {
            System.out.println("메뉴를 골라주세요.");
            dailyShowMenu(day_sell_coffee, coffee_count, coffee_price);
            coffee_choice = sc.nextInt();
            if (coffee_count[coffee_choice - 1] == 0) { // 품절일 때 시간 없을 때 고려해야함 시간도
                System.out.println("품절입니다. 다른 음료를 고르시겠습니까?");
                System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                choice = sc.nextInt();
                if (choice == 2) {
                    if (buycount > 0) {
                        return changere;
                    } else {
                        return originre;
                    }
                } else if (choice == 1) {
                    flag1 = true;
                }
            } else if (coffee_time[coffee_choice - 1] > day_alltime) {
                System.out.println("영업시간 이내에 만들 수 없습니다. 다른 음료를 고르시겠습니까?");
                System.out.println("1. 예 2. 아니오"); // 다음사람으로 넘어감
                // 다음 사람으로 넘어가면 이 함수도 끝나야함
                choice = sc.nextInt();
                if (choice == 2) {
                    if (buycount > 0) {
                        return changere;
                    } else {
                        return originre;
                    }
                } else if (choice == 1) {
                    flag1 = true;
                }
            } else { // 정상 주문이 된다면
                buycount++;
                people_happy = peopleHappy(people_happy, coffee_happy, day, people, coffee_choice - 1);
                changere[coffee_choice - 1][0] = coffee_count[coffee_choice - 1] - 1;
                changere[moneyindex][0] += coffee_price[coffee_choice - 1];
                changere[peoplehappyindex][0] = people_happy[day][people];
                changere[dayalltimeindex][0] = day_alltime - coffee_time[coffee_choice - 1];
                System.out.println("메뉴가 정상적으로 담겼습니다. 더 주문하시겠습니까? \n 1. 예 2. 아니오 3. 주문 취소");
                choice = sc.nextInt();
                if (choice == 1) {
                    flag1 = true;
                } else if (choice == 2) {
                    System.out.println("주문이 완료되었습니다.");
                    return changere;
                } else if (choice == 3) {
                    return originre;
                }
            }
        }
        if (buycount > 0) {
            return originre;
        } else {
            return changere;
        }
    }

    public static int[][] AllSellistCount(int[] day_sell_count, int[][] allday_sell_count, int day) {
        for (int i = day - 1; i < day; i++) {
            for (int j = 0; j < day_sell_count.length; j++) {
                allday_sell_count[day - 1][j] = day_sell_count[j];
            }
        }
        return allday_sell_count;
    }

    public static String[][] AllSellistName(String[] day_selled_coffee, String[][] allday_sell_name, int day) {
        for (int i = day - 1; i < day; i++) {
            for (int j = 0; j < allday_sell_name.length; j++) {
                allday_sell_name[day - 1][j] = day_selled_coffee[j];
            }
        }
        return allday_sell_name;
    }

    public static void AllShowSell(String[][] allday_sell_name, int[][] allday_sell_count, int day) { //총 가격 함수도받아야됨 당일 총 얼마인지
        // 당일 판매만큼 돌리기 데이 만큼 돌리고 처음에는 데이 그 뒤는 판매양 만큼만 돌리기
        for (int i = 0; i < day; i++) {
            System.out.printf("%d일", i + 1);
            for (int j = 0; j < allday_sell_name.length; j++) {
                System.out.printf("%d : %d개 :", allday_sell_name[i][j], allday_sell_count[i][j]);
            }
        }

    }

    public static int[] daySellcountReset(int[] day_sell_count) {
        for (int i = 0; i < day_sell_count.length; i++) {
            day_sell_count[i] = 0;
        }
        return day_sell_count;
    }

    public static String[] daySelledcoffeeReset(String[] day_selled_coffee) {
        for (int i = 0; i < day_selled_coffee.length; i++) {
            day_selled_coffee[i] = "";
        }
        return day_selled_coffee;
    }

    public static String[] daySellcoffeeReset(String[] day_sell_coffee) {
        for (int i = 0; i < day_sell_coffee.length; i++) {
            day_sell_coffee[i] = "";
        }
        return day_sell_coffee;
    }

    public static int[][] eventResetNameCount(int[][] event_coffeename_count) {
        for (int z = 0; z < event_coffeename_count.length; z++) {
            for (int y = 0; y < event_coffeename_count[z].length; y++) {
                event_coffeename_count[z][y] = 0;
            }
        }
        return event_coffeename_count;
    }

    public static String[] eventResetName(String[] event_coffeename) {
        for (int i = 0; i < event_coffeename.length; i++) {
            event_coffeename[i] = "";
        }
        return event_coffeename;
    }

    public static int[] eventResetCount(int[] event_coffeecount) {
        for (int i = 0; i < event_coffeecount.length; i++) {
            event_coffeecount[i] = 0;
        }
        return event_coffeecount;
    }

    public static int[] eventResetTime(int[] event_coffeetime) {
        for (int i = 0; i < event_coffeetime.length; i++) {
            event_coffeetime[i] = 0;
        }
        return event_coffeetime;
    }

    // 꼭 필요한가?
    public static int peopleFlag(int daypeople, int people_flag) {
        if (daypeople != 0) {
            System.out.println("다음 손님으로 넘어갑니다.");
            people_flag = 1;
        } else { // day피플이 없다면
            System.out.println("다음 날로 넘어갑니다.");
            people_flag = 0;
        }
        return people_flag;
    }


    public static int[] coffeeCountSet(int[][] coffee_count_price, int[] coffee_count) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < coffee_count.length; j++) {
                coffee_count[j] = coffee_count_price[i][j];
            }
        }
        return coffee_count;
    }

    public static int[] coffeePriceSet(int[][] coffee_count_price, int[] coffee_price) {
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < coffee_price.length; j++) {
                coffee_price[j] = coffee_count_price[i][j];
            }
        }
        return coffee_price;
    }

    public static int[] coffeeHappySet(int[] coffee_price, int[] coffee_happy) { // 가격은 0원에서 10000원
        for (int i = 0; i < coffee_price.length; i++) {
            if (coffee_price[i] < 1000 && coffee_price[i] > 0) { // 0 ~ 999 5로 고정
                coffee_happy[i] = 5;
            } else if (coffee_price[i] > 1000 && coffee_price[i] < 10000) {
                coffee_happy[i] = (coffee_price[i] / 100);
            }
        }
        return coffee_happy;
    }


    public static int[][] peopleHappy(int[][] people_happy, int[] coffee_happy, int day, int people, int coffee_choice) { // 그냥 주문 행복도용
        if ((people_happy[day][people] + coffee_happy[coffee_choice - 1]) < 100) {
            people_happy[day][people] += coffee_happy[coffee_choice - 1];
        } else {
            people_happy[day][people] = 100;
        }

        return people_happy;
    }

    public static int[][] eventpeopleHappy(int[][] people_happy, int[] coffee_happy, int coffee_or_event, int day, int people, int choice, int want_event_menu) { // 손님들 만족도 일반 주문용 이벤트용
        if (coffee_or_event != 0) { // 이벤트 주문이라면
            if (want_event_menu != 0) { // 원하는 메뉴였다면 1이니까
                if ((people_happy[day][people] + 70) < 100) {
                    people_happy[day][people] += 70;
                } else { // 100보다 크면 그냥 100으로 셋팅
                    people_happy[day][people] = 100;
                }
            }
        } else { // 이벤트 주문이 아니라면
            if ((people_happy[day][people] + coffee_happy[choice - 1]) < 100) {
                people_happy[day][people] += coffee_happy[choice - 1];
            } else {
                people_happy[day][people] = 100;
            }
        }
        return people_happy;
    }

    public static int[][] coffeeCountPrice(int[][] coffee_count_price, int[] coffee_time, int day_alltime) {
        boolean flag = true;
        int count = 0;
        int coffeetime_sum = 0;
        int choice = 0;
        for (int i = 0; i < coffee_count_price.length; i++) {
            for (int j = 0; j < coffee_count_price[i].length; j++) {
                if (i == 0) { // 첫 번째는 잔수
                    flag = true;
                    while (flag) {
                        System.out.println((j + 1) + "번 째 메뉴의 잔 수를 설정해주세요");
                        count = sc.nextInt();
                        if (coffeetime_sum + (coffee_time[j] * count) > day_alltime) {
                            System.out.println("잔 수가 너무 많아 영업시간 이내에 만들 수 없습니다. 그래도 설정하시겠습니까?\n 1. 예 2. 아니오");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                coffee_count_price[i][j] = count;
                                coffeetime_sum = coffeetime_sum + (count * coffee_time[j]);
                                flag = false;
                            } else if (choice == 2) {
                                flag = true;
                            } else {
                                System.out.println("다른 번호를 누르셨습니다. 다시 잔 수를 설정해주세요.");
                            }
                        } else {
                            coffee_count_price[i][j] = count;
                            coffeetime_sum = coffeetime_sum + (count * coffee_time[j]);
                            flag = false;
                        }
                    }
                } else { // 두 번째는 가격
                    System.out.println((j + 1) + "번 째 메뉴의 가격을 설정해주세요");
                    coffee_count_price[i][j] = sc.nextInt();
                }
            }
        }
        return coffee_count_price;
    }

    public static String[] coffeeName(String[] coffee_names) { // 커피 종류 지정하는 거
        for (int i = 0; i < 1; i++) {
            coffee_names[i] = "아이스 아메리카노";
            coffee_names[i + 1] = "핫 아메리카노";
            coffee_names[i + 2] = "아이스 초코";
            coffee_names[i + 3] = "핫 초코";
            coffee_names[i + 4] = "아이스 카페라떼";
            coffee_names[i + 5] = "핫 카페라떼";
            coffee_names[i + 6] = "석류 에이드";
            coffee_names[i + 7] = "녹차 프라푸치노";
            coffee_names[i + 8] = "아이스크림";
            coffee_names[i + 9] = "쌍화차";

        }
        return coffee_names;
    }

    public static void showMenu(String[] coffee_names) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i + 1) + " : " + coffee_names[i]);
            i++;
            if (i == coffee_names.length) {
                flag = false;
            }
        }
    }

    public static void dailyShowMenu(String[] day_sell_coffee, int[] coffee_count, int[] coffee_price) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i + 1) + ". " + day_sell_coffee[i] + ": " + coffee_price[i] + "원 " + "( " + coffee_count[i] + " ) 잔 남았습니다.");
            i++;
            if (i == day_sell_coffee.length) {
                flag = false;
            }
        }
    }

    public static void eventShowMenu(String[] event_coffeename, int[] event_coffeecount) { // 이름 뿐만 아니라 남은 잔수도 보여주는게 더 편할 듯
        boolean flag = true;
        int i = 0;
        while (flag) {
            if (event_coffeecount[i] == 0) {
                System.out.println(" ");
            } else if (event_coffeecount[i] == 0) {
                System.out.println("품절");
            } else {
                System.out.println((i + 1) + " : " + event_coffeename[i] + " 남은 잔 수 : " + event_coffeecount[i]);
            }
            i++;
            if (i == event_coffeename.length) {
                flag = false;
            }
        }
    }


    public static int[] coffeeCount(int[] coffee_count) { // 커피 하루 재고 입력
        for (int i = 0; i < 5; i++) {
            coffee_count[i] = sc.nextInt();
        }
        return coffee_count;
    }

    public static String[] daySellCoffee(String[] coffee_names, String[] day_sell_coffee, int[] coffee_select) { // 하루 메뉴 선정하는 함수
        int choice = 0;
        boolean flag = true;

        for (int i = 0; i < coffee_select.length; i++) {
            day_sell_coffee[i] = coffee_names[coffee_select[i]];
        }
        return day_sell_coffee;
    }

    public static int[] daySellCoffeeTime(String[] day_sell_coffee, int[] coffee_select, int[] coffee_time, int day_alltime) { // 커피 시간 정하기
        int choice = 0;
        for (int i = 0; i < coffee_select.length; i++) {
            System.out.println((i + 1) + "번째 메뉴인 " + day_sell_coffee[i] + " 의 시간을 골라주세요");
            coffee_time[i] = sc.nextInt();
            if (coffee_time[i] > day_alltime) {
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
                        System.out.println("하루 영업 시간은 총 12시간을 넘길 수 없습니다.");
                    } else {
                        System.out.println("영업시간은");
                        if (start_minute + minute >= 60) {
                            hour++;
                            minute = (start_minute + minute - 60);
                        } else {
                            minute += start_minute;
                        }
                        if (start_hour + hour > 24) {
                            System.out.printf("전 날 : %d시 %d분 부터 다음날 : %d시 %d분 까지 입니다.", start_hour, start_minute, (start_hour + hour - 24), minute);
                            System.out.println(" ");
                            flag = false;
                            flag2 = false;
                        } else {
                            System.out.printf("%d시 %d분 부터 ~ %d시 %d분 까지 입니다.", start_hour, start_minute, (hour + start_hour), minute);
                            System.out.println(" ");
                            flag = false;
                            flag2 = false;
                        }

                    }
                }

            }
        }
        alltime = (hour * 60) + minute;
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
        if (choice > day_alltime) {
            System.out.println("영업시간 보다 길 수 없습니다.");
        } else {
            event_time = choice;
            allset[1] = event_time;
        }

        return allset;
    }

    public static int[][] coffeeEvent2(int[] coffee_evnet, String[] day_sell_coffee, int[] coffee_price, int[] coffee_count, int[] coffee_time) { // 커피 메뉴 , 수량 고르기 1 메뉴 2 수량
        int choice = 0;
        boolean flag = true;
        int i = 0;
        int j = 0;

        int[][] event_coffeename_count_time = new int[3][5];
        for (int t = 0; t < event_coffeename_count_time.length; t++) { // 0으로 초기화
            for (int k = 0; k < event_coffeename_count_time[t].length; k++) {
                event_coffeename_count_time[t][k] = 0;
            }
        }
        while (flag) {
            System.out.println("1. 이벤트 메뉴추가 2.나가기");
            choice = sc.nextInt();
            if (choice == 1) {
                dailyShowMenu(day_sell_coffee, coffee_count, coffee_price);
                System.out.println("메뉴를 골라주세요");
                choice = sc.nextInt();
                // 이 부분 예외 설정 해야함
                event_coffeename_count_time[i][j] = choice; // 함수밖으로 나가서 day_sellcoffee로부터 이름 받을수 있게
                event_coffeename_count_time[i + 2][j] = coffee_time[choice - 1]; // 시간을 이 때 받아야함 아니면 choice 값 때문에 오류남
                System.out.printf("잔 수를 설정해주세요");
                choice = sc.nextInt();
                event_coffeename_count_time[i + 1][j] = choice;

                j++;
                if (j == day_sell_coffee.length) {
                    System.out.println("이벤트 메뉴가 가득 찼습니다. 나갑니다.");
                    flag = false;
                }
            } else {
                if (event_coffeename_count_time[0][0] == 0) {
                    System.out.println("메뉴가 하나도 없습니다 정말 나가시겠습니까?\n 1. 예 2. 아니오");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        flag = false;
                    } else if (choice == 2) {
                        flag = true;
                    } else {
                        System.out.println("잘못 누르셨습니다. 메뉴를 다시 골라주세요");
                        flag = true;
                    }
                } else {
                    flag = false;
                }
            }
        }
        return event_coffeename_count_time;

    }


    public static void computer1(int day_alltime, int[] coffee_time, String[] day_sell_coffee, int[] coffee_count) { // 효율성 따지는 친구 얘는 시간내에 몇 잔을 팔아야 이득인지 알려주는애
        String name = "";
        int max = 0;
        int maxcount = 0;
        int t = 0;
        int[] countsort = new int[5];
        int[] timesort = new int[5];
        boolean flag = true;
        int syscnt = 0;
        int syslast = 0;
        String[] namecoffee = new String[5];
        String cntname = "";

        String[] sysname = new String[5];
        int[] syscount = new int[5];


        //
        int cnttime = 0;
        int cntcount = 0;
        for (int a = 0; a < coffee_time.length; a++) {
            timesort[a] = coffee_time[a]; // 다 옮겨담기
            countsort[a] = coffee_count[a];
            namecoffee[a] = day_sell_coffee[a];
        }
        for (int j = 0; j < coffee_time.length - 2; j++) {
            if (timesort[j] > timesort[j + 1]) {
                cnttime = timesort[j]; // 결국 제일 커피 만드는 빠른 순서가 맨 앞으로감
                timesort[j] = timesort[j + 1]; // 그것이 countsort에 담김
                timesort[j + 1] = cnttime;

                cntcount = countsort[j]; // 갯수
                countsort[j] = countsort[j + 1];
                countsort[j + 1] = cntcount;

                cntname = namecoffee[j];
                namecoffee[j] = namecoffee[j + 1];
                namecoffee[j + 1] = cntname;

            }
            if (j == coffee_time.length - 2) {
                for (int k = 0; k < coffee_time.length - 2; k++) {
                    if (timesort[k] > timesort[k + 1]) {
                        j = 0;
                    }

                }
            }
        }

        for (int i = 0; i < coffee_time.length; i++) {
            int time = (timesort[i] * countsort[i]);
            if (day_alltime >= time) { // 1차적으로 효율계산
                day_alltime -= time;
                sysname[i] = namecoffee[i];
                syscount[i] = countsort[i]; // 근데 느닺없이 coffee_count가 오네 순서가 안맞음 count도 순서 맞춰야함
                syscnt++;
            } else if (day_alltime < time && syslast == 0) {
                while (flag) { // 하나 하나 줄이면서 마지막 효율 뽑아내기
                    time -= timesort[i];
                    countsort[i]--;
                    if (time > day_alltime) {
                        flag = true;
                    } else {
                        day_alltime -= time;
                        sysname[i] = namecoffee[i];
                        syscount[i] = countsort[i];
                        syscnt++;
                        syslast++;
                        flag = false;
                    }
                }
            }
        }
        if (syscnt == 1) {
            System.out.println(sysname[0] + "를 " + syscount[0] + "개 파는것이 제일 효율적입니다.");
        }
        for (int x = 0; x <= syscnt - 1; x++) {
            if (x == syscnt - 1) {
                System.out.println(sysname[x] + "를 " + syscount[x] + "개를 파는것이 제일 효율적입니다.");
            } else {
                System.out.println(sysname[x] + "를 " + syscount[x] + "개,");
            }
        }
    }

    // 이벤트는 null 나옴 메뉴 1개만 들어가도 되서 위처럼 하면 문제가 생김
    public static void eventcomputer1(int coffee_event_time, int[] event_coffeetime, String[] event_coffee_name, int[] event_coffee_count, int day_alltime) { // 얘는 이벤트 시간내에 몇 잔을 팔아야 이득인지 알려주는 애
        String name = "";
        int max = 0;
        int maxcount = 0;
        int t = 0;
        boolean flag = true;
        int syscnt = 0;
        int syslast = 0;
        String cntname = "";
        int eventcount = 0;

        String[] sysname = new String[5];
        int[] syscount = new int[5];


        //
        int cnttime = 0;
        int cntcount = 0;


        for (int a = 0; a < event_coffeetime.length; a++) {
            if (event_coffeetime[a] != 0) {
                eventcount++;
            }
        }

        int[] countsort = new int[eventcount];
        int[] timesort = new int[eventcount];
        String[] namecoffee = new String[eventcount];

        for (int b = 0; b < eventcount; b++) { // 당연히 첫번째에 들어가니까 1개만 있는건 할 필요 없고
            timesort[b] = event_coffeetime[b];
            namecoffee[b] = event_coffee_name[b];
        }

        if (eventcount > 1) {
            for (int j = 0; j < eventcount; j++) {

                if (timesort[j] > timesort[j + 1]) {
                    cnttime = timesort[j]; // 시간
                    timesort[j] = timesort[j + 1];
                    timesort[j + 1] = cnttime;

                    cntcount = countsort[j]; // 갯수
                    countsort[j] = countsort[j + 1];
                    countsort[j + 1] = cntcount;

                    cntname = namecoffee[j];
                    namecoffee[j] = namecoffee[j + 1];
                    namecoffee[j + 1] = cntname;

                }
                if (j == eventcount) { // 체크 다 정렬됐는지
                    for (int k = 0; k < eventcount; k++) {
                        if (timesort[k] > timesort[k + 1]) {
                            j = 0;
                        }

                    }
                }

            }
        }

        for (int i = 0; i < eventcount; i++) {
            int time = (timesort[i] * countsort[i]);
            if (coffee_event_time >= time) { // 1차적으로 효율계산
                coffee_event_time -= time;
                sysname[i] = namecoffee[i];
                syscount[i] = countsort[i];
                syscnt++;
            } else if (coffee_event_time < time && syslast == 0) {
                while (flag) {
                    time -= timesort[i];
                    countsort[i]--;
                    if (time > coffee_event_time) {
                        flag = true;
                    } else {
                        coffee_event_time -= time;
                        sysname[i] = namecoffee[i];
                        syscount[i] = countsort[i];
                        syscnt++;
                        syslast++;
                        flag = false;
                    }
                }
            }
        }

        if (syscnt == 1 && syscount[0] != 0) {
            System.out.println(sysname[0] + "를 " + syscount[0] + "개 파는것이 제일 효율적입니다.");
        }
        for (int x = 0; x <= syscnt - 1; x++) {
            if (x == syscnt - 1 && syscount[x] != 0) {
                System.out.println(sysname[x] + "를 " + syscount[x] + "개를 파는것이 제일 효율적입니다.");
            } else if (syscount[x] != 0) {
                System.out.println(sysname[x] + "를 " + syscount[x] + "개,");
            }
        }
    }

    public static void dayset(int people, int day, int[] daymoney, int[][] people_happy, String[] day_selled_coffee, int[] day_sell_count) { // 하루 정리 마감 보면서 얼마 벌었는지 그런 목록들 보여주는거
        int happy = 0;
        for (int t = 0; t < day_selled_coffee.length; t++) { // 커피 판 거 정리
            System.out.println((t + 1) + ": " + day_selled_coffee[t] + " " + day_sell_count + "잔");
        }
        for (int i = day - 1; i < day; i++) { // 만족감
            for (int j = 0; j < people; j++) {
                happy += people_happy[i][j];
            }
        }
        System.out.println(people + 1 + "명 의 총 만족감 : " + happy);

        System.out.println("하루 총 수익 : " + daymoney[day]);
    }

    public static String[] daysellmenuname(String[] day_sell_coffee, int choice, String[] day_selled_coffee) { // 팔린 거 이름
        for (int i = 0; i < day_selled_coffee.length; i++) {
            if (day_selled_coffee[i].equals(day_sell_coffee[choice - 1])) {

            } else {
                day_selled_coffee[i] = day_sell_coffee[choice - 1];
            }
        }
        return day_selled_coffee;
    }

    public static int[] daysellmenucount(String[] day_sell_coffee, int choice, String[] day_selled_coffee, int[] day_sell_count) { // 팔린 거 갯수
        for (int i = 0; i < day_selled_coffee.length; i++) {
            if (day_selled_coffee[i].equals(day_sell_coffee[choice - 1])) {
                day_sell_count[i]++;
            } else {
                day_selled_coffee[i] = day_sell_coffee[choice - 1];
                day_sell_count[i]++;
            }
        }
        return day_sell_count;
    }
}
