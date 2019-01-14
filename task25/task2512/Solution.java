package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;

/*
Живем своим умом
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler  {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        Throwable th = e;

        while (th != null) {
            list.add(th);
            th = th.getCause();
        }

        Collections.reverse(list);
        for (Throwable value : list) {
            System.out.println(value.getClass().getName() + ": " + value.getMessage());
        }

    }



    public static void main(String[] args) throws Exception {
            /*Solution solution = new Solution();
            Thread thread = new Thread(solution);
            thread.start();
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));*/
        }


    }

