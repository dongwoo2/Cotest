package teacherstudyre;


import java.util.Scanner;

// 장애물 위치 - 이것도 이차원 배열 위치안에서
// 목적지 위치 - 같음
//
public class Study20241113_2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] map= new int[100][100];
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
        map = setting_first(map,mapgaro,mapsero,lobot_start_garo,lobot_start_sero, obstacle_garo,obstacle_sero);
    }


    public static int[][] setting_first(int[][] map, int mapgaro, int mapsero, int lobotgaro, int lobotsero, int obstacle_garo, int obstacle_sero){
        map[obstacle_garo][obstacle_sero] = 99; // 장애물 99
        int garoset = 0;
        int seroset = 0;
        for(int i = 0; i < mapgaro; i++) {
            for(int j = 0; j < mapsero; j++) {
                if(map[i][j] == 99) {
                    continue;
                }
                map[lobotgaro][lobotsero] = 0;
                if(lobotgaro > i) { // 가로에서 지금 순서가 로봇보다 위에 있을 때
                    garoset = lobotgaro - i;
                } else if(lobotgaro == i) { // 같은 가로에 있을 때
                    garoset = 0;
                } else { // 가로에서 지금 순서가 로봇보다 아래에 있을 때
                    garoset = i - lobotgaro;
                }
                if(lobotsero > j) { // 세로에서 지금 순서가 로봇보다 왼쪽에 있을때
                    seroset = lobotsero - j;
                } else if (lobotsero == j) { // 같은 세로에 있을 때
                    seroset = 0;
                } else {
                    seroset = lobotsero - j; // 로봇보다 오른쪽에 있을 때
                }

                if(garoset == 1 && seroset == 1) {
                    map[i][j] = 2;
                } else if (garoset == 1 && seroset > 0) {
                    map[i][j] = seroset;
                } else if (garoset > 0  && seroset == 1) {
                    map[i][j] = garoset;
                }
                // 5번 다 도는데
                // 일단 시작위치 기준으로
                // 로봇이랑 거리가 1이면 값 1, 2이면 2, 3이면 3 최대는 8 최대 8을 어떻게 지정이 되는지
            }
        }
        for(int t = 0; t < mapgaro; t++){
            System.out.println(" ");
            for(int k = 0; k < mapsero; k++) {
                System.out.print(map[t][k]);
            }
        }

        return map;
    }



    /**
    public int[][] goBack(int[][] map) { // 앞뒤



        return map;
    }

    public int[][] upDown() { // 위아래

    }
     **/
}
