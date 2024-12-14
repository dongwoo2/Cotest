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
        int choice = 0;
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

        System.out.println("대각선 이동이 가능하게 설정하시겠습니까? 1.예 2.아니오");
        choice = sc.nextInt();
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
        map = setting_first(map, mapgaro, mapsero, lobot_start_garo, lobot_start_sero, obstacle_garo, obstacle_sero, goal_garo, goal_sero, choice);
        goBack(map, mapgaro, mapsero, lobot_start_garo - 1, lobot_start_sero - 1, goal_garo, goal_sero, choice); // 인덱스 조정
    }


    public static int[][] setting_first(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero, int obstacle_garo, int obstacle_sero, int goalgaro, int goalsero, int choice) {

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

        if(choice == 1) {
            for (int i = 0; i < mapgaro; i++) {
                for (int j = 0; j < mapsero; j++) {
                    if (map[i][j] == 99 || map[i][j] == 100) {
                        continue;
                    }
                    map[lobotgaro][lobotsero] = 0;
                    // 로봇가로 로봇세로 뺀 값이둘다 1이 나오면 1만으로도 다 갈 수 있는 애들임
                    if(Math.abs(lobotgaro - i) == 1 && Math.abs(lobotsero - j) == 1) { // 대각으로 움직이니까 로봇주변 다 1
                        map[i][j] = 1;
                    } else if(Math.abs(lobotgaro - i) > Math.abs(lobotsero - j)) { // 큰 값이 거리가 됨
                        map[i][j] = Math.abs(lobotgaro - i);
                    } else if (Math.abs(lobotgaro - i) < Math.abs(lobotsero - j)) { // 큰 값이 거리가 됨
                        map[i][j] = Math.abs(lobotsero - j);
                    } else if (Math.abs(lobotgaro - i) == Math.abs(lobotsero - j)) { // 같을 경우 뺀 값 i,j중 아무거나 써도 됨
                        map[i][j] = Math.abs(lobotsero - j);
                    }
                }
            }
        } else {
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
                    map[i][j] = garoset + seroset;
                }
            }
        }


            return map;
        }



    public static void goBack(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero, int goalgaro, int goalsero, int choice) {

        int cnt = 0;
        if(cnt == 0) {
            printMap(map, mapgaro, mapsero, lobotgaro, lobotsero);
            cnt++;
        }
        // 로봇이 이동할 수 있는 방향 (상, 하, 좌, 우) + 추가 대각선
        // (위 왼쪽 대각), (위 오른쪽 대각) , (아래 왼쪽 대각), (아래 오른쪽 대각), (위, 아래, 왼쪽, 오른쪽)
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1},{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int destinationGaro = goalgaro;
        int destinationSero = goalsero;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int nextGaro = lobotgaro;
            int nextSero = lobotsero;


            // 인접한 칸 중에서 가장 작은 값을 찾기
            // 인접한 칸 중에서 가장 작은 값을 찾고, 목적지에 더 가까운 방향으로 이동하기
            for (int[] direction : directions) {
                int newGaro = lobotgaro + direction[0];
//                System.out.println("direction0 = " + direction[0]);
                int newSero = lobotsero + direction[1];
//                System.out.println("direction1 = " + direction[1]);
                if(newGaro == (destinationGaro - 1) && newSero == (destinationSero - 1) && choice == 1) {
                    nextGaro = (destinationGaro - 1) ;
                    nextSero = (destinationSero - 1);
                    break;
                } else {
                    // 맵의 범위를 벗어나지 않고 장애물이 없는 경우
                    if (newGaro >= 0 && newGaro < mapgaro && newSero >= 0 && newSero < mapsero) {

                        if (map[newGaro][newSero] != 99 && map[newGaro][newSero] < minValue) {
                            // 현재 위치에서 목적지까지의 거리 계산
                            int currentDistance = Math.abs(newGaro - destinationGaro) + Math.abs(newSero - destinationSero);
                            int bestDistance = Math.abs(lobotgaro - destinationGaro) + Math.abs(lobotsero - destinationSero);

                            // 현재 위치에서 목적지까지의 거리가 줄어드는 경우
                            if (currentDistance < bestDistance) {
                                minValue = map[newGaro][newSero];
                                nextGaro = newGaro;
                                nextSero = newSero;
                            }
                        }
                    }
                }
            }

            // 목적지에 도달했거나 더 이상 이동할 수 없는 경우 종료


            // 로봇의 현재 위치를 -1로 설정 (지나간 자리 표시)
            map[lobotgaro][lobotsero] = -1;

            // 로봇의 위치 업데이트
            lobotgaro = nextGaro;
            lobotsero = nextSero;

            // 현재 위치를 0으로 설정
            //map[lobotgaro][lobotsero] = 0;

            // 주변 값 업데이트

            updateMapValues(map, mapgaro, mapsero, lobotgaro, lobotsero, choice);

            // 현재 맵 상태 출력
            printMap(map, mapgaro, mapsero, lobotgaro, lobotsero);
            if (map[nextGaro][nextSero] == 100 || minValue == Integer.MAX_VALUE) {
//                printMap(map, mapgaro, mapsero, lobotgaro, lobotsero);
                break;
            }
        }
    }
    // 주변값을 업데이트 하는 메서드
    // 모든 값을 업데이트하는 메서드
    public static void updateMapValues(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero, int choice) {
        if(choice == 2) {
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
        } else {
            for (int i = 0; i < mapgaro; i++) {
                for (int j = 0; j < mapsero; j++) {
                    if (map[i][j] == 99) continue; // 장애물은 건너뜁니다
                    if (map[i][j] == 100) continue; // 목적지도 건너뜁니다
                    if (map[i][j] == -1) continue;
                    // 로봇가로 로봇세로 뺀 값이둘다 1이 나오면 1만으로도 다 갈 수 있는 애들임
                    if(Math.abs(lobotgaro - i) == 1 && Math.abs(lobotsero - j) == 1) { // 대각으로 움직이니까 로봇주변 다 1
                        map[i][j] = 1;
                    } else if(Math.abs(lobotgaro - i) > Math.abs(lobotsero - j)) { // 큰 값이 거리가 됨
                        map[i][j] = Math.abs(lobotgaro - i);
                    } else if (Math.abs(lobotgaro - i) < Math.abs(lobotsero - j)) { // 큰 값이 거리가 됨
                        map[i][j] = Math.abs(lobotsero - j);
                    } else if (Math.abs(lobotgaro - i) == Math.abs(lobotsero - j)) { // 같을 경우 뺀 값 i,j중 아무거나 써도 됨
                        map[i][j] = Math.abs(lobotsero - j);
                    }

                }
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
                    System.out.print(map[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}

