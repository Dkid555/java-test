package com.javatest.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (Integer i : arr2) {
            for (int j = 0; j < map.get(i); j++) {
                arr1[count++] = i;
            }
            map.remove(i);
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(arr1));

        for (Integer i : map.keySet()) {
            for (int j = 0; j < map.get(i); j++) {
                arr1[count++] = i;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int idx = 0;

        for (int i = 0; i < arr1.length; ++i) ++count[arr1[i]];

        for (int v : arr2) {
            while (count[v] > 0) {
                arr1[idx++] = v;
                count[v]--;
            }
        }

        for (int i = 0; i < 1001; ++i)
            while (count[i] > 0) {
                arr1[idx++] = i;
                count[i]--;
            }

        return arr1;
    }
}
