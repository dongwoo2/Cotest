package javastudy.ch02;
@FunctionalInterface // 함수형 인터페이스라는 뜻 함수형 인터페이스는 메소드가 한 개만 있어야됨
public interface Add {

    public int add(int x, int y);
}
