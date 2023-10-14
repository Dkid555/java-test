package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> Appears = new HashMap<>();
        Set<Integer> Result = new HashSet<>();
        for (int num : nums) {
            Appears.put(num, Appears.getOrDefault(num, 0) + 1);
            if (Appears.get(num) == 1) {
                Result.add(num);
            } else Result.remove(num);
        }
        return (int) Result.toArray()[0];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{2, 2, 3, 2}));
    }

    ///
    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.