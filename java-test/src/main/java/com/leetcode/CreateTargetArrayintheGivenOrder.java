package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            result.add(index[i], nums[i]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
