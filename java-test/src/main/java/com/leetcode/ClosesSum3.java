package com.leetcode;

public class ClosesSum3 {
    static int Partion(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = nums[high];
        nums[high] = nums[i];
        nums[i] = temp;
        return i;
    }

    static void quick(int[] nums, int low, int high) {
        if (low < high) {
            int pi = Partion(nums, low, high);
            quick(nums, low, pi - 1);
            quick(nums, pi + 1, high);
        }
    }

    static int CloseSum(int[] nums, int target) {
        quick(nums, 0, nums.length - 1);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int a = i + 1;
            int b = nums.length - 1;
            while (a < b) {
                int curr = nums[a] + nums[i] + nums[b];
                if (curr < target) a++;
                else b--;
                if (Math.abs(curr - target) < Math.abs(result - target)) {
                    result = curr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -1, 3, 12, -10, 15, 100, -1000};
        int target = 0;
        System.out.println(CloseSum(nums, target));
    }
}
