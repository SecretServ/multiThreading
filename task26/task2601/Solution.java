package com.javarush.task.task26.task2601;

//import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {


    public static void main(String[] args) {
        /*Integer[] array = {13, 8, 15, 5};
        for (Integer value : array) {
            System.out.println(value);
        }

        System.out.println("After SUPERsorting");
        array = sort(array);

        for (Integer value : array) {
            System.out.println(value);
        }*/
    }

    public static Integer[] sort(Integer[] array) {
        int size = array.length;
        int medi;
        Integer[] newArray = new Integer[size];

        Arrays.sort(array);
        //System.out.println("After Sorting");
        for (Integer value : array) {
            System.out.println(value);
        }

        if (size % 2 == 0) {
            medi = (array[(size - 1) / 2] + array[(size + 1) / 2]) / 2;
        } else {
            int index = (size - 1) / 2;
            medi = array[index];
        }

        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(medi - o1) - Math.abs(medi - o2);
            }
        };

        Arrays.sort(array, compareByMediana);

        return array;
    }
}
