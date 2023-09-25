package teacherstudyre;

import java.util.Scanner;

public class Study925_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 몇 개의 숫자를 입력 받으시겠습니까? " );
        int n = sc.nextInt();
        int k = 1;
        int sum = 0;
        int sum2 = 0;
        int x;
        int y;



        while (n>k) {

            if(k==1) {
                System.out.println("처음에 입력받을 숫자");
                x = sc.nextInt();
                k++;

                if (k == 2) {
                    System.out.println(k + " 번째 숫자");
                    y = sc.nextInt();
                    sum = x+y;
                    System.out.println(x + " [본인이 생각한 숫자] " + y + " [본인이 생각한 숫자] = " + sum);

                    sum2 = sum;
                }
            }
            k++;
            System.out.print(k + " 번 째 숫자 :");
            int num = sc.nextInt();
            sum2 += num;

            System.out.println((sum2-num)+"[결과값]"+ num + " [본인이 생각한 숫자] = " + sum2);


        }

    }
}
//        	몇 개의 숫자를 입력받으시겠습니까? : 4
//
//        			처음에 입력받을 숫자 : 1
//        			두 번째 숫자 : 2
//        				1[본인이 생각한 숫자] + 2[본인이 생각한 숫자] = 3
//        				세 번째 숫자 : 5
//        				3[결과값] + 5[본인이 생각한 숫자] = 8[결과값]
//        				네 번째 숫자 : 6
//        				8[결과값] + 6[본인이 생각한 숫자] = 14[결과값]
//            			다섯 번 째 숫자 : 5
//            			14[결과값] + 5[본인이 생각한 숫자] = 19[결과값]

//k++;
//System.out.print(k + " 번 째 숫자 :");
//int num = sc.nextInt();
//sum2 = sum + num;
//System.out.println(sum+"[결과값]"+num + " [본인이 생각한 숫자] = " + sum2);
