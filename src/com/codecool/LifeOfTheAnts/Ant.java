package com.codecool.LifeOfTheAnts;

abstract class Ant extends Insect {

    abstract void move();

    byte distanceFromQueen() {
        return (byte) (Math.abs(posX) + Math.abs(posY));
    }
}
