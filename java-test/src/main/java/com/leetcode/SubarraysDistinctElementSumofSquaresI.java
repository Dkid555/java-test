package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumofSquaresI {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += 1;
            Set<Integer> set = new HashSet<>();
            set.add(nums.get(i));
            for (int j = i + 1; j < nums.size(); j++) {
                set.add(nums.get(j));
                result += (set.size() * set.size());
            }
        }

        return result;
    }
}
//You are given a 0-indexed integer array nums.
//
//The distinct count of a subarray of nums is defined as:
//
//Let nums[i..j] be a subarray of nums consisting of all the
// indices from i to j such that 0 <= i <= j < nums.length.
// Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
//Return the sum of the squares of distinct counts of all subarrays of nums.
//
//A subarray is a contiguous non-empty sequence of elements within an array.