package teacherstudyre;

import java.util.Random;

public class Study20240205_1_2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ants = new int[5];
        int[] touchs = new int[5];
        int[] ranking = new int[5];
        int[] rankingtime = new int[5];
        ants[4] = 150;
        int rankingcheck = 0;
        int touch = 0;
        ants[0] = 100; // 오류방지


        // 개미 초기 위치 설정
        ants[3] = random.nextInt(24);
        ants[2] = ants[3] - random.nextInt(ants[3]);
        while (ants[2] == ants[3] || ants[2] > ants[3]) {
            ants[2] = ants[3] - random.nextInt(ants[3]);
        }
        ants[1] = ants[2] - random.nextInt(ants[2]);
        while (ants[1] == ants[2] || ants[1] > ants[2]) {
            ants[1] = ants[2] - random.nextInt(ants[2]);
        }
        touchs[1] = random.nextInt(2);
        touchs[2] = random.nextInt(2);
        touchs[3] = random.nextInt(2);
        System.out.println("ants1 = " + ants[1]);
        System.out.println("touchs1 = " + touchs[1]);
        System.out.println("ants2 = " + ants[2]);
        System.out.println("touchs2 = " + touchs[2]);
        System.out.println("ants3 = " + ants[3]);
        System.out.println("touchs3 = " + touchs[3]);
        int minute = 0;
        boolean flag = true;
        while (flag) {
            minute++;
            System.out.println("================" +minute + "분");
            // 마지막에 확인 하고
            for (int i = 1; i <= 3; i++) {
                 // 개미 이동
                if((ants[i] > 0 && ants[i] < 24) && (ants[i] != ants[i+1] + 1) && (ants[i] + 1 != ants[i+1])) {
                    if(touchs[i] != 0) {
                        ants[i]--;
                    } else {
                        ants[i]++;
                    }
                    // 만약 부딪쳤을 때 제자리에 있어야 한다면
                    // ants[i] -= 1 주석처리하고 ants[i+1]에도 부딪혀서 부딪친거 확인해주는 변수 체크 후 다음순서로 진행안되게 하면 됨
                } else if(((ants[i] > 0 && ants[i] < 24) && (ants[i] == ants[i+1])) || ((ants[i] > 0 && ants[i] < 24) && (ants[i] + 1 == ants[i+1] && (touchs[i] == 0 && touchs[i+1] != 0)))) {
                    ants[i] -= 1;
//                    ants[i+1] += 1;
                    if(touchs[i] != 0) {
                        touchs[i] = 0;
                    } else {
                        touchs[i]++;
                    }
                    if(touchs[i+1] != 0) {
                        touchs[i+1] = 0;
                    } else {
                        touchs[i+1]++;
                    }
                } else if((ants[i] + 1 == ants[i+1]) && (touchs[i] == 0 && touchs[i+1] == 1)) { // 위에랑 소스 중복 함수로 뺴기
                    ants[i] -= 1;
//                    ants[i+1] += 1;
                    if(touchs[i] != 0) {
                        touchs[i] = 0;
                    } else {
                        touchs[i]++;
                    }
                    if(touchs[i+1] != 0) {
                        touchs[i+1] = 0;
                    } else {
                        touchs[i+1]++;
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



                if(i == 99 && (ants[1] == ants[2])) { // 마지막에 확인
                    if(touchs[1] == 0) {
                        touchs[1]++;
                    } else {
                        touchs[1] = 0;
                    }
                    if(touchs[2] == 0) {
                        touchs[2]++;
                    } else {
                        touchs[2] = 0;
                    }
                } else if(i == 3 && (ants[2] == ants[3])) { // 마지막에 확인
                    if(touchs[2] == 0) {
                        touchs[2]++;
                    } else {
                        touchs[2] = 0;
                    }
                    if(touchs[3] == 0) {
                        touchs[3]++;
                    } else {
                        touchs[3] = 0;
                    }
                }
                if(i == 3 && touchs[1] == 0 && touchs[2] == 0) {

                }
            }
        }
        System.out.println("1등 : " +  ranking[1] + "번 개미\n도착시간 : " + rankingtime[1]);
        System.out.println("2등 : " +  ranking[2] + "번 개미\n도착시간 : " + rankingtime[2]);
        System.out.println("3등 : " +  ranking[3] + "번 개미\n도착시간 : " + rankingtime[3]);
    }

    public static void met(int[] ants , int i , int [] touchs) { // 처음에 조건을 잡는게 맞음
        if(ants[i - 1] + 1 != ants[i]) {
            if(touchs[i] != 0) {
                ants[i]--;
            } else {
                ants[i]++;
            }
        } else if (ants[i - 1] + 1 == ants[i]) { // 부딪침
            if(touchs[i] != 0) {
                touchs[i] = 0;
            } else if(touchs[i] == 0) {
                touchs[i]++;
            }
            if(touchs[i] != 0) {
                ants[i]--;
            } else {
                ants[i]++;
            }
        }
    }

}


