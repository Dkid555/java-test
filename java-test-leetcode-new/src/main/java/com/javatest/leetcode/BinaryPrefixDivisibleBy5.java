package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum = (sum * 2 + num) % 5;
            if (sum != 0) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }
}
