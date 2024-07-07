package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DeterminetheMinimumSumofakavoidingArray {
    public int minimumSum(int n, int k) {
        return k / 2 >= n ? n * (n + 1) / 2 : (n + (k - 1) / 2) * (n + (k - 1) / 2 + 1) / 2 - (k - 1) * (k - 1 + 1) / 2 + (k / 2) * (k / 2 + 1) / 2;
    }

    public int minimumSum2(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int temp = 1, sum = 0;
        while (set.size() != n) {
            if (!set.contains(k - temp)) {
                set.add(temp);
                sum += temp;
            }
            temp++;
        }
        return sum;
    }
}
