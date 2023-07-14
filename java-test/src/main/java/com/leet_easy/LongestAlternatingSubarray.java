package com.leet_easy;

public class LongestAlternatingSubarray {

    public static int alternatingSubarray(int[] nums) {
        int ans = 1;
        int res = 0;
        boolean bool = false;
        for (int i = 1; i < nums.length; i++) {
            if (!bool && nums[i] == nums[i - 1] + 1) {
                bool = true;
                ans++;
                res = Math.max(ans, res);
                continue;
            }
            if (bool && nums[i] == nums[i - 1] - 1) {
                bool = false;
                ans++;
                res = Math.max(ans, res);
                continue;
            }
            if (bool && nums[i] == nums[i - 1] + 1) {
                bool = true;
                ans = 2;
                res = Math.max(ans, res);
                continue;
            }
            ans = 1;
            bool = false;
        }

        return res > 0 ? res : -1;
    }

    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }
}
