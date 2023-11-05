package teacherstudyre;

import java.util.Scanner;

public class Study1105_1 {

    public static void main(String[] args) {
        solution();
    }
    

    
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int people = 1, money = 0,  count1 = 0, count2 = 0, count3 = 0, choice, choice2, stop = 0;
        String food = "";

        System.out.println(" 1.껌5000원 2.과자7000원 3.복숭아4000 4.환불 5.종료 " );

        while(stop != 1) {
            choice = sc.nextInt();

            if (choice == 1) {
                money = allmoney(money,choice);
                count1 = foodcount(choice,count1);
                menu(people,choice,money,food,count1);
                System.out.println(" 추가 주문하시겠습니까? 1.예 2.아니오");
                choice2 = sc.nextInt();
                if(choice2 == 2) {
                    people++;
                    count1 = 0;
                }
            } else if (choice == 2) {
                money = allmoney(money,choice);
                count2 = foodcount(choice,count2);
                menu(people,choice,money,food,count2);
                System.out.println(" 추가 주문하시겠습니까? 1.예 2.아니오");
                choice2 = sc.nextInt();
                if(choice2 == 2) {
                    people++;
                    count2 = 0;
                }
            } else if (choice == 3) {
                money = allmoney(money,choice);
                count3 = foodcount(choice,count3);
                menu(people,choice,money,food,count3);
                System.out.println(" 추가 주문하시겠습니까? 1.예 2.아니오");
                choice2 = sc.nextInt();
                if(choice2 == 2) {
                    people++;
                    count3 = 0;
                }
            } else if (choice == 4) {
                System.out.println(" 1.개별 환불 2.전체 환불 ");
                choice = sc.nextInt();
                if(choice == 1) {
                    System.out.println(" 어떤 것을 환불하시겠습니까? ");
                } else if (choice == 2) {
                    money = money - money;
                }
            }
            else if(choice == 5) {
                if(count2 /10 != 0){
                    int need = count2%10;
                    System.out.println(" 과자를 추가 구매하여야 합니다. ");
                    System.out.println(" 현재 과자의 갯수가 " + count2 + "개 이며");
                    System.out.println(need + " 개를 더 구매하여야 합니다.");
                } else if (count3 < count2) {
                    int need = count2 - count3;
                    System.out.println(" 북숭아가 과자보다 적어 추가 구매하여야 합니다. ");
                    System.out.println(" 현재 과자의 갯수가 " + count2 + "개 이고 복숭아가" + count3 + "개 이니");
                    System.out.println(need + " 개를 더 구매하여야 합니다.");
                } else
                stop++;
            }

        }
        
    }

    public static void menu (int people,int choice,int money, String food, int count) {
        if(choice == 1) {
            money = allmoney(money,choice);
            food = "껌";
            count++;
        } else if(choice == 2) {
            money = allmoney(money,choice);
            food = "과자";
            count++;
        } else if(choice == 3) {
            money = allmoney(money,choice);
            food = "복숭아";
            count++;
        }
        System.out.print(people + " 번 째 사람이 " + food + "를 " + count + " 번 째 주문하셨습니다 누적 금액은 " + money + " 원 입니다.");

    }

    public static int allmoney(int money,int choice) {
        if(choice == 1) {
            money += 5000;
        } else if(choice == 2) {
            money += 7000;
        } else if(choice == 3) {
            money += 4000;
        }
        return money;
    }

    public static int foodcount(int ch , int count) {

        if(ch !=4) {
            count ++;
        }
        return count;
    }
    
}
