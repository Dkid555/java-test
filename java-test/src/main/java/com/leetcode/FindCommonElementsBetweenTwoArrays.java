package com.leetcode;

public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] num1freq = new int[102];
        int[] num2freq = new int[102];
        int count1 = 0;
        int count2 = 0;
        count1 = getCount(nums1, nums2, num1freq, count1);
        count2 = getCount(nums2, nums1, num2freq, count2);
        int[] ans = new int[2];
        ans[0] = count2;
        ans[1] = count1;
        return ans;
    }

    private int getCount(int[] nums1, int[] nums2, int[] num1freq, int count1) {
        for (int j : nums1) {
            num1freq[j]++;
        }
        for (int j : nums2) {
            if (num1freq[j] != 0) {
                count1++;
            }
        }
        return count1;
    }
}
