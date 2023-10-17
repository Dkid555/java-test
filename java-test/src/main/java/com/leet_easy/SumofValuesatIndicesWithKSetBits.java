package com.leet_easy;

import java.util.List;

public class SumofValuesatIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        final int size = nums.size();
        for (int i = 0; i < size; ++i) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                if (count > k)
                    break;
                temp >>>= 1;
            }
            if (count == k)
                sum += nums.get(i);
        }
        return sum;
    }
}
//You are given a 0-indexed integer array nums and an integer k.
//
//Return an integer that denotes the sum of elements in nums
// whose corresponding indices have exactly k set bits in their binary representation.
//
//The set bits in an integer are the 1's present when it is written in binary.
//
//For example, the binary representation of 21 is 10101, which has 3 set bits.