package com.leetcode;

import java.util.*;

public class MinimumMovestoEqualArrayElements {
    public static int minMoves(int[] nums) {
        int moves = 0;
        moves = move(nums, moves);
        return moves;
    }

    public static int move(int[] nums, int moves) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        if (set.size() == 1) return moves;
        int max = 0;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            Stack<Integer> temp = map.getOrDefault(nums[i], new Stack<>());
            temp.push(i);
            map.put(nums[i], temp);
        }
        int increment = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                nums[i]++;
                increment--;
            }
        }
        if (increment != 0) {
            while (increment != 0) {
                nums[map.get(max).pop()]++;
                increment--;
            }
        }
        return move(nums, ++moves);
    }

    // faster
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            int move = Math.abs(nums[0] - nums[i]);
            moves += move;
        }
        return moves;
    }

    //
    public static int minMoves3(int[] nums) {
        int c = 0;
        if (nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        for (int n : nums) {
            c = c + (n - min);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(minMoves3(new int[]{1, 1, 1, 5000}));
    }
}
