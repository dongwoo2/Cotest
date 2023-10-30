package teacherstudyre;

public class Study1029_1_2 {

    public static void main(String[] args) {

        solution();
    }

    public static void solution() {

        int b = 1, c = 1;
        for (int i = 1; i <= 100; i++) {
            saw(i, b, c);
            if (i == 100) {
                for (b = 1; b <= i + 50; b++) {
                    saw(i, b, c);
                    if (b == 150) {
                        for(c = 1; c <= b*2; c++) {
                            saw(i, b, c);
                            if(c == 300) {

                            }
                        }
                    }
                }
            }
        }
    }

    public static void saw(int i, int b, int c) {
        System.out.println(" ====================================================== ");
        System.out.println("i = " + i);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println(" ====================================================== ");

    }


}
