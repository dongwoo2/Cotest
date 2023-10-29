package teacherstudyre;

public class Study1029_1 {

    public static void main(String[] args) {
//        int b = 1, c = 1;
        int b=1, c=1;
        System.out.println("\n\n지금부터 1부터 100까지의 숫자를 나열합니다.\n\n");
        for(int i = 1; i <= 100; i++) {
            System.out.println(" ============================== ");
            System.out.println("i의 숫자 = " + i);
            System.out.println("b의 숫자 = " + b);
            System.out.println("c의 숫자 = " + c);
            System.out.println(" ============================== ");


            if(i == 100) {
                for(b = 1; b <= 150; b++) {
                    System.out.println(" ============================== ");
                    System.out.println("i의 숫자 = " + i);
                    System.out.println("b의 숫자 = " + b);
                    System.out.println("c의 숫자 = " + c);
                    System.out.println(" ============================== ");
                }
                for(c = 1; c < 300; c++) {
                    System.out.println(" ============================== ");
                    System.out.println("i의 숫자 = " + i);
                    System.out.println("b의 숫자 = " + b);
                    System.out.println("c의 숫자 = " + c);
                    System.out.println(" ============================== ");
                }
                for(c = 300; c >= -500; c--){
                    System.out.println(" ============================== ");
                    System.out.println("i의 숫자 = " + i);
                    System.out.println("b의 숫자 = " + b);
                    System.out.println("c의 숫자 = " + c);
                    System.out.println(" ============================== ");
                }
                for(i = 100, b = 150; i >= -500; i--,b--) {
                    System.out.println(" ============================== ");
                    System.out.println("i의 숫자 = " + i);
                    System.out.println("b의 숫자 = " + b);
                    System.out.println("c의 숫자 = " + c);
                    System.out.println(" ============================== ");
                    if(i == -500){
                        for(b = -449; b >= -500; b--) {
                            System.out.println(" ============================== ");
                            System.out.println("i의 숫자 = " + i);
                            System.out.println("b의 숫자 = " + b);
                            System.out.println("c의 숫자 = " + c);
                            System.out.println(" ============================== ");

                        }

                    }

                }
            }
            if(i == b && b == c) {
                for(i = -500; i <= 3000; i++) {
                    System.out.println(" ============================== ");
                    System.out.println("i의 숫자 = " + i);
                    System.out.println("b의 숫자 = " + b);
                    System.out.println("c의 숫자 = " + c);
                    System.out.println(" ============================== ");
                    if(i == 1500) {
                        for(b = -500; b <= i + 1000; b++) {
                            System.out.println(" ============================== ");
                            System.out.println("i의 숫자 = " + i);
                            System.out.println("b의 숫자 = " + b);
                            System.out.println("c의 숫자 = " + c);
                            System.out.println(" ============================== ");
                            if(b == i + 1000) {
                                for(c = -500; c<b; c++) {
                                    System.out.println(" ============================== ");
                                    System.out.println("i의 숫자 = " + i);
                                    System.out.println("b의 숫자 = " + b);
                                    System.out.println("c의 숫자 = " + c);
                                    System.out.println(" ============================== ");

                                }
                                for(b = 2500; b < 4999; b++) {
                                    System.out.println(" ============================== ");
                                    System.out.println("i의 숫자 = " + i);
                                    System.out.println("b의 숫자 = " + b);
                                    System.out.println("c의 숫자 = " + c);
                                    System.out.println(" ============================== ");

                                }
                            }
                        }
                    }
                }
            }
            for(i = 3001; i < 5000; i++) {
                System.out.println(" ============================== ");
                System.out.println("i의 숫자 = " + i);
                System.out.println("b의 숫자 = " + b);
                System.out.println("c의 숫자 = " + c);
                System.out.println(" ============================== ");
            }
            for(c = 2500; c <= 5000; c++){
                System.out.println(" ============================== ");
                System.out.println("i의 숫자 = " + i);
                System.out.println("b의 숫자 = " + b);
                System.out.println("c의 숫자 = " + c);
                System.out.println(" ============================== ");
            }
        }


    }
}
