package com.leetcode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class NumberofDaysBetweenTwoDates {
    public static int daysBetweenDates(String date1, String date2) {
        return Math.abs((int) ChronoUnit.DAYS.between(
                LocalDate.of(Integer.parseInt(date1.substring(0, 4)),
                        Integer.parseInt(date1.substring(5, 7)), Integer.parseInt(date1.substring(8, 10)))
                , LocalDate.of(Integer.parseInt(date2.substring(0, 4)), Integer.parseInt(date2.substring(5, 7)),
                        Integer.parseInt(date2.substring(8, 10)))));
    }

    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}

