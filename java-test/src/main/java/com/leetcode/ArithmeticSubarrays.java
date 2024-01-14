package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticSubarrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ans.add(sol(nums, l[i], r[i]));
        }
        return ans;
    }

    public static boolean sol(int[] nums, int left, int right) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int len = right - left + 1;
        if ((max - min) % (len - 1) != 0)
            return false;
        int d = (max - min) / (len - 1);
        if (d == 0) return true;
        boolean[] arr = new boolean[len];
        for (int i = left; i <= right; i++) {
            if ((nums[i] - min) % d != 0) return false;
            else {
                int idx = (nums[i] - min) / d;
                if (arr[idx]) return false;
                arr[idx] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5})
        );
    }
}
