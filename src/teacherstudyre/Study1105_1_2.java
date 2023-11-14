package teacherstudyre;



import java.util.Scanner;



public class Study1105_1_2 {

    public static void main(String[] args) {

        solution();

    }

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int stop = 0;

        int people = 1;

        int money = 0;

        int choice = 0;

        int gum = 5000;

        int chip = 7000;

        int peach = 4000;

        int count1 = 0;

        int count2 = 0;

        int count3 = 0;

        int allcount1 = 0;

        int allcount2 = 0;

        int allcount3 = 0;

        int refund = 0;

        while(stop != 1) {

            System.out.println(" 1.껌5000원 2.과자7000원 3.복숭아4000 4.환불 5.종료 " );

            choice = sc.nextInt();

            if(choice == 1) {

                count1 = foodcount(choice,count1);

                allcount1 = allcount1 + 1;

                money = allmoney(money, gum);

                menu(count1, "껌", money , people);

                System.out.println(" 추가 주문하시겠습니까? \n 1.예 2.아니오");

                choice = sc.nextInt();



                if(choice == 1) {

                } else {

                    count1 = 0;

                    people++;

                    System.out.println(people + " 번 째 사람이 입장합니다.");

                }

            } else if(choice == 2) {

                count2 = foodcount(choice,count2);

                allcount2 = allcount2 + 1;

                money = allmoney(money, chip);

                menu(count2, "과자", money , people);

                System.out.println(" 추가 주문하시겠습니까? \n 1.예 2.아니오");

                choice = sc.nextInt();



                if(choice == 1) {

                } else {

                    count2 = 0;

                    people++;

                    System.out.println(people + " 번 째 사람이 입장합니다.");

                }

            } else if(choice == 3) {

                count3 = foodcount(choice,count3);

                allcount3 = allcount3 + 1;

                money = allmoney(money, peach);

                menu(count3, "복숭아", money , people);

                System.out.println(" 추가 주문하시겠습니까? \n 1.예 2.아니오");

                choice = sc.nextInt();



                if(choice == 1) {

                } else {

                    count3 = 0;

                    people++;

                    System.out.println(people + " 번 째 사람이 입장합니다.");

                }

            } else if(choice == 4) {

                System.out.println(" 1.개별 환불 2.전체 환불 ");

                choice = sc.nextInt();

                if(choice == 1) {

                    System.out.println(" 어떤 것을 환불하시겠습니까? ");

                    refund = 0;

                    while(refund == 0) {

                        System.out.println(" 1.껌5000원 2.과자7000원 3.복숭아4000원 ");



                        choice = sc.nextInt();



                        if(choice == 1){

                            if(allcount1 > 0){

                                allcount1 = countrefund(allcount1) ;

                                money = moneyrefund(money,gum);

                                count1--;

                                System.out.println("껌이 한 개 환불되어" + allcount1 +" 개 이며 누적금액" + money + " 원 입니다..");

                                System.out.println("계속환불하시겠습니까? 1.예 2.아니오");

                                choice = sc.nextInt();

                                if(choice == 1) {

                                    System.out.println(" 어떤 것을 환불하시겠습니까? ");

                                } else{

                                    refund++;

                                }

                            } else {

                                System.out.println("구입 한 적이 없어 환불불가.");

                                refund++;

                            }



                        } else if(choice == 2){

                            if(allcount2 > 0){

                                allcount2 = countrefund(allcount2) ;

                                money = moneyrefund(money,chip);

                                count2--;

                                System.out.println("과자가 한 개 환불되어" + allcount2 +" 개 이며 누적금액" + money + " 원 입니다..");

                                System.out.println("계속환불하시겠습니까? 1.예 2.아니오");

                                choice = sc.nextInt();

                                if(choice == 1) {

                                    System.out.println(" 어떤 것을 환불하시겠습니까? ");

                                } else{

                                    refund++;

                                }

                            } else {

                                System.out.println("구입 한 적이 없어 환불불가.");

                                refund++;

                            }



                        } else if(choice == 3){

                            if(allcount3 > 0){

                                allcount3 = countrefund(allcount3) ;

                                money = moneyrefund(money,peach);

                                count3--;

                                System.out.println("과자가 한 개 환불되어" + allcount3 +" 개 이며 누적금액" + money + " 원 입니다..");

                                System.out.println("계속환불하시겠습니까? 1.예 2.아니오");

                                choice = sc.nextInt();

                                if(choice == 1) {

                                    System.out.println(" 어떤 것을 환불하시겠습니까? ");

                                } else{

                                    refund++;

                                }

                            } else {

                                System.out.println("구입 한 적이 없어 환불불가.");

                                refund++;

                            }

                        }

                    }





                } else {

                    money = money - money;

                    allcount1 -= allcount1;

                    allcount2 -= allcount2;

                    allcount3 -= allcount3;

                    count1 -= count1;

                    count2 -= count2;

                    count3 -= count3;

                    System.out.println("전체 환불되었습니다.");

                }

            } else if(choice == 5) {

                int needs = (allcount2%3);

                if(needs % 3 != 0){

                    int need = 3 - needs;

                    System.out.println(" 과자를 추가 구매하여야 합니다. ");

                    System.out.println(" 현재 과자의 갯수가 " + allcount2 + "개 이며");

                    System.out.println(need + " 개를 더 구매하여야 합니다.");

                } else if (allcount3 < allcount2) {

                    int need = allcount2 - allcount3;

                    System.out.println(" 북숭아가 과자보다 적어 추가 구매하여야 합니다. ");

                    System.out.println(" 현재 과자의 갯수가 " + allcount2 + "개 이고 복숭아가" + allcount3 + "개 이니");

                    System.out.println(need + " 개를 더 구매하여야 합니다.");

                } else{

                    System.out.println("오늘의 매출 : " + money);

                    System.out.println((allcount1 > 0)? "껌 x" + allcount1 + "개 : " +(gum*allcount1) : "");

                    System.out.println((allcount2 > 0)? "과자 x" + allcount2 + "개 : " +(chip*allcount2) : "");

                    System.out.println((allcount3 > 0)? "복숭아 x" + allcount3 + "개 : " +(peach*allcount3) : "");

                    stop++;

                }

            }

        }

    }

    public static void menu(int count, String food, int money , int people) {

        System.out.print(people + " 번 째 사람이 " + food + "를 " + count + " 번 째 주문하셨습니다 누적 금액은 " + money + " 원 입니다.");

    }

    public static int foodcount(int choice, int count) {

        if(choice <=3) {

            count++;

        }

        return count;

    }

    public static int allmoney(int money, int food) {

        money = money+food;

        return money;



    }

    public static int countrefund(int count) {

        count--;

        return count;

    }

    public static int moneyrefund(int money, int food) {

        money = money-food;

        return money;

    }

}