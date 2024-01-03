package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int e : nums) {
            if (e < 0) negative.add(e);
            else positive.add(e);
        }
        System.out.println(nums.length / 2);
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }
        return nums;
    }
}
