package teacherstudyre;

public class Tests {
    public static void main(String[] args) {
        Person Dong = new Person("동우");
        Dong.age = 20;
        Dong.introduceMyself();
        Dong.walk();


        System.out.println("================================================");

        Me Dong2 = new Me("동우", 20);
        Dong2.sex = "남";
        Dong2.address = "안산";
        Dong2.blood = "O";
        Dong2.job = "개발자";
        Dong2.height = 174.1f;
        Dong2.weight = 83.4f;
        Dong2.origin = "데일리샷";
        Dong2.schoolnumber = 2323;
        Dong2.companynumber = 2410;
        Dong2.happyPlace = "서울랜드";
        Dong2.university = "한신대학교";
        Dong2.originBorn = "서울";


        Dong2.basic_information();
        Dong2.health();
        Dong2.univer(17);
        Dong2.detail_information();
        Dong2.happy();
        Dong2.born();
    }


}
