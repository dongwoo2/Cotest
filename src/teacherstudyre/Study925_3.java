package teacherstudyre;

import java.util.Scanner;

public class Study925_3 {

    public static void main(String[] args) {

        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 숫자 2개를 입력하시오 ");

        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = n+k;
        int count = 0;
        int oper = 0;
        int cAnswer = 0;
        int choice;
        int temp;
        int count2 = 0;
        int wAnswer2 = 0;
        System.out.println(n + " + " + k + " = ");


        while(true) {

            int answer = sc.nextInt();

            if(sum != answer) {
                System.out.println("오답입니다. 다시 기회가 주어집니다");
                wronganswer(count);
                System.out.println(oper + count + "번 기회");

                if(count == 10) {
                    count = 0;
                    oper++;
                    if(oper > 3) {
                        System.out.println("종료");
                        System.exit(0);
                    }
                }
            }
            if(sum == answer) {
                System.out.println("정답입니다.");
                cAnswer++;
                int wAnswer = (oper*10) + count;

                if(wAnswer > cAnswer) {
                    chan(oper,count);
                    System.out.println("10개 기회추가");
                }

                while(count2<=5) {

                    if (count2 == 0) {
                        System.out.println("1." + n);
                        System.out.println("2." + k);
                        System.out.println(" 둘 중에 더 큰 숫자를 고르시오");

                        choice = sc.nextInt();
                        if ((n > k && choice == 1) || (n < k && choice == 2)) {
                            System.out.println("정답입니다.");
                            System.out.println("다음 문제로 넘어가겠습니다.");
                            count2++;

                        } else {
                            System.out.println("오답입니다. 다시 기회가 주어집니다.");

                            wronganswer(count);
                            count++;
                            if(count == 10) {
                                count = 0;
                                oper++;
                                System.out.print(count);
                                System.out.print(oper);

                                if(oper > 3) {
                                    System.out.println("종료");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    if(count2 > 0) {
                        temp = n;
                        n = k;
                        k = temp;
                        System.out.println(count2 + " 번 문제입니다");
                        System.out.println(" 둘 중에 더 큰 숫자를 고르시오");
                        System.out.println("1." + n);
                        System.out.println("2." + k);
                        choice = sc.nextInt();
                        if((n > k && choice == 1) ||(n < k && choice == 2)) {
                            System.out.println("정답입니다.");
                            break;
                        } else{
                            count2++;
                            wAnswer++;
                            System.out.println("오답입니다.");
                            System.out.println("재도전 기회");
                            if(wAnswer2 == 3) {
                                if(n>k) {
                                    System.out.println("1번이 정답입니다.");
                                    continue;
                                } else{
                                    System.out.println("2번이 정답입니다.");
                                    continue;
                                }
                            }

                        }
                    }
                }
            }

        }

    }



    public static int wronganswer(int count) {
        count++;
        return count;
    }

    public static int chan(int opper,int count) {

        if(opper >=1) {
            opper--;
            return opper;
        } else {
            count = 0;
            return count;

        }

    }
}