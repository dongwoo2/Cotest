package teacherstudyre;

import java.util.Scanner;

public class Study20250202_1 {

    public static void main(String[] args) {

        System.out.println("안녕하세요 책상점에 오신것을 환영합니다.");
        Study20250112_Book book = new Study20250112_Book();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int choice1 = 0;
        book.name[0] = "소설1";
        book.name[1] = "소설2";
        book.num[0] = 1;
        book.num[1] = 2;
        book.authorname[0] = "김동우1";
        book.authorname[1] = "김동우2";
        book.company[0] = "Company1";
        book.company[1] = "Company2";
        book.bookyear[0] = 2025;
        book.bookyear[1] = 2025;
        book.cnt[0] = 10;
        book.cnt[1] = 10;
        book.showBook();


        System.out.println("어떤 책을 구매하시겠습니까?");
        choice = sc.nextInt();
        System.out.println(book.name[choice - 1] + "을 고르셨습니다.");
        System.out.println("몇 권을 구매하시겠습니까?");
        choice1 = sc.nextInt();
        book.sellBook(choice, choice1);



    }

}