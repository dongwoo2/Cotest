package teacherstudyre;

public class Study20240619_1 {
    public static void main(String[] args) {
        String str = "Hello, world!";
        int len = str.length();
        System.out.println("문자열의 길이 : " + len);

        int []arr = {1,2,3,4,5};
        int arrren = arr.length;
        System.out.println("배열의 길이 : " + arrren);

        String str2 = null;
        if(str2 != null) {
            int len2 = str2.length();
            System.out.println("문자열의 길이 : " + len2);
        } else {
            System.out.println(" 문자열이 null 입니다. ");
        }
    }
}
