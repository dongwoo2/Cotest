package teacherstudyre;


import java.util.Scanner;

// 장애물 위치 - 이것도 이차원 배열 위치안에서
// 목적지 위치 - 같음
//
public class Study20241113_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] map = new int[100][100];
        int mapgaro = 0;
        int mapsero = 0;
        int lobot_start_garo = 0;
        int lobot_start_sero = 0;
        int obstacle_garo = 0; // 장애물
        int obstacle_sero = 0;
        int goal_garo = 0;
        int goal_sero = 0;
        System.out.println("맵의 크기를 정해주세요. 1. 가로 2. 세로");
        mapgaro = sc.nextInt();
        mapsero = sc.nextInt();
        System.out.println("로봇의 위치를 찍어주세요. 1. 가로 2. 세로");
        lobot_start_garo = sc.nextInt();
        lobot_start_sero = sc.nextInt();
        System.out.println("장애물의 위치를 찍어주세요. 1. 가로 2. 세로");
        obstacle_garo = sc.nextInt();
        obstacle_sero = sc.nextInt();
        System.out.println("목적지의 위치를 찍어주세요. 1. 가로 2. 세로");
        goal_garo = sc.nextInt();
        goal_sero = sc.nextInt();
        // 최단 경로 설정을 어떻게?
        // [0][0] [0][1] [0][2] [0][3] [0][4]
        // [1][0] [1][1] [1][2] [1][3] [1][4]
        // [2][0] [2][1] [2][2] [2][3] [2][4]
        // [3][0] [3][1] [3][2] [3][3] [3][4]
        // [4][0] [4][1] [4][2] [4][3] [4][4]

        // 0에서 시작한다고 하면
        // 장애물 값 99
        // 맵에 초기값을 어떻게 주지 그냥 거리에 따라 줄까
        //
        map = setting_first(map, mapgaro, mapsero, lobot_start_garo, lobot_start_sero, obstacle_garo, obstacle_sero, goal_garo, goal_sero);
        goBack(map, mapgaro, mapsero, lobot_start_garo - 1, lobot_start_sero - 1); // 인덱스 조정
    }


    public static int[][] setting_first(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero, int obstacle_garo, int obstacle_sero, int goalgaro, int goalsero) {

        int garoset = 0;
        int seroset = 0;
        lobotgaro -= 1;
        lobotsero -= 1;
        obstacle_garo -= 1;
        goalgaro -= 1;
        goalsero -= 1;
        obstacle_sero -= 1;
        map[obstacle_garo][obstacle_sero] = 99; // 장애물 99
        map[goalgaro][goalsero] = 100;
        for (int i = 0; i < mapgaro; i++) {
            for (int j = 0; j < mapsero; j++) {
                if (map[i][j] == 99 || map[i][j] == 100) {
                    continue;
                }
                map[lobotgaro][lobotsero] = 0;
                if (lobotgaro == i && lobotsero < j) { // 같은 가로에 있고 세로열이 지금 열보다 왼쪽에 있을경우
                    garoset = 0;
                    seroset = j - lobotsero;
                } else if (lobotgaro == i && lobotsero > j) { // 같은 가로에 있고 세로열이 지금 열보다 오른쪽에 있을경우
                    garoset = 0;
                    seroset = lobotsero - j;
                } else if (lobotgaro < i && lobotsero == j) { // 로봇의 위치보다 밑에 있고 세로가 같을 경우
                    garoset = i - lobotgaro;
                    seroset = 0;
                } else if (lobotgaro < i && lobotsero < j) { // 로봇의 위치보다 밑에 있고 세로가 오른쪽에 있을경우
                    garoset = i - lobotgaro;
                    seroset = j - lobotsero;
                } else if (lobotgaro < i && lobotsero > j) { // 로봇보다 밑에 있고 왼쪽에 있을 경우
                    garoset = i - lobotgaro;
                    seroset = lobotsero - j;
                } else if (lobotgaro > i && lobotsero == j) { // 로봇의 위치보다 위에 있고 세로가 같을 경우
                    garoset = lobotgaro - i ;
                    seroset = 0;
                } else if (lobotgaro > i && lobotsero < j) { // 로봇의 위치보다 위에 있고 세로가 오른쪽에 있을경우
                    garoset = lobotgaro - i;
                    seroset = j - lobotsero;
                } else if (lobotgaro > i && lobotsero > j) { // 로봇보다 위에 있고 왼쪽에 있을 경우
                    garoset = lobotgaro - i;
                    seroset = lobotsero - j;

                }
                    // 5번 다 도는데
                    // 일단 시작위치 기준으로
                    // 로봇이랑 거리가 1이면 값 1, 2이면 2, 3이면 3 최대는 8 최대 8을 어떻게 지정이 되는지
                map[i][j] = garoset + seroset;
                }
            }
            for (int t = 0; t < mapgaro; t++) {
                System.out.println(" ");
                for (int k = 0; k < mapsero; k++) {

                    System.out.print(map[t][k] + " ");
                    // TODO if 로봇의 위치일경우 로봇이렇게 표기
                }
            }


            return map;
        }



    public static void goBack(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero) {
        // 로봇이 이동할 수 있는 방향 (상, 하, 좌, 우)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // (위, 아래, 왼쪽, 오른쪽)

        while (true) {
            int minValue = Integer.MAX_VALUE;
            int nextGaro = lobotgaro;
            int nextSero = lobotsero;

            // 인접한 칸 중에서 가장 작은 값을 찾기
            for (int[] direction : directions) {
                int newGaro = lobotgaro + direction[0];
                int newSero = lobotsero + direction[1];

                // 맵의 범위를 벗어나지 않고 장애물이 없는 경우
                if (newGaro >= 0 && newGaro < mapgaro && newSero >= 0 && newSero < mapsero) {
                    if (map[newGaro][newSero] != 99 && map[newGaro][newSero] < minValue) {
                        minValue = map[newGaro][newSero];
                        nextGaro = newGaro;
                        nextSero = newSero;
                    }
                }
            }

            // 목적지에 도달했거나 더 이상 이동할 수 없는 경우 종료
            if (map[nextGaro][nextSero] == 100 || minValue == Integer.MAX_VALUE) {
                break;
            }

            // 로봇의 현재 위치를 -1로 설정 (지나간 자리 표시)
            map[lobotgaro][lobotsero] = -1;

            // 로봇의 위치 업데이트
            lobotgaro = nextGaro;
            lobotsero = nextSero;

            // 현재 위치를 0으로 설정
            //map[lobotgaro][lobotsero] = 0;

            // 주변 값 업데이트
            updateMapValues(map, mapgaro, mapsero, lobotgaro, lobotsero);

            // 현재 맵 상태 출력
            printMap(map, mapgaro, mapsero, lobotgaro, lobotsero);
        }
    }
    // 주변값을 업데이트 하는 메서드
    // 모든 값을 업데이트하는 메서드
    public static void updateMapValues(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero) {
        for (int i = 0; i < mapgaro; i++) {
            for (int j = 0; j < mapsero; j++) {
                if (map[i][j] == 99) continue; // 장애물은 건너뜁니다
                if (map[i][j] == 100) continue; // 목적지도 건너뜁니다
                if (map[i][j] == -1) continue;
                // 로봇과의 거리 계산
                int distance = Math.abs(lobotgaro - i) + Math.abs(lobotsero - j);
                map[i][j] = distance; // 거리로 업데이트
            }
        }
    }
    // 맵을 출력하는 메서드
    public static void printMap(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero) {
        for (int i = 0; i < mapgaro; i++) {
            for (int j = 0; j < mapsero; j++) {
                if (i == lobotgaro && j == lobotsero) {
                    System.out.print("로봇 "); // 로봇의 위치 표시
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}

