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

    Study20250112_Book(String name, int num, String authorname, String company, int bookyear, int cnt) {
        this.name = name;
        this.num = num;
        this.authorname = authorname;
        this.company = company;
        this.bookyear = bookyear;
        this.cnt = cnt;
    }

    Study20250112_Book() {

    }

    public void printClass() {
        System.out.println(this.getClass());
    }

    public void addBook(int num, int cnt) {
        this.cnt =+ cnt;
        System.out.println(" '"+this.name +"'" + cnt +"권이 추가되었습니다.");
        System.out.println("남은수량 : " + this.cnt);
    }

    public void sellBook(int num, int cnt) {
        // num cnt 넘길 때 인덱스 기준으로 넘기기 때문에 넘기는 함수에서 유효성 검증 해야함
        // 인덱스 기준으로 this.cnt[0]도 가능하지 않나
        if(this.cnt[num - 1] > cnt) {
            this.cnt[num - 1] =- cnt;
            System.out.println("구매가 완료되었습니다.");
            System.out.println("한 손님이 '"+this.name[num - 1] +"'" + cnt +"권을 사갔습니다.");
            System.out.println("남은수량 : " + this.cnt[num - 1]);
            System.out.println("현재 책의 총 권수는 " + book.cnt[choice - 1] + "개 입니다.");
        } else {
            System.out.println("책의 수량보다 더 많이 사실 수 없습니다.");
            // 여기서 while문 써야할 듯 어쨋든 구매라 크게 만들어야할 듯
            System.out.println(this.cnt[num - 1] + "개 이하로 골라주세요.");
        }
    }
    public void showBook() {
        System.out.println("번호 : " + num);
        System.out.println("제목 : " + name);
        System.out.println("작가 : " + authorname);
        System.out.println("출판사 : " + company);
        System.out.println("출판연도 : " + bookyear);
        System.out.println("수량 : " + cnt);
    }
    public void increaseBook(int num, int cnt) {
        System.out.println(num + "번 책의 재고가 모두 소진되어 책을 추가합니다.");
        System.out.println("수량이 부족하여 추가 주문 " + cnt + "권을 넣었습니다.");
        System.out.println("남은 수량 : " + this.cnt);
    }

}
