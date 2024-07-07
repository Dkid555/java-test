package com.javatest.leet_easy;

public class UglyNumber {
    static boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 5 == 0) n = n / 5;
        while (n % 3 == 0) n = n / 3;
        while (n % 2 == 0) n = n / 2;
        if (n != 1) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(-6));
    }
}
