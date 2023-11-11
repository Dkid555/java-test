package com.leetcode;

public class Maximum69Number {
    public int maximum69Number(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public static int maximum69Number2(int num) {
        int multiply = 10000;

        while (multiply != 0) {
            if (num / multiply != 0) {

                int left = num / multiply;
                if (left % 10 == 6) {
                    num += multiply * 3;
                    return num;
                }
                multiply /= 10;
            } else {
                multiply /= 10;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number2(6669));
    }
}

//You are given a positive integer num consisting only of digits 6 and 9.
//
//Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).