package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {

    public static boolean condition = false;
    public static boolean braskets = false;

    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) {
            return false;
        }

        if (telNumber != null || !telNumber.isEmpty()) {
            condition = true;

                if (checkBasic(telNumber)) {
                    condition = true;

                    if (checkStartDigitOrBrascket(telNumber)) {
                        condition = true;
                        if ((checkDigitsCount(telNumber) == 10)) {
                            condition = true;
                            if (checkIfDoubleCurves(telNumber)) {
                                condition = true;
                                if (checkBrascketsConditions(telNumber)) {
                                    condition = false;
                                    //condition = checkIfDoubleCurves(telNumber);
                                } else {
                                    condition = true;
                                }
                            } else {
                                condition = false;
                            }
                        } else {
                            condition = false;
                        }
                    } else if (checkStartPlus(telNumber)) {
                        condition = true;
                        if ((checkDigitsCount(telNumber) == 12)) {
                            condition = true;
                            if (checkIfDoubleCurves(telNumber)) {
                                condition = true;
                                if (checkBrascketsConditions(telNumber)) {
                                    condition = false;
                                } else {
                                    condition = true;
                                }
                            } else {
                                condition = false;
                            }
                        } else {
                            condition = false;
                        }
                    } else {
                        condition = false;
                    }

                } else { //basic
                    condition = false;
                }

        } else { //!null
            condition = false;
        }

        //condition = checkIfDoubleCurves(telNumber);


        return condition;
    }


    //////////////////////////

    public static boolean checkBasic (String str) {
        Pattern p = Pattern.compile(".*[^()+\\d\\n\\r-].*|.*[^\\d]$|.*-{2,}.*|(?:.*-.*){3,}");
        Matcher m = p.matcher(str);
        return !m.matches();
    }

    /*public static boolean checkBegining (String str) {
        Pattern p = Pattern.compile("^(\\+.*).*|^(\\d.*).*|^(\\(.*).*");
        Matcher m = p.matcher(str);
        return m.matches();
    }*/

    public static boolean checkStartPlus(String str) {
        Pattern p = Pattern.compile("^\\+.*");
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
        /*Pattern p = Pattern.compile("(?<=\\().*(?=\\))");
        Matcher m = p.matcher(str);*/


        Pattern p1 = Pattern.compile("^.*-.*\\(\\d+\\).*|.*(\\(\\d+\\)).*(\\(\\d+\\)).*|.*\\(\\d{0,2}\\).*|.*\\(\\d{4,}\\).*|.*\\).*\\(.*|(.*\\(.*){2,}|(.*\\).*){2,}");
        Matcher m1 = p1.matcher(str);
        return m1.matches();
    }

    public static boolean checkIfDoubleCurves(String str) {

        Pattern p = Pattern.compile("\\(|\\)");
        Matcher m = p.matcher(str);

        if (m.find()) {
            int counLeft = 0;
            int counRight = 0;
            Pattern pLeft = Pattern.compile("\\(");
            Pattern pRight = Pattern.compile("\\)");
            Matcher mLeft = pLeft.matcher(str);
            Matcher mRight = pRight.matcher(str);

            while(mLeft.find()) {
                counLeft++;
            }

            while(mRight.find()) {
                counRight++;
            }

            if (counLeft == counRight && counLeft == 1) {
                braskets = true;
            } else {
                braskets = false;
            }
        } else {//endif
            braskets = true;
        }

        return braskets;

    }

    public static void main(String[] args) {

        /*System.out.println("+380501234567: " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567: " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67: " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567: " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567: " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7: " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567: " + checkTelNumber("050ххх4567"));
        System.out.println("050123456: " + checkTelNumber("050123456"));
        System.out.println("(0)501234567: " + checkTelNumber("(0)501234567"));*/

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
        System.out.println("(02254)50123: " + checkTelNumber("(02254)50123"));
        System.out.println("(025)01(234)57: " + checkTelNumber("(025)01(234)57"));
        System.out.println("+38)050(1234-567: " + checkTelNumber("+38)050(1234-567"));
        System.out.println(")0501234567: " + checkTelNumber(")0501234567"));
        System.out.println("(0501234567: " + checkTelNumber("(0501234567"));
        System.out.println("05012(34567: " + checkTelNumber("05012(34567"));
        System.out.println("05012)34567: " + checkTelNumber("05012)34567"));

        System.out.println("05(012(34567: " + checkTelNumber("05(012(34567"));
        System.out.println("(05012345674: " + checkTelNumber("(05012345674"));



        /*System.out.println("(38(050)1234567: " + checkStartDigitOrBrascket("(38(050)1234567"));
        System.out.println("+380501234: " + checkStartDigitOrBrascket("+380501234"));*/


    }
}
