package com.leetcode;

public class DifferenceBetweenElementSumandDigitSumofanArray {
    private int numTodigit(int num) {
        if (num < 10)
            return num;
        return num % 10 + numTodigit(num / 10);
    }

    public int differenceOfSum(int[] nums) {
        int elemSum = 0;
        int digitSum = 0;
        for (int num : nums) {
            elemSum += num;
            digitSum += numTodigit(num);
        }
        return elemSum - digitSum;
    }
}
