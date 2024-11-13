package teacherstudyre;

public class People implements Comparable<People> {
    String name;
    int age;

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return name + ", " + age;
    }
    @Override
    public int compareTo(People other) {
        return Integer.compare(age, other.age);
    }

}
