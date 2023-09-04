package teacherstudyre;

import java.util.Scanner;

public class september_04 {
    static int choice2 =0;
    static int	money = 10000;

    public static void main(String[] args) {
        foodSelect();
    }
    public static void foodSelect(){
        Scanner sc = new Scanner(System.in);
        int rice, woo, chip, plusmoney;
        int money2;


        System.out.println("plus money : ");
        plusmoney = sc.nextInt();
        money += plusmoney;
        System.out.println("money : " + money);

        System.out.println("rice price : ");
        rice = sc.nextInt();

        System.out.println("woo price : ");
        woo = sc.nextInt();

        System.out.println("chip price : ");
        chip = sc.nextInt();

        money2 =foodPriceSelect("rice", money, rice);


        money2 = foodPriceSelect("woo", money2, woo);


        money2 = foodPriceSelect("chip", money2, chip);

    }

    public static int foodPriceSelect(String food, int money, int foodmoney) {
        Scanner sc = new Scanner(System.in);
        System.out.println(food + " How many do you want to buy?");
        int count = sc.nextInt();


            foodmoney = foodmoney * count;
            money = money - foodmoney;
            if(money < 0){
                if(choice2 != 0){
                    System.out.println("already received money kicked out by the owner");
                    System.exit(0);
                }
                if (choice2 == 0) {
                    System.out.println("short " + money + "\n\n give plusmoney");
                    int plusmoney = sc.nextInt();
                    money = money + plusmoney;
                    money = money + foodmoney;
                    System.out.println("now " + money + "won left.");
                    money = money - foodmoney;
                    System.out.println(food + " ordered and we have " + money
                            + " won left");
                    choice2 += 1;
                }
            }
            else {
                System.out.println(food + " ordered and we have " + money
                        + " won left");
            }
            return money;
    }

}