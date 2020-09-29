package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String CH = "\\b[a-zа-яA-ZА-ЯЁёЇїІі]{1}\\b";
    public static final String IN = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";
    public static final String DO = "\\d*?\\.\\d+";
    public static final String ST = "[а-яa-zA-ZА-ЯЁёЇїІі]{2,}";
    public static final String PATH = "part3.txt";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tsikl = true;
        do {
            String user = in.nextLine();
            if ("stop".equals(user) ) {
                tsikl = false;
            } else if ("char".equals(user)) {
                printChar();
                System.out.println();
            } else if ("int".equals(user)) {
               printInt();
               System.out.println();
            }  else if ("double".equals(user)) {
                printDouble();
                System.out.println();
            }else if ("String".equals(user)) {
                printString();
                System.out.println();
            }else {
                System.out.println("Incorrect input");
            }
        } while (tsikl);
    }

    public static void printInt(){
        String input = Demo.readFile(PATH);
        Pattern pattern1 = Pattern.compile(IN);
        Matcher m1 = pattern1.matcher(input);
        StringBuilder latinStr = new StringBuilder();
        while (m1.find()) {
            String d = m1.group();
            latinStr.append(d).append(" ");
        }
        System.out.print(latinStr.toString());
    }
    public static void printChar(){
        String input = Demo.readFile(PATH);
        Pattern pattern1 = Pattern.compile(CH);
        Matcher m1 = pattern1.matcher(input);
        StringBuilder latinStr = new StringBuilder();
        while (m1.find()) {
            String d = m1.group();
            latinStr.append(d).append(" ");
        }
        System.out.print(latinStr.toString());
    }
    public static void printDouble(){
        String input = Demo.readFile(PATH);
        Pattern pattern1 = Pattern.compile(DO);
        Matcher m1 = pattern1.matcher(input);
        StringBuilder latinStr = new StringBuilder();
        while (m1.find()) {
            String d = m1.group();
            latinStr.append(d).append(" ");
        }
        System.out.print(latinStr.toString());
    }
    public static void printString(){
        String input = Demo.readFile(PATH);
        Pattern pattern1 = Pattern.compile(ST);
        Matcher m1 = pattern1.matcher(input);
        StringBuilder latinStr = new StringBuilder();
        while (m1.find()) {
            String d = m1.group();
            latinStr.append(d).append(" ");
        }
        System.out.print(latinStr.toString());
    }
}
