package teacherstudyre;

import java.util.Scanner;

public class Study1015_1 {

    public static void main(String[] args) {
        solution();

    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int money = 0;
        int k = 0;
        while (true) {
            System.out.println("1.구구단  2.음식점  3.계산기  4.종료");
            int select = sc.nextInt();
            if (select == 1) {
                gugudan();
            } else if(select == 2) {
               money = food(money,k);
               k++;
            } else if(select == 3) {
                calculate();
            } else if(select ==4) {
                break;
            } else {
                System.out.println("없는 번호입니다 다시 선택해주세요");

            }
        }
    }

    public static void gugudan() {
        int t = 1;
        while (t<10) {
            System.out.println("2 * " + t + " = " + (2*t));
            t++;
        }
    }

    public static int food(int money,int k) {
        Scanner sc = new Scanner(System.in);

        System.out.println("볶음밥 가격");
        int rice = sc.nextInt();
        System.out.println("자장면 가격");
        int jajang = sc.nextInt();
        System.out.println("탕수육 대 가격");
        int tang1 = sc.nextInt();
        System.out.println("탕수육 중 가격");
        int tang2 = sc.nextInt();
        System.out.println("탕수육 소 가격");
        int tang3 = sc.nextInt();



        while (true) {
            System.out.println("1.볶음밥 " + rice + "원" +" 2.자장면 " + jajang + "원" +" 3.탕수육 대자 " + tang1 + "원 중자 " + tang2 + "원 소자 " + tang3 +" 원 " + "4. 종료" );
            int select = sc.nextInt();

            if(select == 4){
                break;
            } else if(select == 1) {
                money += rice;
                System.out.println("볶음밥을 선택하셨습니다.");
                System.out.println("현재 돈 : " + money + " 원.");
                continue;
            } else if(select>4) {
                System.out.println("없는 번호입니다 다시 선택해주세요");
                continue;
            }

            while (true) {
                if (select == 2) {
                    System.out.println("1.볶음밥"+ rice + " 원" + "2.자장면"+ jajang + " 원" + " 3.탕수육");
                    int select2 = sc.nextInt();

                    if (select2 == 3) {
                        System.out.println(" 1.탕수육 대자 " + tang1 + " 원 2.중자" + tang2 + "원 3.소자" + tang3 +" 원" );
                        int select3 = sc.nextInt();
                        if (select3 == 4) {
                            break;
                        } else if(select3 == 1) {
                            money+= tang1;
                            System.out.println("탕수육 대자를 선택하셨습니다.");
                            System.out.println("현재 돈 : " + money + " 원.");
                            break;
                        } else if(select3 == 2) {
                            money+= tang2;
                            System.out.println("탕수육 중자를 선택하셨습니다.");
                            System.out.println("현재 돈 : " + money + " 원.");
                            break;
                        } else if(select3 == 3) {
                            money+= tang3;
                            System.out.println("탕수육 소자를 선택하셨습니다.");
                            System.out.println("현재 돈 : " + money + " 원.");
                            break;
                        }
                    } else if(select2 == 1) {
                        money+=rice;
                        System.out.println("볶음밥을 선택하셨습니다.");
                        System.out.println("현재 돈 : " + money + " 원.");
                        break;
                    } else if(select2 == 2) {
                        money+=jajang;
                        System.out.println("자장면을 선택하셨습니다.");
                        System.out.println("현재 돈 : " + money + " 원.");
                        break;
                    } else if(select2 > 4) {
                        System.out.println("없는 번호입니다 다시 선택해주세요");
                        break;
                    }

                }
            }
        }
        return money;
    }

    public static void calculate() {
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.더하기 2.빼기");
            int choice = sc.nextInt();
            if (choice == 1) {
                x = sc.nextInt();
                y = sc.nextInt();
                System.out.println(x + y);
                break;
            } else if (choice == 2) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (y > x) {
                    while (y > x) {
                        System.out.println("두 번째 숫자가 더 클 수 없습니다. 다시 입력해주세요");
                        y = sc.nextInt();
                    }
                    System.out.println(x - y);
                    break;
                } else {
                    System.out.println(x - y);
                    break;
                }
            } else {
                System.out.println("없는 번호입니다 다시 선택해주세요");
            }
        }
    }
}
