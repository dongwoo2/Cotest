package teacherstudyre;

import java.util.Random;

public class Study20240205_1_2 {

    public static void main(String[] args) {
        Random random = new Random();
        int [] ants = new int[4];
        int [] touchs = new int[4];
        ants[0] = 100; // 오류방지


        // 개미 초기 위치 설정
        ants[3] = random.nextInt(24);
        ants[2] = ants[3] - random.nextInt(ants[3]);
        while(ants[2] == ants[3]) {
            ants[2] = ants[3] - random.nextInt(ants[3]);
        }
        ants[1] = ants[2] - random.nextInt(ants[2]);
        while(ants[1] == ants[2]) {
            ants[1] = ants[2] - random.nextInt(ants[2]);
        }
        System.out.println("ants1 = " + ants[1]);
        System.out.println("ants2 = " + ants[2]);
        System.out.println("ants3 = " + ants[3]);
        int minute = 0;
        boolean flag = true;
        while (flag) {
            minute++;
            if(t)
        }
    }
}


