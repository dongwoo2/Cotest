package teacherstudyre;

public class Booktest {
    public static void main(String[] args) {
        Book b;
        b = new Book();
        b.title = "자바";
        b.price = 15000;
        b.company = "청어람";
        b.page = 700;

        System.out.println(b.title);
        System.out.println(b.price);
        System.out.println(b.company);
        System.out.println(b.page);

        Person p = new Person("동우");
        p.age = 15;
        p.weight = 68.4f;
        p.height = 175.7f;

        System.out.println(p.name);
        System.out.println(p.age);
        System.out.println(p.weight);
        System.out.println(p.height);
    }

}


