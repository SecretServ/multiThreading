package com.javarush.task.task24.task2413;

/**
 * Created by BrigadaSSEE on 08.10.2018.
 */
public class Stand extends BaseObject {

    private double speed;
    private double direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public double getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        setX(getX() + (direction * speed));
    }

    public void moveLeft() {
        direction = -1;
    }

    public void moveRight() {
        direction = 1;
    }


}
