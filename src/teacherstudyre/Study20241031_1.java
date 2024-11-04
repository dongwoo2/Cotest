package teacherstudyre;

import java.util.Scanner;

public class Study20241031_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] people = new int[5];
        int pass_energy = 0; // 에너지 전달
        String[] energy_build = new String[100];
        int[] energy_build_price = new int[100];
        boolean flag = true;
        int turn = 0;
        int choice = 0;

        // 존 마다 사람수도 채킹 해야하는데
        // 에너지 건물은 어떻게 하지? 클래스?

        System.out.println("몇 개의 도시를 만드시겠습니까?");
        choice = sc.nextInt();

        Village[] villages = new Village[choice];

        villages = setVillage(choice, villages);

        while (flag) {
            turn++;
            for(int i = 0; i < villages[0].zoneCount; i++){

            }
        }

    }
    public static Village[] setVillage(int choice, Village[] villages) {
        for (int i = 0; i < choice; i++) {
            System.out.println("마을 " + (i + 1) + "의 정보를 입력하세요:");
            System.out.print("에너지 풀: ");
            int energyPool = sc.nextInt();
            System.out.print("이름: ");
            String name = sc.next();
            System.out.print("존 수: ");
            int zoneCount = sc.nextInt();
            System.out.print("최대 전송량: ");
            int maxTransfer = sc.nextInt();
            System.out.print("최소 에너지: ");
            int minEnergy = sc.nextInt();

            // Village 객체 생성 후 배열에 저장
            villages[i] = new Village(energyPool, name, zoneCount, maxTransfer, minEnergy);
            villages[i].zonePeople();
            villages[i].maxTransfer = villages[i].max_check(maxTransfer);
            villages[i].minEnergy = villages[i].min_check(minEnergy);
            System.out.println("maxTransfer = " + villages[i].maxTransfer);
            System.out.println("minEnergy = " + villages[i].minEnergy);
            // 일단 이렇게 생성이 되면 max,min 검증해주는 함수가 필요함
        }
        return villages;
    }
    public static Village turnPlus(Village vi) {
            return vi;
    }

}
