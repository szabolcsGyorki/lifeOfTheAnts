package com.codecool.LifeOfTheAnts;

import java.util.Random;

class Worker extends Ant {

    @Override
    void move() {
        if (!Hive.waspAttack) {
            Random random = new Random();
            while (true) {
                byte direction = (byte) (random.nextInt(4) + 1);
                if (direction == 1) {
                    if (posX + 1 < Hive.maxPosX)
                        posX++;
                    break;
                }
                if (direction == 2) {
                    if (posX - 1 > Hive.minPosX)
                        posX--;
                    break;
                }
                if (direction == 3) {
                    if (posY + 1 < Hive.maxPosY)
                        posY++;
                    break;
                }
                if (direction == 4) {
                    if (posY - 1 > Hive.minPosY)
                        posY--;
                    break;
                }
            }
        }
    }
}
