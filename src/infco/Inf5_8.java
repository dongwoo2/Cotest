package infco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int risk;

    public Person(int id, int risk) {
        this.id = id;
        this.risk = risk;
    }
}

public class Inf5_8 {

    public static void main(String[] args) {
        Inf5_8 T = new Inf5_8();
        T.result();
    }

    public void result() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }


    public int solution(int n, int k ,int[]arr) {
        int result = 0;

        Queue<Person> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();

            for (Person x : q) {
                if (x.risk > tmp.risk) {
                    q.offer(tmp);
                    tmp = null; // 맨 뒤로 보낸거 증명
                    break;
                }
            }
            if (tmp != null) { // 맨 뒤로 안보냄
                result++;
                if (tmp.id == k) {
                    return result;
                }
            }

        }

        return result;
    }

}
