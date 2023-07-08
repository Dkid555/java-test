package com.leetcode;

public class XOROperationinanArray {
    public static int xorOperation(int n, int start) {
        int[] numbers = new int[n];
        int bitwise = start;
        numbers[0] = start;
        for (int i = 1; i < n; i++) {
            numbers[i] = start + 2 * i;
            bitwise = bitwise ^ numbers[i];
        }
        return bitwise;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(4, 3));
    }
}


/*
* You are given an integer n and an integer start.

Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.*/


// in array of couples find alone value


class FindNoPairValue {
    static int find(int[] nums) {
        int XORresult = 0;
        for (int val : nums) {
            XORresult ^= val;
        }
        return XORresult;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{9, 9, 19, 10, 9, 12, 2, 12, 3, 3, 11, 5, 8, 4, 13, 6, 2, 11, 9, 19, 11, 15, 9, 17, 15, 12, 5, 14, 12, 16, 18, 16, 10, 3, 8, 9, 16, 20, 2, 4, 16, 12, 11, 14, 20, 16, 2, 18, 17, 20, 3, 13, 16, 17, 1, 1, 11, 20, 20, 4}));
    }
}