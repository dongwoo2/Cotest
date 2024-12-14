package teacherstudyre;

import java.util.Scanner;

public class test2 {

    static int result_cnt = 0;
    static int find = 0;
    static int pos[][] = {{0, 1, -1, 0}, {1, 0, 0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int y, x;

        System.out.println("맵의 y크기는?");
        y = scanner.nextInt();
        System.out.println("맵의 x크기는?");
        x = scanner.nextInt();

        char map[][] = new char[y][x];
        int visited[][] = new int[y][x];
        int result[][][] = new int[101][101][3];
        int des_y = 0, des_x = 0;

        int bfs_list[][] = new int[101][3];
        int bfs_cnt = 0;
        int start_y = 0, start_x = 0;


        System.out.println("Map: (도착지점은 D로 표시)");
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                map[i][k] = scanner.next().charAt(0);

                if (map[i][k] == 'D') {
                    start_y = i;
                    start_x = k;
                }
                if (map[i][k] == 'R') {
                    des_y = i;
                    des_x = k;
                }
                if (map[i][k] == '1') {
                    visited[i][k] = 1;
                }
            }
            scanner.nextLine();
        }


//        int cur_direction = 0;
//        System.out.println("로봇의 방향: ");
//        cur_direction = scanner.nextInt();

        int cur_y = start_y, cur_x = start_x;

        bfs_list[bfs_cnt][0] = cur_y;
        bfs_list[bfs_cnt][1] = cur_x;
        bfs_list[bfs_cnt++][2] = 0;
        visited[cur_y][cur_x] = 1;

        int num = BFS(y, x, bfs_cnt, bfs_list, visited, map, result, des_y, des_x);

        int route_y = des_y;
        int route_x = des_x;

        for (int i = 0; i < num; i++) {
            map[result[route_y][route_x][0]][result[route_y][route_x][1]] = 'R';

            for (int k = 0; k < y; k++) {
                for (int p = 0; p < x; p++) {
                    System.out.printf("%c ", map[k][p]);
                }
                System.out.println();
            }
            System.out.println();

            if (result[route_y][route_x][0] == des_y && result[route_y][route_x][1] == des_x) break;

            int temp_y = route_y;
            int temp_x = route_x;
            route_y = result[temp_y][temp_x][0];
            route_x = result[temp_y][temp_x][1];
        }


        System.out.println("현재 위치: (" + des_y + ", " + des_x + ")");


        for (int i = 0; i < num; i++) {
            System.out.println("현재 위치: (" + result[des_y][des_x][0] + ", " + result[des_y][des_x][1] + ")");

            if (result[des_y][des_x][0] == des_y && result[des_y][des_x][1] == des_x) break;

            int temp_y = des_y;
            int temp_x = des_x;
            des_y = result[temp_y][temp_x][0];
            des_x = result[temp_y][temp_x][1];
        }


    }

    public static int BFS(int max_y, int max_x, int bfs_cnt, int bfs_list[][], int visited[][], char map[][], int result[][][], int des_y, int des_x) {

        int num = 0;
        int cur_bfs_cnt = 0;

        while (true) {

            int cur_y = bfs_list[cur_bfs_cnt][0];
            int cur_x = bfs_list[cur_bfs_cnt][1];
            num = bfs_list[cur_bfs_cnt++][2];

//            System.out.printf("%d %d %d\n", cur_y, cur_x, num);


            if (cur_y == des_y && cur_x == des_x) break;

            for (int i = 0; i < 4; i++) {
                int temp_y = cur_y + pos[0][i];
                int temp_x = cur_x + pos[1][i];

                if ((temp_y >= 0 && temp_y < max_y) && (temp_x >= 0 && temp_x < max_x) && visited[temp_y][temp_x] == 0 && map[temp_y][temp_x] != '1') {
//                    System.out.printf("%d %d result: %d %d\n", temp_y, temp_x, cur_y, cur_x);

                    bfs_list[bfs_cnt][0] = temp_y;
                    bfs_list[bfs_cnt][1] = temp_x;
                    bfs_list[bfs_cnt++][2] = num + 1;
                    visited[temp_y][temp_x] = 1;
                    result[temp_y][temp_x][0] = cur_y;
                    result[temp_y][temp_x][1] = cur_x;
                }

            }

        }

        return num;

    }


}
