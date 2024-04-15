package com.Amazon.Arrrays;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> visited_first = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(visited_first.contains(nums[i]))
                continue;
            visited_first.add(nums[i]);
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}
//Given an integer array nums, return all the triplets
// [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
