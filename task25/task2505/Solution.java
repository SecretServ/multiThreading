package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {


    public static void main(String[] args) throws InterruptedException  {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

            String name;
            Thread t;
            Throwable e;

           public MyUncaughtExceptionHandler() {
               try {
                   t = new Thread();
                   Thread.sleep(500);
                   System.out.print(secretKey + ", " + Thread.currentThread().getName() + ", " + t + " " + MyUncaughtExceptionHandler.this.e);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   System.out.println();
               }
           }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
               this.t = t;
               this.e = e;
            }
        }

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            this.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

