package com.javatest.leetcode;

public class CounttheDigitsThatDivideaNumber {
    public int countDigits(int num) {
        int temp = num;
        int sum = 0;
        while (temp != 0) {
            int div = temp % 10;
            temp /= 10;
            sum += num % div == 0 ? 1 : 0;
        }
        return sum;
    }
}
