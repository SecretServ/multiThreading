package com.javarush.task.task26.task2603;

import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;
        public int size = comparators.length;

        public CustomizedComparator(Comparator<T>... vararg) {
            for (int i = 0; i < size; i++) {
                comparators[i] = vararg[i];
            }
        }


        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) break;
            }
            return result;
        }


    }
}
