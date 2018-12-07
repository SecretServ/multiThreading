package com.javarush.task.task25.task2506;

/**
 * Created by Danver on 04.11.2018.
 */

public class LoggingStateThread extends Thread {

    Thread thread;
    State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        state = thread.getState();
    }

    public void run() {
        //super.run();
        String stateTarget = new String();
        while (true) {
            if (!(stateTarget.equals(thread.getState().name()))) {
                stateTarget = thread.getState().name();
                System.out.println(stateTarget);
                if (stateTarget.equals("TERMINATED")) {
                    break;
                }
            }
        }
    }



}

