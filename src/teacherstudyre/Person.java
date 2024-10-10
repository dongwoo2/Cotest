package teacherstudyre;

public class Person {

    public String name;
    public int age;
    public float weight;
    public float height;
    String blood;
    String address;

    // 초기화
    Person(String n) {
        name = n;
    }

    void study() {
        System.out.println("study !");
    }

    void introduceMyself() {
        System.out.println("내 이름은 " + name + "입니다.");
        System.out.println("내 나이는 " + age + "입니다.");
    }

    void walk() {
        System.out.println(name + "이 걷습니다.");
    }

    void speak() {
        System.out.println("Speak!!!");
    }
}
