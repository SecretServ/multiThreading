package com.javarush.task.task25.task2506;

/**
 * Created by Danver on 04.11.2018.
 */
public class LoggingStateThread extends Thread {

    Thread thread;
    State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.state = thread.getState();
    }

    public void run() {

        //System.out.println(state);
        //Thread.State state = thread.getState();
        while (state != State.TERMINATED) {
            System.out.println(state);
            if (state == State.TERMINATED) {
                return;
            }
        }
            Thread.currentThread().interrupt();
            return;
    }
}
