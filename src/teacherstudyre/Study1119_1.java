package teacherstudyre;

import java.util.Scanner;

public class Study1119_1 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.println(100%26);
        int answer = 0;
        String oneman = "";
        String twoman = "";
        int count1 = 0;
        int count2 = 0;
        int hint = 0;
        int hint1Count = 0;
        int panelty = 0;
        int turn = 1;
        int oriA = 0;
        int k = 0,t = 0;

        int cnt = 0;
        answer = numbers(answer);

        System.out.print("1번 플레이어 이름 입력 : ");
        oneman = sc.next();
        System.out.print("2번 플레이어 이름 입력 : ");
        twoman = sc.next();

        System.out.println(oneman + "님, " + twoman + "님 반갑습니다." );

        System.out.println("1.플레이어가 제시한 숫자보다 크거나 작을 시 컴퓨터가 알려줍니다.그럼 게임을 시작하겠습니다. ");
        System.out.println(oneman + "님 부터 시작합니다. ");
        while (cnt != 1) {

            if((hint == 1 || hint == 2) && panelty == 0) {
                hint1(answer,k);
                hint2(oriA,turn);
                hint++;
            }
            if(hint == 2 && cnt == 0 && panelty == 0) { //힌트를 주었으나 답을 못맞추었을때
                //힌트3
                if(hint1Count == 1){
                    answer += 100;
                } else if (hint1Count == 3) {
                    answer += 360;
                } else if (hint1Count == 5) {
                    answer += 1700;
                }
                hint++;
            }
            if(hint == 3 && cnt == 0 && panelty == 0) { //힌트4 페널티
                if(hint1Count <3) {
                    panelty++;
                }

            }
            System.out.print(oneman + "님이 입력할 번호 : ");
            int one = sc.nextInt();
            if(one == answer) {
                oriA = turn+4;
                if(turn%5 == 0) {
                    k++;
                    answer += 1200;
                    hint++;
                } else if (turn%7 == 0) {

                    answer -= 560;
                    hint++;
                } else {
                    cnt++;
                }
            } else {
                if(turn/8 >= 1) {
                    System.out.println(rule3(answer));
                }
                if(turn/10 >= 1) {
                    System.out.println(rule4(answer));
                }
            }
            compare(one,answer, oneman);

            System.out.print(twoman + "님이 입력할 번호 : ");
            int two = sc.nextInt();
            if(two == answer) {
                oriA = turn+4;
                if(turn%5 == 0) {
                    k++;
                    answer += 1200;
                    hint++;
                }else if(turn%7 == 0) {

                    answer -= 560;
                    hint++;
                }
                else {
                    cnt++;
                }
            } else {
                if(turn/8 >= 1) {
                    System.out.println(rule3(answer));
                }
                if(turn/10 >= 1) {
                    System.out.println(rule4(answer));
                }
            }
            compare(two,answer, twoman);

            turn++;
        }

    }

    public static int numbers(int answer) {
        Scanner sc = new Scanner(System.in);
        int one = 0,two=0,three=0,four=0;
        System.out.print("첫 번째 번호 입력 : ");
        one = sc.nextInt();
        System.out.print("두 번째 번호 입력 : ");
        two = sc.nextInt();
        System.out.print("세 번째 번호 입력 : ");
        three = sc.nextInt();
        System.out.print("네 번째 번호 입력 : ");
        four = sc.nextInt();
        answer = one+two+three+four;
        return answer;
    }

    public static void compare(int num,int answer,String man) {
        if(num > answer) {
            System.out.println(man+"님이 입력하신 숫자가 답보다 더 큽니다.");
        } else if (num < answer) {
            System.out.println(man+"님이 입력하신 숫자가 답보다 더 작습니다.");
        } else {
            System.out.println(" 정답입니다!! 완벽하십니다!! 멋지세요!! ");
            System.out.println(man + "님 승리!!");
        }
    }

    public static int hint1(int answer,int k) {
        int cnt = 0;
        if(k == 0) {
            answer += 560;
        } else if (k == 1) {
            answer -= 1200;
        }
        for(int i = 20;  i <= answer; i++) {

            if (answer % i == 0 && cnt < 5) {
                System.out.println("정답이 " + i + "의 배수입니다.");
                cnt++;


            } else if(answer % i != 0 && i == answer-1) {
                System.out.println(" 더 이상 일치하는 배수가 없습니다. ");
            }

        }
        return cnt;
    }
    public static void hint2(int ori, int turn) {
        if(ori >= turn) {
            System.out.println("이전 최근 5턴 중에서 정답이 존재합니다.");
        } else {
            System.out.println("이전 최근 5턴 중에서 정답이 존재하지 않습니다.");
        }

    }
    public static int hint3(int answer, int count) {
        if(count == 1) {
            answer += 100;
        } else if (count == 3) {
            answer += 360;
        } else if (count == 5) {
            answer += 1700;
        }
        return answer;
    }
    public static int hint4(int h1count, int h2count) {
        int pt = 0;

        return pt;

    }
    public static int rule3(int answer) {
        int sum = 0;
        int mok = 0;
        while (answer > 0){
            sum += answer%10;
            mok = answer/10;
            answer = mok;
        }
        return sum;
    }
    public static int rule4(int answer) {
        String anleng = Integer.toString(answer);

        int solu = anleng.length();

        return solu;

    }


}
