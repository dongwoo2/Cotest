package teacherstudyre;

import java.util.Random;

public class Study20240205_1_2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ants = new int[4];
        int[] touchs = new int[4];
        int[] ranking = new int[4];
        int[] rankingtime = new int[4];
        int rankingcheck = 0;
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
                    if(i == 1 && touchs[i] == 0) { //1번 개미
                        ants[i]++;
                    } else if(i == 1 && touchs[i] != 0) {
                        ants[i]--;
                    }
                    if (i == 2 && touchs[i] == 0) { //2번 개미
                        ants[i]--;
                    } else if(i == 2 && touchs[i] != 0) {
                        ants[i]++;
                    }
                    if (i == 3 && touchs[i] == 0) { //3번 개미
                        ants[i]++;
                    } else if(i == 3 && touchs[i] != 0) {
                        ants[i]--;
                    }
                }


                if(ants[i] == 0 || (ants[i] > 23 && ants[i] < 100)) {
                    ants[i] = 101;
                    rankingcheck++;
                    if(rankingcheck == 1) {
                        ranking[1] = i;
                        rankingtime[1] = minute;
                    }
                    if(rankingcheck == 2) {
                        ranking[2] = i;
                        rankingtime[2] = minute;
                    }
                    if(rankingcheck == 3) {
                        ranking[3] = i;
                        rankingtime[3] = minute;
                    }
                }
                if(rankingcheck == 3) {
                    flag = false;
                }

                System.out.println("ants[" +i+"] : " + ants[i]);
            }
        }
        System.out.println("1등 : " +  ranking[1] + "번 개미\n도착시간 : " + rankingtime[1]);
        System.out.println("2등 : " +  ranking[2] + "번 개미\n도착시간 : " + rankingtime[2]);
        System.out.println("3등 : " +  ranking[3] + "번 개미\n도착시간 : " + rankingtime[3]);
    }
}


