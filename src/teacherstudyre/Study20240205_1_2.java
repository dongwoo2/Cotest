package teacherstudyre;

import java.util.Random;

public class Study20240205_1_2 {

    public static void main(String[] args) {
        Random random = new Random();
        int [] ants = new int[4];

        // 개미 초기 위치 설정
        ants[1] = random.nextInt();
        int minute = 0;
        boolean flag = true;
        while (flag) {
            minute++;
            for(int i = 1; i<=3; i++) {
                ants[i]++;
                if(ants[i] < ants[i-1] && ants[i] < ants[i+1]) {

                }
            }
        }
    }
}

