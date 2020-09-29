package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String user;
        do{
            user = in.nextLine();
            try {
                if("stop".equals(user)){
                    break;
                } else {
                    String[] request = user.split(" ");
                    Locale locale = new Locale(request[1]);
                    ResourceBundle introLabels = ResourceBundle.getBundle("resources", locale);
                    System.out.println(introLabels.getString(request[0]));
                }
            } catch (RuntimeException e) {
                System.out.println("Incorrect input");
            }
        } while (!"stop".equals(user));
    }
}
