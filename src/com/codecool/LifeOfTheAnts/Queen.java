package com.codecool.LifeOfTheAnts;

import java.util.Random;

class Queen extends Ant {

    private boolean matingMood;
    private short matingMoodCounter;

    Queen() {
        Random random = new Random();
        int moodChance = random.nextInt(1);
        setMatingMood(moodChance == 1);
        if (!matingMood) {
            setMatingMoodCounter();
        }
    }

    @Override
    void move() {
        if (!Hive.waspAttack) {
            if (matingMoodCounter > 0) {
                matingMoodCounter--;
            }
            if (matingMoodCounter == 0) {
                setMatingMood(true);
            }
        }
    }

    boolean isInMatingMood() {
        return matingMood;
    }

    void setMatingMood(boolean matingMood) {
        this.matingMood = matingMood;
    }

    void setMatingMoodCounter() {
        Random random = new Random();
        this.matingMoodCounter = (short) (random.nextInt(100) + 100);
    }
}
