package teacherstudyre;

public class Game_Racing {

    /*
        터치는 데미지 내 공격력 데미지
        상대 터치에 따라 공격을 입기도함
     */
    public String developer = "dong3";
    public String name;
    public String car_name;
    public int speed;
    public int durability; // 내구도
    public int touch; // 부딪침
    public String grade; // 차 수준
    public int money;
    public int car_money;

    Game_Racing(String de ,String n, String car_n, int sp, int du, int to, String gr, int mo, int car_mo) { // 생성자
        developer = de;
        name = n;
        car_name = car_n;
        speed = sp;
        durability = du;
        touch = to;
        grade = gr;
        money = mo;
        car_money = car_mo;
    }

    Game_Racing() {
    }

    void introduce() {
        System.out.println("이 게임은 레이싱게임 입니다.");
        System.out.println("제작자는 " + developer + "입니다.");
        System.out.println("능력치는 스피드, 내구도, 공격력이 있으며 돈으로 차의 등급을 올릴 수 있습니다");
    }

    // 등급이 올라갈수록 전체적인 능력치 +5
    String upgrade_car(int money, String grade){
        if(grade.equals("C")) {
            if(money > 10000) {
                System.out.println("B등급으로 업그레이드 되었습니다.");
                grade = "B";
                return grade;
            }
        } else if (grade.equals("B")) {
            if(money > 20000) {
                System.out.println("A등급으로 업그레이드 되었습니다.");
                grade = "A";
                return grade;
            }
        } else {
            System.out.println("이미 최고 등급입니다.");
            return grade;
        }
        return grade;
    }


}
