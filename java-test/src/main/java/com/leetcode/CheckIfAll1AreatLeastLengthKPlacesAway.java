package com.leetcode;

public class CheckIfAll1AreatLeastLengthKPlacesAway {
    public static boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        if (nums[0] == 0) {
            count = k;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count < k) return false;
                count = 0;
            } else count++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }
}
