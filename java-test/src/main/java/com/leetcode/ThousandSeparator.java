package com.leetcode;

public class ThousandSeparator {
    public static String thousandSeparator(int n) {
        String result = "";
        while (n > 1000) {
            int ost = n % 1000;
            n = n / 1000;
            result = "." + (ost % 100 == ost ? (ost % 10 == ost ? "00" + ost : "0" + ost) : ost) + result;
        }
        return n + result;
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(51040));
    }
}
