package com.javatest.leetcode;

public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int i = 1;
        int start = 0;
        int[] result = new int[n];
        if ((n & 1) == 1){
            ++start;
        }
        for (;start < n; ++start){
            result[start] = i;
            result[++start] = -(i++);
        }
        return result;
    }
}
