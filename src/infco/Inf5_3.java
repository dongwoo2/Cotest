package infco;

import java.util.Scanner;
import java.util.Stack;

public class Inf5_3 {

    public static void main(String[] args) {

        Inf5_3 T = new Inf5_3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();

        int [] move = new int[m];
        for(int k = 0; k < m; k++) {
            move[k] = sc.nextInt();
        }
        System.out.println(T.solution(board, move));
    }

    public int solution(int [][]board, int []move) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
//		stack.push(0);

        for(int moves : move) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves-1] != 0) {
                    if(!stack.empty() && board[j][moves-1] == stack.peek()) {
                        answer += 2;
                        stack.pop();
                        board[j][moves-1] = 0;
                        break;
                    } else {
                        stack.push(board[j][moves-1]);
                        board[j][moves-1] = 0;
                        break;
                    }
                }
            }

        }



        return answer;
    }
}