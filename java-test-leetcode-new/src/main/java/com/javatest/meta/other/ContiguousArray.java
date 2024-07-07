package com.javatest.meta.other;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int zeros = 0, ones = 0, maxLen = 0;

        hashmap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++; else ones++;
            int diff = zeros - ones;

            if (hashmap.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - hashmap.get(diff));
            } else {
                hashmap.put(diff, i);
            }
        }

        return maxLen;
    }
}
