package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread thread;

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override

        public void run() { System.out.println(Thread.currentThread().getName()); while (!Thread.currentThread().isInterrupted()) { try { Thread.sleep(100); System.out.println(Thread.currentThread().getName()); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } } }

    @Override
    public void stop() {
        Thread.currentThread().interrupt();
    }

   /* @Override
    public void stop() {
        Thread.currentThread().interrupt();
    }*/

    /*@Override public void run() {
        System.out.println(Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); }
        }
    }*/


}
