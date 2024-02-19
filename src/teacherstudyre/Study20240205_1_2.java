package teacherstudyre;

import java.util.Random;

public class Study20240205_1_2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ants = new int[4];
        int[] touchs = new int[4];
        int[] ranking = new int[3];
        int touch = 0;
        ants[0] = 100; // 오류방지


        // 개미 초기 위치 설정
        ants[3] = random.nextInt(24);
        ants[2] = ants[3] - random.nextInt(ants[3]);
        while (ants[2] == ants[3]) {
            ants[2] = ants[3] - random.nextInt(ants[3]);
        }
        ants[1] = ants[2] - random.nextInt(ants[2]);
        while (ants[1] == ants[2]) {
            ants[1] = ants[2] - random.nextInt(ants[2]);
        }
        touchs[1] = random.nextInt(2);
        touchs[2] = random.nextInt(2);
        touchs[3] = random.nextInt(2);
        System.out.println("ants1 = " + ants[1]);
        System.out.println("ants2 = " + ants[2]);
        System.out.println("ants3 = " + ants[3]);
        int minute = 0;
        boolean flag = true;
        while (flag) {
            minute++;
            for (int i = 1; i <= 3; i++) {
                 // 개미 이동
                if ((ants[i] - ants[i - 1]) == 1) {
                    if(touchs[i] == 0) {
                        touchs[i]++;
                    } else {
                        touchs[i] = 0;
                    }
                    if(touchs[i-1] == 0) {
                        touchs[i - 1]++;
                    } else {
                        touchs[i-1] = 0;
                    }

                    } else { // 개미가 움직이는 방향도 랜덤으로 해볼까? 정해놓지 말고?
                    if(i == 1 && touchs[i] == 0) {
                        ants[i]++;
                    } else if(i == 1 && touchs[i] != 0) {
                        ants[i]--;
                    }

                    if (i == 2 && touchs[i] == 0) {
                        ants[i]--;
                    } else if(i == 2 && touchs[i] != 0) {
                        ants[i]++;
                    }
                    if (i == 3 && touchs[i] == 0) {
                        ants[i]++;
                    } else if(i == 3 && touchs[i] != 0) {
                        ants[i]--;
                    }
                }


                if(ants[i] < 0 || ants[i] > 24) {
                    if(ranking[1] == 0) {
                        
                    }

                }

            }
        }
    }
}


