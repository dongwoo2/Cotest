package infco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inf5_7 {

    public static void main(String[] args) {
        result();
    }

    public static void result() {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String subject = sc.next();
        System.out.println(solution2(n, subject));

    }

    public static String solution2(String n, String subject) {
        String answer = "YES";

        Queue<Character> q = new LinkedList<Character>();

        for(char x : n.toCharArray()) {
            q.offer(x);
        }

        for(char x : subject.toCharArray()) {
            if(q.contains(x)) {
                if(q.peek() == x) {
                    q.poll();
                } else {
                    return "NO";
                }
            }
        }
        if(!q.isEmpty()){
            return "NO";
        }

        return answer;
    }

//	public static String solution(String n, String subject) {
//		String answer = "YES";
//
//		Queue<Character> q = new LinkedList<Character>();
//
//		for(char x : n.toCharArray()) {
//			q.offer(x);
//		}
//
//		for(char x : subject.toCharArray()) {
//			if(q.contains(x)) {
//				if(q.poll() != x) {
//					return "NO";
//				}
//			}
//		}
//		if(!q.isEmpty()){
//			return "NO";
//		}
//
//		return answer;
//	}
}
