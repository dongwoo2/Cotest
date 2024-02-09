package teacherstudyre;

// 0부터 24까지 가는 것을 순위로 매긴다고 했을 시
public class Study20240205_1 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int line[] = new int[24];
        int ant1 = 4;
        int ant2 = 11;
        int ant3 = 18;
        int se1 = 0; //첫번째 개미가 부딪친 걸 알려줄 변수
        int se2 = 0;
        int se3 = 0;
        //se가 0이라면 정상적으로 진행 아니라면 반대로 진행
        int minute = 0; // 분
        int one = 0;
        int two = 0;
        int three = 0;

        while (true) { // 3개의 모든 개미가 도착하면 끝
            // 개미 하나 하나 따로 분리해서 더하고 넣고 하는게 더 좋을 거 같네
            minute++;
            if (ant1 > 0 && ant1 <= 24 && se1 == 0 && ant1 != ant2) {
                ant1++;
            } else if (ant1 > 0 && ant1 <= 24 && se1 != 0 && ant1 != ant2) {
                ant1--;
            }

            if(ant2 > 0 && ant2 <= 24 && se2 == 0 && ant2 != ant1) {
                ant2++;
            } else if(ant2 > 0 && ant2 <= 24 && se2 != 0 && ant2 != ant1) {
                ant2--;
            }
            if(ant1 == ant2) {
                se1++;
                se2++;
            }
            if(ant3 > 0 && ant3 <= 24 && se3 == 0 && ant3 != ant2) {
                ant3++;
            } else if (ant3 > 0 && ant3 <= 24 && se3 != 0 && ant3 != ant2) {
                ant3--;
            }
            if(ant1 == 0 || ant1 > 24) {
                ant1 = 99;
                if(one != 0) {
                    if(two != 0) {
                        three = minute;
                    }
                }
            }

        }
    }

}
