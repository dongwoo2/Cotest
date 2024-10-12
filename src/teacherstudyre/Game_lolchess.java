package teacherstudyre;

// 롤토체스
public class Game_lolchess {

    public String developer;
    public String name;
    public String[] chess_name; // 기물 이름
    public int[] chess_grade; // 기물 등급
    public String[] chess_property; // 기물이 가지고 있는 특성
    public String[] property; // 게임 시즌 특성 (감시자 3,6,9) 이런식으로 값 넣을 수 있게하자
    public int level;

    Game_lolchess(String de, String na, String[] c_n, int[] c_g, String[] c_p, String[] pro, int le) {
        developer = de;
        name = na;
        chess_name = c_n;
        chess_grade = c_g;
        chess_property = c_p;
        property = pro;
        level = le;
    }

    Game_lolchess() {

    }
}
