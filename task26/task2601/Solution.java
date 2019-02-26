package com.javarush.task.task26.task2601;

//import java.lang.reflect.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    //public static int medi = 0;

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};//new Integer[5];
        //array = {13, 8, 15, 5, 17};
        for (Integer value : array) {
            System.out.println(value);
        }

        System.out.println("After Sorting");
        array = sort(array);

        for (Integer value : array) {
            System.out.println(value);
        }

        //System.out.println(medi);


    }

    public static Integer[] sort(Integer[] array) {
        int size = array.length;
        int medi;
        int index;
        Integer[] newArray = new Integer[size];

        //int medi = 0;
        /*int index = array.length;
        int tmp = 0;
        for (int i = index - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }*/

        Arrays.sort(array);

        if (size % 2 == 0) {
            medi = (array[size / 2] + array[size / 2 + 1]) / 2;
            System.out.println("medi = " + medi);
        } else {

            medi = array[(size - 1) / 2];
            index = (size - 1) / 2;
            newArray[0] = medi;
            System.out.println("odd medi = " + medi);
            System.out.println("medi index = " + index);

            for (int i = 1, j = index + i; i <= index; i++) {
                newArray[i] = array[index + i];
                newArray[j] = array[index - i];
            }

            /*for (int i = index, j = index; i < size & j >= 0; i++, j--) {


            }*/
        }



        System.out.println(medi);

        //System.out.println();

        //implement logic here
        return newArray;
    }
}
