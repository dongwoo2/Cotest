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
        int c = 0;

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
            // 여기서 canenergypool 이랑 energypool 맞춰야함 turn 지났으니까
            villages = turnPlus(villages);
            flag2 = true;
            while (flag2) {
                villages[c].canEnergyPool = villages[c].EnergyPool;
                System.out.println("패널티 체크 전에 에너지를 이동시키겠습니까? 1.예 2.아니오");
                choice = sc.nextInt();
                if(choice == 1) {
                    villages = energyLoan(villages, c); // 에너지 대출 이 함수가 패널티 체크전으로 가야함
                }
                villages = panaltyCheck(villages, c); // 패널티 체크
                villages = panalty(villages, c); // 패널티 부과
                villages = payOut(villages, c); // 돈 자동으로 갚아지는거
                // 패널티 체크 시작하고 들어가야함
                showEnergy(villages, c);
                System.out.println("1. 에너지 건물 구입 2. 에너지풀에 에너지 저장");
                choice = sc.nextInt();
                if (choice < 2) {
                    if (choice == 1){
                        villages = equipmentBuilding(villages, c); // 건물 구입 함수
                    } else if(choice == 2) {
<<<<<<< HEAD
                        System.out.println("1. 자동 에너지 저장 2. 수동 에너지 저장");
=======
                        // 얼마만큼의 에너지를 저장하겠습니까?
                        // 여기서도 분기 나누기 1은 자동저장 2는 얼마만큼 저장하겠다
>>>>>>> c1fdd972ad0f9bb7765a12598e897566518b5e61
                        villages = saveEnergy(villages, c);

                    }

                } else {
                    System.out.println("잘못 입력");
                }
                c++;
                // 턴 끝나면 zone을 0으로 만들어야 한다고? 그러면 바로 패널티 걸리잖아
                // 패널티 체크를 언제할 지 잘 정해야함
                if (c > villages.length) { // 한 턴 끝난거
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
            if (maxTransfer > 500) {
                System.out.println("최대 전송량은 500을 넘을 수 없습니다. 500으로 고정됩니다.");
            }
            System.out.print("최소 에너지: ");
            int minEnergy = sc.nextInt();
            if (minEnergy < 100) {
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

    public static Village[] turnPlus(Village[] vi) { // TODO 턴 플러스 되서 에너지 플러스 되는거랑 사람 에너지 때문에 마이너스 되는거 따로 만들어야함
        for (int i = 0; i < vi.length; i++) {
            for (int j = 0; j < vi[i].zoneCount; j++) {
                // 최소 에너지 요구량은 에너지를 소비하는 건 사람 수 마다 소비하게 됨 1명당 1, 건물은 아직 안정함
                // 근데 턴마다 사람으로 인해서 에너지를 2 얻음 그러니 그냥 더하기만 하면 됨
                vi[i].zone[j] += vi[i].people[j] * 2;
            }
        }
        return vi;
    }

    public static void showEnergy(Village[] vi, int c) {
        for (int i = c - 1; i < c; i++) {
            for (int j = 0; j < vi[i].zoneCount; j++) {
                System.out.println(vi[i].name + " 마을의 " + (j + 1) + "번 째 존의 에너지" + vi[i].zone[j]);
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
            if (vi[c].zoneCount > choice || vi[c].zoneCount < choice) {
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
                            if (vi[c].canEnergyPool > building_price) {
                                System.out.println("구입이 완료되었습니다.");
                                vi[c].canEnergyPool -= building_price;
                                flag2 = false;
                                flag = false;
                            } else {
                                System.out.println("금액이 모자랍니다. 선택화면으로 돌아갑니다.");
                                // 여기서 대출권도 있으면 좋겠는데 대출이 가능할까?
                            }
                        }
                        if (whileout == 1) {
                            System.out.println("잘못 선택하셨습니다 건물 선택화면으로 돌아갑니다.");
                            whileout = 0;
                        }
                    }
                }
            }


        }
        return vi;
    }

<<<<<<< HEAD

=======
>>>>>>> c1fdd972ad0f9bb7765a12598e897566518b5e61
    public static Village[] equipmentBuilding2(Village[] vi, int c) {
        // 이 부분 사실 캔에너지 부분으로 써야했는데 이상해졌네 존에서 에너지 어떻게 하는건데?
        // 어떻게 할건데? 에너지?
        // 설계 미스인데 에너지 풀에서 쓰는 에너지만 써야하는데
        // 존에 있는 에너지는 쓸 수 없을텐데 근데 페널티가 저장할때만 나오는거야? 그러면 패널티 나올일이 별로 없는데
        // 그러면 패널티가 적다기보다는 건물이 많은 순으로 순위를 매겨야 할 거 같은데

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
            if (vi[c].zoneCount > choice || vi[c].zoneCount < choice) {
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
                        if (whileout == 1) {
                            System.out.println("잘못 선택하셨습니다 건물 선택화면으로 돌아갑니다.");
                            whileout = 0;
                        }
                    }
                }
            }


        }
        return vi;
    }

    // 그냥 자기 마을에서 빌릴 때 이것도 한 턴으로 보자
    public static Village[] energyLoan(Village[] vi, int c) { // 그냥 대출할 때, 아니면 구입할 금액이 부족해서 대출할 때
        int origin = 0;
        int choice = 0;
        int energy = 0;
        boolean flag = true;
        boolean flag2 = true;
        boolean flag3 = true;
        while (flag) {
            System.out.println("어느 존이 대출을 받겠습니까?");
            origin = sc.nextInt();
            if (origin > vi[c].zoneCount) { // origin 가 크면안됨 작아야함
                System.out.println("잘못 선택하셨습니다");
            } else {
                while (flag2) {
                    System.out.println(origin + "존 에너지 : " + vi[c].zone[origin - 1]);
                    System.out.println("어느 존에게 대출을 받겠습니까?");
                    choice = sc.nextInt();
                    if (choice > vi[c].zoneCount) {
                        System.out.println("잘못 선택하셨습니다");
                    } else {
                        while (flag3) {
                            System.out.println(choice + "존 에너지 : " + vi[c].zone[choice - 1]);
                            System.out.println("얼마를 대출 받으시겠습니까?");
                            energy = sc.nextInt();
                            if (vi[c].maxTransfer < energy) { // 에너지 최대량을 넘을 때
                                System.out.println("에너지 전송 최대량을 넘을 수 없습니다.");
                            } else if (vi[c].zone[choice - 1] < energy) { // 존이 가진 에너지보다 많은 에너지를 선택했을 때
                                System.out.println(choice + "존 에너지 : " + vi[c].zone[choice - 1] + " 보다 많이 보내실 수 없습니다.");
                            } else {
                                vi[c].zone[origin - 1] += energy;
                                vi[c].zone[choice - 1] -= energy;
                                flag3 = false;
                                flag2 = false;
                                flag = false;
                                System.out.println("대출이 정상적으로 완료되었습니다.");
                                System.out.println(origin + "존 에너지 : " + vi[c].zone[origin - 1]);
                                System.out.println(choice + "존 에너지 : " + vi[c].zone[choice - 1]);
                            }
                        }
                    }
                }
            }


        }
        //vi[c].zone[choice - 1]

        return vi;
    }

    //public static Village[] minEnergyOut(Village[] vi, int c) { // 함수 하나가 너무 많이 일을 하게 만들지 말자 그냥 얘는 계산만 마이너스 되면 마이너스 되는대로ㅇㅇ
    //}

    public static Village[] panaltyCheck(Village[] vi, int c) { // 패널티 체크
        int minener = 0;
        for (int i = 0; i < vi[c].zoneCount; i++) {
            minener = Math.max(vi[c].minEnergy, vi[c].people[i]); // 사람 1명당 1의 에너지가 들어가니까
            if (vi[c].zone[i] < minener) {
                vi[c].panalty_check[i] = 1;
                vi[c].allPanalty++;
            } else {
                vi[c].panalty_check[i] = 0;
            }
        }
        return vi;
    }

    public static Village[] panalty(Village[] vi, int c) { // 패널티 부여
        int origin = 0; // 빌리는 놈
        int choice = 0; // 돈 빌려주는 놈
        int energy = 0;
        boolean flag = true;
        boolean flag2 = true;
        for (int i = 0; i < vi[c].zoneCount; i++) {
            if (vi[c].panalty_check[i] == 1) { // 그 존에 에너지풀에서 대출을 해주는거임
                while (flag) {
                    System.out.println((i + 1) + "존이 페널티가 있습니다. 에너지 양 : " + vi[c].zone[i]);
                    System.out.println("어느 마을에서 대출 받으시겠습니까?");
                    for (int j = 0; j < vi.length; j++) {
                        System.out.println(j + " : " + vi[j].EnergyPool);
                    }
                    choice = sc.nextInt();
                    if (vi.length < choice) { // 마을 잘못골랐을 때
                        System.out.println("잘못 고르셨습니다. 다시 골라주세요");
                    } else { // 마을 제대로 골랐을 때
                        while (flag2) {
                            System.out.println("얼마나 빌리시겠습니까?");
                            energy = sc.nextInt();
                            if (vi[choice - 1].EnergyPool < energy) { // 에너지풀 총량보다 많이 골랐을 때
                                System.out.println("에너지풀 총량을 초과하셨습니다" + vi[choice - 1].EnergyPool + "이하로 선택하셔아 합니다.");
                            } else if (vi[choice - 1].maxTransfer < energy) { // 최대 초과량보다 많이 골랐을 때
                                System.out.println("최대 전송량을 초과하셨습니다. " + vi[choice - 1].maxTransfer + " 이하로 선택하셔야합니다.");
                            } else {
                                vi[choice - 1].energy_loan[c][i] += energy; // 빌려주는놈
                                vi[choice - 1].EnergyPool -= energy; // 빌려주는놈
                                vi[c].energy_loan[c][i] -= energy; // 빌리는 놈
                                vi[c].zone[i] += energy; // 빌리는 놈
                                System.out.println("대출이 정상적으로 진행되었습니다.");
                                flag2 = false;
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        return vi;
    }

    public static Village[] payOut(Village[] vi, int c) { // 자동으로 돈 갚는 시스템
        // people이 최소 에너지임 그걸 이제 min보다 큰지 아닌지 체크해서 하는거고
        int minener = 0;
        for (int i = 0; i < vi.length; i++) {
            minener = Math.max(vi[c].minEnergy, vi[c].people[i]); // 사람 1명당 1의 에너지가 들어가니까
            for (int j = 0; j < vi[c].zoneCount; j++) {
                if(vi[c].energy_loan[i][j] < 0) { // 돈 갚을게 있다면

                    if(vi[c].zone[j] > vi[i].energy_loan[c][j] + minener) {
                        // vi[c].zone[j] > vi[c].energy_loan[i][j] + minener
                        // 위에가 원래 계산식이었으나 내가 빌렸으면 돈이 - 상태여서 계산이 어려워짐
                        // 그래서 + 상태가 되어있는 돈 빌린놈의 값을 가져와서 계산을 진행함
                        vi[c].zone[j] -= vi[i].energy_loan[c][j] + minener;
                        vi[i].EnergyPool += vi[i].energy_loan[c][j]; // 빌려준 놈 돈 다시 생기는거
                        vi[i].energy_loan[c][j] = 0; // 빌려준놈 돈 초기화
                        vi[c].energy_loan[i][j] = 0; // 빌린놈 돈 초기화
                        System.out.println("자동으로 돈이 갚아졌습니다.");
                        System.out.println(c+1 + "번 마을 " + j+1 + "번 째 존 에너지:" + vi[c].zone[j]);
                        System.out.println(i+1 + "번 마을 에너지풀: " + vi[i].EnergyPool);
                    }
                }
            }
        }
        return vi;
    }

    public static Village[] saveEnergy(Village[] vi, int c) { // 알아서 최소량 피해서 자동으로 저장 귀찮으니까 만든 거
        int minener = 0;
        int saveener = 0;
        for(int i = 0; i < vi[c].zoneCount; i++) {
            minener = Math.max(vi[c].minEnergy, vi[c].people[i]);
            if(vi[c].zone[i] > minener) { // 저장은 패널티 체크 다음이니까
                 saveener = vi[c].zone[i] - minener;
                 // 실제로 에너지풀에 저장되는 에너지는 다음턴에 쓸 수 있음 좋겠는데
                 // 거기에 에너지풀은 실제로는 들어가 있는데 쓸 수 있는 에너지는 몇입니다
                 // 에너지 총량: , 가용 에너지 총량: 이런 식으로 하자
                 // canEnergyPool에 적용되어야함 한 턴 지나면 다시 가용될 수 있게 더해지고 그 로직도 추가해야할 듯
                 vi[c].EnergyPool += saveener;
                 vi[c].canEnergyPool = vi[c].EnergyPool - saveener;
                 // 이 로직에서 다음 턴 지나면 더해질 수 있게
            }
        }
        return vi;
    }

    public static Village[] saveEnergy_2(Village[] vi, int c) { // 수동 저장
        int minener = 0;
        int saveener = 0;

        for(int i = 0; i < vi[c].zoneCount; i++) {
            minener = Math.max(vi[c].minEnergy, vi[c].people[i]);

            if(vi[c].zone[i] > minener) {
                System.out.println("에너지를 얼마나 저장하시겠습니까?");
                System.out.println(i+1 + "존 에너지 현재 총량은 " + vi[c].zone[i] + " 입니다.");
                System.out.println("에너지를 저장하고 난 후 " + minener + " 보다 적으면 패널티를 얻습니다.\n 얼마만큼의 에너지를 저장하시겠습니까?");

                saveener = sc.nextInt();

                
            }
        }
        return vi;
    }




}

