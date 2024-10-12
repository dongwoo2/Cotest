package teacherstudyre;

// 농사게임
public class Game_farm {

    public String developer;
    public String name;
    public int stamina; // 농사 체력
    public String[] crop; // 작물 종류 일단 3개만
    public int[] cropseed_buy_money; // 작물씨 사는 가격
    public int[] crop_sell_money; // 작물 파는 가격
    public int money;

    Game_farm(String de, String na, int st, String[] cr, int[] cs_buy_money, int[] cr_sell_moeny, int mo) {
        developer = de;
        name = na;
        stamina = st;
        crop = cr;
        cropseed_buy_money = cs_buy_money;
        crop_sell_money = cr_sell_moeny;
        money = mo;
    }

    Game_farm() {

    }

    void introduce() {
        System.out.println("이 게임은 농사게임 입니다.");
        System.out.println("제작자는 " + developer + "입니다.");
        System.out.println("게임에는 작물을 심고 수확할 수 있으며, 농사체력이 있어 정해진 양만큼의 일만 할 수 있습니다.");
        System.out.println("작물의 씨앗을 사고 심은 뒤 수확을 하여 상점에 작물을 팔 수 있습니다.");
    }
}
