package teacherstudyre;

public class Game {

        String developer;
        String gameType;
        String[] attributes;

        public Game(String developer, String gameType, String[] attributes) {
            this.developer = developer;
            this.gameType = gameType;
            this.attributes = attributes;
        }

        public void displayInfo() {
            System.out.println("개발자: " + developer);
            System.out.println("게임 종류: " + gameType);
            System.out.print("게임 특성: ");
            for (String attribute : attributes) {
                System.out.print(attribute + " ");
            }
            System.out.println("\n");
        }

}
