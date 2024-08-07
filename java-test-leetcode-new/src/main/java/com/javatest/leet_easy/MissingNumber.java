package com.javatest.leet_easy;

public class MissingNumber {
    int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = (n * (n - 1)) / 2;

        for (int num : nums) {
            total -= num;
        }

        return total;
    }
}
