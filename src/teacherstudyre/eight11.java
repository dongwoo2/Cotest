package teacherstudyre;

import java.util.Scanner;

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


 */
public class eight11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;

//     if(b>a){
//         c = a + b;
//     }else {
//         c = (a+b) - 300;
//     }
//        d = a + b + c;
//        e = d * 3;
//        f = (d + e) + 5000;
//        g = f * 2;



        if(5000<=a && a<=10000){
            System.out.println(a + "는 5000이상 10000이하의 숫자입니다.");
            if(b>=4000){
                System.out.println(b + "는 4000 이상의 숫자가 들어있고," + a +  "보다 클 수도 있고, 작을 수도 있습니다.");
                if(b>a){
                    System.out.println(" 단, b가 a보다 크다면 c는 "+ a +"와 "+ b +"의 합입니다.");
                    c = a + b;
                }else {
                    c = (a+b) - 300;
                    System.out.println( b + "가 "+ a +"보다 작다면 c는 " + a + "와 "+ b +"의 합에서 -300입니다. ");
                }
                int d1 = (a+b+c);
                if(d != d1){
                    System.out.println(" d가 잘못되었습니다. ");
                }else {
                    System.out.println(d+ "는 " +a+ " 와 " + b + "와"  + c + "를  합친수 입니다.");
                }
                if(e > d*3){
                    System.out.println("e가 잘못되었습니다.");
                }else {

                }
                int f1 = (d + e) + 5000;
                if(f < f1){
                    System.out.println("f가 잘못되었습니다.");
                }
                int g1 = f1*2;
                if(g != g1){
                    System.out.println("g가 잘못되었습니다.");
                }

            }
        }else {
            System.out.println("a가 잘못되었습니다.");
        }
    }

}
