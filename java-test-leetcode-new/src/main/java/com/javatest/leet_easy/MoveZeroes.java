package com.javatest.leet_easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MoveZeroes {

    static void moveZeroes(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(nums);

    }
}
