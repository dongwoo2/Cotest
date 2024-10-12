package teacherstudyre;

public class Game_rpg {

    public String developer;
    public String name;
    public int power;
    //public String[] skill;
    public int speed;
    public int stamina;
    public int mana;
    public int[] skill_mana;
    public String[] skill_name;


    // 직접 입력을 대비해서 만든 생성자
    Game_rpg(String de, String n, int p, int sp, int st, int ma, int[] s_ma, String[] s_na) {
        developer = de;
        name = n;
        power = p;
        speed = sp;
        stamina = st;
        mana = ma;
        skill_mana = s_ma;
        skill_name = s_na;
        //this.speed = speed;
    }

    Game_rpg() {

    }

    void introduce() {
        System.out.println("이 게임은 RPG 게임이며, 캐릭터의 이름, 파워, 스피드, 스태미나, 마나, 스킬이름, 스킬 마나 사용량을 설정할 수 있습니다.");
        System.out.println("제작자는 " + developer + " 입니다.");
    }



}
