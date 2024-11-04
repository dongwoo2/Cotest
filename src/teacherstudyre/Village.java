package teacherstudyre;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Village {
    int EnergyPool = 0; // 전체 에너지 계수
    String name = ""; // 도시 이름
    int zoneCount = 0;
    int zone[] = new int[100]; // 도시 안에 있는 구역 얘가 에너지 생산량도 포함함
    int people[] = new int[100]; // 사람 수 인덱스 0 부터 존 시작
    int maxTransfer = 0; // 각 구역이 다른 구역에 전달할 수 있는 에너지의 최대량 Max 함수를 사용해 결정 500
    int minEnergy = 0; // 각 구역이 필요로 하는 최소 에너지 Min 함수를 사용해 결정 100 사람 한 명당 1의 에너지라고 생각하자
    Scanner sc = new Scanner(System.in);


    Village(){

    }

    Village(int EnergyPool, String name, int zoneCount, int maxTransfer, int minEnergy) {
        this.EnergyPool = EnergyPool;
        this.name = name;
        this.zoneCount = zoneCount;

        this.maxTransfer = Math.max(500, maxTransfer); // 최소 제한 500은 보낼 수 있어야함
        this.minEnergy = Math.min(100, minEnergy); // 최소 100만큼의 에너지가 필요함
    }

    public int[] zonePeople() { // 존 구역 사람수 체크하면서 자동으로 에너지도 체크
        for (int i = 0; i < zoneCount; i++) {
            System.out.println(i + 1 + "존 사람수를 설정해주세요.");
            this.people[i] = sc.nextInt();
        }
        for (int j = 0; j < zoneCount; j++) {
            zone[j] = this.people[j] * 2;
        }
        return zone;
    }
    public int max_check(int maxTransfer) {
        this.maxTransfer = Math.min(500, maxTransfer); // 최대 전송량 설정
        return this.maxTransfer;
    }
    public int min_check(int minEnergy) {
        this.minEnergy = Math.max(100, minEnergy); // 최소 에너지 설정 (예시로 1000으로 설정)
        return this.minEnergy;
    }

}

