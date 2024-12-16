package teacherstudyre;

import java.util.Date;
import java.util.Scanner;

public class Study20241216_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //메뉴 이름, 가격, 주문 시각을 입력으로 받는다.
        String menuName[] = new String[100];
        int menuPrice[] = new int[100];
        Date date[] = new Date[100];
        boolean flag = true;
        int i = 0;
        while (flag) {
            i++;
            System.out.println("메뉴이름을 입력해주세요.");
            menuName[i] = sc.next();
            System.out.println("메뉴의 가격을 정해주세요.");
            menuPrice[i] = sc.nextInt();
            System.out.println("주문 시각을 입력해주세요.");

        }
        // 1. 가격기준 정렬
        // 위 기능에서, 1. 주문 2. 음식 추가 3. 주문조회[내부에 정렬기능선택가능] 4. 정산[오늘 판 개
        //수 및 가격] 같은 식으로 만들어주세요.
    }
}
