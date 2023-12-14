/*
총 ?개의 값을 받게 된다.
그리고 출력은 거꾸로 출력되게 만들어주세요.
거꾸로 출력이 완료되었다면,[그 후]
이번에는 입력 받은 값의 합을 나타내시고,
혹시라도 7이라는 숫자를 입력한 적이 있다면, 해당 7이라는 숫자가 몇 번이나 나왔는지,
7이 총 3번 이상 입력받지 않았다면, 7을 입력을 더 받아야 합니다. 라는 문구와 함께 5번의 기회가 더 주어진다.
해당 7이라는 숫자가 들어있는 배열[거꾸로 배열 기준]의 인덱스 중 중간(짝수의 경우 반올림기준) 몇 번인지를 나타내시고,
7이 나온 수만큼 더해진 값이 얼마인지 나타내보세요.

예시)

입력 1 2 3 4 5 6 7 7 8 9 10

[거꾸로]10 9 8 7 7 6 5 4 3 2 1

총 합은 62입니다.

7은 총 2번 나왔습니다.

7이 들어있는 index 중에서 중간에 위치한 index는 ?번 입니다.

7이 나온 값만큼 더한 숫자는 14입니다.

 */
package teacherstudyre;

import java.util.Scanner;

public class Study1210_4 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = 0;
        int tmp = 0;
        int cnt = 0;
        int c = 0;
        int mincnt = 0;
        int t = 0;
        int chance = 5;
        boolean flag = true;

        while(flag) {
            System.out.println("몇 개를 입력하시겠습니까?");
            int n = sc.nextInt();  // array count
            int indexsum = 0;

            double middle2 = Math.round((double)n/2); //middle
            int middle = (int) middle2;
            int[]arr = new int[n]; // 초기화
            int[]brr = new int[n]; // 초기화
            int[]crr = new int[3];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println(" 총 합은 " + sum + "입니다.");
            int arrsizes = arr.length;
            System.out.println(arrsizes);
            brr = reverse(arr);

            for (int x = 0; x < brr.length; x++) {
                if (x == 0)
                    System.out.print("[reverse] : ");
                System.out.print(" " + brr[x]);

            }

            crr = middlesum(brr, middle);
            tmp = crr[0];
            c = crr[1];
            indexsum = crr[2];

//			if (brr[x] == 7) {
//				tmp++;
//				if (tmp == 1) {
//					mincnt = middle - (t + 1);
//					mincnt = Math.abs(mincnt);
//					c = t + 1;
//				} else {
//					cnt = middle - (t + 1);
//					cnt = Math.abs(cnt);
//				}
//				if (cnt < mincnt) {
//					mincnt = cnt;
//					c = t + 1;
//				}
//			}
            // for(int j = n-1; j >= 0; j--, t++) {
//			brr[t] = arr[j];
//			if(j == n - 1) {
//				System.out.print("reverse : ");
//			}
//			System.out.print(" "+brr[t]);
//			if(brr[t] == 7) {
//				tmp++;
//				if(tmp == 1) mincnt = t+1;
//				cnt = middle - (t + 1);
//
//				if(cnt < mincnt) {
//					mincnt = cnt;
//					c = t+1;
//				}
//			}
//		}

            System.out.println(" ");
            System.out.println("7은 총 " + tmp + "번 나왔습니다.");
            System.out.println("7이 들어있는 index 중에서 중간에 위치한 index는 " + c +"번 입니다.");
            System.out.println("7이 나온 값만큼 더한 숫자는 " + indexsum + "입니다.");
            if(tmp >= 3) {
                flag = false;
            }else {
                chance--;
                System.out.println("7을 3번이상 입력하셔야 합니다. \n남은 기회는 " + chance + "번 입니다.");
                if(chance == 0) {
                    System.out.println("기회가 다 소진되었습니다.");
                    flag = false;
                }
            }
            t = 0;
            sum = 0;
            tmp = 0;
            c = 0;
        }

    }

    /*
     * arr[0] = 7의갯수
     * arr[1] = middle에 제일 가까운 인덱스
     * arr[2] = 7이 나온 값만큼 더하는 숫자
     */

    public static int[] middlesum(int []brr, int middle) {
        int cnt = 0;
        int mincnt = 0;
        int minfix = 0;
        int cntfix = 0;
        int []arr = new int[3];
        for(int i = 0; i < brr.length; i++) {
            if(brr[i] == 7) {
                arr[0] = arr[0] + 1;
                if(arr[0] == 1) {
                    mincnt = middle - (i+1);
                    mincnt = Math.abs(mincnt);
                    arr[1] = i + 1;
                } else {
                    cnt = middle - (i+1);
                    cnt = Math.abs(cnt);
                }
                minfix = mincnt;
                cntfix = cnt;
                if(cntfix < minfix) {
                    minfix = cntfix;
                    arr[1] = (i + 1);
                }
            }
        }
        arr[2] = arr[0] * 7;
        return arr;
    }

    public static int[] reverse(int[]arr) {
        int arrsize = 0;
        int t = 0;
        arrsize = arr.length;
        int [] crr = new int[arrsize];
        for(int i = arrsize-1; i >= 0; i--,t++) {
            crr[t] = arr[i];
        }
        return crr;
    }

}

