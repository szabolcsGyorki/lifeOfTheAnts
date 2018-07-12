package com.codecool.LifeOfTheAnts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Hive {

    static byte maxPosX = 50;
    static byte maxPosY = 50;
    static byte minPosX = 50;
    static byte minPosY = 50;
    static byte waspX;
    static byte waspY;

    static boolean queensMatingMood;
    static boolean waspAttack;


    private static void doesWaspAttack() {

        Random random = new Random();
        int waspChance = random.nextInt(100);
        if (waspChance > 95) {
            Wasp wasp = new Wasp();
            waspX = wasp.getPosX();
            waspY = wasp.getPosY();
            waspAttack = true;
        }
    }

    public static void main(String[] args) {
        List<Ant> ants = new ArrayList<>();
        Queen queen = new Queen();

        ants.add(queen);
        for (int i = 0; i < 8; i++) {
            ants.add(new Soldier());
        }
        for (int i = 0; i < 12; i++) {
            ants.add(new Worker());
        }
        for (int i = 0; i < 25; i++) {
            ants.add(new Drone());
        }

        for (int i = 0; i < 2000; i++) {
            queensMatingMood = queen.isInMatingMood();
            if (!waspAttack) {
                doesWaspAttack();
            }

            for (Ant ant : ants) {
                ant.move();
                if (ant instanceof Drone) {
                    if (((Drone) ant).getMatingCounter() == 10) {
                        queen.setMatingMoodCounter();
                        queen.setMatingMood(false);
                    }
                }
            }
        }
    }

}
