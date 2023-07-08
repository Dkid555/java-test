package com.leetcode;


//Given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int[] index = new int[3];
        for (int color : nums) {
            index[color]++;
        }
        for (int i = 0, k = 0; i < nums.length && k <= 2; ) {
            while (index[k] != 0) {
                nums[i] = k;
                i++;
                index[k]--;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] colors = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
