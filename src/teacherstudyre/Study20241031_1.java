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
        boolean flag2 = true;
        boolean flag3 = true;
        int turn = 0;
        int choice = 0;


        // 존 마다 사람수도 채킹 해야하는데
        // 에너지 건물은 어떻게 하지? 클래스?

        System.out.println("몇 개의 도시를 만드시겠습니까?");
        choice = sc.nextInt();

        Village[] villages = new Village[choice];

        villages = setVillage(choice, villages);
        System.out.println(villages[0].EnergyPool + villages[0].name);

        //모두의 마블 생각해서 사람수대로 에너지 ++ 될 수 있게
        while (flag) {
            turn++;
            villages = turnPlus(villages);
            while (flag2) {
                int c = 1;
                showEnergy(villages , c);
                System.out.println("1. 에너지 건물 구입 2. 에너지 대출");
                choice = sc.nextInt();
                if(choice == 1) {
                    villages = equipmentBuilding(villages, c); // 건물 구입 함수
                } else if(choice == 2) {

                }
                c++;
                if(c > villages.length) {
                    c = 0;
                    flag2 = false;
                }
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
            if(maxTransfer > 500) {
                System.out.println("최대 전송량은 500을 넘을 수 없습니다. 500으로 고정됩니다.");
            }
            System.out.print("최소 에너지: ");
            int minEnergy = sc.nextInt();
            if(minEnergy < 100) {
                System.out.println("최소 에너지 요구량은 100보다 작을 수 없습니다. 처음 턴에는 100으로 고정됩니다.");
                // 최소 에너지 요구량은 에너지를 소비하는 건 사람 수 마다 소비하게 됨 1명당 1, 건물은 아직 안정함
            }

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
    public static Village[] turnPlus(Village[] vi) {
        for(int i = 0; i < vi.length; i++){
            for(int j = 0; j < vi[i].zoneCount; j++) {
                // 최소 에너지 요구량은 에너지를 소비하는 건 사람 수 마다 소비하게 됨 1명당 1, 건물은 아직 안정함
                // 근데 턴마다 사람으로 인해서 에너지를 2 얻음 그러니 그냥 더하기만 하면 됨
                vi[i].zone[j] += vi[i].people[j];
            }
        }
            return vi;
    }

    public static void showEnergy(Village[] vi, int c) {
        for(int i = c - 1; i < c; i++) {
            for(int j = 0; j < vi[i].zoneCount; j++) {
                System.out.println( vi[i].name +" 마을의 " + (j + 1) + "번 째 존의 에너지" + vi[i].zone[j]);
            }
        }
    }

    public static Village[] equipmentBuilding(Village[] vi, int c) {
        int choice = 0;
        int building_choice = 0;
        int building_price = 0;
        boolean flag = true;
        boolean flag2 = true;
        int check = 0;
        int whileout = 0;
        while (flag) { // 에너지빌딩[0] = 존[0] 즉 존에 있는 빌딩임
            System.out.println("몇 번째 존을 고르시겠습니까?");
            choice = sc.nextInt();
            if(vi[c].zoneCount > choice || vi[c].zoneCount < choice) {
                System.out.println("잘못 선택하셨습니다.");
                System.out.println("zone 선택화면으로 돌아갑니다.");
            } else {
                while (flag2) {
                    System.out.println("1. 빌딩 2. 호텔 3. 랜드마크"); // 가격 200,400,800
                    building_choice = sc.nextInt();
                    if (building_choice == 1) {
                        building_price = 200;
                        check = 1;
                    } else if (building_choice == 2) {
                        building_price = 400;
                        check = 1;
                    } else if (building_choice == 3) {
                        building_price = 800;
                        check = 1;
                    } else {
                        System.out.println("잘못된 번호를 선택하셨습니다.");
                    }


                    if (check == 1) {
                        if (vi[c].energy_building[choice] == building_choice) { // 똑같은 건물을 선택했을 시
                            System.out.println("현재 똑같은 건물을 소유하고 있습니다.");
                            System.out.println("1. 다시선택 2. 나가기");
                            choice = sc.nextInt();
                            if (choice == 2) {
                                flag = false;
                                flag2 = false;
                            } else if (choice == 1) {
                                check = 0;
                            } else {
                                whileout = 1;
                            }
                        } else if (vi[c].energy_building[choice] > building_choice) {
                            System.out.println("현재 선택한 건물보다 더 좋은 건물을 소유하고 있습니다.");
                            System.out.println("1. 다시선택 2. 나가기");
                            choice = sc.nextInt();
                            if (choice == 2) {
                                flag = false;
                                flag2 = false;
                            } else if (choice == 1) {
                                check = 0;
                            } else {
                                whileout = 1;
                            }
                        } else {
                            if (vi[c].zone[choice] > building_price) {
                                System.out.println("구입이 완료되었습니다.");
                                flag2 = false;
                                flag = false;
                            } else {
                                System.out.println("금액이 모자랍니다. 선택화면으로 돌아갑니다.");
                            }
                        }
                        if(whileout == 1) {
                            System.out.println("잘못 선택하셨습니다 건물 선택화면으로 돌아갑니다.");
                            whileout = 0;
                        }
                    }
                }
            }


        }
        return vi;
    }

    public static Village[] energyLoan(Village[] vi, int c) { // 대출
        int choice = 0;
        System.out.println("어느 존이 대출을 받겠습니까?");
        choice = sc.nextInt();
        //vi[c].zone[choice - 1]


        return vi;
    }

}
