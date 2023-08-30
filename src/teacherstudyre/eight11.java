package teacherstudyre;

import java.util.Scanner;
import java.util.function.BiFunction;

/*

        Scanner sc= new Scanner(System.in);

        System.out.println("이름 : ");
        String name = sc.next();

        System.out.println("name = " + name);




        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 사람 이름 : ");
        String name1 = sc.next();
        System.out.println("두번째 사람 이름 : ");
        String name2 = sc.next();
        System.out.println("세번째 사람 이름 : ");
        String name3 = sc.next();

        System.out.println(" km수를 입력해주세요. ");
        int distance = sc.nextInt();
        int answer  = 0;
        int sum = 0;
        answer += distance * 3;




//        System.out.println(" 첫 번째 사람 이름: " + name1);

        System.out.println(name1 + "과 " + name2 + "와 " + name3 + "이 있다." +
                "\t셋의 집은 각각" + distance + "km마다 떨어져 있는 거리에 존재한다.\n" +
                "\t세 명의 집을 차례대로 방문하려면 몇 km를 걸어가야 하는가.\n");

        System.out.println("답 : ");
        int userAnswer = sc.nextInt();

        if(userAnswer == answer){
            System.out.println("정답입니다.");
        }else{
            System.out.println("오답입니다. 답은" +answer+  "입니다.");
        }




 */
/*


    public static void main(String[] args) {

        int a = 1000, b = 2000;
        int sum;
        //1
        sum = mydata1(a, b);
        System.out.println("sum = " + sum);
        //2
        sum = mydata2(a, b);
        System.out.println("sum = " + sum);
    }

    public static int mydata1(int a, int b) {
        return a + b;
    }

    public static int mydata2(int a, int b) {
        return mydata3(a, b);
    }
    public static int mydata3(int a, int b) {
        return a * b;
    }













   Scanner sc = new Scanner(System.in);

           System.out.println(" 숫자를 입력해주세요 ");
           int a = sc.nextInt();
           int b = sc.nextInt();
           int answer = 0;

           answer = a+b;
           System.out.println(a + " + " + b + " = ");
           int userAnswer = sc.nextInt();

           if(answer == userAnswer) {
           System.out.println("정답입니다.");
           System.out.println(a + " 와 " + b + "둘 중 큰 숫자를 선택하시오");
           int userAnswer2 = sc.nextInt();
           if(userAnswer2 == 1){
           if(a>b){
           System.out.println(" 정답입니다. ");
           }
           if(b > a){
           System.out.println(" 오답입니다. ");
           System.out.println(" 정답은 2번입니다. ");
           }
           }
           if(userAnswer2 == 2){
           if(b > a){
           System.out.println(" 정답입니다. ");
           }
           if(a > b){
           System.out.println("오답입니다.");
           System.out.println(" 정답은 1번입니다. ");
           }
           }
           }


        Scanner sc = new Scanner(System.in);
        System.out.println(" 다음 세 가지 중 고르시오 \n 1.감자 2.옥수수 3. 수박 " );
        int ch = sc.nextInt();
        int ch1 = 0;
        int ch2 = 0;
        int money = 0;
        int money1;

        if(ch == 1){
            System.out.println(" 1번 감자를 선택하였습니다 " );
            System.out.println(" 1천원어치, 2천원어치, 3천원어치 " );
            ch1 = sc.nextInt();
            if(ch1 == 1) {
                money = 1000;
            } else if (ch1 == 2) {
                money = 2000;
            }else if (ch1 == 3) {
                money = 3000;
            }
        }else if (ch == 2){
            System.out.println(" 2번 옥수수를 선택하였습니다 " );
            System.out.println(" 4천원어치, 5천원어치, 6천원어치 " );
            ch1 = sc.nextInt();
            if(ch1 == 1) {
                money = 4000;
            } else if (ch1 == 2) {
                money = 5000;
            }else if (ch1 == 3) {
                money = 6000;
            }
        }else if (ch == 3){
            System.out.println(" 3번 수박을 선택하였습니다 " );
            System.out.println(" 10000천원어치, 20000천원어치, 30000천원어치 " );
            ch1 = sc.nextInt();
            if(ch1 == 1) {
                money = 10000;
            } else if (ch1 == 2) {
                money = 20000;
            }else if (ch1 == 3) {
                money = 30000;
            }
        }

        System.out.println(" \n 몇 개를 주문하시겠습니까?");
        ch2 = sc.nextInt();
        System.out.println("총 금액은 " + (money * ch2) + "원 입니다.");

        1. 효율성
        2. 코드 유지/보수
        3. 코드의 재사용성
        4. 중복의 최소화
        @FunctionalInterface
interface FrFunction{
    int cal(int a, int b);
}
public class eight11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 다음 세 가지 중 고르시오 \n 1.감자 2.옥수수 3. 수박 " );
        int ch = sc.nextInt();
        int ch1 = 0;
        int ch2 = 0;
        int money = 0;
        if(ch == 1){
            System.out.println(" 1번 감자를 선택하였습니다. ");
            System.out.println(" 1천원어치, 2천원어치, 3천원어치 " );
            ch1 = sc.nextInt();

            if(ch1 == 1){
                money = 1000;
            } else if (ch1 == 2) {
                money = 2000;
            } else if (ch1 == 3) {
                money = 3000;
            }
        } else if (ch == 2) {
            System.out.println(" 2번 옥수수를 선택하였습니다. ");
            System.out.println(" 4천원어치, 5천원어치, 6천원어치 " );
            ch1 = sc.nextInt();
            if(ch1 == 1){
                money = 4000;
            } else if (ch1 == 2) {
                money = 5000;
            } else if (ch1 == 3) {
                money = 6000;
            }
        } else if (ch == 3) {
            System.out.println(" 3번 수박을 선택하였습니다. ");
            System.out.println(" 10000천원어치, 20000천원어치, 30000천원어치 " );
            ch1 = sc.nextInt();
            if(ch1 == 1){
                money = 10000;
            } else if (ch1 == 2) {
                money = 20000;
            } else if (ch1 == 3) {
                money = 30000;
            }
        }
        FrFunction f1 = (a,b) -> {return a*b;};
        System.out.println(" \n 몇 개를 주문하시겠습니까?");
        ch2 = sc.nextInt();
        System.out.println("총 금액은 " + (f1.cal(money,ch2)) + "원 입니다.");


    }

}




















        Scanner sc = new Scanner(System.in);
        System.out.println(" 다음 세 가지 중 고르시오 \n 1.감자 2.옥수수 3. 수박 4. 호박" );
        int ch = sc.nextInt();
        int ch1 = 0;
        int ch2 = 0;
        int money = 0;
        int menuNumber = ch == 1?1:(ch==2?2:(ch==3?3:0));

        FrFunction2 allprice;

        if(menuNumber == 0){
            System.out.println("유효한 메뉴가 아닙니다.");
            return;
        }
        if(menuNumber == 1){
            System.out.println(" 1번 감자를 선택하였습니다. ");
            System.out.println(" 1천원어치, 2천원어치, 3천원어치 " );

            allprice = (count) -> count*1000;

        } else if (menuNumber == 2) {
            System.out.println(" 2번 옥수수를 선택하였습니다. ");
            System.out.println(" 4천원어치, 5천원어치, 6천원어치 " );

            allprice = (count) -> (count+3)*1000;
        } else if (menuNumber == 3) {
            System.out.println(" 3번 수박을 선택하였습니다. ");
            System.out.println(" 10000천원어치, 20000천원어치, 30000천원어치 " );

            allprice = (count) -> count*10000;
        }
        else{
            allprice = null;
        }
        if(allprice != null){
            ch1 = sc.nextInt();



            FrFunction f1 = (a,b) -> {return a*b;};
            System.out.println(" \n 몇 개를 주문하시겠습니까?");
            ch2 = sc.nextInt();
            money = allprice.cal2(ch1);
            System.out.println("총 금액은 " + (f1.cal(money,ch2)) + "원 입니다.");
        }



@FunctionalInterface
interface FrFunction{
    int cal(int a, int b);
}
@FunctionalInterface
interface FrFunction2{
    int cal2(int a);
}
 public static void main(String[] args) {
        foodSelect();
    }
    public static int foodSelect(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 감자 2. 옥수수 3. 수박 ");
        int select = sc.nextInt();

        if(select == 1){
            foodPriceSelect("감자",1000,2000,3000);
        }
        if(select == 2){
            foodPriceSelect("옥수수",4000,5000,6000);
        }
        if(select == 3){
            foodPriceSelect("수박",10000,20000,30000);
        }

        return select;
    }
    public static int foodPriceSelect(String food, int price1, int price2, int price3){
        Scanner sc = new Scanner(System.in);
        int allprice = 0;
        System.out.println(food + "를 선택하였습니다.");
        System.out.println(price1 + " " + price2 + " " + price3);
        int select2 = sc.nextInt();
        System.out.println(" 몇 개를 주문하시겠습니까? ");
        int count = sc.nextInt();

        if(select2 == 1) {
            allprice = price1*count;
        }
        if(select2 == 2){
            allprice = price2*count;
        }
        if(select2 == 3){
            allprice = price3*count;
        }
        System.out.println("총 가격은" + allprice + " 원 입니다.");
        return allprice;

    }
     public static void main(String[] args) {
        scoreselect();
    }
    public static int scoreselect(){
        Scanner sc = new Scanner(System.in);
        System.out.print("점수 :");
        int score = sc.nextInt();
        String crd = credit(score);

        System.out.print(" 학점 : " );
        String credit2 = sc.next();
        System.out.println("credit2 = " + credit2);
        System.out.println("crd = " + crd);
        if(crd.equals(credit2)){
            System.out.println(" 올바른 학점입니다. ");
        } else  {
            System.out.println(" 올바르지 않은 학점입니다. ");
        }
        return score; //여기 보이드도 생각해보자 굳이 리턴을 할 필요가 있나
    }

    public static String credit(int score) {


        String edit = "";
        if(score >= 100){
            //System.out.println(" A ");
             edit = "A";
        } else if (score >= 90) {
            //System.out.println(" B " );
             edit = "B";
        } else if (score >= 80) {
            //System.out.println(" C ");
             edit = "C";
        } else if (score >= 70) {
            //.out.println(" D ");
             edit = "D";
        } else if (score >= 60) {
            //.out.println(" E ");
             edit = "E";
        } else if (score >= 50) {
            //System.out.println(" F ");
             edit = "F";
        }

        return edit;
    }



        Scanner sc = new Scanner(System.in);
        String 철수,영희;
        int money = 10000;
        int plus = 0;
        int plus2 = 0;
        int plus3 = 0;
        int plus4 = 0;
        int plus5 = 0;
        int plus6 = 0;
        int choice1 = 0;
        int choice2 = 0;
        int choice3 = 0;
        int choice4 = 0;
        int choice5 = 0;
        int choice6 = 0;
        int choice7 = 0;
        int choice8 = 0;

        System.out.println(" 추가받을 용돈을 적으시오 ");
        plus = sc.nextInt();
        money += plus;
        System.out.println("money = " + money);

        System.out.println("떡볶이 값을 입력하시오" );
        int 떡볶이 = sc.nextInt();
        System.out.println("우동 값을 입력하시오" );
        int 우동 = sc.nextInt();
        System.out.println("과자 값을 입력하시오" );
        int 과자 = sc.nextInt();
        System.out.println("순대 값을 입력하시오" );
        int 순대 = sc.nextInt();
        System.out.println("어묵 값을 입력하시오" );
        int 어묵 = sc.nextInt();

        System.out.println(" 떡볶이를 몇 개 주문하시겠습니까? " );
        choice1 = sc.nextInt();

        if(money <= 떡볶이 * choice1){

            money -=떡볶이 * choice1;
            System.out.println("돈이 " + money + "만큼 부족합니다.");
            System.out.println(" 추가받을 용돈을 적으시오 ");
            plus2 = sc.nextInt();
            money += plus2;
            System.out.println("추가적으로 " + plus2 + " 만큼 용돈을받아" + money + " 원이 되었습니다." );
            System.out.println("떡볶이는" +떡볶이 + "원 입니다." + "남은돈은" + money + " 입니다.");
            System.out.println(" 우동을 몇 개 주문하시겠습니까? " );
            choice5 = sc.nextInt();

            if(money <= 우동 * choice5){
                money -=우동 * choice5;
                System.out.println("돈이 " + money + "만큼 부족합니다.");
                System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 " );
            } else {
                money -= 우동 * choice5;
                System.out.println(" 우동은" + 우동 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                System.out.println(" 과자를 몇 개 주문하시겠습니까? " );
                choice6 = sc.nextInt();

                if(money <= 과자*choice6){
                    money -= 과자 * choice6;
                    System.out.println("돈이 " + money + "만큼 부족합니다.");
                    System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 " );
                } else {
                    money -= 과자 * choice6;
                    System.out.println(" 과자는" + 과자 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                    System.out.println(" 순대를 몇 개 주문하시겠습니까? " );
                    choice7 = sc.nextInt();
                    if(money <= 순대 * choice7){
                        money -= 순대 * choice7;
                        System.out.println("돈이 " + money + "만큼 부족합니다.");
                        System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 " );
                    }else {
                        money -= 순대 * choice7;
                        System.out.println(" 순대는" + 순대 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                        System.out.println(" 어묵을 몇 개 주문하시겠습니까? " );
                        choice8 = sc.nextInt();
                        if(money<= 어묵 * choice8){
                            money -= 어묵 * choice8;
                            System.out.println("돈이 " + money + "만큼 부족합니다.");
                            System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 " );
                        }else {
                            money -= 어묵 * choice8;
                            System.out.println(" 어묵은" + 어묵 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                        }
                    }
                }
            }

        } else {
            money -=떡볶이 * choice1;
            System.out.println(" 떡볶이는" + 떡볶이 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
            System.out.println(" 우동을 몇 개 주문하시겠습니까? " );
            choice3 = sc.nextInt();

            if(money <= 우동 * choice3){
                money -= 우동 * choice3;
                System.out.println("돈이 " + money + "만큼 부족합니다.");
                System.out.println(" 추가받을 용돈을 적으시오 ");
                plus3 = sc.nextInt();
                money += plus3;
                System.out.println("추가적으로 " + plus3 + " 만큼 용돈을받아" + money + " 원이 되었습니다." );
                System.out.println("우동은" + 우동 + "원 입니다." + "남은돈은" + money + " 입니다.");
                System.out.println(" 과자를 몇 개 주문하시겠습니까? " );
                choice2 = sc.nextInt();
                if (money <= 과자 * choice2) {
                    money -= 과자 * choice2;
                    System.out.println("돈이 " + money + "만큼 부족합니다.");
                    System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 ");
                } else {
                    money -= 과자 * choice2;
                    System.out.println("과자는" + 과자 + "원 입니다." + "남은돈은" + money + " 입니다.");
                    System.out.println("순대 몇 개 주문? ");
                    choice1=sc.nextInt();
                    if (money <= 순대 * choice1) {
                        money -= 순대 * choice1;
                        System.out.println("돈이 " + money + "만큼 부족합니다.");
                        System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 ");
                    } else {
                        money -= 순대 * choice1;
                        System.out.println("순대는" + 순대 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        System.out.println(" 어묵을 몇 개 주문하시겠습니까? " );
                        choice2=sc.nextInt();
                        if (money <= 어묵 * choice2) {
                            money -= 어묵 * choice2;
                            System.out.println("돈이 " + money + "만큼 부족합니다.");
                            System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 ");
                        } else {
                            money -= 어묵 * choice2;
                            System.out.println("어묵은" + 어묵 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        }
                    }
                }
            }else {
                money -= 우동 * choice3;
                System.out.println(" 우동은" + 우동 + "원이고" + " 남은 돈은" + money + " 원 입니다.");

                System.out.println(" 과자를 몇 개 주문하시겠습니까? " );
                choice4 = sc.nextInt();
                if(money <= 과자*choice4){
                    money -= 과자 * choice4;
                    System.out.println("돈이 " + money + "만큼 부족합니다.");
                    System.out.println(" 추가받을 용돈을 적으시오 ");
                    plus4 = sc.nextInt();
                    money += plus4;
                    System.out.println("추가적으로 " + plus4 + " 만큼 용돈을받아" + money + " 원이 되었습니다." );
                    System.out.println("과자는" + 과자 + "원 입니다." + "남은돈은" + money + " 입니다.");
                    System.out.println(" 순대를 몇 개 주문하시겠습니까? " );
                    choice1 = sc.nextInt();
                    if (money <= 순대 * choice1) {
                        money -= 순대 * choice1;
                        System.out.println("돈이 " + money + "만큼 부족합니다.");
                        System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 ");
                    } else {
                        money -= 순대 * choice1;
                        System.out.println("순대는" + 순대 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        System.out.println(" 어묵를 몇 개 주문하시겠습니까? " );
                        choice1 = sc.nextInt();

                        if (money <= 어묵 * choice1) {
                            money -= 어묵 * choice1;
                            System.out.println("돈이 " + money + "만큼 부족합니다.");
                            System.out.println(" 이미 용돈을 받았습니다. 주인장에게 쫓겨납니다 ");
                        } else {
                            money -= 어묵 * choice1;
                            System.out.println("어묵은" + 어묵 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        }
                    }
                } else {
                    money -= 과자 * choice4;
                    System.out.println(" 과자는" + 과자 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                    System.out.println(" 순대를 몇 개 주문하시겠습니까? " );
                    choice1=sc.nextInt();

                    if (money <= 순대 * choice1) {
                        money -=순대 * choice1;
                        System.out.println("돈이 " + money + "만큼 부족합니다.");
                        System.out.println(" 추가받을 용돈을 적으시오 ");
                        plus3 = sc.nextInt();
                        money += plus3;
                        System.out.println("추가적으로 " + plus3 + " 만큼 용돈을받아" + money + " 원이 되었습니다." );
                        System.out.println("순대는" + 순대 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        System.out.println(" 어묵을 몇 개 주문하시겠습니까? " );
                        choice2 = sc.nextInt();
                        if (money <= 어묵 * choice2) {
                            money -=어묵 * choice2;
                            System.out.println("돈이 " + money + "만큼 부족합니다.");
                            System.out.println(" 이미 용돈을 받았습니다 주인장에게 쫓겨납니다. ");
                        }else {
                            money -= 어묵 * choice2;
                            System.out.println(" 어묵은" + 어묵 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                        }

//                        if (money <= 어묵 * choice2) {
//                            money -=어묵 * choice2;
//                            System.out.println("돈이 " + money + "만큼 부족합니다.");
//                            System.out.println(" 이미 용돈을 받았습니다 주인장에게 쫓겨납니다. ");
//                        }
                    }else {
                        money -=순대 * choice1;
                        System.out.println(" 순대는" + 순대 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                        System.out.println(" 어묵을 몇 개 주문하시겠습니까? " );
                        choice2 = sc.nextInt();

                        if (money <= 어묵 * choice2) {
                            money -= 어묵 * choice2;
                            System.out.println("돈이 " + money + "만큼 부족합니다.");
                            System.out.println(" 추가받을 용돈을 적으시오 ");
                            plus3 = sc.nextInt();
                            money += plus3;
                            System.out.println("추가적으로 " + plus3 + " 만큼 용돈을받아" + money + " 원이 되었습니다.");
                            System.out.println("어묵은" + 어묵 + "원 입니다." + "남은돈은" + money + " 입니다.");
                        } else {
                            money -= 어묵 * choice2;
                            System.out.println(" 어묵은" + 어묵 + "원이고" + " 남은 돈은" + money + " 원 입니다.");
                        }
                    }
                }
            }
        }



















//2번째 방식

        Scanner sc = new Scanner(System.in);
        int Ejr, dnehd, rhkwk, rlghl = 0, rotn, gkq = 10000, dydehs;
        int rlghl2 = 0;
        System.out.println("추가 용돈 : ");
        dydehs = sc.nextInt();
        gkq = gkq + dydehs;
        System.out.println("총 금액은 " + gkq + "원입니다.");

        System.out.println("떡볶이 가격 : ");
        Ejr = sc.nextInt();
        System.out.println("우동 가격 : ");
        dnehd = sc.nextInt();
        System.out.println("과자 가격 : ");
        rhkwk = sc.nextInt();

        if (rlghl2 == 0) {
            System.out.println("떡볶이 개수 : ");
            rotn = sc.nextInt();
            Ejr = Ejr * rotn;
            gkq = gkq - Ejr;
            if (gkq < 0) {
                if (rlghl != 0) {
                    System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                    rlghl2 = 1;
                }
                if (rlghl == 0) {
                    System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                    dydehs = sc.nextInt();
                    gkq = gkq + dydehs;
                    gkq = gkq + Ejr;
                    System.out.println("현재 " + gkq + "원입니다.");
                    gkq = gkq - Ejr;
                    rlghl = rlghl + 1;
                }
            }
            if (rlghl2 == 0) {
                System.out.println("떡볶이를 주문하고 " + gkq + "원이 되었습니다.");
            }
        }


        if (rlghl2 == 0) {
            System.out.println("우동 개수 : ");
            rotn = sc.nextInt();
            dnehd = dnehd * rotn;
            gkq = gkq - dnehd;
            if (gkq < 0) {
                if (rlghl != 0) {
                    System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                    rlghl2 = 1;
                }
                if (rlghl == 0) {
                    System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                    dydehs = sc.nextInt();
                    gkq = gkq + dydehs;
                    gkq = gkq + dnehd;
                    System.out.println("현재 " + gkq + "원입니다.");
                    gkq = gkq - dnehd;
                    rlghl = rlghl + 1;
                }
            }
            if (rlghl2 == 0) {
                System.out.println("우동을 주문하고 " + gkq + "원이 되었습니다.");
            }
        }


        if (rlghl2 == 0) {
            System.out.println("과자 개수 : ");
            rotn = sc.nextInt();
            rhkwk = rhkwk * rotn;
            gkq = gkq - rhkwk;
            if (gkq < 0) {
                if (rlghl != 0) {
                    System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                    rlghl2 = 1;
                }
                if (rlghl == 0) {
                    System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                    dydehs = sc.nextInt();
                    gkq = gkq + dydehs;
                    gkq = gkq + rhkwk;
                    System.out.println("현재 " + gkq + "원입니다.");
                    gkq = gkq - rhkwk;
                    rlghl = rlghl + 1;
                }
            }
            if (rlghl2 == 0) {
                System.out.println("과자를 주문하고 " + gkq + "원이 되었습니다.");
            }
        }












public class eight11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Ejr, dnehd, rhkwk, rlghl = 0, rotn, gkq = 10000, dydehs;

        System.out.println("추가 용돈 : ");
        dydehs = sc.nextInt();
        gkq = gkq + dydehs;
        System.out.println("총 금액은 " + gkq + "원입니다.");

        System.out.println("떡볶이 가격 : ");
        Ejr = sc.nextInt();
        System.out.println("우동 가격 : ");
        dnehd = sc.nextInt();
        System.out.println("과자 가격 : ");
        rhkwk = sc.nextInt();

        System.out.println("떡볶이 개수 : ");
        rotn = sc.nextInt();
        Ejr = Ejr * rotn;
        gkq = gkq - Ejr;

        if(gkq < 0){
            if(rlghl != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(rlghl == 0){
                System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                dydehs = sc.nextInt();
                gkq = gkq + dydehs;
                gkq = gkq + Ejr;
                System.out.println("현재 " + gkq + "원입니다.");
                gkq = gkq - Ejr;
                rlghl = rlghl + 1;
            }
        }
        System.out.println("떡볶이를 주문하고 " + gkq + "원이 되었습니다.");







        System.out.println("우동 개수 : ");
        rotn = sc.nextInt();
        dnehd = dnehd * rotn;
        gkq = gkq - dnehd;

        if(gkq < 0){
            if(rlghl != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(rlghl == 0){
                System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                dydehs = sc.nextInt();
                gkq = gkq + dydehs;
                gkq = gkq + dnehd;
                System.out.println("현재 " + gkq + "원입니다.");
                gkq = gkq - dnehd;
                rlghl = rlghl + 1;
            }
        }
        System.out.println("우동을 주문하고 " + gkq + "원이 되었습니다.");







        System.out.println("과자 개수 : ");
        rotn = sc.nextInt();
        rhkwk = rhkwk * rotn;
        gkq = gkq - rhkwk;

        if(gkq < 0){
            if(rlghl != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(rlghl == 0){
                System.out.println("현재 " + gkq + "원이 부족합니다.\n\n추가 용돈 : ");
                dydehs = sc.nextInt();
                gkq = gkq + dydehs;
                gkq = gkq + rhkwk;
                System.out.println("현재 " + gkq + "원입니다.");
                gkq = gkq - rhkwk;
                rlghl = rlghl + 1;
            }
        }
        System.out.println("과자를 주문하고 " + gkq + "원이 되었습니다.");



    }
}


 */
public class eight11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Ricake, woodong, chip, choice = 0, count, money = 10000, plusmoney;

        System.out.println("추가 용돈 : ");
        plusmoney = sc.nextInt();
        money = money + plusmoney;
        System.out.println("총 금액은 " + money + "원입니다.");

        System.out.println("떡볶이 가격 : ");
        Ricake = sc.nextInt();
        System.out.println("우동 가격 : ");
        woodong = sc.nextInt();
        System.out.println("과자 가격 : ");
        chip = sc.nextInt();

        System.out.println("떡볶이 개수 : ");
        count = sc.nextInt();
        Ricake = Ricake * count;
        money = money - Ricake;

        if(money < 0){
            if(choice != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(choice == 0){
                System.out.println("현재 " + money + "원이 부족합니다.\n\n추가 용돈 : ");
                plusmoney = sc.nextInt();
                money = money + plusmoney;
                money = money + Ricake;
                System.out.println("현재 " + money + "원입니다.");
                money = money - Ricake;
                choice = choice + 1;
            }
        }
        System.out.println("떡볶이를 주문하고 " + money + "원이 되었습니다.");







        System.out.println("우동 개수 : ");
        count = sc.nextInt();
        woodong = woodong * count;
        money = money - woodong;

        if(money < 0){
            if(choice != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(choice == 0){
                System.out.println("현재 " + money + "원이 부족합니다.\n\n추가 용돈 : ");
                plusmoney = sc.nextInt();
                money = money + plusmoney;
                money = money + woodong;
                System.out.println("현재 " + money + "원입니다.");
                money = money - woodong;
                choice = choice + 1;
            }
        }
        System.out.println("우동을 주문하고 " + money + "원이 되었습니다.");







        System.out.println("과자 개수 : ");
        count = sc.nextInt();
        chip = chip * count;
        money = money - chip;

        if(money < 0){
            if(choice != 0){
                System.out.println("이미 용돈을 추가받았기 때문에 쫓겨납니다.");
                return;
            }
            if(choice == 0){
                System.out.println("현재 " + money + "원이 부족합니다.\n\n추가 용돈 : ");
                plusmoney = sc.nextInt();
                money = money + plusmoney;
                money = money + chip;
                System.out.println("현재 " + money + "원입니다.");
                money = money - chip;
                choice = choice + 1;
            }
        }
        System.out.println("과자를 주문하고 " + money + "원이 되었습니다.");



    }
}






































