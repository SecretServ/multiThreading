package com.javarush.task.task25.task2508;

public abstract interface CustomThreadManipulator {
    public void start(String threadName);
    public void stop();
}
