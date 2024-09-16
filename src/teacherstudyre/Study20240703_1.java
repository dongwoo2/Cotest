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
        boolean flag6 = true;
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
        //int[][] event_people_happy = new int[100][100]; //이벤트 손님 만족도
        int event_flag = 1;
        // (7/10)
        int event_get = 0; // 손님이 이벤트 잔 받았는지 안받았는지 확인 이벤트 잔은 손님당 1잔
        int people = 0; // 하루 온 손님
        int daypeople = 0; // 와야 할 손님
        int people_flag = 0; // 당일에 남은 손님이 없다면 0 손님이 있다면  1
        int coffee_event_man = 0;
        int coffee_event_time = 0;
        int event_happy_sum = 0;
        int month = 0;
        int day = 0;

        int money = 0;
        int allmoney = 0;
        int[] daymoney = new int[100];

        int coffee_or_event = 0; // 이벤트용 주문인지 아닌지 0이면 일반주문 1이면 이벤트주문
        int want_event_menu = 1; // 이벤트 메뉴중에서 원하는 메뉴였는지
        String[] day_selled_coffee = new String[5]; // 하루중에 팔린커피 목록
        int[] day_sell_count = new int[5]; // 하루 팔린 커피 몇 잔인지 다음 날 눌러지면 초기화되게 셋팅
        int event_choice = 0;
        int event_people = 0;
        int settingflag = 0;
        int[][] people_count = new int[100][1]; // 사람 수 몇 명 이었는지
        int ori_day_alltime = 0;

        int cleanday = 0; // 청소 안하면 1일씩 쌓임
        int cleancheck = 0; // 청소 했는지 안했는지 1은 한거 0은 안한거
        int clean_item = 1; // 1 초급 2 중급 3 고급

        int panalty_check = 0; // 0은 패널티 없는거 1은 패널티 있음 근무시간 넘어가서 일하면 패널티 생겨서 근무시간 1시간 줄어듬
        // next choice 에 들어갈것
        // 1번은 청소 근데 두번 째는 얼마나 안했는지 얘를 들어 [0][7] 은 7일을 안한거임
        // 청소를 하루 씩 안할수록 패널티 만족도 패털티 10퍼센트 추가 전체 만족도 10퍼센트 감소
        // 2는 커피 바꾸는 기능 1 - 저급 , 2 - 중급 3 - 고급
        // 3은 커피기기 - 이것도 3단계 정해놓고 1은 1분감소 원가 10퍼 증가 2는 2분감소 원가 20퍼 증가 3은 3분감소 원가 효율 30퍼 증가
        // 일을 다 끝냈을때 노동적인 요소가 들어감 이제 청소 예를 들어 청소가 30분걸리는데 저급으로 할 때 그렇다면
        // 총 시간보다 오버 됐으므로 문제가 생김
        // 4는 청소도구
        // 5는 인테리어 - 만족도
        // 6은 빨대 같은 기타도구 - 만족도
        // 7은 커피 외 원자재
        // 20은 돈 하자
        // 0 청소, 1 커피원두, 2 커피기기, 3 청소도구, 4 인테리어, 5 기타도구, 6 커피 외 원자재
        int[][] next_choice = new int[20][3];

        coffeeName(coffee_names);

        while (flag) {
            // 장사 셋팅
            if (settingflag == 0) {
                flag2 = true;
                flag3 = true;
                flag4 = true;
                flag5 = false;
                flag6 = false;
                settingflag++;
                System.out.println("장사 시간을 정해주세요");
                day_alltime = dayHour(hour, minute, day, people_happy, people, coffee_count_price, coffee_count, people_count, ori_day_alltime);
                if (next_choice[0][1] != 0) { // day_alltime이 마이너스가 되면 패널티 생김
                    System.out.println("전 날 근무시간 초과로 인하여 근무시간이 1시간 줄어듭니다.");
                    day_alltime -= 60;
                    ori_day_alltime = day_alltime;
                } else {
                    ori_day_alltime = day_alltime;
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
                coffee_time = daySellCoffeeTime(day_sell_coffee, coffee_select, coffee_time, day_alltime, next_choice); // 커피 시간 정하기
                coffee_count_price = coffeeCountPrice(coffee_count_price, coffee_time, day_alltime); // 커피 잔수와 가격 정하기 time은 예외적용에 필요 alltime도 마찬가지
                coffee_count = coffeeCountSet(coffee_count_price, coffee_count, next_choice); // 잔수 배열 하나로 보기 쉽게 세팅
                coffee_price = coffeePriceSet(coffee_count_price, coffee_price, next_choice); // 가격 배열 하나로 보기 쉽게
                coffee_happy = coffeeHappySet(coffee_price, coffee_happy); // 만족도 배열 하나로 보기 쉽게
                // 시간 - 기기에 따라 영향 받는 거 coffee_time, coffee_count 가격 10퍼 20퍼, 잔 2잔, 잔 5잔
                // 가격, 만족도 - 원두에 영향받는거 coffee_price - 가격 , coffee_happy - 만족도는 가격이 상향되면 알아서 올라가게 해놨음
                daypeople = dayPeopleSet(day_alltime, coffee_time);

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
            }

            coffee_event_man = coffee_event[0]; // 이벤트 인원
            coffee_event_time = coffee_event[1]; // 이벤트 시간 설정
            while (flag2) { // 장사 시작
                System.out.println((day + 1) + "번 째 날 " + (people + 1) + "번 째 손님입니다.");
                if(coffee_event[0] > 0) {
                    coffee_or_event = 1;
                    flag3 = true;
                    flag6 = true;
                }
                flag4 = true;


                while (flag3) { // 이벤트
                    System.out.printf("이벤트 시간 %d분 진행합니다. 남은 인원 %d명 입니다.", coffee_event_time, coffee_event_man);
                    System.out.println("어떤 이벤트 음료가 드시고 싶으십니까?");
                    eventShowMenu(event_coffeename, event_coffeecount);
                    choice = sc.nextInt();
                    if (event_coffeecount[choice - 1] == 0 || coffee_event[1] < event_coffeetime[choice - 1]) { // 손님이 고른 이벤트 메뉴가 없을 때
                        System.out.println("메뉴를 고를 수 없습니다. 다른 음료를 고르시겠습니까?");
                        System.out.println("1. 예 2. 아니오"); // 안 고를시 일반 주문으로 넘어감
                        choice = sc.nextInt();
                        if(choice == 2) {
                            event_people--;
                            flag3 = false;
                        } else if(choice == 1) { // 원하는 메뉴가 아닌 다른 메뉴를 고를 때 만족도 떨어짐
                            want_event_menu = 0;
                        }
                    } else { // 손님이 고른 이벤트 메뉴가 있을 때
                        if(want_event_menu != 0) { // 0은 손님이 원하지 않는거
                            want_event_menu = 1;
                        }
                        day_alltime -= event_coffeetime[choice - 1]; // 전체 영업시간 당연히 줄고
                        coffee_event[1] -= event_coffeetime[choice - 1]; // 커피 전체시간 당연히 줄고
                        people_happy = eventpeopleHappy(people_happy, coffee_happy, coffee_or_event, day, people, choice, want_event_menu);
                        event_happy_sum += people_happy[day][people];
                        event_coffeecount[choice - 1]--; // 한 잔 줄이고 그리고 이벤트는 1잔이 맥시멈
                        coffee_event_man--;
                        flag6 = true;
                        while(flag6) {
                        System.out.println("이벤트는 1인 1잔이 맥시멈입니다. 일반 메뉴로 이동하시겠습니까? \n 1.예 2.아니오");
                        choice = sc.nextInt();
                        if (choice == 2) {// 손님 한 명 끝
                            people++; // 사람 올려서 사람 바꿔주고
                            daypeople--;
                            flag6 = false;
                            if (daypeople == 0 || day_alltime < 30) { // 사람수가 끝나면 장사가 끝난거니까
                                flag2 = false;
                                flag3 = false;
                                flag4 = false;
                                flag5 = true;
                                flag6 = false;
                            } else if (choice == 1) {
                                flag3 = false; // 근데 여기서 이 손님 끝나고 이벤트 할 사람이 있다면 다시 flag3를 true 해주어야함
                                flag6 = false;
                            } else {
                                System.out.println("잘못 입력하셨습니다 다시 입력해주세요.");
                            }
                        } else if(choice == 1) {
                            flag4 = true;
                            flag6 = false;
                        }
                        }
                    }
                    for (int i = 0; i < event_coffeecount.length; i++) { // 이벤트 잔이 다 떨어지는거 확인용
                        if (event_coffeecount[i] == 0) {
                            event_flag += 1;
                        }
                    }
                    if(event_flag == 6) {
                        event_flag = 0;
                    } else {
                        event_flag = 1;
                    }

                    if (coffee_event_man == 0 || coffee_event_time == 0 || event_flag == 0) { // 커피 이벤트 타임이 제일 적은 메뉴보다 시간이 적을시에 flag2 = false로 바꿔야함
                        eventSuccess(event_happy_sum, coffee_event[0]);
                        coffee_event[0] = 0;
                        flag3 = false;
                    }
                    }
                }
                while (flag4) { // 그냥 메인
                    System.out.println("어떤 메뉴를 고르시겠습니까?");
                    dailyShowMenu(day_sell_coffee, coffee_count, coffee_price);
                    choice = sc.nextInt();
                    if(coffee_count[choice - 1] > 0 && day_alltime > coffee_time[choice - 1]) { // 여기 수정해야함

                    }
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
                    if(day_alltime < 90) {
                        System.out.println("영업 종료 " + day_alltime + "분 전입니다.");
                        System.out.println("영업 종료하시겠습니까? \n1.네 2.아니오");
                        choice = sc.nextInt();
                        if(choice == 1) {
                            flag4 = false;
                            flag5 = true;
                        } else {
                            flag4 = true;
                        }
                    }
                    System.out.println("originre = " + originre);
                    people++;
                    daypeople--;
                    if (daypeople < 0 || day_alltime < 30) { // 영업 끝났을 때
                        flag4 = false;
                        flag5 = true;
                    }
                }
                while (flag5) {// 하루 영업 끝났을 떄 자동으로 이곳으로 이동
                    // 청소도구 시간,

                        people_count[day][0] = people;
                        System.out.println("오늘의 영업이 끝났습니다.");
                        // 매출 보여주고
                        dayHowmuch(money, people_happy, people, coffee_count, coffee_count_price, day_sell_coffee);
                        next_choice = nextchoice(money, next_choice, day_alltime); // 여기 다음날 갈 때 이것저것 정해지는 함수 설정
                        // 이함수 전제조건 그냥 무조건 끝나야함
                        // 이 함수 끝난거면 day++가 무조건 되어야하고
                        // 0 청소, 1 커피원두, 2 커피기기, 3 청소도구, 4 인테리어, 5 기타도구, 6 커피 외 원자재
                        day++;
                        people = 0;
                        settingflag = 0;
                        flag5 = false;
                        flag2 = true;
            }

        }

    }

    public static int clean(int clean_item, int day_alltime) {
        boolean flag = true;
        while (flag)
            if (clean_item == 3) {
                day_alltime -= 10;
                flag = false;
            } else if (clean_item == 2) {
                day_alltime -= 20;
                flag = false;
            } else if (clean_item == 1) {
                day_alltime -= 30;
                flag = false;
            } else {
                System.out.println("오류가 있습니다 청소도구를 확인해주세요");
            }
        return day_alltime;
    }


    // 장사 잘되면 하루 적정 장사시간은 8시간 전 날 보다 손님도 적고 손님의 만족도
    public static int[][] computerSetTime(int[][] people_happy, int people, int day, int[][] coffee_count_price, int[] coffee_count, int[][] people_count, int day_alltime) {// 첫날만 손으로 설정
        int settime = 0;
        int happyavg = 0;
        int yesterday_happyavg = 0;
        int happysum = 0;
        int yesterday_happysum = 0;
        int yesterday_people = 0;
        int[][] hour_minute = new int[2][1];

        yesterday_people = people_count[day - 1][0];


        for (int i = day; i <= day; i++) {
            for (int j = 0; j < people; j++) {
                happysum += people_happy[i][j];
            }
            for (int t = 0; t < yesterday_people; t++) {
                yesterday_happysum += people_happy[i - 1][t]; // 전날
            }
        }

        happyavg = happysum / people;
        yesterday_happyavg = yesterday_happysum / yesterday_people;
        // 일단 만족도로만 시간 구분
        if (happyavg < yesterday_happyavg) { // 만족도가 어제보다 낮을 때
            if (day_alltime < 690) {
                day_alltime += 30;
            } else if (day_alltime > 690 && day_alltime <= 720) {
                day_alltime = 720;
            }
            hour_minute[0][1] = day_alltime / 60;
            hour_minute[1][1] = day_alltime % 60;

        } else { // 만족도가 어제보다 높을 때
            if (day_alltime <= 720 && day_alltime >= 570) {
                day_alltime -= 30;
            } else if (day_alltime >= 540 && day_alltime <= 570) {
                day_alltime = 540;
            } else if (day_alltime <= 540) {
                day_alltime += 30;
            }
            hour_minute[0][1] = day_alltime / 60;
            hour_minute[1][1] = day_alltime % 60;
        }
        return hour_minute;
    }

    public static int dayPeopleSet(int day_alltime, int[] coffee_time) {
        int sum = 0;
        int avg = 0;
        int people = 0;
        for (int i = 0; i < coffee_time.length; i++) {
            sum += coffee_time[i];
        }
        avg = sum / coffee_time.length; // 평균을 구하고
        people = day_alltime / avg;
        System.out.println("오늘 적정 손님 수는 " + people + "명 입니다.");
        return people;
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


    // 커피기기에 영향을 받음
    public static int[] coffeeCountSet(int[][] coffee_count_price, int[] coffee_count, int[][] next_choice) {
        int grade = 0;
        int count = 0;
        String strgrade = "";
        grade = next_choice[2][0];

        if(grade == 2) {
            count+=2;
            strgrade = "중급";
            System.out.println(strgrade +" 커피기기의 영향에 따라 잔수가 추가됩니다." + count + "잔 추가");
        } else if (grade == 3) {
            count+=3;
            strgrade = "고급";
            System.out.println(strgrade +" 커피기기의 영향에 따라 잔수가 추가됩니다." + count + "잔 추가");
        }
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < coffee_count.length; j++) {
                coffee_count[j] = coffee_count_price[i][j] + count;
            }
        }
        return coffee_count;
    }

    // 커피 원두에 영향을 받음
    public static int[] coffeePriceSet(int[][] coffee_count_price, int[] coffee_price, int[][] next_choice) {
        int grade = 0;
        int count = 0;
        String strgrade = "";
        int percent = 0;
        grade = next_choice[2][0];

        if(grade == 2) {
            count+=10;
            strgrade = "중급";
            System.out.println(strgrade + " 커피원두의 영향에 따라 가격이 상향됩니다." + count + "퍼 상향");
        } else if (grade == 3) {
            count+=20;
            strgrade = "고급";
            System.out.println(strgrade + " 커피원두의 영향에 따라 가격이 상향됩니다." + count + "퍼 상향");
        } else { // 0일때 나는 오류상황 있음 0으로 못나누는데 0으로 나눌려고 해서 오류방지 코드
            count = 1;
        }

        if(grade == 2 || grade == 3) {
            for (int i = 1; i < 2; i++) {
                for (int j = 0; j < coffee_price.length; j++) {
                    percent = coffee_count_price[i][j] / count;
                    coffee_price[j] = coffee_count_price[i][j] + percent;
                }
            }
        }
        return coffee_price;
    }

    public static int[] coffeeHappySet(int[] coffee_price, int[] coffee_happy) { // 가격은 0원에서 10000원 // 여기다 고급그거 해야할듯
        for (int i = 0; i < coffee_price.length; i++) {
            if (coffee_price[i] < 1000 && coffee_price[i] > 0) { // 0 ~ 999 5로 고정
                coffee_happy[i] = 5;
            } else if (coffee_price[i] > 1000 && coffee_price[i] < 100000) {
                coffee_happy[i] = (coffee_price[i] / 100);
                if(coffee_happy[i] > 100) {
                    coffee_happy[i] = 100;
                }
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
        // 이벤트 주문이라면
        if (want_event_menu != 0) { // 원하는 메뉴였다면 1이니까
            if ((people_happy[day][people] + 70) < 100) {
                people_happy[day][people] += 70;
            } else { // 100보다 크면 그냥 100으로 셋팅
                people_happy[day][people] = 100;
            }
        }

        return people_happy;
    }

    public static void eventSuccess(int event_happy_sum, int coffee_event_man) {
        int avg = 0;
        avg = event_happy_sum / coffee_event_man;
        if (avg > 50) {
            System.out.println("성공적인 이벤트였습니다!\n 사람들의 만족도가 평균" + avg + "점 입니다.");
        } else {
            System.out.println("아쉬운 이벤트였습니다.\n 사람들의 만족도가 평균" + avg + "점 입니다.");
        }
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

    public static int[] coffeelevel(int[] coffee_level_origin) { // 저급 1 ,중급 2, 고급 3
        // 저급 기본 단가는 5000원
        // 중급 만원
        // 고급 2만원
        // 원가 1개로 커피 10개 뽑기가능
        // 일단 처음 커피 레벨은 1
        for (int i = 0; i < 1; i++) {
            coffee_level_origin[i] = 1;
            coffee_level_origin[i + 1] = 1;
            coffee_level_origin[i + 2] = 1;
            coffee_level_origin[i + 3] = 1;
            coffee_level_origin[i + 4] = 1;
            coffee_level_origin[i + 5] = 1;
            coffee_level_origin[i + 6] = 1;
            coffee_level_origin[i + 7] = 1;
            coffee_level_origin[i + 8] = 1;
            coffee_level_origin[i + 9] = 1;
        }
        return coffee_level_origin;
    }

    // 결국은 예산 때문에 장사시작할 때 커피 원가에 따른 예산 삭감이 있어야함
    public static int[] coffeelevelChange(int[] coffee_level_change, int change, int cnt, int allmoney, String[] coffee_names) {
        int choice = 0;
        int levelchoice = 0;
        boolean flag = true;

        System.out.println("어떤 커피를 바꾸시겠습니까?");
        showMenu(coffee_names);

        choice = sc.nextInt();
        System.out.println("이름 : " + coffee_names[choice - 1] + "을 선택하셨습니다");
        System.out.println("어떤 등급으로 바꾸시겠습니까?");
        while (flag) {
            levelchoice = sc.nextInt();

            if (coffee_level_change[choice - 1] == levelchoice) { // 현재 등급이랑 같다면
                System.out.println("현재 같은 등급입니다. \n 유지하시겠습니까? \n 1. 예 2. 아니오");
                choice = sc.nextInt();
                if (choice == 1) {

                }
            } else if (coffee_level_change[choice - 1] > levelchoice) { // 고급에서 밑으로 갈 때
                System.out.println("현재 더 높은 등급입니다. \n 더 낮은 등급으로 바꾸시겠습니까?? \n 1. 예 2. 아니오");
                if(choice == 1) {

                }
            }
        }


        return coffee_level_change;
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

    // FIXME 메뉴 하나만 보임 
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

    // 커피기기에 영향받음 next_choice[2][0]
    public static int[] daySellCoffeeTime(String[] day_sell_coffee, int[] coffee_select, int[] coffee_time, int day_alltime, int [][] next_choice) { // 커피 시간 정하기
        int grade = 0;
        int count = 0;
        String strgrade = "";
        grade = next_choice[2][0];

        if(grade == 2) {
            count = 1;
            strgrade = "중급";
            System.out.println(strgrade +" 커피기기의 영향에 따라 커피 제조시간이 줄어듭니다." + count + "분 감소");
        } else if (grade == 3) {
            count = 2;
            strgrade = "고급";
            System.out.println(strgrade +" 커피기기의 영향에 따라 커피 제조시간이 줄어듭니다." + count + "분 감소");
        }


        int choice = 0;
        for (int i = 0; i < coffee_select.length; i++) {
            System.out.println((i + 1) + "번째 메뉴인 " + day_sell_coffee[i] + " 의 시간을 골라주세요");
            coffee_time[i] = sc.nextInt();
            if (coffee_time[i] > day_alltime) {
                System.out.println("영업 시간 보다 길게 할 수 없습니다.");
                i--;
            } else if(coffee_time[i] < count) {
                System.out.println("제조시간을 더 이상 줄 일 수 없습니다\n 1분으로 고정합니다.");
                coffee_time[i] = 1;
            } else {
                coffee_time[i]-=count;
            }
        }
        return coffee_time;
    }

    //시작 시간만 내가 정함
    public static int dayHour(int hour, int minute, int day, int[][] people_happy, int people, int[][] coffee_count_price, int[] coffee_count, int[][] people_count, int day_alltime) { // 1. 영업 전체시간, 2.영업 시작 시간, 3.영업 끝나는 시간
        boolean flag = true;
        boolean flag2 = true;
        int start_hour = 0;
        int start_minute = 0;
        int alltime = 0;
        int[][] hour_minute = new int[2][1];
        while (flag) {
            System.out.println("영업을 몇 시 부터 시작하시겠습니까? 시간은 0~23 숫자로 입력해주시고, 분은 0~59 숫자로 입력해주세요");
            start_hour = sc.nextInt();
            start_minute = sc.nextInt();

            if (hour > 23 || minute > 59 || hour < 0 || minute < 0) {
                System.out.println("0 ~ 23 내의 시간만 가능합니다. 다시 입력해주세요.");
            } else {
                while (flag2) {
                    if (day == 0) {
                        System.out.println("하루 영업시간을 정해주세요");
                        System.out.print("시간 :");
                        hour = sc.nextInt();
                        System.out.print("분 :");
                        minute = sc.nextInt();
                    } else {
                        hour_minute = computerSetTime(people_happy, people, day, coffee_count_price, coffee_count, people_count, day_alltime);
                        hour = hour_minute[0][1]; // 1은 시간
                        minute = hour_minute[1][1]; // 2는 분
                    }
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
        int choice2 = 0;
        boolean flag = true;
        int i = 0;
        int j = 0;
        int eventcoffeetime_sum = 0;
        int[] outmenu = new int[10];

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
                dailyShowMenu(day_sell_coffee, coffee_count, coffee_price); // TODO 이벤트 메뉴 추가하면 안보이게 해야함
                System.out.println("메뉴를 골라주세요");
                choice = sc.nextInt();
                if(coffee_count[choice - 1] < 0) {
                    System.out.println("메뉴 최대량을 넘었습니다.");
                } else {
                    // 이 부분 예외 설정 해야함
                    event_coffeename_count_time[i][j] = choice; // 함수밖으로 나가서 day_sellcoffee로부터 이름 받을수 있게
                    event_coffeename_count_time[i + 2][j] = coffee_time[choice - 1]; // 시간을 이 때 받아야함 아니면 choice 값 때문에 오류남
                    System.out.printf("잔 수를 설정해주세요");
                    choice2 = sc.nextInt();
                    if(coffee_count[choice - 1] < choice2) {
                        System.out.println("메뉴 최대량을 넘겼습니다. 메뉴 선택 화면으로 돌아갑니다.");
                    } else {
                        event_coffeename_count_time[i + 1][j] = choice2;
                        coffee_count[choice - 1] -= choice2;
                        j++;
                        eventcoffeetime_sum += coffee_time[choice-1] * choice2;
                        if(eventcoffeetime_sum > coffee_evnet[1]) {
                            System.out.println("커피 이벤트 시간을 초과하였습니다. 메뉴 선택이 끝납니다.");
                            flag = false;
                        }
                    }
                }

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

    // 만족도, 돈, 사람 수 , 판 잔의 수
    // 오늘은 총 몇 명의 사람이 방문하였고, 몇 잔이 팔렸으며, 사람들의 만족도는 몇 퍼 입니다~
    public static void dayHowmuch(int money, int[][] people_happy, int people, int[] coffee_count, int[][] coffee_count_price, String[] day_sell_coffee) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < coffee_count.length; j++) {
                if (coffee_count_price[i][j] > coffee_count[j]) {
                    cnt = coffee_count_price[i][j] - coffee_count[j];
                    sum += cnt;
                    System.out.println(day_sell_coffee[j] + "가 " + cnt + "잔 만큼 팔렸습니다.");
                }
            }
        }
        System.out.println("총 " + sum + "잔이 팔렸습니다.");
        System.out.println("하루 매출은 " + money + "원 입니다.");

    }
    // 1번은 청소 근데 두번 째는 얼마나 안했는지 얘를 들어 [0][7] 은 7일을 안한거임
    // 청소를 하루 씩 안할수록 패널티 만족도 패털티 10퍼센트 추가 전체 만족도 10퍼센트 감소
    // 2는 커피 바꾸는 기능 1 - 저급 , 2 - 중급 3 - 고급
    // 3은 커피기기 - 이것도 3단계 정해놓고 1은 1분감소 원가 10퍼 증가 2는 2분감소 원가 20퍼 증가 3은 3분감소 원가 효율 30퍼 증가
    // 일을 다 끝냈을때 노동적인 요소가 들어감 이제 청소 예를 들어 청소가 30분걸리는데 저급으로 할 때 그렇다면
    // 총 시간보다 오버 됐으므로 문제가 생김
    // 4는 청소도구
    // 5는 인테리어 - 만족도
    // 6은 빨대 같은 기타도구 - 만족도
    // 7은 커피 원가외 문제 있는거
    // 20은 돈 하자
    // 매출 확인을 먼저하자
    public static int[][] nextchoice(int money, int next_choice[][], int day_alltime) {
        next_choice[20][0] = money;
        int choice = 0;
        int choice2 = 0;
        int intgrade = 0;
        int howmoney = 0;
        boolean flag = true;
        boolean flag2 = true;
        String stringgrade = "";
        String what = "";
        int[][] howmuch = new int[7][3]; // 바꿀 선택과 물품수
        for (int i = 1; i < 7; i++) { // 왜냐면 1은 청소니까
            for (int j = 0; j < howmuch[i].length; j++) {
                if (i == 1) { // 커피 원두
                    howmoney = 100;
                } else if (i == 4) { // 인테리어 가격이 많이 다른것들만 조절
                    howmoney = 1000000;
                } else {
                    howmoney = 100000;
                }
                howmuch[i][j] = howmoney * (j + 1);
            }
        }
        while (flag) {
            System.out.println("1. 청소 2. 커피원두 바꾸기 3. 커피기기 바꾸기 4. 청소도구 바꾸기 5. 인테리어 바꾸기 6. 기타도구 바꾸기 7. 커피 외 원재료 바꾸기 8. 나가기");
            choice = sc.nextInt();
            if (money < 100) { // 돈이 너무 없을때는 청소부터 해라
                System.out.println("무언가를 사기에는 돈이 부족합니다");
            }
            if (choice == 1) {
                what = "청소";
            } else if (choice == 2) {
                what = "커피원두";
            } else if (choice == 3) {
                what = "커피기기";
            } else if (choice == 4) {
                what = "청소도구";
            } else if (choice == 5) {
                what = "인테리어";
            } else if (choice == 6) {
                what = "기타도구";
            } else if (choice == 7) {
                what = "커피 외 원재료";
            } else if (choice == 8) {
                flag = false;
                flag2 = false;
            } else {
                System.out.println("잘못 선택하셨습니다.");
            }
            if (choice == 1) {
                next_choice[0][0]++;
                intgrade = next_choice[3][0];
                if (intgrade == 1) {
                    intgrade = 30;
                } else if (intgrade == 2) {
                    intgrade = 20;
                } else if (intgrade == 3) {
                    intgrade = 10;
                } else {
                    System.out.println("오류 입니다. 청소기기 설정이 이상합니다.");
                    intgrade = 0;
                }
                if (intgrade > day_alltime) { // 패널티
                    intgrade -= day_alltime;
                    next_choice[0][1] = 1;
                    return next_choice;
                }

            } else if (choice != 1 && choice < 8) {
                intgrade = next_choice[choice][0];
                if (intgrade == 1) {
                    stringgrade = "저급";
                } else if (intgrade == 2) {
                    stringgrade = "중급";
                } else if (intgrade == 3) {
                    stringgrade = "고급";
                }
                while (flag2) {
                    System.out.println("현재 " + what + "은(는) " + stringgrade + " 입니다.");
                    System.out.println("저급 : " + howmuch[choice][0] + "원");
                    System.out.println("중급 : " + howmuch[choice][1] + "원");
                    System.out.println("고급 : " + howmuch[choice][2] + "원");

                    System.out.println("어떤 것을 선택하시겠습니까?");
                    choice2 = sc.nextInt();
                    if (choice2 > 0 && choice2 < 4 && choice2 != intgrade) { // 품목도 같으면 안도;ㅁ
                        if (next_choice[20][0] > howmuch[choice][choice2 - 1]) {
                            next_choice[choice][0] = choice2;
                            next_choice[20][0] =- howmuch[choice][choice2 - 1];
                            System.out.println("정상적으로 바뀌었습니다.");
                            return next_choice;
                        } else {
                            System.out.println("돈이 부족합니다.");
                        }
                    } else if (intgrade == choice2) {
                        System.out.println("품목이 같습니다 다시 선택해주세요.");
                    } else {
                        System.out.println("잘못 선택 다시 선택 바람");
                    }
                }
            } else {
                System.out.println("잘못 선택하셨습니다.");
            }
        }
        return next_choice;
    }
}
