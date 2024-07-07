package com.javatest.leetcode;

public class RemoveOneElementtoMaketheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int previous = nums[0];
        int toRemove = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= previous) {
                if (++toRemove > 1)
                    return false;
                if (i == 1 || nums[i] > nums[i - 2])
                    previous = nums[i];
            } else
                previous = nums[i];
        return true;
    }
}
