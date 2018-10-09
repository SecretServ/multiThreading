package com.javarush.task.task24.task2413;

/**
 * Created by BrigadaSSEE on 08.10.2018.
 */
public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);
    public abstract void move();

    public boolean isIntersec(BaseObject o) {
        double dist = Math.sqrt(Math.pow((this.x - o.x), 2) + Math.pow((this.y - o.y), 2));
        return dist <= Math.max(this.radius, o.radius);
    }

}
