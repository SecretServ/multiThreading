package com.javarush.task.task25.task2508;

/* 
Не валять дурака
*/
public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        try {
            manipulator.start("first");
            Thread.sleep(150);
        } catch (InterruptedException e) {
            manipulator.stop();
        }
        try {
            manipulator.start("second");
            Thread.sleep(250);
        } catch (InterruptedException e) {
            manipulator.stop();
        }

        try {
            manipulator.start("forth");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            manipulator.stop();
        }

            manipulator.start("third");
            manipulator.stop();





        try {
            manipulator.start("fifth");
            Thread.sleep(1);

    } catch (InterruptedException e) {
    manipulator.stop();
}    }
}