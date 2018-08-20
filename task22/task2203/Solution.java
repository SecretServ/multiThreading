package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception {

        if (string == null) {
            throw new TooShortStringException();
        }

        char[] arr = string.toCharArray();
        int size = arr.length;
        int counter = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i]== '\t') {
                counter++;
                if (counter == 1) {
                    start = i + 1;
                }
                    if (counter == 2) {
                        end = i;
                }
            }
        }

        if (counter < 2) {
            throw new TooShortStringException();
        } else {
            return string.substring(start, end);
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
