package com.leetcode;

import java.util.Arrays;

public class MinimumNumberGame {
    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int Bob = 0;
        int Alice = 1;
        int swh = 0;
        for (int num : nums) {
            if (swh == 0) {
                arr[Alice] = num;
                Alice += 2;
                ++swh;
            } else {
                arr[Bob] = num;
                Bob += 2;
                --swh;
            }
        }
        return arr;
    }

    public static int[] numberGame2(int[] nums) {
        int[] sort = new int[101];
        for (int num : nums)
            sort[num]++;
        int[] arr = new int[nums.length];
        int Bob = 0;
        int Alice = 1;
        int swh = 0;
        for (int i = 0; i < sort.length; ) {
            if (sort[i] == 0)
                ++i;
            else {
                if (swh == 0) {
                    arr[Alice] = i;
                    Alice += 2;
                    ++swh;
                } else {
                    arr[Bob] = i;
                    Bob += 2;
                    --swh;
                }
                --sort[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberGame2(new int[]{5, 4, 2, 3})));
    }
}
