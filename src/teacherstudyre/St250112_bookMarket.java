package teacherstudyre;

public class St250112_bookMarket {

    public static void main(String[] args) {

        Study20250112_Book book =  new Study20250112_Book("파이썬을 배워라", 1, "김동우", "한영출판사", 2012, 5);
        Study20250112_Book book2 =  new Study20250112_Book("자바를 배워라", 2, "박애림", "한영출판사", 2014, 10);
        Study20250112_Book book3 =  new Study20250112_Book("노드를 배워라", 3, "김초코", "한영출판사", 2016, 15);
        book.printClass();

        System.out.println("어떤 책을 사시겠습니까?");
        // 그럼 여기에 책의 종류가 나오면서 보여줘야 하는데 위에 식으로 객체 생성해서 하는 건 별론데


    }
}
