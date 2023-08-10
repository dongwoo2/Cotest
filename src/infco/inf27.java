package infco;

import java.util.Scanner;

public class inf27 {
    public static void main(String[] args) {
        inf27 T = new inf27();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr, n, m));
    }

    // 해결방법
    // 입력받은 수를 m개 만큼 잘라서 더해주고 큰값으로 리턴 값을 교체
    // 다음 차례로 넘어갈 때마다 앞의 값은 빼주고 뒤에 값을 더해주는 방법을 사용
    // 시간복잡도를 줄이기 위하여
    public int solution(int[] arr, int n, int m) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < m; i++) { // 첫번째 합 구하기
            sum += arr[i];
        }
        answer = sum; // 첫번째 합 대입

        // 앞에 값은 빼주고 뒤에 값을 더해주며 비교
        for (int i = m; i < n; i++) {
            sum = sum + arr[i] - arr[i - m];
            if (answer < sum) answer = sum;
        }

        return answer;
    }
}
