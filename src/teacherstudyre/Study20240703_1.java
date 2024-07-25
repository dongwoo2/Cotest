package teacherstudyre;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class Study20240703_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String [] coffee_names = new String[10]; // 커피 이름
        String [] day_sell_coffee = new String[5]; // 하루에 5종류만 팔 거니까 그에 맞게 매일 다른 게 들어감
        int [] coffee_time = new int[5];
        int[][] coffee_price_count = new int[2][5]; // 잔수와 가격 1은 잔수 2는 가격
        boolean flag = true;
        int choice = 0;
        int[] coffee_select = new int[5];
        int hour = 0;
        int minute = 0;
        int day_alltime = 0;
        int[] coffee_event = new int[2]; // 1은 인원 2는 시간
        int[][] event_coffeename_count = new int[2][5]; // 이벤트커피 1은 메뉴 2는 잔수
        //1에 대응되는 day_sell_coffee에 대응되는 번호가 들어가있음
        String[] event_coffeename = new String[5]; // 1메뉴가 여기 들어감
        int[] event_coffeecount = new int[5];
        int[][] people_happy = new int[100][100]; // 손님 만족도
        // (7/10)
        int people = 0;

        int coffee_event_man = 0;
        int coffee_event_time = 0;
        int month = 0;
        int day = 0;



        coffeeName(coffee_names);

        while (flag) { // 장사 셋팅
            System.out.println("장사 시간을 정해주세요");
            day_alltime = dayHour(hour, minute);
            showMenu(coffee_names);
            System.out.println("커피 5가지를 고르세요");
            for(int i = 0; i < coffee_select.length; i++) {
                choice = sc.nextInt();
                if(choice > 0 && choice < 11) {
                    coffee_select[i] = choice;
                } else {
                    System.out.println("잘못 선택하셨습니다 번호를 다시 골라주세요");
                    i--;
                }
            }
            day_sell_coffee = daySellCoffee(coffee_names, day_sell_coffee, coffee_select); // 하루 커피 종류 정하기
            coffee_time = daySellCoffeeTime(day_sell_coffee,coffee_select,coffee_time,day_alltime); // 커피 시간 정하기
            coffee_price_count = coffeePriceCount(coffee_price_count); // 커피 잔수와 가격 정하기

            System.out.println("1. 이벤트 설정 2. 넘어가기"); // 만약 이벤트를 안하고 지나간다면 다 초기화를 해주어야함
            choice = sc.nextInt();
            if(choice == 1) {
                coffee_event = coffeeEvent1(day_alltime); // coffee_event의 0은 인원, 1은 시간
                event_coffeename_count = coffeeEvent2(coffee_event,day_sell_coffee);
                for(int i = 0; i < event_coffeename_count.length-1; i++) {
                    for(int j = 0; j < event_coffeename_count[i].length; j++) {
                        if(event_coffeename_count[i][j] != 0) {
                            event_coffeename[i] = day_sell_coffee[event_coffeename_count[i][j]];
                            event_coffeecount[i] = event_coffeename_count[i+1][j];
                        }
                    }

                }
            }
        }

        while (flag) { // 손님 받는 거
            System.out.println((day+1) + "번 째 날 " + (people+1) + "번 째 손님입니다.");
            if(coffee_event[0] > 0) { // 이벤트 설정한 게 있다면 이벤트는 장사 시작과 동시에 하자
                while (flag) {
                    coffee_event_man = coffee_event[0]; // 이벤트 인원
                    coffee_event_time = coffee_event[1]; // 이벤트 시간 설정
                    System.out.printf("이벤트 시간 %d분 진행합니다. 남은 인원 %d명 입니다.", coffee_event_man, coffee_event_time);
                    
                    // 이벤트 메뉴 보여주어야함
                    System.out.println("어떤 음료가 드시고 싶으십니까?");
                    eventShowMenu(event_coffeename, event_coffeecount);

                    choice = sc.nextInt();

                /* 얘는 일반주문할 때
                System.out.println("어떤 음료가 드시고 싶으십니까?");
                coffee_price_count = coffeeCountBuy(coffee_price_count,choice);
                 */
                    // 장바구니로 선택하는 느낌으로 하자
                    // 메뉴가 없습니다 메뉴가 없으면 그냥 모달창 느낌으로 메뉴가 없어 한 다음에
                    //
                }
            } else { // 이벤트 설정한 게 없다면

            }

        }
    }
    public static int[][] coffeeCountBuy(int[][]coffee_price_count, int choice) { //int[][] coffee_price_count = new int[2][5]; // 잔수와 가격 1은 잔수 2는 가격

    }

    public static int[][] eventCoffeeCountBuy(int[][]event_coffeename_count, int choice) { //int[][] coffee_price_count = new int[2][5]; // 잔수와 가격 1은 잔수 2는 가격

    }
    public static void peopleHappy() { // 손님들 만족도

    }

    public static int[][] coffeePriceCount(int[][] coffee_price_count) {
        for(int i = 0; i < coffee_price_count.length; i++) {
            for(int j = 0; j < coffee_price_count[i].length; j++) {
                if(i == 0) { // 첫 번째는 잔수
                    System.out.println((j+1) + "번 째 메뉴의 잔수를 설정해주세요");
                    coffee_price_count[i][j] = sc.nextInt();
                } else { // 두 번째는 가격
                    System.out.println((j+1) + "번 째 메뉴의 가격을 설정해주세요");
                    coffee_price_count[i][j] = sc.nextInt();
                }
            }
        }
        return coffee_price_count;
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

    public static void dailyShowMenu(String [] day_sell_coffee) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.println((i+1) + " : " + day_sell_coffee[i]);
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
    public static int[][] coffeeEvent2(int[]coffee_evnet, String []day_sell_coffee) { // 커피 메뉴 , 수량 고르기 1 메뉴 2 수량
        int choice = 0;
        boolean flag = true;
        int i = 0;
        int j = 0;

        int[][] event_coffeename_count = new int[2][5];
        for(int t = 0; t < event_coffeename_count.length; t++) { // 0으로 초기화
            for(int k = 0; k < event_coffeename_count[t].length; k++) {
                event_coffeename_count[t][k] = 0;
            }
        }
        while (flag) {
            System.out.println("1. 이벤트 메뉴추가 2.나가기");
            choice = sc.nextInt();
            if(choice == 1) {
                dailyShowMenu(day_sell_coffee);
                System.out.println("메뉴를 골라주세요");
                choice = sc.nextInt();
                event_coffeename_count[i][j] = choice - 1; // 함수밖으로 나가서 day_sellcoffee로부터 이름 받을수 있게
                System.out.printf("잔 수를 설정해주세요");
                choice = sc.nextInt();
                event_coffeename_count[i+1][j] = choice;
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

    public static void computer1(int day_alltime, int[] coffee_event, int[]coffee_time, String []day_sell_coffee) { // 효율성 따지는 친구
        int [] coffeename_count = new int[2];
        int max = 0;
        int t = 0;
        for(int i = 0; i < coffee_time.length; i++) {
            t = coffee_time[i]/day_alltime;
            if(t > max) {
                max = t;
                coffeename_count[0] = i; // 커피종류 알 수 있게
                coffeename_count[1] = max; // 갯수
            }
        }
        System.out.println(day_sell_coffee[coffeename_count[0]]+ "를 " + coffeename_count[1]+ "개 팔아요 제일 효율적입니다.");
    }

}
