package javastudy.ch04;

public class TestStringConcat {

    public static void main(String[] args) {

        int num = 100; //final로 선언이 되어 있음

        String s1 = "hello";
        String s2 = "world";
        StringConcatImpl concat1 = new StringConcatImpl();
        concat1.makeString(s1, s2);

        //람다식을 구현을하면 익명 내부 클래스가 만들어지고 , 이를 통해 익명 객체가 생성됨
        StringConcat concat2 = (str1, str2) -> {
            System.out.println(str1 + "," + str2);
            System.out.println(num);
        }; //여기다 바로 구현을 함
        //원래과정
        // 1.인터페이스 생성 2. 클래스 생성 클래스에서 impl을 하고 3.클래스를 생성해서 호출함
        // 그렇지만 람다를 쓰면 클래스를 만들어 구현하는 과정을 생략가능
        concat2.makeString(s1,s2);

        StringConcat concat3 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "," + s2);
                System.out.println(num);
            }
        };
        concat3.makeString(s1,s2);
    }
}
