package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationstoCollectElements {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = nums.size() - 1;

        for (; i > -1 && set.size() != k; i--) {
            if (nums.get(i) <= k) set.add(nums.get(i));
        }

        return nums.size() - i - 1;
    }
}
