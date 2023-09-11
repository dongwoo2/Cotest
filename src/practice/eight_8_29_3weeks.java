package practice;

import java.util.Scanner;

public class eight_8_29_3weeks {

    private int money;
    private int choice2;

    public eight_8_29_3weeks(int money, int choice2){
        this.money = money;
        this.choice2 = choice2;
    }


    public static void main(String[] args) {
        foodSelect();
    }
    public static void foodSelect(){
        Scanner sc = new Scanner(System.in);
        int ri, woo, chip, plusmoney;
        int money = 10000;
        int choice2 =0;
//    	int money2;

        System.out.println("plus money : ");
        plusmoney = sc.nextInt();

        money += plusmoney;
        System.out.println("money : " + money);

        System.out.println("ri price : ");
        ri = sc.nextInt();

        System.out.println("woo price : ");
        woo = sc.nextInt();

        System.out.println("chip price : ");
        chip = sc.nextInt();

        eight_8_29_3weeks eight = new eight_8_29_3weeks(money,choice2);

        eight = foodPriceSelect("ri", eight.money, ri ,eight.choice2);

        eight = foodPriceSelect("woo", eight.money, woo ,eight.choice2);

        eight = foodPriceSelect("chip", eight.money, chip ,eight.choice2);

    }

    public static eight_8_29_3weeks foodPriceSelect(String food, int money, int foodmoney, int choice2) {
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
                System.out.println("short " + money + " plusmoney");
                int plusmoney = sc.nextInt();
                money = money + plusmoney;
                money = money + foodmoney;
                System.out.println("now " + money + "won left.");
                money = money - foodmoney;
                System.out.println(food + " ordered and we have " + money
                        + " won left");
                choice2 += 1;

                return new eight_8_29_3weeks(money,choice2);
            }
        }
        else {
            System.out.println(food + " ordered and we have " + money
                    + " won left");
        }

        return new eight_8_29_3weeks(money,choice2);
    }

}
