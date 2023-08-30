package com.leet_easy;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
//        int totalSum = Arrays.stream(nums).sum();
        int totalSum = 0;
        for (int val : nums) {
            totalSum += val;
        }

        for (int i = 0; i < nums.length; leftSum += nums[i++])
            if (leftSum * 2 == totalSum - nums[i])
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
    }
}
