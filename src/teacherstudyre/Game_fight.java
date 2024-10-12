package teacherstudyre;

// 격투게임
public class Game_fight {

    public String developer;
    public String name;
    public int stamina;
    public int power;
    public int speed;
    public int defense;

    Game_fight(String de, String na, int st, int po, int sp, int def) {
        developer = de;
        name = na;
        stamina = st;
        power = po;
        speed = sp;
        defense = def;
    }

    Game_fight() {

    }

    void introduce() {
        System.out.println("이 게임은 격투게임 입니다.");
        System.out.println("제작자는 " + developer + "입니다.");
        System.out.println("능력치는 체력, 스피드, 방어력, 공격력이 있습니다.");
    }
}
