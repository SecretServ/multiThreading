package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BrigadaSSEE on 16.07.2018.
 */
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private static List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse  target : getHorses()) {
            target.move();
        }
    }
    public void print() {
        for (Horse  target : getHorses()) {
            target.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int size = getHorses().size();
        double max = getHorses().get(0).getDistance();
        int counter = 0;
        for (int i = 1; i < size; i++) {
            if (max < getHorses().get(i).getDistance()) {
                max = getHorses().get(i).getDistance();
                counter = i;
            }
        }
        return getHorses().get(counter);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main (String[] args) throws InterruptedException {
        Horse horse1 = new Horse("horse1",3,0);
        Horse horse2 = new Horse("horse2",3,0);
        Horse horse3 = new Horse("horse3",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
    }

}