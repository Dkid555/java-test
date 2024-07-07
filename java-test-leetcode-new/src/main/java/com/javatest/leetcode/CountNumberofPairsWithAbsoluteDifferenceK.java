package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofPairsWithAbsoluteDifferenceK {


    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (map.containsKey(num - k)) {
                res += map.get(num - k);
            }
            if (map.containsKey(num + k)) {
                res += map.get(num + k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        return res;
    }
}
