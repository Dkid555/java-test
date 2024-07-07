package com.javatest.leetcode;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum = sum + i;
        if (sum % 3 != 0)
            return false;
        int each = sum / 3, temp = 0, found = 0;
        for (int j : arr) {
            temp = temp + j;
            if (temp == each) {
                temp = 0;
                found++;
            }
        }
        return found >= 3;
    }
}
