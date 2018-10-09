package com.javarush.task.task24.task2413;

import java.util.List;

/**
 * Created by BrigadaSSEE on 08.10.2018.
 */
public class Arkanoid {

    private int width;
    private int height;

    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    static Arkanoid game;

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void setStand(Stand stand) { this.stand = stand; }
    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public Ball getBall() {
        return this.ball;
    }
    public Stand getStand() {
        return this.stand;
    }
    public List<Brick> getBricks() { return this.bricks; }



    public Arkanoid(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void run() {}
    public void move() {
        ball.move();
        stand.move();
    }

    public void draw(Canvas canvas) {
        ball.draw(canvas);
        stand.draw(canvas);
        for (int i = 0; i < bricks.size(); i++) {
            bricks.get(i).draw(canvas);
        }

    }


    public static void main(String[] args) {

    }
}
