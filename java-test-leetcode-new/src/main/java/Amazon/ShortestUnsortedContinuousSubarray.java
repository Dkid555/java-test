package com.Amazon;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray2(new int[]{2,6,4,8,10,9,15}));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(nums);
        int start = 0;
        for(;start < nums.length; ++start){
            if(nums[start] != copy[start])
                break;
        }
        if (start == nums.length)
            return 0;

        int end = nums.length - 1;
        for (; end >= 0; --end){
            if(nums[end] != copy[end])
                break;
        }

        return end - start + 1;
    }
    public static int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int end = -1, max = nums[0];
        for (int i = 1; i < n; ++i){
            if (nums[i] < max)
                end = i;
            else
                max = nums[i];
        }
        int start = 0, min = nums[n - 1];
        for (int i = n - 2; i >= 0; --i){
            if (nums[i] > min)
                start = i;
            else
                min = nums[i];
        }
        return end - start + 1;
    }
}
//Given an integer array nums, you need to find one continuous subarray
// such that if you only sort this subarray in non-decreasing order,
// then the whole array will be sorted in non-decreasing order.
//
//Return the shortest such subarray and output its length.