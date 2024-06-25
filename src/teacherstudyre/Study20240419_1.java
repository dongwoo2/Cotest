package teacherstudyre;


import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Study20240419_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }


    public static void solution() {
        String weaponsort[] = new String[10];
        String weaponitem[][] = new String[10][10];
        String weaponitem2[][] = new String[10][10]; // 대체품
        String onemanpurchase[][] = new String[30][30]; // 구매내역을 보기 위한 변수 어떤것을 구매했는지 알 수 있게 - 한 사람
        String allmanpurchase[][] = new String[30][30]; // 구매내역을 보기 위한 변수 어떤것을 구매했는지 알 수 있게 - 전체
        int wdurability[][] = new int[10][10]; // 내구도
        int wspeed[][] = new int[10][10]; // 스피드
        int wweight[][] = new int[10][10]; // 무게
        int wpower[][] = new int[10][10]; // 공격력
        int wprice[][] = new int[10][10]; // 무기 가격
        int wprice2[][] = new int[10][10]; // 할인무기 가격
        int wamount[][] = new int[10][10]; // 무기 수량
        int originalwamount[][] = new int[10][10]; // 갯수 설정해주는 무기 수량 초기 갯수에 따라 3턴 지나면 자동으로 몇 개가ㅓ 채워져야 하는지 알 수 있게 해줌
        int daymoney[] = new int[10];
        int manspeed[][] = new int[10][10]; // 민첩성 - 스피드
        int manstamina[][] = new int[10][10]; // 지구력 - 무게
        int manpower[][] = new int[10][10]; // 힘 - 공격력

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

        weaponsort = weaponkind(weaponsort);
        weaponitem = weaponset(weaponsort, weaponitem);

        wdurability = wdurability(wdurability);
        wspeed = wspeed(wspeed);
        wweight = wweight(wweight);
        wpower = wpower(wpower);
        wprice = wprice(wprice, wdurability, wspeed, wweight, wpower);
        wamount = wamount(wamount); // 이제 물품이 0개가 되면 3턴뒤에 다시 생기는 걸로 만들기
        originalwamount = origin_wamount_fisrt_set(wamount,originalwamount); // 물품 오리지날 초기 셋팅 설정

        // 구매자 스텟 만들기 힘,민첩성,지구력

        while (flag) {
            System.out.println("1.판매자 로그인 2.구매자 로그인 3.회원가입");
            choice = sc.nextInt();
            flag2 = true;
            if (choice == 1) {
                logincheck = check_id(choice, buyer_id, buyer_pw, day, man, seller_id, seller_pw);
                if (logincheck == 1) { //로그인 성공
                    while (flag2) { // 판매자
                        System.out.println("1.항목 인벤토리 보기 2.새 항목 추가하기 3.항목 제거하기 4.항목 재고 업데이트 5. 프로모션 설정 6.판매 보고서 7.판매자 로그아웃");
                        choice = sc.nextInt();
                        if (choice == 1) {
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
                            System.out.println("어떤 항목을 업데이트 하시겠습니까?");
                            choice2 = sc.nextInt();
                            sellercheck = seller_error_check(choice, choice2, weaponitem);
                            if (sellercheck == 1) {
                                wamount = amountweapon1(wamount, choice2);
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
                                    wprice2 = discount(wprice, dispercent); // 할인이 있는 기간에는 wprice2로 가격진행
                                    System.out.println("프로모션 기간을 얼마나 설정하시겠습니까?");
                                    promotionday1 = sc.nextInt();
                                }
                            } else if (choice == 2) {
                                if (promotionday1 != 0) {
                                    System.out.println("다른 프로모션이 진행중입니다.");
                                } else {
                                    System.out.println("프로모션 기간을 얼마나 설정하시겠습니까?");
                                    promotionday2 = sc.nextInt();
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
                        System.out.println((day + 1) + "일" + (man + 1) + "번 째 구매자 입니다.");
                        if (manc == 0) {
                            System.out.println("구매자의 스텟을 셋팅해주세요");
                            manpower[day][man] = manstatpower(manpower, day, man);
                            manspeed[day][man] = manstatspeed(manspeed, day, man);
                            manstamina[day][man] = manstatstamina(manstamina, day, man);
                        }
                        manc++;
                        flag3 = true;
                        System.out.println("1.구매하기 2.구매내역보기 3.기본통계보기 4.다음사람 5.다음 날 6.구매자 로그아웃");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            while (flag3) {
                                if (promotionday1 != 0) { // 할인중
                                    System.out.println(dispercent + "% 할인을 진행하고 있습니다. 기간은 " + promotionday1 + "일 남았습니다.");
                                    allweapon(weaponitem, wprice2, wamount);
                                    minusitem = 1;
                                } else if (promotionday2 != 0) { // 1 + 1
                                    System.out.println("1 + 1 이벤트를 진행하고 있습니다.\n기간은 " + promotionday2 + "일 남았습니다.");
                                    allweapon(weaponitem, wprice, wamount);
                                    minusitem = 2;
                                } else { // 아무것도 안함
                                    allweapon(weaponitem, wprice, wamount);
                                    minusitem = 1;
                                }
                                System.out.println("몇 번째 아이템을 구매하시겠습니까?");
                                choice = sc.nextInt(); // 구매하고 난 뒤에 갯수 줄이기
                                if (choice < 100) {
                                    c1 = choice / 10;
                                    c2 = choice % 10;
                                    choice_check++;
                                } else {
                                    System.out.println("항목에 없는것을 고르셨습니다 다시 선택해주세요.");
                                    choice_check = 0;
                                }
                                if (c1 != 0 && c2 == 0 && choice < 100) { // 10번을 선택했을 시 인덱스에서는 9번 그리고 20번하면 19번 이렇게 선택이 되어야함
                                    c1--;
                                    c2 = 9;
                                } else if (c1 != 0 && c2 != 0 && choice < 100) { // 정상적인 진행이 될 때 c2는 --가 되어야함
                                    c2--;
                                } else if (c1 == 0 && c2 != 0 && choice < 100) {
                                    c2--;
                                }

                                if (choice_check != 0) {
                                    System.out.println(" = " + wamount[c1][c2]);
                                    if (wamount[c1][c2] >= minusitem && promotionday2 == 0) { // 구매가 잘 되었을 때
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
                                        System.out.println("품절 되었습니다 다른 상품 구매를 원하시면 1번, 구매를 원치 않으시면 2번을 눌러주세요.");
                                        if (choice == 2) {
                                            flag3 = false;
                                        } else if (choice == 1) {
                                            flag3 = true;
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
                                weapon_property(weaponitem, wspeed, wpower, wdurability, wweight, weaponcnt, purcnt);
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
                            if(dayturn == 3) {
                                dayturn = 0;
                                wamount = origin_wamount(wamount,originalwamount);
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


    public static void weapon_property(String[][] weaponitem, int[][] wspeed, int[][] wpower, int[][] wdurabilty, int[][] wweight, int[] weaponcnt, int purcnt) { // 구매한 무기 속성보기 또한 자신의 속성까지 몰 수 있게
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
            // System.out.println("내구성 : " + (wdurabilty[c1][c2]+c3)); 일단 내구성은 무기에서만 다루기로 하기
        }
    }


    public static int[][] discount(int[][] wprice, int dispercent) {

        for (int i = 0; i < wprice.length; i++) {
            for (int j = 0; j < wprice.length; j++) {
                wprice[i][j] = wprice[i][j] - (wprice[i][j] * dispercent / 100);
            }
        }
        return wprice;
    }


    public static int manstatpower(int[][] manpower, int day, int man) { // 힘 스텟 셋팅
        System.out.println("힘을 셋팅해주세요");
        int power = 4;
        if (day == 0 && man == 0) {
            power = 6;
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
        if (day == 0 && man == 0) {
            speed = 6;
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
        if (day == 0 && man == 0) {
            stamina = 6;
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

    public static int[][] wprice(int wprice[][], int wdurablity[][], int wspeed[][], int wweight[][], int wpower[][]) { // 무기 가격설정
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
                allstat[i][j] = wdurablity[i][j] + wpower[i][j] + kspeed + kweight;
                wprice[i][j] = allstat[i][j] * 3;
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


    public static int[][] wamount(int wamount[][]) {
        for (int i = 0; i < wamount.length; i++) {
            for (int j = 0; j < wamount.length; j++) {
                wamount[i][j] = 3;
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

}



