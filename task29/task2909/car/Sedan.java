package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {
    public int numberOfPassengers;

    public Sedan (int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
