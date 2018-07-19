package com.javarush.task.task21.task2113;

/**
 * Created by BrigadaSSEE on 16.07.2018.
 */
public class Horse {
    public String name;
    public double speed;
    public double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    /////////////////////////////////////
    public void setSpeed (double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return this.speed;
    }
    /////////////////////////////////////
    public void setDistance (double distance) {
        this.distance = distance;
    }
    public double getDistance() {
        return this.distance;
    }

    public void move() {
        setDistance(getDistance() + (getSpeed() * Math.random()));
    }
    public void print() {
        int count = (int)Math.round(Math.floor(getDistance()));
        for (int i = 0; i < count; i++) {
            System.out.print(".");
        }
        System.out.println(getName());
    }
}
