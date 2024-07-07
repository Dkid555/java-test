package com.javatest.leetcode;

public class SubtracttheProductandSumofDigitsofanInteger {
    public int subtractProductAndSum(int n) {
        int multi = 1;
        int sum = 0;
        while (n > 0) {
            int left = n % 10;
            multi *= left;
            sum += left;
            n /= 10;
        }
        return multi - sum;
    }
}
