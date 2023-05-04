package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2588_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        br.close();

        StringBuilder sb = new StringBuilder();

        sb.append(A * (B % 10)); // ex 385) 5
        sb.append('\n');

        sb.append(A * (B % 100)/10); // 8
        sb.append('\n');

        sb.append(A * (B / 100)); // 3
        sb.append('\n');

        sb.append(A * B);

        System.out.println(sb);
    }
}
