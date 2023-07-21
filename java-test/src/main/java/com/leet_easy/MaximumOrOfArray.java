package com.leet_easy;

public class MaximumOrOfArray {
    public static long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] previous = new long[n + 1];
        long[] suff = new long[n + 1];
        for (int i = 1; i < n; i++) {
            previous[i] = previous[i - 1] | (long) nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = suff[i + 1] | (long) nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long curr = (long) nums[i] << k;
            long temp = previous[i] | curr | suff[i + 1];
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumOr(new int[]{8, 1, 2}, 2));
    }
}
