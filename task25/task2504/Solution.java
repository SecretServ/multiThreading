package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread value : threads)
        switch (value.getState()) {
            case NEW : value.start();
                break;
            case WAITING : value.interrupt();
                break;
            case TIMED_WAITING : value.interrupt();
                break;
            case BLOCKED : value.interrupt();
                break;
            case RUNNABLE : value.isInterrupted();
                break;
            case TERMINATED :
                System.out.println(value.getPriority());
                break;
            default:
                System.out.println("This is default message");
        }
    }

    public static void main(String[] args) {
    }
}
