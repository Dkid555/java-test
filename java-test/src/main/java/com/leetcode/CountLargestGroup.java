package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num = 1; num <= n; num++) {
            int sum = 0;
            int tmpn = num;

            if (num > 9) {
                while (tmpn > 0) {
                    sum += tmpn % 10;
                    tmpn /= 10;
                }
            } else
                sum = num;

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }

        int cnt = 0;
        for (int val : map.values()) {
            if (val == max)
                cnt++;
        }

        return cnt;
    }
}
