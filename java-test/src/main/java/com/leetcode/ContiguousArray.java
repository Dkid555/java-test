package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (map.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return subArrayLength;
    }
}
//Given a binary array nums,
// return the maximum length
// of a contiguous subarray with an equal number of 0 and 1.