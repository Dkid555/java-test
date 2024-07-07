package com.javatest.leetcode;

public class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        int appearance = arr.length / 4;
        int[] helper = new int[100001];
        for (int num : arr) {
            ++helper[num];
            if (helper[num] > appearance)
                return num;
        }
        return -1;
    }
}
