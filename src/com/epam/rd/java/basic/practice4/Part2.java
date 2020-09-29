package com.epam.rd.java.basic.practice4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {
    public static final Logger log = Logger.getLogger(Part2.class.getName());

    public static void bubbleSort(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        File file = new File("part2.txt");
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    for(int i = 0; i < 10; i++) {
                        stringBuilder.append(Integer.toString(secureRandom.nextInt(50)) + ' ');
                    }
                    try (FileWriter writer = new FileWriter("part2.txt", false)) {
                        writer.write(stringBuilder.toString().trim());
                    }
                }
            } catch (IOException ex) {
                log.log(Level.SEVERE,"Exception ",ex);
            }
        } else {
            Scanner reader = null;
            try {
                reader = new Scanner(file);
            } catch (FileNotFoundException e) {
                log.log(Level.SEVERE,"Exception ",e);
            }
            stringBuilder.append(reader.nextLine());
            reader.close();
        }

        String[] strings = stringBuilder.toString().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        StringBuilder out = new StringBuilder();
        bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            out.append(nums[i]).append(" ");
        }

        try (FileWriter newWriter = new FileWriter("part2_sorted.txt", false)) {
            newWriter.write(out.toString().trim());
        } catch (IOException e) {
            log.log(Level.SEVERE,"Exception ",e);
        }
        System.out.println("input ==> " + stringBuilder.toString());
        System.out.println("output ==> " + out.toString().trim());
    }
}

