package com.leetcode;

import java.util.*;

public class MinimumAbsoluteDifference {
    static public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
            List<List<Integer>> temp = map.getOrDefault((arr[i + 1] - arr[i]), new ArrayList<>());
            temp.add(List.of(arr[i], arr[i + 1]));
            map.put(arr[i + 1] - arr[i], temp);
        }
        return map.get(min);
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{1,3,4,2}));
    }
}
