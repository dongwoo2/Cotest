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
                for (; b <= 150; b++) {
                    saw(i, b, c);
                    if (b == 150) {
                        for(; c <= b*2; c++) {
                            saw(i, b, c);
                        }
             for(; c >= -500; c--) {
                 saw(i,b,c);
             }
             for(; i >= -500; i--) {
                 saw(i,b,c);
             }
             for(; b >= -500; b--) {
                 saw(i,b,c);
             }
             if(i == b && b == c) {
                 for(; i <=3000; i++) {
                     saw(i,b,c);
                     if(i == 1500) {
                         for(; b <= 5000; b++) {
                             saw(i,b,c);
                             if(b > i+1000){
                                 c++;
                             }
                             if(b == 5000) {
                                 for(; i < b; i++) {
                                     saw(i,b,c);
                                 }
                                 for(; c <= b; c++) {
                                     saw(i,b,c);
                                 }
                             }
                         }


                     }
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
