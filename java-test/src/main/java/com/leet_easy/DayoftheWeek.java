package com.leet_easy;

import java.time.LocalDate;

public class DayoftheWeek {
    public static String dayOfTheWeek(int day, int month, int year) {
        String dayWeek = String.valueOf(LocalDate.of(year, month, day).getDayOfWeek()).toLowerCase();
        return Character.toUpperCase(dayWeek.charAt(0)) + dayWeek.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }
}
