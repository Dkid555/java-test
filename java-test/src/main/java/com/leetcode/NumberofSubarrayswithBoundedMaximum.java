package com.leetcode;

public class NumberofSubarrayswithBoundedMaximum {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0, res = 0, maxind = -1;
        for (int j = 0; j < nums.length; ) {
            if (nums[j] >= left && nums[j] <= right) {
                maxind = j;
            }
            if (nums[j] > right) {
                j++;
                i = j;
                maxind = -1;
                continue;
            }
            if (maxind != -1) {
                res += maxind - i + 1;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}
//Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays
// such that the value of the maximum array element in that subarray is in the range [left, right].
//
//The test cases are generated so that the answer will fit in a 32-bit integer.