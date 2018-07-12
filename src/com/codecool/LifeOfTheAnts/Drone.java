package com.codecool.LifeOfTheAnts;

import java.util.Random;

class Drone extends Ant {

    private byte matingCounter = 0;

    @Override
    void move() {
        if (!Hive.waspAttack) {
            if (matingCounter > 0) {
                matingCounter--;
                if (matingCounter == 0) {
                    kickedOut();
                }
            } else {
                if (posX > 0) {
                    posX--;
                } else if (posX < 0) {
                    posX++;
                } else if (posY > 0) {
                    posY--;
                } else if (posY < 0) {
                    posY++;
                }
                if (distanceFromQueen() < 3) {
                    tryMating();
                }
            }
        }
    }

    private void tryMating() {
        if (Hive.queensMatingMood) {
            System.out.println("HALLELUJA");
            matingCounter = 10;
        } else {
            System.out.println("D'OH");
            kickedOut();
        }
    }

    private void kickedOut() {
        Random random = new Random();
        do {
            posX = (byte) (random.nextInt(100) - 50);
        } while (posX > -40 && posX < 40);
        do {
            posY = (byte) (random.nextInt(100) - 50);
        } while (posX > -40 && posX < 40);
    }

    byte getMatingCounter() {
        return matingCounter;
    }
}
