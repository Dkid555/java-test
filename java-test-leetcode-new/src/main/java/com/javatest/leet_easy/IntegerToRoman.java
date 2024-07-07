package com.javatest.leet_easy;

/*
 * Convert integer to roman
 * */

public class IntegerToRoman {
    static String roman(int number) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousand = {"", "M", "MM", "MMM"};
        return (thousand[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + ones[number % 10]);
    }

    public static void main(String[] args) {
        int number = 1024;
        RomanToInt sum = new RomanToInt();
        System.out.println(roman(number));
        System.out.println(RomanToInt.romantoInt(roman(1024)));
    }
}
