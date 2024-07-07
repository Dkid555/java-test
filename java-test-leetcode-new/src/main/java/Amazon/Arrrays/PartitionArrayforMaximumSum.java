package com.Amazon.Arrrays;

import java.util.HashMap;
import java.util.Map;

//import static com.data.calculator.Calculator.result;

public class PartitionArrayforMaximumSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        return find(arr, 0, 0, 0, k, map);
    }

    public static int find(int[] arr, int i, int max, int len, int k, Map<String, Integer> map) {
        if (i >= arr.length) {
            return max * len;
        }
        String str = i + " " + max + " " + len;
        if (map.containsKey(str))
            return map.get(str);
        int last = 0, notLast = 0;
        last = max * len + find(arr, i + 1, arr[i], 1, k, map);
        if (len < k)
            notLast = find(arr, i + 1, Math.max(max, arr[i]), len + 1, k, map);
        map.put(str, Math.max(last, notLast));
        return Math.max(last, notLast);
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
//Given an integer array arr, partition the
// array into (contiguous) subarrays of length
// at most k. After partitioning, each subarray
// has their values changed to become the maximum value of that subarray.
//
//Return the largest sum of the given array after partitioning.
// Test cases are generated so that the answer fits in a 32-bit integer.