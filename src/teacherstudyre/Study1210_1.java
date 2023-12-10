package teacherstudyre;

public class Study1210_1 {

    public static void main(String[] args) {
        int arr[] = new int[10];

        arr[0] = 5000;
        arr[1] = 10000;
        arr[2] = 20000;
        arr[3] = 30000;
        arr[4] = 40000;
        arr[5] = 50000;
        arr[6] = 60000;
        arr[7] = 70000;
        arr[8] = 80000;
        arr[9] = 90000;

        System.out.println("1번째 TEST");
        for(int i = 0; i <= 9; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("2번째 TEST");
        for(int k : arr) {
            System.out.println("k = " + k);
        }
    }

}
