package com.javatest.leet_easy;

public class CountHillsandValleysinanArray {
    public static int countHillValley(int[] nums) {
        int r = 0, left = nums[0];
        for (int i = 1; i < nums.length - 1; i++)
            if (left < nums[i] && nums[i] > nums[i + 1] || left > nums[i] && nums[i] < nums[i + 1]) {
                r++;
                left = nums[i];
            }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 6, 5, 5, 4, 1};
        System.out.println(countHillValley(nums));
    }
}
