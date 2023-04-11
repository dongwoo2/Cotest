import java.util.Scanner;

//4344번
public class studentaverage {
    //콘솔 입력할 때 다음 줄로 이동하여 깔끔하게 예저처럼 보이고 싶은데 잘 안됨

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt(); // 테스트 케이스 수
        int n = 0;			  // 학생 수
        double result; 	  // 결과 몇%

        for(int i = 0; i < c; i++) { //테스트 케이스 수 만큼 돌림
            int sum = 0; //합계
            int avr = 0; //평균
            int count = 0; // 평균이상의 사람들 카운트

            n=sc.nextInt(); //학생 수
            int score[] = new int[n]; //학생 점수
            for(int j = 0; j<n; j++) { //학생 수 만큼 for문 돌리고
                score[j] = sc.nextInt(); // score[j] 에점수 입력
                sum += score[j]; //sum에 입력한 점수 합치기
            }

            avr = (sum/n);
            for(int k = 0; k<score.length; k++){ //평균보다 높은 점수를 찾아내는 포문
                if(score[k]>avr)
                    count ++;
            }
            result = (double)count/n*100; //count와 n을 int 로 만들어서 정수처리만 됨 강제로 double로 변환시켜 실수도 처리할 수 있게끔 생성
            System.out.printf("%.3f",result); //소수점 3자리
            System.out.println("%");

        }
        sc.close();
    }

}