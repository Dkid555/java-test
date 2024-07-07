package com.javatest.leetcode;

public class UncrossedLines {
    public static int helper(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length + 1];
        for (int i = 1; i <= nums2.length; i++) {
            int prev = 0;
            for (int j = 1; j <= nums1.length; j++) {
                int curr = dp[j];
                if (nums1[j - 1] == nums2[i - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], curr);
                }
                prev = curr;
            }
        }
        return dp[nums1.length];
    }

    ///Or without if in main
    public static int maxuncrossed(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return maxuncrossed(nums2, nums1);
        }
        int[] dp = new int[nums1.length + 1];
        for (int i = 1; i <= nums2.length; i++) {
            int prev = 0;
            for (int j = 1; j <= nums1.length; j++) {
                int curr = dp[j];
                if (nums1[j - 1] == nums2[i - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], curr);
                }
                prev = curr;
            }
        }
        return dp[nums1.length];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 7, 1, 7, 5};

        int[] nums2 = new int[]{1, 9, 2, 5, 1};
        /*
        //For helper variant
        if (nums1.length < nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        System.out.println(helper(nums1,nums2));
        */
        System.out.println(maxuncrossed(nums1, nums2));
    }
}
