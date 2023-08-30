package com.leet_easy;

public class Base7 {

    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        boolean check = false;
        if (num < 0) {
            num = -num;
            check = true;
        }
        while (num > 0) {
            res.append(num % 7);
            num = num / 7;
        }
        if (check) res.append('-');
        return res.reverse().toString();
    }

    public static String convertToBase7_2(int num) {
        return Integer.toString(num, 5);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7_2(162100));
    }
}
//Given an integer num, return a string of its base 7 representation.