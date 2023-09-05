package practice;

import java.util.Arrays;
import java.util.Scanner;

public class charstudy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length -1;

        while (left < right){
            char temp;
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        // return Arrays.toString(chars);
        return new String(chars);
    }
}
