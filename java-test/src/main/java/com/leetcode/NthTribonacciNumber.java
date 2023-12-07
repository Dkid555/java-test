package com.leetcode;

public class NthTribonacciNumber {

    // T0 = 0
    // T1 = 1
    // T2 = 1
    // T3 = 2
    //

    //Tn = T0 + T1 +.....+Tn-1
    public static int tribonacci(int n) {
        if (n <= 2) {
            if (n == 0) {
                return 0;
            }
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i < n + 1; ++i) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(0));
    }
}
//The Tribonacci sequence Tn is defined as follows:
//
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//Given n, return the value of Tn.