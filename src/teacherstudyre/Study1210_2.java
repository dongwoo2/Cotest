package teacherstudyre;

public class Study1210_2 {

    public static void main(String[] args) {
        int[] intArray = new int[5];

        intArray[0] = 2;
        intArray[1] = 3;
        intArray[2] = 5;
        intArray[3] = 7;
        intArray[4] = 11;

//        for(int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }
//
//        System.out.println(intArray[2] + intArray[4]);

        int[] myarray = {1, 2, 3, 4, 5};
        int[] testarray = {6, 7, 8, 9};
        int[] mybang = {10, 20, 30, 40, 50, 60, 70};

        for(int i = 0; i <= 4; i++) {
            System.out.println("myarray["+ i + "] = " + myarray[i]);
        }

        for(int i = 0; i <= 3; i++) {
            System.out.println("testarray["+ i + "] = " + testarray[i]);
        }

        for(int i = 0; i <= 6; i++) {
            System.out.println("mybang["+ i + "] = " + mybang[i]);
        }
    }
}
