package teacherstudyre;

import java.util.Map;
import java.util.Scanner;

public class Study1222_1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int n = sc.nextInt(); // 배열의크기
        int cut = 0;
        int []arr = new int[n];
        int []krr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        System.out.println("몇 번째 인덱스를 자르겠습니까? ");
        cut = sc.nextInt();
        krr = cutarr(arr, cut);
        int sum = sumarr(krr);
        System.out.println("sum = " + sum);

    }

    public static int[] cutarr(int arr[],int cut) {

        int arrf = 0;
        int arrl = 0;
        if(arr.length > cut) {
            arrl = arr.length-cut; //뒷부분
            //2번째 인덱스에서 잘렸으면 3이되는데 부분배열의 뒷부분이 된다

            arrf = arr.length-arrl; // 앞부분
            //2번째 인덱스에서 잘렸으면 2가 되는데 부분배열의 앞부분이 된다
            //뒷부분이 앞쪽으로 오는 형태의 배열이 되어야한다.
            //arrl+arrf 식의 순서가 되어야한다.
            //뒷부분 + 앞부분 형태가 되어야한다 이걸 리턴해야함
            //일단은 부분배열이 짤린 것을 보여줄 수 있도록 만들어보자
        }
        int brr[] = new int[arr.length];
        for(int i = 0; i < arrf; i++) {
            brr[i] = arr[i];
        }

        for(int i = arr.length; i >= arrl; i--) {
            brr[i-1] = arr[i-1];
        }
//        for(int x : brr) {
//            System.out.println("x = " + x);
//        }
        //3번쨰 인덱스가 첫번째 인덱스로 이동할 수 있게 만들어야함 지금 그냥 순서만 바뀜

//        for(int i = arr.length, j = 0; i > 0; i--,j++) {
//            brr[i-1] = arr[j];
//        }
//        arr[arrl] = brr[0]
//        arr[arrl+1] = brr[1]
//        arr[arrl+2] = brr[2]
//        arr[arrf] = brr[3]
//        arr[arrf+1] = brr[4]
//
        for(int i = arrl-1, j = 0; i < arr.length; i++,j++) {
            brr[j] = arr[i];
        }
        for(int i = 0, j = arrl; j < arr.length; i++,j++) {
            brr[j] = arr[i];
        }

        //이제 뒷부분이 앞으로 올 수 있게
        for(int x : brr) {
            System.out.println("x = " + x);
        }

        return brr;
    }


    public static int sumarr(int[]krr) {
        int sum = 0;
        int maxsum = 0;
        for(int i = 0; i < krr.length; i++) {
                sum = 0;
            for(int j = 0; j  < krr.length; j++) {
                sum = sum + krr[j];
                maxsum = Math.max(maxsum,sum);
            }
        }
        return maxsum;
    }


}

