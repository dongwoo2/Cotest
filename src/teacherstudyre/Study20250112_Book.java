package teacherstudyre;

public class Study20250112_Book {

    // 서점관리 프로그램을 만들건데
    // 서점의 주요 품목인 책을 객체로
    // 그리고 생성자를 통해 책의 제목과, 번호[고유번호], 작가, 출판사, 출판연도, 수량 등을 저장

    String name[]; // 책의 제목
    int num[]; // 고유번호
    String authorname[]; // 작가 이름
    String company[]; // 출판사
    int bookyear[]; // 출판연도
    int cnt[]; // 수량

    Study20250112_Book(String[] name, int[] num, String[] authorname, String[] company, int[] bookyear, int[] cnt) {
        this.name = name;
        this.num = num;
        this.authorname = authorname;
        this.company = company;
        this.bookyear = bookyear;
        this.cnt = cnt;
    }

    public Study20250112_Book() {
        // 배열의 크기를 설정합니다. 예를 들어, 10개의 책을 저장할 수 있도록 설정
        name = new String[10];
        num = new int[10];
        authorname = new String[10];
        company = new String[10];
        bookyear = new int[10];
        cnt = new int[10];
    }

    public void printClass() {
        System.out.println(this.getClass());
    }

    public void addBook(int index, int cnt) {
        this.cnt[index] += cnt; // += 연산자로 수정
        System.out.println(" '" + this.name[index] + "'" + cnt + "권이 추가되었습니다.");
        System.out.println("남은수량 : " + this.cnt[index]);
    }

    public void sellBook(int choice, int quantity) {
        // 판매 로직 구현
        if (cnt[choice - 1] >= quantity) {
            cnt[choice - 1] -= quantity;
            System.out.println(quantity + "권이 판매되었습니다.");
        } else {
            System.out.println("재고가 부족합니다.");
        }
    }
    public void showAllBooks() {
        for (int i = 0; i < num.length; i++) {
            if (name[i] != null) { // null 체크를 통해 유효한 책만 출력
                System.out.println("번호 : " + num[i]);
                System.out.println("제목 : " + name[i]);
                System.out.println("작가 : " + authorname[i]);
                System.out.println("출판사 : " + company[i]);
                System.out.println("출판연도 : " + bookyear[i]);
                System.out.println("수량 : " + cnt[i]);
                System.out.println(); // 각 책 정보 사이에 빈 줄 추가
            }
        }
    }
    public void increaseBook(int index, int cnt) {
        System.out.println(num[index] + "번 책의 재고가 모두 소진되어 책을 추가합니다.");
        System.out.println("수량이 부족하여 추가 주문 " + cnt + "권을 넣었습니다.");
        this.cnt[index] += cnt; // 재고 추가
        System.out.println("남은 수량 : " + this.cnt[index]);
    }

}
