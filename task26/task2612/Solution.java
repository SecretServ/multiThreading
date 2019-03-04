package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {

    private Lock lock = new ReentrantLock();

    public void someMethod() {

        //lock.lock();
        if (lock.tryLock()) {
            try {
                ifLockIsFree();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }
        } else {
                ifLockIsBusy();
        }
        // Implement the logic here. Use the lock field
    }

    public void ifLockIsFree() {actionIfLockIsFree();}

    public void ifLockIsBusy() {actionIfLockIsBusy();}

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
