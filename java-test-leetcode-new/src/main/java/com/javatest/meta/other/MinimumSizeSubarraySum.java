package com.javatest.meta.other;

public class MinimumSizeSubarraySum {
    public int minSubArrayLenw(int target, int[] nums) {
        int sum = 0;
        int a = 0;
        while (a < nums.length) {
            sum += nums[a];
            a++;
            if (sum >= target) {
                break;
            }
        }
        if (sum < target) {
            return 0;
        }
        int b = 1;
        while (a + b - 1 < nums.length) {
            sum -= nums[b - 1];
            sum += nums[a + b - 1];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[a + b - 1];
                    if (sum >= target) {
                        a--;
                    }
                }
                sum += nums[a + b - 1];
            }
            b++;
        }
        while (sum >= target) {
            sum -= nums[nums.length - a];
            if (sum >= target) {
                a--;
            }
        }
        return a;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int mn = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                sum -= nums[i];
                mn = Math.min(j - i + 1, mn);
                i++;
            }
            j++;
        }
        if (mn == Integer.MAX_VALUE) {
            return 0;
        }
        return mn;
    }
    //Given an array of positive integers nums and a
    // positive integer target, return the minimal length of a
    //subarray
    // whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
}
