package teacherstudyre;

public class Study20240225_2 {
    int[][] multiArray = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
    };

    int[][] multiArray2 = new int[3][4];

    public static void main(String[] args) {
        Study20240225_2 T = new Study20240225_2();

        for(int i = 0; i < T.multiArray[0].length; i++) {
            T.multiArray[0][i] = 5 + i;
            System.out.println(T.multiArray[0][i]);
        }

        for (int i = 0; i < T.multiArray[2].length; i++) {
            T.multiArray[2][i] = 9 + i;
            System.out.println(T.multiArray[2][i]);
        }

        for (int i = 0; i < T.multiArray.length; i++) {
            for (int j = 0; j < T.multiArray[i].length; j++) {
                T.multiArray[i][j] = (i * 4 + 1) + j;
            }
        }

    }

}
