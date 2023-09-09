package com.leet_easy;

import java.time.LocalDate;

public class DayoftheYear {
    public static int dayOfYear(String date) {
        LocalDate data = LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10)));
        return data.getDayOfYear();
    }

    public static int dayOfYear2(String date) {
        return LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10))).getDayOfYear();
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-02-10"));
    }
}
//YYYY-MM-DD