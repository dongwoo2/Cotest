package teacherstudyre;

import java.util.Scanner;

public class Study1126_2 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
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
                if(choice == 2 || choice == 3) {
                    System.out.println("금액을 입력하시오");
                    moneyplus = sc.nextInt();
                    money = cardmoney(count,choice,money,moneyplus);
                }

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


}

