package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        pwh(nums, 0, subset, ans);
        return ans;
    }

    public void pwh(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        pwh(nums, i + 1, subset, ans);
        subset.remove(subset.size() - 1);
        pwh(nums, i + 1, subset, ans);
    }
}

//Given an integer array nums of unique elements, return all possible
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.