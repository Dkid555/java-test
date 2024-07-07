package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        return getMoneyAmount(1, n + 1, new HashMap<>());
    }

    public int getMoneyAmount(int left, int right, Map<Integer, Integer> memo) {
        if (left >= right - 1) return 0;
        int bestCost = Integer.MAX_VALUE, memoKey = left + (right * 201);
        if (memo.containsKey(memoKey)) return memo.get(memoKey);
        for (int i = (left + right) / 2 - 1; i < right; i++) {
            int currentCost = Math.max(getMoneyAmount(left, i, memo), getMoneyAmount(i + 1, right, memo)) + i;
            bestCost = Math.min(bestCost, currentCost);
        }
        memo.put(memoKey, bestCost);
        return bestCost;
    }
}
