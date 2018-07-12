package com.codecool.LifeOfTheAnts;

import java.util.Random;

abstract class Insect {

    byte posX;
    byte posY;

    Insect() {
        setPosX();
        setPosY();
    }

    private void setPosX() {
        Random random = new Random();
        do {
            this.posX = (byte) (random.nextInt(100) - 50);
        } while (posX < Hive.maxPosX && posX > Hive.minPosX);
    }

    private void setPosY() {
        Random random = new Random();
        do {
            this.posY = (byte) (random.nextInt(100) - 50);
        } while (posX < Hive.maxPosY && posX > Hive.minPosY);
    }
}
