package com.leetcode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         * nums1 should be returned
         * */
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            --k;
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
