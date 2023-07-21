package com.leet_easy;

import java.util.Arrays;

//Given an integer array nums, return the third distinct maximum number
// in this array. If the third maximum does not exist, return the maximum number.
public class ThirdMaximumNumber {

    // using stream api
    public static int thirdMax(int[] nums) {
        if (nums.length < 3)
            return Arrays.stream(nums).max().getAsInt();
        int[] fin = Arrays.stream(nums).distinct().sorted().toArray();
        return fin.length < 3 ? fin[fin.length - 1] : fin[fin.length - 3];
    }

    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[]{3, 2, 1}));
    }

    public static int thirdMax2(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max1 > num && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max2 > num && num > max3) {
                max3 = num;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }

}
