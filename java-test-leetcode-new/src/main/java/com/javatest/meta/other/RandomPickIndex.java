package com.javatest.meta.other;

import java.util.*;

public class RandomPickIndex {
    private final Map<Integer, List<Integer>> map_from_array;

    public RandomPickIndex(int[] nums) {
        this.map_from_array = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            this.map_from_array.putIfAbsent(nums[i], new ArrayList<>());
            this.map_from_array.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        if (this.map_from_array.containsKey(target)) {
            List<Integer> indexes = this.map_from_array.get(target);
            return indexes.get(new Random().nextInt(indexes.size()));
        }
        return -1;
    }


}
//Given an integer array nums with possible duplicates,
// randomly output the index of a given target number. You can assume that the given target number must exist in the array.
//
//Implement the Solution class:
//
//Solution(int[] nums) Initializes the object with the array nums.
//int pick(int target) Picks a random index i from nums where nums[i] == target.
// If there are multiple valid i's, then each index should have an equal probability of returning.