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
 */
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
