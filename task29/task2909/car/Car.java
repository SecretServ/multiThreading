package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    /*public Date date;
    public Date SummerStart;
    public Date SummerEnd;
    public int length;*/

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    protected Car(){}

    public void fill(double numberOfLiters) throws Exception{
            if (numberOfLiters < 0)
                throw new Exception();
            fuel += numberOfLiters;
    }

    /********************************************************************/
    /*public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
        } else {
            consumption = length * summerFuelConsumption;
        }
        return consumption;
    }*/
    /********************************************************************/

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        boolean temp;
        if (date.after(summerStart) && date.before(summerEnd)) {
            temp = true;
        } else {
            temp = false;
        }
        return temp;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    /*********************************************************************/
    /*public int getNumberOfPassengersCanBeTransferred() {
        if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;

        return numberOfPassengers;
    }*/
    /*********************************************************************/
    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        } else {
            return 0;
        }
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    /************************************************************/
    /*public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }
    }*/
    /************************************************************/
    public void startMoving() {
        //if (driverAvailable) {
            fastenDriverBelt();
            if (numberOfPassengers > 0) fastenPassengersBelts();
        }



    private boolean canPassengersBeTransferred() {
        if (driverAvailable && fuel > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    /************************************************************/
    /*public int getMaxSpeed() {
        if (type == TRUCK)
            return 80;
        if (type == SEDAN)
            return 120;
        return 90;
    }*/
    /************************************************************/
    public abstract int getMaxSpeed();



    public static Car create(int type, int numberOfPassengers) {
        if (type==Car.TRUCK) {
            return new Truck(numberOfPassengers);
        } else if (type==Car.SEDAN) {
            return new Sedan(numberOfPassengers);
        } else if (type==Car.CABRIOLET) {
            return new Cabriolet(numberOfPassengers);
        } else return null;
    }


}