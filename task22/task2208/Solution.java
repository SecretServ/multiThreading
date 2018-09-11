package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {

    public static Map<String, String> map = new LinkedHashMap<String, String>();




    public static void main(String[] args) {
        /*map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);*/

        /*map.put("23f", null);
        map.put("6543", null);

        System.out.println(map);

        System.out.println(getQuery(map));*/

        /*Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", "15asd");
        map.put("dfsd", "15asafsd");
        map.put("123edf", "dsfsa");
        map.put("fgfdgaerg", "1rf234f4d");

        System.out.println(getQuery(map));*/

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        int size = params.size();
        if (size == 0) {
            return sb.toString().trim();
        }
        for (Map.Entry entry : params.entrySet()) {
            if (entry.getValue() == null) {
                size--;
            } else {
                size--;
                sb.append(entry.getKey() + " = " + "'" + entry.getValue() + "'");

                if (size > 0) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString().trim();
    }
}
