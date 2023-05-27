package com.leetcode;

import java.util.Stack;

/*
 * Find shortest way to get to
 * */
public class JumpGameII {
    static void Jumps(int[] nums, int position, Stack<Integer> fin, int steps) {
        if (position == nums.length - 1) {
            if (fin.isEmpty()) fin.add(steps);
            else {
                int temp = fin.pop();
                if (temp > steps) fin.push(steps);
                else fin.push(temp);
            }
            return;
        }

        if (position < nums.length - 1) {
            for (int i = 1; i <= nums[position]; i++)
                Jumps(nums, position + i, fin, steps + 1);
        }

    }

    //O(n)
    static int JumpFast(int[] nums) {
        int end = 0, farthest = 0;
        int jump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        //ArrayList<Integer> fin = new ArrayList<>();
        Stack<Integer> fin = new Stack<>();
        //Jumps(nums, 0, fin, 0);
        System.out.println(JumpFast(nums));

    }
}
