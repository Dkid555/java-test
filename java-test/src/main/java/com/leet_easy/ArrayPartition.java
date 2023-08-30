package com.leet_easy;

import java.util.Arrays;

public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static int arrayPairSum2(int[] nums) {

        // nums in (-10000;10000)
        int[] sort = new int[20001];
        for (int num : nums) { // indexes can't be less than 0)
            sort[num + 10000]++;
        }
        int res = 0;
        boolean isEven = true;
        for (int i = 0; i < sort.length; i++) {
            while (sort[i] > 0) { // conver back to original value
                if (isEven) res += i - 10000;
                sort[i]--;
                isEven = !isEven;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum2(new int[]{6, 2, 6, 5, 1, 2}));
    }
}
