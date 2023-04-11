import java.util.Scanner;

public class time { //2884번

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int RT = 0;
        int H;
        int M;
        boolean count;

        while(true) {
            H = sc.nextInt(); //만약 범위를 초과하는 값을 집어넣으면 계속 그 값이 적용이 되게 count = false 쪽에 있는 무한루프가 발생함
            M = sc.nextInt(); //그래서 while 문 안쪽에 집어놓고 초기화를 시켜주어야함
            boolean checkH = ((H >= 0 && H< 24)? true : false);
            boolean checkM = ((M >= 0 && M< 60)? true : false);

            if(checkH == true && checkM == true){
                if(M < 45) { //m이 45보다 작으면
                    --H; //1시간 마이너스
                    RT = 60 + (M - 45); // M에서 45빼고 60을 더한 값을 결과값으로 지정
                    if(H <= 0) { //H가 0보다 작을시 H를 23으로 설정
                        H = 23;
                    }
                } else  { // M값이 45보다 크거나 같으면이 설정되는듯
                    RT = (M - 45);
                }
                System.out.println(H + " " + RT);
                count = true;

            } else {
                System.out.println("범위초과 다시 입력하시오");
                count= false; //false 이기에 while문 재반복
            }
            if(count == true){ //true 값이 오면 while문 나감
                break;
            }
        }
        sc.close(); //close가 while 안에 있으면 한 번 true이든 false이든 한 번에 끝남 while문의 끝에 close가 있기에 스캐너가 죽음
    }

}
