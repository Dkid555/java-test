package com.javatest.leet_easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ApplyOperationstoanArray {
    int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        moveZeroes(nums);
        return nums;
    }

    void moveZeroes(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) queue.add(i);
            else {
                if (!queue.isEmpty()) {
                    nums[queue.remove()] = nums[i];
                    nums[i] = 0;
                    queue.add(i);
                }
            }
        }
    }
}
