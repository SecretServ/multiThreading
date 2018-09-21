package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {

    public static boolean condition = false;

    public static boolean checkTelNumber(String telNumber) {



        if (telNumber != null) {
            condition = true;
            if (checkBasic(telNumber)) {
                condition = true;

                if (checkStartPlus(telNumber) && (checkDigitsCount(telNumber) == 12)) {
                    condition = checkBrascketsConditions(telNumber);
                } else {
                    condition = false;
                }


                if (checkStartDigitOrBrascket(telNumber) && (checkDigitsCount(telNumber) == 10)) {
                    condition = checkBrascketsConditions(telNumber);
                } else {
                    condition = false;
                }
            }
        }
        return condition;
    }

    public static boolean checkBasic (String str) {
        Pattern p = Pattern.compile(".*[^()+\\d\\n\\r-].*|.*[^\\d]$|.*-{2,}.*|(?:.*-.*){3,}");
        Matcher m = p.matcher(str);
        return !m.matches();
    }

    public static boolean checkStartPlus(String str) {
        Pattern p = Pattern.compile("^\\+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean checkStartDigitOrBrascket(String str) {
        Pattern p = Pattern.compile("^[(\\d].*");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static int checkDigitsCount (String str) {
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        int counter = 0;
        while(m.find()) {
            counter++;
        }
        return counter;
    }

    public static boolean checkBrascketsConditions(String str) {
        Pattern p = Pattern.compile(".*\\(.*");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            Pattern p1 = Pattern.compile("^.*-.*\\(\\d+\\).*|.*(\\(\\d+\\)).(\\(\\d+\\)).*|\\(\\d{0,2}\\)|\\(\\d{4,}\\)|.*\\).*\\(.*");
            Matcher m1 = p1.matcher(str);
            return !m1.matches();
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("+380501234567: " + checkTelNumber("+380501234567"));
        System.out.println("+38050123-45-67: " + checkTelNumber("+38050123-45-67"));
        System.out.println("0501234564: " + checkTelNumber("0501234564"));
        System.out.println("(050)1234567: " + checkTelNumber("(050)1234567"));
        System.out.println("(050)123-4567: " + checkTelNumber("(050)1234567"));



        System.out.println("050aaa4567: " + checkTelNumber("050aaa4567"));
        System.out.println("+38(050)1-23-45-6-7: " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("(0501234567-: " + checkTelNumber("(0501234567-"));
        System.out.println("(0501--234567: " + checkTelNumber("(0501--234567"));

        System.out.println("(025)501234567: " + checkTelNumber("(025)501234567"));
        System.out.println("+380-5012(345)67: " + checkTelNumber("+380-5012(345)67"));
        System.out.println("(02)50123457: " + checkTelNumber("(02)50123457"));
        System.out.println("+38)050(1234-567: " + checkTelNumber("+38)050(1234-567"));
        System.out.println(")0501234567: " + checkTelNumber(")0501234567"));
        System.out.println("(0501234567: " + checkTelNumber("(0501234567"));


        /*System.out.println("(38(050)1234567: " + checkStartDigitOrBrascket("(38(050)1234567"));
        System.out.println("+380501234: " + checkStartDigitOrBrascket("+380501234"));*/




    }
}
