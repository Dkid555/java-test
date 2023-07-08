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
