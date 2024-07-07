package com.javatest.leetcode;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int[] indexes = new int[100000];
        for (int num : nums) {
            indexes[num] += 1;
            if (indexes[num] > 1)
                return num;
        }
        return -1;
    }

}
