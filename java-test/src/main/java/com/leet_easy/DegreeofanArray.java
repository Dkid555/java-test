package com.leet_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeofanArray {
    public static int findShortestSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = map.getOrDefault(nums[i], new ArrayList<>());
            temp.add(i);
            map.put(nums[i], temp);
            if (max == map.get(nums[i]).size()) {
                list.add(nums[i]);
            }
            if (max < map.get(nums[i]).size()) {
                list = new ArrayList<>();
                max = map.get(nums[i]).size();
                list.add(nums[i]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int val : list) {
            result = Math.min(result, map.get(val).get(max - 1) - map.get(val).get(0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
//Given a non-empty array of non-negative integers nums,
// the degree of this array is defined as the maximum
// frequency of any one of its elements.
//
//Your task is to find the smallest possible length
// of a (contiguous) subarray of nums, that has the same degree as nums.