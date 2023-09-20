package infco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person1 {
    int id;
    int risk;

    public Person1(int id, int risk) {
        this.id = id;
        this.risk = risk;
    }
}

public class Inf5_8_2 {

    public static void main(String[] args) {

        Inf5_8_2 T = new Inf5_8_2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int []arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }

    public int solution(int n, int k, int[]arr) {
        int result = 0;


        Queue<Person1> q = new LinkedList<Person1>();

        for(int i = 0; i < n; i++) {
            q.offer(new Person1(i, arr[i]));
        }

        while(!q.isEmpty()) {
            Person1 tmp = q.poll();
            for(Person1 x : q) {
                if(x.risk > tmp.risk) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                result++;
                if(k == tmp.id) {
                    return result;
                }
            }
        }

        return result;
    }

}
