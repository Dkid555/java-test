package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSumContinuesSub {

    static long maximumSum(List<Integer> arr) {
        int size = arr.size();
        long max_sofar = Integer.MIN_VALUE, max_end = 0;
        for (int i = 0; i < size; i++) {
            max_end = max_end + arr.get(i);
            if (max_end > max_sofar)
                max_sofar = max_end;
            if (max_end < 0)
                max_end = 0;
        }
        return max_sofar;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, -1, 3, 4, -2, 5, -7);
        System.out.println(maximumSum(arr));
    }
}
