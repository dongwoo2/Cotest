import java.util.Scanner;

public class sugar { //2839번

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0; //설탕무게
        int tcount = 0; //봉지갯수

        n= sc.nextInt();

        while(true) {
            if(n%5==0){ //[1] 5로 나눠지면
                System.out.println(n/5 + tcount); // n이 20이면 4+0 = 4 나옴
                break;
            } else if(n<=0) { //[2] n이 0보다 작으면 조건 성립 -1 출력
                System.out.println("-1");
                break;
            }
            n -= 3; // 위에 [1],[2] 조건에 걸리지 않으면 n에서 3을 빼고 tcount에 +1
            tcount ++;
        }
        sc.close();
    }

}