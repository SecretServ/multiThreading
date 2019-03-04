package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {


    public Soldier(String name, int age) {
        super.name = name;
        super.age = age;
    }

    public void live() {
            fight();
    }

    public void fight() {
    }
}
