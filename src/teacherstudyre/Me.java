package teacherstudyre;

public class Me {
    public String name;
    public int age;
    public float weight;
    public float height;
    public String sex;
    public String origin; // 소속
    public String originBorn; // 태어난 곳
    public String job;
    public String address;
    public int schoolnumber; // 학번
    public int companynumber; // 사번
    public String blood;
    public String happyPlace;
    public String university;

    Me(String n, int a) {
        name = n;
        age = a;
    }

    void born() {
        int borny = 0;
        borny = 2024 - age;
        System.out.println("나 " + name + "는 " + borny + "년에 "  + originBorn + "에서 태어났다.");
    }

    void happy() {
        System.out.println(name + "는 어린 시절에 엄마 아빠와 함께" + happyPlace + "에 가는것이 가장 즐거웠다.");
    }

    void univer(int come) {
        System.out.println(name + "는 " + university + "에 " + come + "학번으로 입학했다");
    }
    void detail_information() {
        System.out.println(name + "는 현재 2024년 " + address + "에 살고있고,\n" + name + "는 " + job + "으로 취업하고 싶다. 라고 말했다");
    }

    void basic_information() {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("sex = " + sex);
        System.out.println("weight : " + weight);
        System.out.println("height : " + height);
    }

    void health() {
        System.out.println(name + "가 운동을 합니다.");
    }

}
