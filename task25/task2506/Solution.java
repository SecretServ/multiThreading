package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);
        //Thread.sleep(1000);
        loggingStateThread.start(); //NEW
        Thread.sleep(1000);
        target.start();  //RUNNABLE
        Thread.sleep(1000);
        //TERMINATED
    }
}
