package com.checker.app.io;

import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.Scanner;

/**
 * The type Day service.
 * Write a program using switch case where you have to ask day name from the user and then you will print the first three letters
 * of that day in the capital letter as a response to the user
 */
public class DayService {

    private final static EnumSet<DayOfWeek> days = EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.SUNDAY);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Write the day name");
        while (scanner.hasNext()) {
            String dayFromUser = scanner.nextLine()
                                        .toUpperCase();
            if (dayFromUser.equals("Q")) {
                break;
            }
            try {
                if (days.contains(DayOfWeek.valueOf(dayFromUser))) {
                    System.out.println(dayFromUser.substring(0, 3));
                }
                System.out.println("Write the day name");
            } catch (Exception e) {
                System.out.println("Write the proper day");
            }
        }
    }
}

