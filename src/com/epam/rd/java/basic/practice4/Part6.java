package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part6 {
    public static final String CYRL = "[а-яА-ЯЁёЄєІіЇї]+";
    public static final String LATN = "[a-zA-Z]+";
    public static final String PATH = "part6.txt";

    public static String writeLatin() {
        String input = Demo.readFile(PATH);
        Pattern pattern1 = Pattern.compile(LATN);
        Matcher m1 = pattern1.matcher(input);
        StringBuilder latinStr = new StringBuilder();
        while (m1.find()) {
            latinStr.append(m1.group()).append(" ");
        }
        return latinStr.toString();
    }

    public static String writeCyrillic() {
        String input = Demo.readFile(PATH);
        Pattern pattern2 = Pattern.compile(CYRL);
        Matcher m2 = pattern2.matcher(input);
        StringBuilder cyrilicStr = new StringBuilder();
        while (m2.find()) {
            cyrilicStr.append(m2.group()).append(" ");
        }
        return cyrilicStr.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tsikl = true;
        do {
            String user = in.nextLine();
            if ("stop".equals(user) || "Stop".equals(user)) {
                tsikl = false;
            } else if ("Latn".equals(user)) {
                System.out.println(user + ": " + writeLatin());
            } else if ("Cyrl".equals(user)) {
                System.out.println(user + ": " + writeCyrillic());
            } else {
                System.out.println(user + ": Incorrect input");
            }
        } while (tsikl);
    }
}
