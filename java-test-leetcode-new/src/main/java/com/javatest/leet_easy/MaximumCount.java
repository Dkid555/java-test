package com.javatest.leet_easy;

//Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
//
//In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
//Note that 0 is neither positive nor negative.
public class MaximumCount {
    static int maxcount(int[] nums) {
        int oric = 0;
        int zeros = 0;
        if (nums[0] > 0) return nums.length;
        if (nums[0] == 0 && nums[nums.length - 1] == 0) return 0;
//        if(nums[0] == 0) return 0;
        for (int val : nums) {
            if (val < 0) oric++;
            else if (val == 0) {
                zeros++;
            } else if (val > 0) return Math.max(oric, nums.length - oric - zeros);
        }
        return oric;
    }


    public static void main(String[] args) {
        System.out.println(maxcount_bin(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }

    // with binary search
    static int maxcount_bin(int[] nums) {
        if (nums[0] > 0) return nums.length;
        else if (nums[0] == 0 && nums[nums.length - 1] == 0) return 0;
        else if (nums[0] == 0) {
            int i = 0;
            while (nums[i] == 0) i++;
            return nums.length - i;
        } else if (nums.length == 1) return 1;
        int zeros = 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < 0 && nums[mid + 1] >= 0) {
                if (nums[mid + 1] == 0) {
                    int i = mid + 1;
                    while (i != nums.length && nums[i] == 0) {
                        i++;
                        zeros++;
                    }
                }
                break;
            } else if (nums[mid] < 0) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return Math.max(mid + 1, nums.length - zeros - mid - 1);

    }


}
