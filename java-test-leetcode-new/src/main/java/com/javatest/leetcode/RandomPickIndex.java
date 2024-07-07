package com.javatest.leetcode;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> map;

    public RandomPickIndex(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> temp = this.map.getOrDefault(nums[i], new ArrayList<>());
            temp.add(i);
            this.map.put(nums[i], temp);
        }
    }

    public int pick(int target) {
        if (this.map.containsKey(target)) {
            List<Integer> listIndexes = map.get(target);
            int random = new Random().nextInt(listIndexes.size());
            return listIndexes.get(random);
        } else
            return -1;
    }
}
//Given an integer array nums with possible duplicates,
// randomly output the index of a given target number. You can assume that
// the given target number must exist in the array.
//
//Implement the Solution class:
//
//Solution(int[] nums) Initializes the object with the array nums.
//int pick(int target) Picks a random index i from nums where nums[i] == target.
// If there are multiple valid i's, then each index should have an equal probability of returning.