package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;


public class CountArrayPairsDivisiblebyK {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int gcdResult = gcd(nums[i], k);
            int desiredFactor = k / gcdResult;
            for (int num : counter.keySet()) {
                if (num % desiredFactor == 0) {
                    ans += counter.get(num);
                }
            }
            counter.put(gcdResult, counter.getOrDefault(gcdResult, 0) + 1);
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
