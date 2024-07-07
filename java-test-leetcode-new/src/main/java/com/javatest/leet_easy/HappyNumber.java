package com.javatest.leet_easy;

//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    static int newNumber(int n) {
        int newNumber = 0;
        while (n != 0) {
            int num = n % 10;
            newNumber += num * num;
            n = n / 10;
        }
        return newNumber;
    }

    static boolean isHappy(int n) {
        Set<Number> set = new HashSet<>();
        while ((n != 1 || n != 7) && !set.contains(n)) {
            set.add(n);
            n = newNumber(n);
        }
        return n == 1 || n == 7;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
