package teacherstudyre;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Math.min;
import static java.lang.Math.max;


public class Study20240419_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }


    public static void solution() {
        String weaponsort[] = new String[10];
        String weaponitem[][] = new String[10][10];
        int reser_weaponitem[][] = new int[10][10]; // 예약품 체크
        String weaponitem2[][] = new String[10][10]; // 대체품
        String onemanpurchase[][] = new String[30][30]; // 구매내역을 보기 위한 변수 어떤것을 구매했는지 알 수 있게 - 한 사람
        String reser_onemanpurchase[][] = new String[30][30]; // 예약내역
        String allmanpurchase[][] = new String[30][30]; // 구매내역을 보기 위한 변수 어떤것을 구매했는지 알 수 있게 - 전체
        int wdurability[][] = new int[10][10]; // 내구도
        int wspeed[][] = new int[10][10]; // 스피드
        int wweight[][] = new int[10][10]; // 무게
        int wpower[][] = new int[10][10]; // 공격력
        int wendurance[][] = new int[10][10]; // 지구력 소모량
        int wprice[][] = new int[10][10]; // 무기 가격
        int wprice2[][] = new int[10][10]; // 할인무기 가격
        int wamount[][] = new int[10][10]; // 무기 수량
        int originalwamount[][] = new int[10][10]; // 갯수 설정해주는 무기 수량 초기 갯수에 따라 3턴 지나면 자동으로 몇 개가ㅓ 채워져야 하는지 알 수 있게 해줌
        int daymoney[] = new int[10];
        int manspeed[][] = new int[10][10]; // 민첩성 - 스피드
        int manstamina[][] = new int[10][10]; // 지구력 - 무게
        int manpower[][] = new int[10][10]; // 힘 - 공격력
        int reservation[][] = new int[10][10]; // 무기 예약
        int reser_day_man[][] = new int[100][100];

        boolean flag = true;
        boolean flag2 = true;
        boolean flag3 = true;
        int choice = 0;
        int choice2 = 0;
        int allmoney = 0; // 수입;
//        System.out.println("오늘 손님은 몇 명 입니까?");
//        int people = sc.nextInt();
        int people1 = 0;
        int check = 0;
        int check2 = 0;
        int login = 0;
        int promotionday1 = 0; // 프로모션1 만료일 변수
        int promotionday2 = 0; // 프로모션2 만료일 변수
        int dispercent = 0;
        int c1 = 0;
        int c2 = 0;
        int minusitem = 0;
        int day = 0;
        int man = 0;
        int purcnt = 0; // 한 사람이 뭘하는지 체크하는용도
        int daypurcnt = 0; // 당일이 지나가면 리셋되는 용도
        int onedaycnt = 1; //매일 매일 몇 명인지 체크
        int daymancnt[] = new int[30]; // 하루 씩 인원 체크
        int weaponcnt[] = new int[30]; // 하루 무기 갯수 체크
        int dayday[] = new int[30];
        int prodayday[] = new int[30];
        String weaponname[][] = new String[30][30]; // 하루 무기 이름 체크
        int pro_weaponcnt = 0; // 프로모션 하루 하루 따로 무기 갯수 체크 앞에가
        String pro_weaponname[][] = new String[30][30]; // 프로모션 무기 이름 체크 프로모션 진행하는 날짜 뒤에가 그냥 몇 개 인지
        int proday = 0;
        int manc = 0;
        int choice_check = 0;
        int promotion_switch = 0; // 프로모션이 몇 개 진행 되고 있는지
        int sellercheck = 0;
        String seller_id = ""; // 판매자 아이디
        String seller_pw = ""; // 판매자 패스워드
        String buyer_id[][] = new String[30][30]; // 구매자 아이디
        String buyer_pw[][] = new String[30][30]; // 구매자 패스워드
        int logincheck = 0;
        int dayturn = 0;
        int reservationman_c1[][] = new int[100][100]; //  인덱스 : 날짜, 사람, 값: 무기 번호
        int reservationman_c2[][] = new int[100][100]; //  인덱스 : 날짜, 사람, 값: 무기 번호
        int reservation_check = 0; // 예약 상품 총 갯수 체크 하는 애
        int[][] reser_man = new int[3][2]; // [][0]: 날짜, [][1]: 사람 번호
        int allman = 0; // 몇 번째 사람인지 총 인원수 체크 예약시스템 때문에 필요
        int reserman[] = new int[100];
        int reser_per[] = new int[100];
        int weapon_choice = 0;
        int reser_weapon_choice[][] = new int[100][100];
        String reser_weapon[][] = new String[100][100];
        // 예약한 무기 배열을 만들자
        // 몇 번째 무기를 예약했는지 변수 [1][1]
        // 장사하는 날짜 reservation[day][person] = 67 여러개 예약할수도 있으니 String 형태로 넣고 짤라서 하자 , 로 짜르기
        //

        weaponsort = weaponkind(weaponsort);
        weaponitem = weaponset(weaponsort, weaponitem);

        wdurability = wdurability(wdurability);
        wspeed = wspeed(wspeed);
        wweight = wweight(wweight);
        wpower = wpower(wpower);
        wendurance = wendurance(wendurance);
        wprice = wprice(wprice, wdurability, wspeed, wweight, wpower, wendurance);
        wamount = wamount(wamount); // TODO 예약 3턴 차면 자동으로 물품 생기게 추가하기
        originalwamount = origin_wamount_fisrt_set(wamount,originalwamount); // 물품 오리지날 초기 셋팅 설정
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime promotionDate1 = LocalDateTime.now();
        LocalDateTime promotionDate2 = LocalDateTime.now();
        // 구매자 스텟 만들기 힘,민첩성,지구력

        while (flag) {
            System.out.println("1.판매자 로그인 2.구매자 로그인 3.회원가입");
            choice = sc.nextInt();
            flag2 = true;
            if (choice == 1) {
                logincheck = check_id(choice, buyer_id, buyer_pw, day, man, seller_id, seller_pw);
                if (logincheck == 1) { //로그인 성공
                    while (flag2) { // 판매자
                        System.out.println("1.항목 인벤토리 보기 2.새 항목 추가하기 3.항목 제거하기 4.항목 재고 업데이트 및 재발주 5. 프로모션 설정 6.판매 보고서 7.판매자 로그아웃");
                        choice = sc.nextInt();
                        if (choice == 1) { // TODO 프로모션 있는 거 체크는 하나만 만들어서 그 안에서 또 따루 나누기
                            if (promotionday1 == 0 || promotionday2 == 0) { // 할인 x
                                allweapon(weaponitem, wprice, wamount);
                            } else { // 할인 o
                                if (promotionday1 != 0) {
                                    allweapon(weaponitem, wprice2, wamount);
                                } else if (promotionday2 != 0) {
                                    allweapon(weaponitem, wprice, wamount);
                                }
                            }

                        } else if (choice == 2) {
                            System.out.println("어디에 항목을 추가하시겠습니까?");
                            choice2 = sc.nextInt();
                            sellercheck = seller_error_check(choice, choice2, weaponitem);
                            if (sellercheck == 1) {
                                weaponitem = newweapon1(weaponitem, wprice, choice2); // 이름
                                wprice = newweapon2(weaponitem, wprice, choice2); // 가격
                                wamount = newweapon_amount(wamount,choice2); // 재고
                                weapon_originam_amount(wamount,originalwamount,choice2);
                            }
                        } else if (choice == 3) {
                            System.out.println("어떤 항목을 삭제하시겠습니까?");
                            choice2 = sc.nextInt();
                            sellercheck = seller_error_check(choice, choice2, weaponitem);
                            if (sellercheck == 1) {
                                weaponitem = outweapon1(weaponitem, wprice, choice2); // 이름
                                wprice = outweapon2(weaponitem, wprice, choice2); // 가격
                            }
                        } else if (choice == 4) {
                            System.out.println("1.항목 갯수 업데이트 2. 재발주하기");
                            choice = sc.nextInt();
                            if(choice == 1) {
                                System.out.println("어떤 무기를 업데이트 하시겠습니까?");
                                choice2 = sc.nextInt();
                                sellercheck = seller_error_check(choice, choice2, weaponitem);
                                if (sellercheck == 1) {
                                    wamount = amountweapon1(wamount, choice2);
                                }
                            } else if (choice == 2) {
                                System.out.println("어떤 무기를 재발주 하시겠습니까?");
                                choice2 = sc.nextInt();
                                if (c1 != 0 && c2 == 0 && choice < 100) { // 10번을 선택했을 시 인덱스에서는 9번 그리고 20번하면 19번 이렇게 선택이 되어야함
                                    c1--;
                                    c2 = 9;
                                } else if (c1 != 0 && c2 != 0 && choice < 100) { // 정상적인 진행이 될 때 c2는 --가 되어야함
                                    c2--;
                                } else if (c1 == 0 && c2 != 0 && choice < 100) {
                                    c2--;
                                }
                                wamount = weapon_update(originalwamount, wamount, reservation, c1, c2);
                                System.out.println(weaponname[c1][c2] + "가 재발주 되었습니다.");
                            }
                        } else if (choice == 5) { // 프로모션 설정
                            System.out.println("1.할인 2.1+1 이벤트 3.프로모션 해제"); // 만약 무수히 많은 포로모션이 생긴다면? 배열 앞에는 프로모션의 뭔지 넣고 2번째 프로모션에는 날짜를 넣는것을 시도해보자
                            // 프로모션이 추가 될 떄마다 프로모션에 대한 변수가 늘어나야할텐데 그런거에 필요한 것은 무엇이 있을까
                            choice = sc.nextInt();
                            if (choice == 1) {
                                if (promotionday2 != 0) {
                                    System.out.println("다른 프로모션이 진행중입니다.");
                                } else {
                                    System.out.println("몇 % 할인을 하시겠습니까?");
                                    dispercent = sc.nextInt(); // 나중에 % 할인중입니다를 쓰기 위함
                                    wprice2 = discount(wprice, dispercent, wprice2); // 할인이 있는 기간에는 wprice2로 가격진행

                                    System.out.printf("현재  %d년 %d월 %d일 입니다.", now.getYear(),now.getMonthValue(), now.getDayOfMonth());
                                    System.out.println("프로모션 기간을 며칠 진행할 것인지 일 자로 적어주세요");
                                    promotionday1 = sc.nextInt();
                                    promotionDate1 = promotionDate1.now().plusDays(promotionday1);
                                    System.out.printf("프로모션 기간이  %d년 %d월 %d일 까지 설정되었습니다.", promotionDate1.getYear(),promotionDate1.getMonthValue(), promotionDate1.getDayOfMonth()-1);
                                    System.out.println("  ");
                                }
                            } else if (choice == 2) {
                                if (promotionday1 != 0) {
                                    System.out.println("다른 프로모션이 진행중입니다.");
                                } else {
                                    System.out.printf("현재  %d년 %d월 %d일 입니다.", now.getYear(),now.getMonthValue(), now.getDayOfMonth());
                                    System.out.println("프로모션 기간을 며칠 진행할 것인지 일 자로 적어주세요");
                                    promotionday2 = sc.nextInt();
                                    promotionDate2 = promotionDate2.now().plusDays(promotionday2);
                                    System.out.printf("프로모션 기간이  %d년 %d월 %d일 까지 설정되었습니다.", promotionDate2.getYear(),promotionDate2.getMonthValue(), promotionDate2.getDayOfMonth()-1);
                                    System.out.println("  ");
                                }
                            } else if (choice == 3) {
                                promotionday1 = 0;
                                promotionday2 = 0;

                            } else {
                                System.out.println("잘못 선택 다시 골라주십쇼.");
                            }
                        } else if (choice == 6) {// 판매 보고소
                            System.out.println("1.하루 판매 보고서 2.프로모션 기간 판매 보고서");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                oneday_sell(weaponcnt, purcnt, weaponname, day, dayday);
                            } else if (choice == 2) {
                                promotion_sell(pro_weaponname, pro_weaponcnt, proday, daypurcnt, prodayday);
                            }
                        } else if (choice == 7) {
                            flag2 = false;
                        }
                    }
                }
            } else if (choice == 2) { // 구매자
                    logincheck = check_id(choice, buyer_id, buyer_pw, day, man, seller_id, seller_pw);
                if (logincheck == 1) {
                    while (flag2) { // 구매자
                        System.out.printf("오늘 날짜 : %d년 %d월 %d일", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
                        System.out.println(" "+(man + 1) + "번 째 구매자 입니다.");
                        if (manc == 0) {
                            System.out.println("구매자의 스텟 확인");
                            manpower[day][man] = manstatpower(manpower, day, man);
                            manspeed[day][man] = manstatspeed(manspeed, day, man);
                            manstamina[day][man] = manstatstamina(manstamina, day, man);
                            System.out.printf("힘 : %d 스피드 : %d  지구력 : %d" , manpower[day][man],manspeed[day][man],manstamina[day][man]);
                            System.out.println(" ");
                            manc++;
                        }

                        flag3 = true;
                        if (manc > 0) {
                            // 예약시스템
                                if(reser_weapon_choice[c1][c2] == 3) { // 예약이 3턴이 되면
                                    System.out.println("예약상품을 재발주 합니다.");
                                    wamount = weapon_ordering(originalwamount,wamount,c1,c2);
                                    reser_weapon_choice[c1][c2] = 0;
                                    for(int i = 0; i < reser_weapon.length; i++){
                                        for(int j = 0; j < reser_weapon[i].length; j++){
                                            if(reser_weapon[i][j] == weaponitem[c1][c2]) {
                                                onemanpurchase[i][j] = weaponitem[c1][c2];
                                                wamount[c1][c2]--;
                                                weaponcnt[day]++;
                                                weaponname[day][daypurcnt] = weaponitem[c1][c2];
                                            }
                                        }
                                    }

                                }



                            System.out.println("1.구매하기 2.구매내역보기 3.기본통계보기 4.다음사람 5.다음 날 6.구매자 로그아웃");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                while (flag3) { // TODO 할인중 프로모션 이거 커피처럼 빼고 구매하는 부분 분리하기
                                    if (promotionday1 != 0) { // 할인중
                                        System.out.println(dispercent + "% 할인을 진행하고 있습니다.");
                                        System.out.printf("기간은 %d년 %d월 %d일 까지 입니다." , promotionDate1.getYear(), promotionDate1.getMonthValue(), promotionDate1.getDayOfMonth());
                                        allweapon(weaponitem, wprice2, wamount);
                                        minusitem = 1;
                                    } else if (promotionday2 != 0) { // 1 + 1
                                        System.out.println("1 + 1 이벤트를 진행하고 있습니다.");
                                        System.out.printf("기간은 %d년 %d월 %d일 까지 입니다." , promotionDate2.getYear(), promotionDate2.getMonthValue(), promotionDate2.getDayOfMonth());
                                        allweapon(weaponitem, wprice, wamount);
                                        minusitem = 2;
                                    } else { // 아무것도 안함
                                        allweapon(weaponitem, wprice, wamount);
                                        minusitem = 1;
                                    }
                                    System.out.println("몇 번째 아이템을 구매하시겠습니까?");
                                    weapon_choice = sc.nextInt(); // 구매하고 난 뒤에 갯수 줄이기
                                    if (weapon_choice < 100) {
                                        c1 = weapon_choice / 10;
                                        c2 = weapon_choice % 10;
                                        choice_check++;
                                    } else {
                                        System.out.println("항목에 없는것을 고르셨습니다 다시 선택해주세요.");
                                        choice_check = 0;
                                    }
                                    if (c1 != 0 && c2 == 0 && weapon_choice < 100) { // 10번을 선택했을 시 인덱스에서는 9번 그리고 20번하면 19번 이렇게 선택이 되어야함
                                        c1--;
                                        c2 = 9;
                                    } else if (c1 != 0 && c2 != 0 && weapon_choice < 100) { // 정상적인 진행이 될 때 c2는 --가 되어야함
                                        c2--;
                                    } else if (c1 == 0 && c2 != 0 && weapon_choice < 100) {
                                        c2--;
                                    }

                                    if (choice_check != 0) {
                                        System.out.println(" = " + wamount[c1][c2]);
                                        if (wamount[c1][c2] >= minusitem && promotionday2 == 0) { // 구매가 잘 되었을 때
                                            if(wamount[c1][c2] == 1000) {
                                                System.out.println("최소 가격의 상품입니다.");
                                                //TODO 서비스 뭐로 할 건지
                                                // minusitem을 추가하던지 근데 그 양이 안된다면
                                                // 어떻게 할 것인지
                                                int service = 0;
                                                if(c1 > 0) {
                                                    service = c1 - 1;
                                                } else if(c1 < 1) {
                                                    service = c1 + 1;
                                                }
                                                System.out.println("서비스로 다른 종류의 상품이 하나 더 추가됩니다.");
                                                System.out.println(weaponname[service][c2]+ " 가 추가 되었습니다.");
                                                wamount[service][c2] = wamount[service][c2] - 1; // 서비스
                                            }
                                            wamount[c1][c2] = wamount[c1][c2] - minusitem;

                                            onemanpurchase[man][purcnt] = weaponitem[c1][c2]; // 한 사람의 구매내역
                                            weaponcnt[day]++;
                                            weaponname[day][daypurcnt] = weaponitem[c1][c2];
                                            if (promotionday1 != 0 || promotionday2 != 0) { // 프로모션 보고소
                                                pro_weaponname[proday][daypurcnt] = weaponitem[c1][c2];
                                                pro_weaponcnt++;
                                                // proday++;
                                            }
                                            purcnt++;
                                            daypurcnt++;
                                            System.out.println("구매가 완료되었습니다. 다시 구매를 원하시면 1번, 구매를 원치 않으시면 2번을 눌러주세요.");
                                            choice = sc.nextInt();
                                            if (choice == 2) {
                                                flag3 = false;
                                            }
                                        } else if (wamount[c1][c2] == 1 && promotionday2 != 0) { // 프로모션 1+1이 진행중인데 갯수가 1개일 때
                                            System.out.println("갯수가 부족하여 1+1이 불가한 상품입니다. 그래도 구매를 원하시면 1번, 다른 상품 구매를 원하시면 2번, 구매를 원치 않으시면 3번을 눌러주세요.");
                                            if (choice == 1) {
                                                wamount[c1][c2]--;
                                                System.out.println("구매가 완료되었습니다. 다시 구매를 원하시면 1번 아니면 2번을 눌러주세요");
                                                onemanpurchase[man][purcnt] = weaponitem[c1][c2];
                                                weaponcnt[day]++;
                                                weaponname[day][daypurcnt] = weaponitem[c1][c2];
                                                if (promotionday1 != 0 || promotionday2 != 0) { // 프로모션 보고소
                                                    pro_weaponname[proday][daypurcnt] = weaponitem[c1][c2];
                                                    pro_weaponcnt++;
                                                    // proday++;
                                                }
                                                purcnt++;
                                                daypurcnt++;
                                                choice = sc.nextInt();
                                                if (choice == 2) {
                                                    flag3 = false;
                                                } else if (choice == 1) {
                                                    flag3 = true;
                                                } else {
                                                    System.out.println("잘못된 번호를 누르셨기에 상품 페이지로 이동합니다.");
                                                }
                                            } else if (choice == 2) {
                                                flag2 = true;
                                            } else if (choice == 3) {
                                                flag2 = false;
                                            }
                                        } else { // 갯수가 없을 때
                                            System.out.println("품절 되었습니다 다른 상품 구매를 원하시면 1번, 구매를 원치 않으시면 2번, 상품 예약을 원하시면 3번을 눌러주세요.");
                                            if (choice == 2) {
                                                flag3 = false;
                                            } else if (choice == 1) {
                                                flag3 = true;
                                            } else if (choice == 3) {
                                                // TODO 예약무기 weapon_choice 로 할 껀데 이 값이 3개가 될 경우
                                                reser_weapon_choice[c1][c2]++;
                                                reser_weapon[man][purcnt] = weaponitem[c1][c2];
                                                purcnt++;
                                                daypurcnt++;
                                                // weapon_choice가 3개이면서 man purcnt가 같은 사람들 값 뽑아내기 몇 번째 사람인지
                                                // 그리고 purcnt를 마지막에 추가하고 싶은데
                                                // 어떻게 마지막에 추가를 할 까

                                                // 예약할 때 마다 이 무기가 몇 번 째 체크인지 만들까?
                                                // 그 전에 예약할 때 어떻게 예약이 체크되는지
                                                // man, purchase에 대해서 구매가 되는데
                                                // 예약했을 때 man purchase도 순번이 넘어가야하는데
                                                // 그 사람의 마지막 purchase로 하는게 제일 깔끔해 보이는데
                                                // 그게 너무 어렵다
                                                // 중간 purchase도 할 수 있을까?
                                                // 그렇다면 중간 purchase를 쓴다면 무기내역에 뜨면 안된다
                                                // 하 개어렵다 진심 일단 onemaapurchase만 안넣고 나중에 man purchase에 넣으면 되는거 아닌가?
                                                // 그렇다 나중에 넣으면 된다 예약무기니까


                                            }
                                        }
                                    }
                                }
                            } else if (choice == 2) { // 구매 내역보기
                                onemanpurchase(onemanpurchase, man, purcnt);
                            } else if (choice == 3) { // 기본 통계보기
                                System.out.println("1. 구매한 무기속성 2. 내 속성");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    weapon_property(weaponitem, wspeed, wpower, wdurability, wweight, wendurance,weaponcnt, purcnt);
                                } else if (choice == 2) {
                                    man_weapon_property(manspeed, manstamina, manpower, weaponitem, wspeed, wpower, wdurability, wweight, weaponcnt, purcnt, day, man);
                                } else {
                                    System.out.println("번호를 잘못선택하셨습니다.");
                                }
                            } else if (choice == 4) { // 다음 사람 , 다음 사람 넘어갈때는 daypurcnt = 0하면 안됨 하루 갯수 체크라서
                                man++;
                                onedaycnt++;
                                purcnt = 0;
                                manc = 0;
                                dayday[day] = daypurcnt;
                                daymancnt[day] = onedaycnt;
                                prodayday[proday] = daypurcnt;
                                if (dayturn == 3) {
                                    dayturn = 0;
                                    wamount = origin_wamount(wamount, originalwamount);
                                } else {
                                    dayturn++;
                                }
                            } else if (choice == 5) { // 다음 날
                                man = 0;
                                dayday[day] = daypurcnt; // daypurcnt는 하루에 몇 개 구매한건지
                                daymancnt[day] = onedaycnt; // onedaycnt는 하루에 몇 명 온건지
                                day++;
                                onedaycnt = 0;
                                purcnt = 0;
                                daypurcnt = 0;
                                manc = 0;
                                now = now.plusDays(1);
                                if (promotionday1 != 0 && promotionday1 > 0) { // 프로모션 1 진행
                                    promotionday1--;
                                    prodayday[proday] = daypurcnt;
                                    if (promotionday1 != 0) {
                                        proday++;
                                    }
                                } else if (promotionday2 != 0 && promotionday2 > 0) { // 프로모션 2 진행
                                    promotionday2--;
                                    prodayday[proday] = daypurcnt;
                                    if (promotionday2 != 0) {
                                        proday++;
                                    }
                                }
                            } else if (choice == 6) { // 구매자 로그아웃
                                flag2 = false;
                                flag3 = false;
                                dayday[day] = daypurcnt;
                                prodayday[proday] = daypurcnt;
                                daymancnt[day] = onedaycnt;
                            }
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.println("1.판매자 회원가입 2.구매자 회원가입 3.메뉴 나가기");
                choice = sc.nextInt();
                boolean joinflag = true;
                if (choice == 1) {
                    while (joinflag) {
                        seller_id = seller_join_id(seller_id);
                        seller_pw = seller_join_pw(seller_pw);
                        joinflag = false;
                    }
                } else if (choice == 2) {
                    while (joinflag) {
                        buyer_id = buyer_join_id(buyer_id, day, man);
                        System.out.println("buyer_id = " + buyer_id[day][man]);
                        buyer_pw = buyer_join_pw(buyer_pw, day, man);
                        joinflag = false;
                    }
                } else if (choice == 3) {

                } else {
                    System.out.println("다른 수를 입력해주세요");
                }
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }

    public static String seller_join_id(String seller_id) {
        System.out.println(" 아이디 입력해주세요 ");
        String id = sc.next();
        seller_id = id;
        return seller_id;
    }

    public static String seller_join_pw(String seller_pw) {
        System.out.println(" 비번 입력해주세요 ");
        String pw = sc.next();
        seller_pw = pw;
        return seller_pw;
    }

    public static String[][] buyer_join_id(String[][] buyer_id, int day, int man) {
        // 최소입력 4자 최대입력 12자
        System.out.println(" 아이디를 입력해주세요 ");
        boolean flag = true;
        while (flag) {
            String id = sc.next();
            if (id.length() < 4 && id.length() > 12) {
                System.out.println("글자수가 맞지 않습니다. 1.다시 2.메뉴아웃");
                int choice = sc.nextInt();
                if (choice == 2) {
                    return buyer_id;
                } else if (choice == 1) {
                    flag = true;
                } else {
                    System.out.println("잘못 입력 다시 회원가입으로 돌아감");
                }
            } else {
                buyer_id[day][man] = id;
                return buyer_id;
            }
        }
        return buyer_id;
    }

    public static String[][] buyer_join_pw(String[][] buyer_pw, int day, int man) {
        System.out.println(" 비밀번호를 입력해주세요 ");
        boolean flag = true;
        while (flag) {
            String pw = sc.next();
            if (pw.length() < 4 && pw.length() > 12) {
                System.out.println("글자수가 맞지 않습니다. 1.다시 2.메뉴아웃");
                int choice = sc.nextInt();
                if (choice == 2) {
                    return buyer_pw;
                } else if (choice == 1) {
                    flag = true;
                } else {
                    System.out.println("잘못 입력 다시 회원가입으로 돌아감");
                }
            } else {
                buyer_pw[day][man] = pw;
                System.out.println("회원가입이 정상적으로 이루어졌습니다.");
                flag = false;
                return buyer_pw;
            }
        }
        return buyer_pw;
    }

    public static int check_id(int choice, String[][] buyer_id, String[][] buyer_pw, int day, int man, String seller_id, String seller_pw) {
        // 로그인 성공시 1 아니면 0 리턴
        int check = 0;
        int count = 0;
        if (choice == 2) { // 구매자
            System.out.println("buyer_id = " + buyer_id[day][man]);
            if (buyer_id[day][man] == null) {
                System.out.println("계정이 없습니다. 회원가입 먼저 해주세요");
                return check;
            } else {
                boolean flag = true;
                while (flag) { // 구매자
                    System.out.println(" 아이디와 비밀번호를 입력해주세요 ");
                    System.out.println("id: ");
                    String id = sc.next();
                    System.out.println("pw: ");
                    String pw = sc.next();
                    if (buyer_id[day][man].equals(id) && buyer_pw[day][man].equals(pw)) {
                        System.out.println(" 로그인 성공 ");
                        flag = false;
                        check = 1;
                        return check;
                    } else {
                        count++;
                        if (count > 5) {
                            System.out.println(" 5회초과 로그인 실패 ");
                            flag = false;
                        } else {
                            System.out.println(" 로그인 실패 다시 입력해주세요");
                        }
                    }
                }
            }

        } else if (choice == 1) {
            if(seller_id == "") {
                System.out.println("계정이 없습니다. 회원가입 먼저 해주세요");
                return check;
            } else {
                boolean flag = true;
                while (flag) {
                    System.out.println(" 아이디와 비밀번호를 입력해주세요 ");
                    System.out.println("id: ");
                    String id = sc.next();
                    System.out.println("pw: ");
                    String pw = sc.next();
                    if (seller_id.equals(id) && seller_pw.equals(pw)) {
                        System.out.println(" 로그인 성공 ");
                        flag = false;
                        check = 1;
                        return check;
                    } else {
                        if (count > 5) {
                            System.out.println(" 5회초과 로그인 실패 ");
                            flag = false;
                        } else {
                            System.out.println(" 로그인 실패 다시 입력해주세요");
                        }
                    }
                }
            }

            }

        return check;
    }


    public static void onemanpurchase(String[][] onemanpurchase, int man, int purcnt) { // 구매내역 확인 구매내역은 그 바로 자신의 구매내역만 확인가능

        for (int i = 0; i < man + 1; i++) {
            for (int j = 0; j < purcnt; j++) {
                if (!onemanpurchase[i][j].equals("")) {
                    if (j == 0) {
                        System.out.print("구매내역 : " + onemanpurchase[i][j]);
                    } else {
                        System.out.print(" ," + onemanpurchase[i][j]);
                    }
                }
            }
        }
        System.out.println(" ");
    }

    public static void promotion_sell(String pro_weaponname[][], int pro_weaponcnt, int proday, int daypurcnt, int[] prodayday) {
        // 제일 많이 팔린 게 무엇인지 보여주기
        int cnt[] = new int[10];
        int bigcnt = 0;
        int indexcnt = 0;
        String cnt2[] = new String[10];
        System.out.println("총 " + pro_weaponcnt + "개 가 팔렸습니다.");
        cnt2[0] = pro_weaponname[0][0];

        for (int i = 0; i < proday; i++) { // 프로모션 진행한 날 수
            for (int j = 0; j < prodayday[i]; j++) { // 프로모션 진행한 날에 판매한 물품수
                if (!pro_weaponname[i][j].equals("")) { // 프로모션 진행한 날짜에 팔린 무기 이름들 앞에는 날짜 뒤에는 그 날 팔린거
                    for (int k = 0; k < j; k++) {
                        if (cnt2[k].equals(pro_weaponname[i][j])) {
                            cnt[k]++;
                        } else if (cnt2[k].equals("")) { // 아무것도 없으면 채워넣기
                            cnt2[k] = pro_weaponname[i][j];
                            cnt[k]++;
                        }
                    }
                }
            }
        }
        for (int t = 0; t < 10; t++) {
            if (cnt[t] > bigcnt) {
                bigcnt = cnt[t];
                indexcnt = t;
            }
        }
        System.out.println("제일 많이 팔린 물품은 " + bigcnt + "개 가 팔린" + cnt2[indexcnt] + " 입니다.");

    }

    public static void oneday_sell(int[] weaponcnt, int daypurcnt, String[][] weaponname, int day, int[] dayday) { //하루니까 purcnt로 담으면 안되는데
        // 이제 어떤 무기를 담았는지

        if (day == 0) {
            System.out.println("1일자 보고서 입니다.");
        } else {
            System.out.println("며칠 자 내역을 보시겠습니까? 1일 부터 ~ " + (day + 1) + "일 까지 고르십시오");
            day = sc.nextInt();
        }

        // if 예외처리 필요
        System.out.println("총 " + dayday[day - 1] + "개 가 팔렸습니다.");
        for (int i = day - 1; i < day; i++) {
            for (int j = 0; j < dayday[day - 1]; j++) {
                if (j == 0) {
                    System.out.println("하루 판매 내역: " + weaponname[i][j]);
                } else {
                    System.out.print(" ," + weaponname[i][j]);
                }
            }
        }
        System.out.println(" ");
    }


    public static void weapon_property(String[][] weaponitem, int[][] wspeed, int[][] wpower, int[][] wdurabilty, int[][] wweight, int[][]wendurance,int[] weaponcnt, int purcnt) { // 구매한 무기 속성보기 또한 자신의 속성까지 몰 수 있게
        int cnt = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < purcnt; i++) {
            cnt = weaponcnt[i];
            c1 = cnt / 10;
            c2 = cnt % 10 - 1;
            c3 = c1 * 10; // 미스릴 같은 등급제에서 설정을 안해서 여기서 급 넣기
            System.out.println(weaponitem[c1][c2]);
            System.out.println("스피드 : " + (wspeed[c1][c2] + c3));
            System.out.println("파워 : " + (wpower[c1][c2] + c3));
            System.out.println("내구성 : " + (wdurabilty[c1][c2] + c3));
            System.out.println("무게 : " + (wweight[c1][c2]));
            System.out.println("지구력 소모량 : " + (wendurance[c1][c2]));
        }
    }

    public static void man_weapon_property(int[][] manspeed, int manstamina[][], int manpower[][], String[][] weaponitem, int[][] wspeed, int[][] wpower, int[][] wdurabilty, int[][] wweight, int[] weaponcnt, int purcnt, int day, int man) { // 구매한 무기 속성보기 또한 자신의 속성까지 몰 수 있게
        /*
        int manspeed[][] = new int[10][10]; // 민첩성 - 스피드
        int manstamina[][] = new int[10][10]; // 지구력 - 무게
        int manpower[][] = new int[10][10]; // 힘 - 공격력
         */
        int cnt = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < purcnt; i++) {
            cnt = weaponcnt[i];
            c1 = cnt / 10;
            c2 = cnt % 10 - 1;
            c3 = c1 * 10; // 미스릴 같은 등급제에서 설정을 안해서 여기서 급 넣기
            //System.out.println(weaponitem[c1][c2]);
            System.out.println("착용한 무기: " + weaponitem[c1][c2]);
            System.out.println("민첩성 : " + (manspeed[day][man] + wspeed[c1][c2] + c3));
            System.out.println("파워 : " + (manpower[day][man] + wpower[c1][c2] + c3));
            System.out.println("지구력 : " + (manstamina[day][man])); // 무게에따라 지구력을 얼마나 쓸 수 있냐로 조정하고 싶긴함
            // TODO 무기에 지구력 소모량 생겼으니 어떻게 수정할 지 체크하기
            // System.out.println("내구성 : " + (wdurabilty[c1][c2]+c3)); 일단 내구성은 무기에서만 다루기로 하기
        }
    }


    public static int[][] discount(int[][] wprice, int dispercent, int[][]wprice2) { // wprice2를 안쓰고 wprice만 리턴해서 보내니까 전체값이 그냥 할인된걸로 고정되어 버렸음

        for (int i = 0; i < wprice.length; i++) {
            for (int j = 0; j < wprice.length; j++) {
                wprice2[i][j] = wprice[i][j] - (wprice[i][j] * dispercent / 100);
            }
        }
        return wprice2;
    }


    public static int manstatpower(int[][] manpower, int day, int man) { // 힘 스텟 셋팅
        System.out.println("힘을 셋팅해주세요");
        int power = 4;
        manpower[day][man] = power;
        if (man == 0) {
            power = 6;
            manpower[day][man] = power;
        } else {
            power = manpower[day][man - 1] + 1;
            if (power > 8) { // 예외처리
                power = 4;
                manpower[day][man] = power;
            } else {
                manpower[day][man] = power;
            }
        }
        return manpower[day][man];
    }

    public static int manstatspeed(int[][] manspeed, int day, int man) { // 스피드 스텟 셋팅
        System.out.println("스피드를 셋팅해주세요");
        int speed = 4;
        manspeed[day][man] = speed;
        if (man == 0) {
            speed = 6;
            manspeed[day][man] = speed;
        } else {
            speed = manspeed[day][man - 1] + 1;
            if (speed > 8) { // 예외처리
                speed = 4;
                manspeed[day][man] = speed;
            } else {
                manspeed[day][man] = speed;
            }
        }
        return manspeed[day][man];
    }


    public static int manstatstamina(int[][] manstamina, int day, int man) { // 스테미나 스텟 셋팅
        System.out.println("지구력을 셋팅해주세요");
        int stamina = 4;
        manstamina[day][man] = stamina;
        if (man == 0) {
            stamina = 6;
            manstamina[day][man] = stamina;
        } else {
            stamina = manstamina[day][man - 1] + 1;
            if (stamina > 8) { // 예외처리
                stamina = 4;
                manstamina[day][man] = stamina;
            } else {
                manstamina[day][man] = stamina;
            }
        }
        return manstamina[day][man];
    }


    public static String[] weaponkind(String weaponsort[]) {

        for (int i = 0; i < 1; i++) {
            weaponsort[0] = "한손검";
            weaponsort[1] = "도끼";
            weaponsort[2] = "철퇴";
            weaponsort[3] = "활";
            weaponsort[4] = "석궁";
            weaponsort[5] = "창";
            weaponsort[6] = "건틀릿";
            weaponsort[7] = "단검";
            weaponsort[8] = "랜스";
            weaponsort[9] = "양손검";
        }
        return weaponsort;

    }

    public static String[][] weaponset(String weaponsort[], String weaponitem[][]) {

        for (int i = 0; i < weaponsort.length; i++) {
            for (int j = 0; j < 1; j++) {
                weaponitem[i][j] = "나무";
                weaponitem[i][j] = weaponitem[i][j] + weaponsort[i];
                weaponitem[i][j + 1] = "돌";
                weaponitem[i][j + 1] = weaponitem[i][j + 1] + weaponsort[i];
                weaponitem[i][j + 2] = "철";
                weaponitem[i][j + 2] = weaponitem[i][j + 2] + weaponsort[i];
                weaponitem[i][j + 3] = "은";
                weaponitem[i][j + 3] = weaponitem[i][j + 3] + weaponsort[i];
                weaponitem[i][j + 4] = "금";
                weaponitem[i][j + 4] = weaponitem[i][j + 4] + weaponsort[i];
                weaponitem[i][j + 5] = "한철";
                weaponitem[i][j + 5] = weaponitem[i][j + 5] + weaponsort[i];
                weaponitem[i][j + 6] = "미스릴";
                weaponitem[i][j + 6] = weaponitem[i][j + 6] + weaponsort[i];
                weaponitem[i][j + 7] = "다이아";
                weaponitem[i][j + 7] = weaponitem[i][j + 7] + weaponsort[i];
                weaponitem[i][j + 8] = "오르하르콘";
                weaponitem[i][j + 8] = weaponitem[i][j + 8] + weaponsort[i];
                weaponitem[i][j + 9] = "운철";
                weaponitem[i][j + 9] = weaponitem[i][j + 9] + weaponsort[i];
            }
        }
        return weaponitem;
    }

    public static void allweapon(String[][] weapon, int[][] wprice, int[][] wamount) {

        for (int i = 0; i < weapon.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < weapon[i].length; j++) {
                if (i == 0) {
                    System.out.print((j + 1) + ". " + weapon[i][j] + "(" + wamount[i][j] + ")" + " : " + wprice[i][j] + " ");
                } else if (i == 1) {
                    if (j == 9) {
                        System.out.print((i + 1) + "0" + ". " + weapon[i][j] + "(" + wamount[i][j] + ")" + " : " + wprice[i][j] + " ");
                    } else {
                        System.out.print((i) + "" + (j + 1) + ". " + weapon[i][j] + "(" + wamount[i][j] + ")" + " : " + wprice[i][j] + " ");
                    }
                } else {
                    if (j == 9) {
                        System.out.print((i + 1) + "0" + ". " + weapon[i][j] + "(" + wamount[i][j] + ")" + " : " + wprice[i][j] + " ");
                    } else {
                        System.out.print((i) + "" + (j + 1) + ". " + weapon[i][j] + "(" + wamount[i][j] + ")" + " : " + wprice[i][j] + " ");
                    }
                }
            }
        }
    }


    public static int seller_error_check(int choice, int choice2, String[][] weapon) {
        // choice는 항목선택용
        // choice2는 물품 선택용
        int c1 = 0;
        int c2 = 0;
        boolean flag = true;
        choice2--;
        c1 = choice2 / 10;
        c2 = choice2 % 10;

        if (choice == 2) { // 새 항목
            if (weapon[c1][c2] != "") { // 해당 자리에 물품이 있을 때
                System.out.println("해당 자리에 " + weapon[c1][c2] + " 라는 무기가 있습니다. 해당 자리에 있는 무기를 제거하시고 새로운 무기로 대체하시겠습니까?");
                System.out.println("1.예 2.아니오");
                choice = sc.nextInt();
                while (flag) {
                    if (choice == 1) {
                        return 1; // 여기까지만
                    } else if (choice == 2) {
                        System.out.println("메뉴 화면으로 돌아가겠습니다");
                        return 0;
                    } else {
                        System.out.println("잘못된 번호를 누르셨습니다. 1, 2 번 중에서 선택해주세요");
                        flag = true;
                    }
                }
            } else { // 해당 자리에 물품이 없을 때
                return 1;
            }

        } else if (choice == 3) { // 제거 항목
            if (weapon[c1][c2] != "") {
                System.out.println("해당 자리에 " + weapon[c1][c2] + " 라는 무기가 있습니다. 해당 자리에 있는 무기를 제거하시겠습니까?");
                System.out.println("1.예 2.아니오");
                choice = sc.nextInt();

                while (flag) {
                    if (choice == 1) {
                        return 1; // 여기까지만
                    } else if (choice == 2) {
                        System.out.println("메뉴 화면으로 돌아가겠습니다");
                        return 0;
                    } else {
                        System.out.println("잘못된 번호를 누르셨습니다. 1, 2 번 중에서 선택해주세요");
                        flag = true;
                    }
                }
            } else {
                System.out.println("해당 자리에 무기가 없습니다.");
                System.out.println("메뉴 화면으로 돌아가겠습니다");
                return 0;
            }

        } else if (choice == 4) { // 업데이트
            if (weapon[c1][c2] != "") {
                System.out.println("해당 자리에 " + weapon[c1][c2] + " 라는 무기가 있습니다. 해당 자리에 있는 무기를 업데이트 하시겠습니까?");
                System.out.println("1.예 2.아니오");
                choice = sc.nextInt();
                while (flag) {
                    if (choice == 1) {
                        return 1; // 여기까지만
                    } else if (choice == 2) {
                        System.out.println("메뉴 화면으로 돌아가겠습니다");
                        return 0;
                    } else {
                        System.out.println("잘못된 번호를 누르셨습니다. 1, 2 번 중에서 선택해주세요");
                        flag = true;
                    }
                }
            }
        } else {
            System.out.println("잘못된 번호를 누르셨습니다.");
            System.out.println("메뉴 화면으로 돌아가겠습니다");
            return 0;
        }
        return 0;
    }

    /* seller_error_check 함수 추가 전 자체 함수에서 오류체크 할 때 쓰던 코드
    public static String[][] newweapon1(String[][] weapon, int[][]wprice, int choice2) { //항목추가 이름 이름 추가가 먼저 되어야함1
        choice2--;
        int c1 = choice2/10;
        int c2 = choice2%10;
        System.out.println("무기 이름을 지어주세요.");
        String weaponname = "";
        weaponname = sc.next();


        for(int i = 0; i < weapon.length; i++) {
            for(int j = 0; j < weapon[0].length; j++) {
                if(weapon[i][j] == weaponname) {
                    System.out.println("이미 있는 무기의 이름입니다.");
                    return weapon;
                } else {
                    weapon[c1][c2] = weaponname;
                    System.out.println("무기가 추가 되었습니다.");
                }

            }
        }
        return weapon;
    }
*/
    // seller_error_check 함수 추가 후 간단해진 코드
    public static String[][] newweapon1(String[][] weapon, int[][] wprice, int choice2) { //항목추가 이름 이름 추가가 먼저 되어야함1
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        System.out.println("무기 이름을 지어주세요.");
        String weaponname = "";
        weaponname = sc.next();

        weapon[c1][c2] = weaponname;
        return weapon;
    }

    public static int[][] newweapon2(String[][] weapon, int[][] wprice, int choice2) { //항목추가 가격
        // allweapon(weapon,wprice);
        // System.out.println("어떤 항목을 추가하시겠습니까?");
        System.out.println("순서대로 스피드, 내구성, 무게, 파워 설정을 해주십시오");
        int speed = sc.nextInt();
        int dura = sc.nextInt();
        int wweight = sc.nextInt();

        int power = sc.nextInt();
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        wprice[c1][c2] = wprice2(dura, speed, wweight, power);
//        wprice[c1][c2] = 0;
        return wprice;
    }
    public static int[][] newweapon_amount(int[][]wamount, int choice2) {
        System.out.println("무기 초기 재고 갯수 설정 : ");
        int cnt = sc.nextInt();
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        wamount[c1][c2] = cnt;
        return wamount;
    }
    public static int[][] weapon_originam_amount(int[][]wamount, int [][]original_wamount ,int choice2) {
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        original_wamount[c1][c2] = wamount[c1][c2];
        return original_wamount;
    }

    public static int[][] outweapon2(String[][] weapon, int[][] wprice, int choice2) { //항목제거 가격
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        wprice[c1][c2] = 0;
        return wprice;
    }

    public static String[][] outweapon1(String[][] weapon, int[][] wprice, int choice2) { //항목제거 이름
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        weapon[c1][c2] = "";
        return weapon;
    }

    public static int[][] amountweapon1(int[][] wamount, int choice2) { //재고업데이트 밖에서 어떤 물품의 재고를 바꾸시겠습니까? 하고 오류제어도 다 해야함
        choice2--;
        int c1 = choice2 / 10;
        int c2 = choice2 % 10;
        System.out.println("물품의 갯수를 몇개로 바꾸시겠습니까?");
        int amount = sc.nextInt();
        wamount[c1][c2] = amount;
        return wamount;
    }

    public static int[][] wendurance(int wendurance[][]) { // 지구력 소모량
        int k = 0;
        for (int i = 0; i < wendurance.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 2;
                    break;
                case 1: // 도끼
                    k = 2;
                    break;
                case 2: // 철퇴
                    k = 3;
                    break;
                case 3: // 활
                    k = 2;
                    break;
                case 4: // 석궁
                    k = 1;
                    break;
                case 5: // 창
                    k = 2;
                    break;
                case 6: // 건틀릿
                    k = 1;
                    break;
                case 7: // 단검
                    k = 1;
                    break;
                case 8: // 랜스
                    k = 4;
                    break;
                case 9: // 양손검
                    k = 3;
                    break;
            }
            for (int j = 0; j < wendurance.length; j++) {
                wendurance[i][j] = k;
            }
        }
        return wendurance;
    }
    public static int[][] wspeed(int wspeed[][]) { // 스피드
        int k = 0;
        for (int i = 0; i < wspeed.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 2;
                    break;
                case 1: // 도끼
                    k = 2;
                    break;
                case 2: // 철퇴
                    k = 3;
                    break;
                case 3: // 활
                    k = 2;
                    break;
                case 4: // 석궁
                    k = 2;
                    break;
                case 5: // 창
                    k = 2;
                    break;
                case 6: // 건틀릿
                    k = 1;
                    break;
                case 7: // 단검
                    k = 1;
                    break;
                case 8: // 랜스
                    k = 4;
                    break;
                case 9: // 양손검
                    k = 4;
                    break;
            }
            for (int j = 0; j < wspeed.length; j++) {
                wspeed[i][j] = k;
            }
        }
        return wspeed;
    }

    public static int[][] wdurability(int wdurability[][]) { // 내구도
        int k = 0;
        for (int i = 0; i < wdurability.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 60;
                    break;
                case 1: // 도끼
                    k = 80;
                    break;
                case 2: // 철퇴
                    k = 100;
                    break;
                case 3: // 활
                    k = 70;
                    break;
                case 4: // 석궁
                    k = 90;
                    break;
                case 5: // 창
                    k = 80;
                    break;
                case 6: // 건틀릿
                    k = 90;
                    break;
                case 7: // 단검
                    k = 40;
                    break;
                case 8: // 랜스
                    k = 95;
                    break;
                case 9: // 양손검
                    k = 120;
                    break;
            }
            for (int j = 0; j < wdurability.length; j++) {
                wdurability[i][j] = k;
                k += 50;
            }
        }
        return wdurability;
    }

    public static int[][] wweight(int wweight[][]) { // 스피드
        int k = 0;
        for (int i = 0; i < wweight.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 1;
                    break;
                case 1: // 도끼
                    k = 2;
                    break;
                case 2: // 철퇴
                    k = 3;
                    break;
                case 3: // 활
                    k = 1;
                    break;
                case 4: // 석궁
                    k = 2;
                    break;
                case 5: // 창
                    k = 3;
                    break;
                case 6: // 건틀릿
                    k = 1;
                    break;
                case 7: // 단검
                    k = 1;
                    break;
                case 8: // 랜스
                    k = 5;
                    break;
                case 9: // 양손검
                    k = 4;
                    break;
            }
            for (int j = 0; j < wweight.length; j++) {
                wweight[i][j] = k;
            }
        }
        return wweight;
    }

    public static int[][] wpower(int wpower[][]) { // 공격력
        int k = 0;
        for (int i = 0; i < wpower.length; i++) {
            //  if(i == 0) k = 50;
            switch (i) {
                case 0: // 한손검
                    k = 80;
                    break;
                case 1: // 도끼
                    k = 90;
                    break;
                case 2: // 철퇴
                    k = 100;
                    break;
                case 3: // 활
                    k = 70;
                    break;
                case 4: // 석궁
                    k = 90;
                    break;
                case 5: // 창
                    k = 100;
                    break;
                case 6: // 건틀릿
                    k = 70;
                    break;
                case 7: // 단검
                    k = 40;
                    break;
                case 8: // 랜스
                    k = 130;
                    break;
                case 9: // 양손검
                    k = 120;
                    break;
            }
            for (int j = 0; j < wpower.length; j++) {
                wpower[i][j] = k;
                k += 50;
            }
        }
        return wpower;
    }

    public static int[][] wprice(int wprice[][], int wdurablity[][], int wspeed[][], int wweight[][], int wpower[][], int[][] wendurance) { // 무기 가격설정
        int kspeed = 0;
        int kweight = 0;
        int allstat[][] = new int[10][10];
        for (int i = 0; i < wprice.length; i++) {
            switch (wspeed[i][i]) {
                case 1:
                    kspeed = 600;
                    break;
                case 2:
                    kspeed = 500;
                    break;
                case 3:
                    kspeed = 400;
                    break;
                case 4:
                    kspeed = 300;
                    break;
                case 5:
                    kspeed = 200;
                    break;
            }
            switch (wweight[i][i]) {
                case 1:
                    kweight = 600;
                    break;
                case 2:
                    kweight = 500;
                    break;
                case 3:
                    kweight = 400;
                    break;
                case 4:
                    kweight = 300;
                    break;
                case 5:
                    kweight = 200;
                    break;
            }
            for (int j = 0; j < wprice.length; j++) {
                allstat[i][j] = wdurablity[i][j] + wpower[i][j] + kspeed + kweight + wendurance[i][j];
                wprice[i][j] = allstat[i][j] * 3;
                if(wprice[i][j] > 50000) {
                    wprice[i][j] = min(50000, wprice[i][j]); // 최대 5만원
                } else if (wprice[i][j] < 1000) {
                    wprice[i][j] = max(1000, wprice[i][j]); // 최소 천원
                }

            }

        }
        return wprice;
    }

    public static int wprice2(int wdurablity, int wspeed, int wweight, int wpower) { // 무기 가격 단일설정
        int kspeed = 0;
        int kweight = 0;
        int allstat = 0;
        int wprice = 0;

        switch (wspeed) {
            case 1:
                kspeed = 600;
                break;
            case 2:
                kspeed = 500;
                break;
            case 3:
                kspeed = 400;
                break;
            case 4:
                kspeed = 300;
                break;
            case 5:
                kspeed = 200;
                break;
        }
        switch (wweight) {
            case 1:
                kweight = 600;
                break;
            case 2:
                kweight = 500;
                break;
            case 3:
                kweight = 400;
                break;
            case 4:
                kweight = 300;
                break;
            case 5:
                kweight = 200;
                break;
        }

        allstat = wdurablity + wpower + kspeed + kweight;
        wprice = allstat * 3;
        if(wprice > 50000) {
            wprice = min(50000, wprice); // 최대 5만원
        } else if (wprice < 1000) {
            wprice = max(1000, wprice); // 최소 천원
        }

        return wprice;
    }


    public static int[][] weaponbuy(int choice, int[][] wamount) {
        int c1 = choice / 10;
        int c2 = choice % 10;
        if (wamount[c1][c2] != 0) {
            wamount[c1][c2] = wamount[c1][c2] - 1;
        } else {
            System.out.println("품절입니다.");
        }
        return wamount;
    }

    public static int[] weaponmoney(int choice, int[][] wprice, int[][] wamount, int[] daymoney, int day) {
        int c1 = choice / 10;
        int c2 = choice % 10;
        if (wamount[c1][c2] != 0) {
            daymoney[day] += wprice[c1][c2];
        } else {
            System.out.println("품절입니다.");
        }
        return daymoney;
    }


    public static int[][] wamount(int wamount[][]) { // 무기 갯수설정
        for (int i = 0; i < wamount.length; i++) {
            for (int j = 0; j < wamount.length; j++) {
                if(j >= 0 && j <= 4) {
                    wamount[i][j] = 3;
                } else if (j >= 5 && j <= 7) {
                    wamount[i][j] = 2;
                } else if (j >= 8 && j <= 9) {
                    wamount[i][j] = 1;
                }

            }
        }
        return wamount;
    }
    public static int[][] origin_wamount_fisrt_set(int wamount[][], int original_wamount[][]) {
        for (int i = 0; i < wamount.length; i++) {
            for (int j = 0; j < wamount.length; j++) {
                original_wamount[i][j] = wamount[i][j];
            }
        }
        return original_wamount;
    }
    public static int[][] origin_wamount(int wamount[][] ,int original_wamount[][]) { // 무기 재고 원래 있었던 숫자만큼 채워줘야함 내가 처음 재고가 2개인걸 설정하면 걔는 다시 2개가 되어야한다는 뜻
        for (int i = 0; i < wamount.length; i++) {
            for (int j = 0; j < wamount.length; j++) {
                wamount[i][j] = original_wamount[i][j];
            }
        }
        return wamount;
    }

    public static int[][] weapon_ordering(int original_wamount[][], int wamount[][], int c1, int c2) { // 무기 재발주
        // 3개 예약했으니 5개의 재고가 찰 수 있게
        wamount[c1][c2] = 5;
        return wamount;
    }

    public static int[][] reservation_weapon(int[][] reservation, int c1, int c2) { // 이 함수 끝나고 예약 3개가 되면 자동으로 발주 들어가게 만들기
        if (reservation[c1][c2] < 3) {
            reservation[c1][c2]++;
        }
        return reservation;
    }
    public static int[][] weapon_update(int original_wamount[][], int wamount[][], int[][] reservation, int c1, int c2) { // 이건 내가 직접 무기를 재발주 하는 시스템
        int choice = 0;
        boolean flag = true;
        if(reservation[c1][c2] > 0 ) {
            System.out.println("최소" + reservation[c1][c2] + "개 보다 많이 발주해야합니다.");
        }
        while (flag) {
            System.out.println("몇 개를 발주하시겠습니까?");
            choice = sc.nextInt();
            if (choice >= reservation[c1][c2]) {
                wamount[c1][c2] = choice;
                flag = false;
            } else {
                System.out.println(reservation[c1][c2] + "개 보다 많거나 같아야 합니다.");
                flag = true;
            }
        }
        return wamount;
    }

    // 예약이 3건 일때 실행되는 함수

    public static int[][] reservation_return(int[][] reservationman_c1, int[][] reservationman_c2, int c1, int c2) {
        // 리턴 값을 사람으로만 하자 어차피 예약은 3건이고 3명만 리턴하면 돼
        // 그리고 리턴 값은 3개 밑에 이거 3개
        // 3명만 리턴 어떻게 리턴하지?
        //  리턴 값으로 보내야할게 날짜 , 몇 번째 사람,

        // 리턴할 배열 초기화 (최대 3건의 예약)
        int[][] reser_man = new int[3][2]; // [][0]: 날짜, [][1]: 사람 번호
        int count = 0; // 리턴할 예약 수 카운트

        for (int i = 0; i < reservationman_c1.length; i++) {
            for (int j = 0; j < reservationman_c2.length; j++) {
                if (reservationman_c1[i][j] == c1 && reservationman_c2[i][j] == c2) {
                    // 예약이 일치하는 경우, 날짜와 사람 번호 저장
                    reser_man[count][0] = i; // 날짜 (i 인덱스)
                    reser_man[count][1] = j; // 사람 번호 (j 인덱스)
                    count++;

                    // 최대 3건까지만 저장
                    if (count >= 3) {
                        return reser_man; // 3건이 채워지면 리턴
                    }
                }
            }
        }

        return reser_man; // 예약 수가 3건 미만인 경우에도 리턴
    }
    //reser_onemanpurchase[man][purcnt] = weaponitem[c1][c2];

    public static void processReservations(int[][] reservation_man, int[][] wamount, String[][] weaponitem, String[][] onemanpurchase, int[] purcnt) {
        int c1, c2;

        // 예약된 무기를 순차적으로 재발주 후 구매내역에 추가함
        for (int i = 0; i < reservation_man.length; i++) {
            int day = reservation_man[i][0]; // 예약된 날짜 [i][0]
            int man = reservation_man[i][1]; // 예약자 순번 [i][1]

            if (day == -1 || man == -1) continue; // 유효하지 않은 예약자임.

            // 예약된 무기 좌표.
            c1 = reservation_man[i][0];
            c2 = reservation_man[i][1];

            // 재고 업데이트 및 구매 내역 저장
            if (wamount[c1][c2] > 0) {
                // 무기 구매 내역에 추가해야해요
                onemanpurchase[man][purcnt[man]] = weaponitem[c1][c2];
                purcnt[man]++; // 예약자 구매내역 순번 증가
                wamount[c1][c2]--; // 재고 감소

                System.out.println("예약자 " + man + "의 구매내역에 " + weaponitem[c1][c2] + "가 추가되었습니다.");
            } else {
                System.out.println("재고가 부족하여 예약 무기 제공이 불가합니다.");
            }
        }
    }
}



