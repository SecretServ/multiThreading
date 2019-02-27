package com.javarush.task.task26.task2601;

//import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    //public static int medi = 0;

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        for (Integer value : array) {
            System.out.println(value);
        }

        System.out.println("After Sorting");
        //array = sort(array);

        for (Integer value : array) {
            System.out.println(value);
        }
    }

    public static Integer[] sort(Integer[] array) {
        int size = array.length;
        int medi;
        Integer[] newArray = new Integer[size];

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //Arrays.sort(array);

        class SortedByMedi implements Comparator<Integer[]> {

            public int compare(Integer[] obj1, Integer[] obj2) {


                int value1  = obj1 - medi;
                double price2 = obj2.getPrice();

                if(price1 > price2) {
                    return 1;
                }
                else if(price1 < price2) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }

        if (size % 2 == 0) {
            medi = (array[(size - 1) / 2] + array[(size + 1) / 2]) / 2;
            int tmp = size / 2;
            int bigIndex = tmp;
            int smallIndex = tmp - 1;

            System.out.println("medi = " + medi);
        } else {
            int index = (size - 1) / 2;
            medi = array[index];
        }
        return newArray;
    }

    /*public static Integer[] sort(Integer[] array) {
        int size = array.length;
        int medi;
        Integer[] newArray = new Integer[size];

        Arrays.sort(array);

        if (size % 2 == 0) {
            medi = (array[(size - 1) / 2] + array[(size + 1) / 2]) / 2;
            int tmp = size / 2;
            int bigIndex = tmp;
            int smallIndex = tmp - 1;

            System.out.println("medi = " + medi);
        } else {
            int index = (size - 1) / 2;
            medi = array[index];
            System.out.println("medi = " + medi);
            System.out.println("After Sorting");
            //array = sort(array);

            for (Integer value : array) {
                System.out.println(value);
            }

            System.out.println("After SUPERsorting");

            //int minDiapasone = Math.abs(medi - array[0]);
            *//*int valueAtMinDiapasone = 0;
            int indexAtMinDiapasone = 0;*//*


            *//***********************************************************************************//*

            for (int i = 0; i < size; i++) {

                int minDiapasone = Math.abs(medi - array[i]);
                int valueAtMinDiapasone = 0;
                int indexAtMinDiapasone = 0;

                *//*System.out.println("FirstMinDiapasone: " + minDiapasone);
                System.out.println("FirstValueAtMinDiapasone: " + valueAtMinDiapasone);*//*

                for (int j = i; j < size; j++) {
                        //int tmp = Math.abs(medi - array[j]);
                        if ((Math.abs(medi - array[j]) < minDiapasone) && array[j] != medi) {
                            minDiapasone = Math.abs(medi - array[j]);
                            valueAtMinDiapasone = array[j];
                            indexAtMinDiapasone = j;
                            System.out.println("minDiapasone: " + minDiapasone);
                            System.out.println("valueAtMinDiapasone: " + valueAtMinDiapasone);
                        }
                }

                newArray[i] = valueAtMinDiapasone;
                array[indexAtMinDiapasone] = medi;
            }

            *//***********************************************************************************//*

        }
        return newArray;
    }*/
}
