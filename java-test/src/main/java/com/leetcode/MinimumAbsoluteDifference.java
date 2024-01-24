package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    static public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> pair = List.of(arr[i], arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{1,3,4,2}));
    }
}
