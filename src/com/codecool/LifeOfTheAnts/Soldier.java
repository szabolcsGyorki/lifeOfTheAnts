package com.codecool.LifeOfTheAnts;

class Soldier extends Ant {

    private byte cycle = 1;

    @Override
    void move() {
        if (!Hive.waspAttack) {
            switch (cycle) {
                case 1:
                    posX++;
                    cycle++;
                    break;
                case 2:
                    posY++;
                    cycle++;
                    break;
                case 3:
                    posX--;
                    cycle++;
                    break;
                case 4:
                    posY--;
                    cycle = 1;
                    break;
            }
        } else {
            if (posX > Hive.waspX) {
                posX--;
            } else if (posX < Hive.waspX) {
                posX++;
            } else if (posY > Hive.waspY) {
                posY--;
            } else if (posY < Hive.waspY) {
                posY++;
            }
            if (posX == Hive.waspX && posY == Hive.waspY) {
                System.out.println("HAJIME");
                Hive.waspAttack = false;
            }
        }
    }
}
