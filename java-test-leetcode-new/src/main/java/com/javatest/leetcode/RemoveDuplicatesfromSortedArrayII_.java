package com.javatest.leetcode;

public class RemoveDuplicatesfromSortedArrayII_ {
    public int removeDuplicates(int[] nums) {
        int prev_index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[prev_index] == nums[i]) {
                if (count < 2) {
                    ++count;
                    nums[++prev_index] = nums[i];
                }
            } else {
                count = 1;
                nums[++prev_index] = nums[i];
            }
        }
        return ++prev_index;
    }
}
