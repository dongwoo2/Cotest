package teacherstudyre;

import java.util.Random;
import java.util.Scanner;
/*
        북
    1 2 3 4 6
서  ㅇ 6 7 8 5   동
    9 ㅈ 2 3 4
    4 ㅣ 6 7 8
        남
 */
public class Main50 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int map[][] = new int[5][5];
        boolean visited[][] = new boolean[5][5];

        for (int i=0; i < map.length; i++) {
            for (int j=0; j < map[i].length; j++) {
                map[i][j] = random.nextInt(2);
                if (map[i][j] == 1) {
                    break;
                }
            }
        }

        int startX = 0;
        int startY = 0;

        while (true) {
            System.out.println("로봇의 시작 x 좌표를 입력해 주세요 ");
            startX = scanner.nextInt();
            System.out.println("로봇의 시작 y 좌표를 입력해 주세요 ");
            startY = scanner.nextInt();

            // 장애물에서 시작할 수 없다.
            if (map[startX][startY] != 1) {
                break;
            } else {
                System.out.println("장애물에서 시작 위치를 지정하실 수 없습니다.");
            }
        }

        System.out.println("로봇의 종점 x 좌표를 입력해 주세요 ");
        int destX = scanner.nextInt();
        System.out.println("로봇의 종점 y 좌표를 입력해 주세요 ");
        int destY = scanner.nextInt();

        findPath(startX,startY,destX,destY,map,visited);
    }


    public static void findPath(int startX, int startY, int destX, int destY, int map[][], boolean visited[][]) {
        while (true) {
            if (startX == destX && startY == destY) {
                System.out.println("목적지에 도착했습니다.");
                break;
            }

            int deltaX = destX - startX; // x 좌표의 목적지 까지의 거리
            int deltaY = destY - startY; // y 좌표의 목적지 까지의 거리

            // 맨해튼 거리를 줄이도록 이동
            // 맨허튼 거리가 작을수록 최단경로
            // |x1 - x2| + |y1 - y2|

            // 1. 목적지 까지의 x 방향을 먼저 고려할지 , 목적지 까지의 y 방향을 먼저 고려할지 상대적인 거리의 차로 계산한다.

            // x 방향 우선
            if (Math.abs(deltaX) >= Math.abs(deltaY)) {
                if (deltaX > 0 && startX + 1 < map[0].length && !check_wall(map, startX + 1, startY) && !visited[startX + 1][startY]) {
                    // 동쪽
                    print_arr(map);
                    startX++;
                    visited[startX][startY] = true;
                } else if (deltaX < 0 && startX - 1 >= 0 && !check_wall(map, startX - 1, startY) && !visited[startX - 1][startY]) {
                    // 서쪽
                    print_arr(map);
                    startX--;
                    visited[startX][startY] = true;
                } else if (deltaY > 0 && startY + 1 < map.length && !check_wall(map, startX, startY + 1) && !visited[startX][startY + 1]) {
                    // 남쪽
                    print_arr(map);
                    startY++;
                    visited[startX][startY] = true;
                } else if (deltaY < 0 && startY - 1 >= 0 && !check_wall(map, startX, startY - 1) && !visited[startX][startY - 1]) {
                    // 북쪽
                    print_arr(map);
                    startY--;
                    visited[startX][startY] = true;
                } else {
                    System.out.println("현재 위치: startX " + startX + " startY " + startY);
                    System.out.println("이동할 수 없습니다. 막혔습니다!");
                    break;
                }
            } else {
                // y 방향 우선
                if (deltaY > 0 && startY + 1 < map.length && !check_wall(map, startX, startY + 1) && !visited[startX][startY + 1]) {
                    //
                    print_arr(map);
                    startY++;
                    visited[startX][startY] = true;
                } else if (deltaY < 0 && startY - 1 >= 0 && !check_wall(map, startX, startY - 1) && !visited[startX][startY - 1]) {
                    print_arr(map);
                    startY--;
                    visited[startX][startY] = true;
                } else if (deltaX > 0 && startX + 1 < map[0].length && !check_wall(map, startX + 1, startY) && !visited[startX + 1][startY]) {
                    print_arr(map);
                    startX++;
                    visited[startX][startY] = true;
                } else if (deltaX < 0 && startX - 1 >= 0 && !check_wall(map, startX - 1, startY) && !visited[startX - 1][startY]) {
                    print_arr(map);
                    startX--;
                    visited[startX][startY] = true;
                } else {
                    System.out.println("현재 위치: startX " + startX + " startY " + startY);
                    System.out.println("이동할 수 없습니다. 막혔습니다!");
                    break;
                }
            }
            System.out.println("현재 위치: startX " + startX + " startY " + startY);
        }
    }

    public static boolean check_wall(int map[][], int startX, int startY) {
        if (map[startX][startY] == 1) {
            // 장애물
            return true;
        } else {
            // 통과할 수 있는 길
            return false;
        }
    }

    public static void print_arr(int map[][]){
        for (int i=0; i < map.length; i++) {
            System.out.print(" [ ");
            for (int j=0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " , ");
            }
            System.out.print(" ] ");
            System.out.println();
        }
    }

}


