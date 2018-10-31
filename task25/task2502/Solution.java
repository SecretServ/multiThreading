package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception  {


            wheels = new ArrayList<>();
            for (String value : this.loadWheelNamesFromDB()) {
                wheels.add(Wheel.valueOf(value));
            }
            //init wheels here

            if (wheels.size() != 4) {
                throw new Exception();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {

        Car car = new Car();

        for (Wheel value : car.wheels) {
            System.out.println(value);
        }
    }
}
