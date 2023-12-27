package com.leetcode;

import java.util.List;

public class MinimumRightShiftstoSorttheArray {
    public int minimumRightShifts(List<Integer> nums) {
        int shift = 0;
        int min = nums.get(0);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (shift != 0 && nums.get(i + 1) > min) {
                return -1;
            }
            if (nums.get(i) > nums.get(i + 1)) {
                if (shift != 0) {
                    return -1;
                }
                shift = i + 1;
            }

        }
        return shift == 0 ? shift : nums.size() - shift;
    }
}
