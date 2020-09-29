package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    public static final Logger log = Logger.getLogger(Part1.class.getName());

    public static String getInput(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return stringBuilder.toString().trim();
        } catch (IOException ex) {
            log.log(Level.SEVERE,"Exception ",ex);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(Part1.delete(getInput("part1.txt")));
    }

    public static String delete(String input){
        StringBuffer stringBuilder;
        Pattern pat  = Pattern.compile("\\b\\w{4,}", Pattern.UNICODE_CHARACTER_CLASS |Pattern.MULTILINE |Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(input);
        stringBuilder = new StringBuffer();
        while (m.find()){
            m.appendReplacement(stringBuilder,m.group().substring(2));
        }
        m.appendTail(stringBuilder);
        return stringBuilder.toString();
    }
}