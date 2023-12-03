package teacherstudyre;

import java.util.Scanner;

public class Study1203_2 {
    static Scanner sc2 = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int cnt = 1;
        int start = 0;
        int money = 0;
        if(start > 0) {
            while (cnt != 0) {
                int choice = sc2.nextInt();
                if (choice == 1) {
                    money = bank();
                }if (choice == 2) {
                    food(money);
                } else if (choice == 3) {
                    cnt = 0;
                }
                money = bank();
                food(money);
            }
        } else if(start == 0) {
            money = bank();
            food(money);
        }
    }
    public static int bank() {
        int lastchance = 0;
        int answer = 0;
        int money = 0;
        int moneyplus = 0;
        int count = 0;
        int choice = 0;
        int cnt = 1;
        int chance = 0;
        int schance1 = 0;
        int next1 = 0;
        int next2 = 0;
        int next3 = 0;
        int age = 0;
        String sex = "";
        int phone = 0;
        String jumin = "";
        String password = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("성별 : ");
        sex = sc.next();
        System.out.println("전화번호 : ");
        phone = sc.nextInt();

        while (cnt != 0) {
            if(next1 == 0) {
                System.out.println("주민번호 : ");

                jumin = sc.next();
                int jl = jumin.length();
                int juminlength = 6;
                answer = three(juminlength,jl);

                if(answer != 0 && schance1 == 0) {
                    chance = chan(answer, chance, schance1, lastchance, "주민번호");
                    schance1++;
                } else if(answer != 0 && schance1 != 0) {
                    chance = chan(answer, chance, schance1, lastchance,  "주민번호");
                    if(chance == 1) lastchance++;
                    if(chance == 0) {
                        cnt = 0;
                    }
                } else if(answer == 0) {
                    next1++;
                    chance = 0;
                    schance1 = 0;
                }
            }
            if(next1 != 0){

                System.out.println("카드 비밀번호 : ");
                password = sc.next();
                int pl = password.length();
                int pllength = 4;
                answer = three(pllength,pl);

                if(answer != 0 && schance1 == 0) {
                    chance = chan(answer, chance, schance1, lastchance, "카드비밀번호");
                    schance1++;
                } else if(answer != 0 && schance1 != 0) {
                    chance = chan(answer, chance, schance1, lastchance,  "카드비밀번호");
                    if(chance == 1) lastchance++;
                    if(chance == 0) {
                        cnt = 0;
                    }
                } else if(answer == 0) {
                    next2++;
                    chance = 0;
                }
            }
            while(next2 != 0) {
                System.out.println("1.계좌 조회. 2.계좌 입금 3.계좌 출금");
                choice = sc.nextInt();
                if(choice == 1) {
                    count = selectcard(count, money);
                }
                if(choice == 2) { // 입금
                    System.out.println("금액을 입력하시오");
                    moneyplus = sc.nextInt();
                    money = cardmoney(count,choice,money,moneyplus);
                    cnt = 0;
                } else if(choice == 3) { // 출금
                    System.out.println("금액을 입력하시오");
                    moneyplus = sc.nextInt();
                    money = cardmoney(count,choice,money,moneyplus);
                }

            }

        }
                return money;
    }

    public static void food(int money) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int fish = 0, corn = 0, fri =0;
        int fishprice = 5000;
        int cornprice = 10000;
        int friprice = 3000;
        int cnt = 0;
        int fCount = 0;
        int numoney = 0;
        if(money > 0) { // 일단은 하드코딩 하는데 동적으로 어떻게 변화시킬지 고민해야함
            if (money < 100000) {
                fishprice = fishprice/10;
                cornprice = cornprice/10;
                friprice = friprice/10;
            } else if (money > 1000000) {
                fishprice = fishprice*10;
                cornprice = cornprice*10;
                friprice = friprice*10;
            }


        }

        while (cnt != 1) {
            System.out.println("1.장어덮밥 " + fishprice + "원 2.옥수수콘 " + cornprice +"원 3.감자튀김 " + friprice + "원 4.총 가격");
            System.out.print("선택 할 번호 : ");
            choice = sc.nextInt();
            String giho = "-";
            if(choice == 1) {
                fish++;
                numoney = foodchoice(choice,fishprice,numoney);
                System.out.println("1번 장어덮밥을 선택하셔서 현재 누적금액은 " + numoney + "원 입니다." );
            } else if (choice == 2) {
                corn++;
                numoney = foodchoice(choice,cornprice,numoney);
                System.out.println("2번 옥수수콘을 선택하셔서 현재 누적금액은 " + numoney + "원 입니다." );
            } else if(choice == 3){
                fri++;
                numoney = foodchoice(choice,friprice,numoney);
                System.out.println("3번 감자튀김을 선택하셔서 현재 누적금액은 " + numoney + "원 입니다." );
            }

            System.out.println("계속 구매하시겠다면 1번, 아니면 2번을 눌러주세요." );
            choice = sc.nextInt();
            if(choice == 1) {
                cnt = 0;
                System.out.println("계속 진행합니다. ");
            } else if (choice == 2){
                fCount = foodcount(fish,corn,fri);
                if(fCount == 1) {
                    corn++;
                    fri++;
                } else if (fCount == 2) {
                    fri++;
                }
                int nowmoney = money; // nowmoney는 내가 가진 돈
                money = gesan(money,giho,numoney);

                System.out.println(nowmoney + "원[현재가진돈] - " + numoney + "원[음식점가격] = " + money + "원");
                System.out.println("장어덮밥 : " + fish + " 옥수수콘 : " + corn + " 감자튀김 : " + fri);
                cnt++;
            }

        }


    }




    public static int selectcard(int count, int money) {
        if(count == 0) {
            System.out.println("현재 잔액은" + money + "원 입니다.");
            count++;
            return count;
        } else if(count != 0) {
            System.out.println("계좌조회는 1회만 가능합니다.");
            return count;
        }
        return 0;
    }

    public static int cardmoney(int count, int choice, int money, int moneyplus) {
        if((choice == 2 || choice == 3) && count == 0) {
            System.out.println("처음에는 계좌조회만 가능합니다.");
            return money;
        } else if(choice == 2 && count != 0) {
            money += moneyplus;
            System.out.println(moneyplus + "원 이 입금되어 현재 잔액은" + money + "원 입니다.");
            return money;
        } else if(choice == 3 && count != 0) {
            if(money < moneyplus) {
                System.out.println("잔액이 부족합니다.");
                return money;
            } else {
                money -= moneyplus;
                System.out.println(moneyplus + "원 이 출금되어 현재 잔액은" + money + "원 입니다.");
                return money;
            }
        }
        return 0;
    }

    public static int three(int length, int stlength) {
        int answer = 0;
        if(stlength == length) {
            return answer;
        } else if(stlength < length) {
            answer++;
            return answer;
        } else {
            answer+=2;
            return answer;
        }
    }
    public static int chan(int answer, int chance, int schance, int lastchance,  String word) {
        if((answer == 1 || answer == 2) && schance == 0) {
            chance += 3;
            System.out.println(word + "가 틀렸습니다 기회가" + chance +"번 남았습니다.");
            return chance;
        } else if(answer == 1 && schance != 0 && chance == 1 && lastchance == 1) {
            System.out.println(word + "가 틀렸습니다 마지막 기회가 1회 추가되어" + chance +"번 남았습니다.");
            return chance;
        } else if(answer == 2 && schance != 0 && chance == 1 && lastchance == 1) {
            chance ++;
            System.out.println(word + "가 틀렸습니다 마지막 기회가 2회 추가되어" + chance +"번 남았습니다.");
            return chance;
        } else {
            chance--;
            if(chance == 0) {
                System.out.println("더 이상 기회가 없습니다 프로그램이 종료됩니다.");
            } else {
                System.out.println(word + "가 틀렸습니다 기회가" + chance +"번 남았습니다.");
            }
            return chance;
        }

    }
    public static int foodchoice(int choice, int foodpr, int numoney) {

        if(choice == 1) {
            System.out.println("1번 장어덮밥을 선택하셨습니다.");
            numoney += foodpr;
            return numoney;
        } else if (choice == 2) {
            System.out.println("2번 옥수수콘을 선택하셨습니다.");
            numoney += foodpr;
            return numoney;
        } else if (choice == 3) {
            System.out.println("3번 감자튀김을 선택하셨습니다.");
            numoney += foodpr;
            return numoney;
        } else {
            System.out.println("감사합니다. 총 가격은 " + numoney + "원 입니다.");
            return numoney;
        }
    }

    public static int foodcount(int fish, int corn, int fri) {
        int count = 0;
        if(fish > corn && fish > fri) {
            System.out.println("'장어덮밥을 많이 주문하셨기 때문에 옥수수콘과 감자튀김은 1개씩 무료로 드립니다. ");
            count++;
            return count;

        } else if(corn > fish && corn > fri) {
            System.out.println("'옥수수콘을 많이 주문하셨기 때문에 감자튀김을 1개씩 무료로 드립니다. ");
            count += 2;
            return count;

        } else if(fri > fish && fri > corn) {
            System.out.println("'감자튀김을 많이 주문하셨기 아무것도 없습니다. ");
            count += 3;
            return count;

        }
        return 0;
    }

    public static int gesan(int one, String giho, int two) {
        int answer = 0;
        if(giho.equals("+")) {
            answer = one + two;
            System.out.println(one + " + " + two + " = " + answer);
            return answer;
        } else if (giho.equals("-")) {
            answer = one - two;
            System.out.println(one + " - " + two + " = " + answer);
            return answer;
        } else if (giho.equals("*")) {
            answer = one * two;
            System.out.println(one + " * " + two + " = " + answer);
            return answer;
        } else if (giho.equals("/")) {
            answer = one/two;
            System.out.println(one + " / " + two + " = " + answer);
            return answer;
        }
        return 0;
    }

}

