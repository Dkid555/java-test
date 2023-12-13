package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberofGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
//            result += map.get(num);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += (entry.getValue() * (entry.getValue() - 1)) / 2;
        }
        return result;
    }

    public int numIdenticalPairs2(int[] nums) {
        int result = 0;
        int[] helper = new int[101];
        for (int num : nums) result += helper[num]++;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}
///Given an array of integers nums, return the number of good pairs.
//
//A pair (i, j) is called good if nums[i] == nums[j] and i < j.