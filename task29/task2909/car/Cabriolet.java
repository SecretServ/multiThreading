package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {
    public int numberOfPassengers;

    public Cabriolet (int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 90;
        return MAX_SEDAN_SPEED;
    }
}
