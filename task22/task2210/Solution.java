package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        /*int count = getTokens("level22.lesson13.task01", ".").length;
        String[] arch = getTokens("level22.lesson13.task01", ".");

        for (int i = 0; i < count; i++) {
            System.out.println(arch[i]);
        }*/

    }


    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        int count = tokenizer.countTokens();
        String[] arch = new String[count];
        while (tokenizer.hasMoreTokens()) {
            for (int i = 0; i < count; i++) {
                arch[i] = tokenizer.nextToken();
            }
        }
        return arch;
    }
}
