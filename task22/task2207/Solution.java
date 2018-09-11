package com.javarush.task.task22.task2207;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.*;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();
    //public static

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            sb.append(str + " ");
        }

        String merge = sb.toString().trim();
        String[] arr = merge.split(" ");
        String[] rArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rArr[i] = rsb.append(arr[i]).reverse().toString();
            rsb.delete(0, rsb.capacity());
        }

        int counter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < rArr.length; j++) {
                if (arr[i].equals(rArr[j])) {
                    counter++;
                    if (counter % 2 == 0) {
                        break;
                    } else {
                        Pair pair = new Pair();
                        pair.first = arr[j];
                        pair.second = arr[i];
                        result.add(pair);
                        break;
                    }
                }
            }
        }

        for (Pair value : result) {
            System.out.println(value);
        }
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        br.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = reader.readLine()) != null ) {
            String[] arr = str.split(" ");
            for (String value : arr) {
                System.out.println(value);
            }
        }


*/

    }

    public static class Pair {
        String first;
        String second;

        Pair() {
        }

        /*Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
