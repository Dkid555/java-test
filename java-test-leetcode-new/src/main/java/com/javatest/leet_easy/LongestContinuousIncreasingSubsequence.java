package com.javatest.leet_easy;

//Given an unsorted array of integers nums,
// return the length of the longest continuous increasing subsequence (i.e. subarray).
// The subsequence must be strictly increasing. A continuous increasing subsequence is
// defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ...,
// nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        int length = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                max = Math.max(max, length);
                length = 1;
            } else {
                length++;
            }
        }
        max = Math.max(max, length);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
