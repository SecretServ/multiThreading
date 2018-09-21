package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //FileReader fr = new FileReader(args[0]);
        //FileWriter fw = new FileWriter("aUTF8.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "WINDOWS-1251"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"));
        String str;
        while ((str = reader.readLine()) != null) {
            writer.write(str);
            //writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
