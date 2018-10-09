package com.javarush.task.task24.task2413;

/**
 * Created by BrigadaSSEE on 08.10.2018.
 */
public class Ball extends BaseObject {

    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getSpeed() {
        return speed;
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'O');
    }

    @Override
    public void move() {
        if (!isFrozen) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    void checkRebound(int minx, int maxx, int miny, int maxy) {

    }

    public void start() {
        isFrozen = false;
    }
}
