package com.javatest.leetcode;

public class JumpGame {
    static boolean Jump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int stepsleft = nums[0];
        int index = 1;
        while (stepsleft > 0) {
            if (index == nums.length - 1) return true;
            stepsleft = Math.max(stepsleft - 1, nums[index]);
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};

        System.out.println(Jump(array));
    }
}
