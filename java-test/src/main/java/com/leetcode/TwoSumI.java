package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumI {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            int diff = target - nums[i];
            if(helper.containsKey(diff)){
                return new int[]{i, helper.get(diff)};
            }
            helper.put(nums[i], i);
        }
        return new int[]{};
    }
}
