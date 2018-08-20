package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        if (string == null) {
            throw new TooShortStringException();
        }

        char[] arr = string.toCharArray();
        int size = arr.length;
        int counter = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < size; i++) {
            if (Character.isWhitespace(arr[i])) {
                counter++;
                if (counter == 1) {
                    start = i + 1;
                }
                if (counter >= 4) {
                    if (counter == 5) {
                        end = i;
                    } else if (counter == 4) {
                        end = size;
                    } else {
                        System.out.println("counter > 5");
                        break;
                    }
                }
            }
        }

        if (counter < 4) {
            throw new TooShortStringException();
        } else {
            return string.substring(start, end);
        }
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
