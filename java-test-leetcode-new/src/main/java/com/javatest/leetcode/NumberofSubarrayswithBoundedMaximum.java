package com.javatest.leetcode;

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

    ///// Better
    public int numSubarrayBoundedMax2(int[] nums, int left, int right) {
        int start = -1;
        int count = 0;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) { // if it is bigger, than array ends
                start = end = i;
                continue;
            }

            if (nums[i] >= left) {
                end = i;
            }

            count += end - start;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}
//Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays
// such that the value of the maximum array element in that subarray is in the range [left, right].
//
//The test cases are generated so that the answer will fit in a 32-bit integer.