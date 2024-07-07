package com.javatest.meta;

import java.util.HashMap;
import java.util.Map;

public class ReversetoMakeEqual {
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Map<Integer, Integer> mapA = new HashMap<>();
        for (int num : array_a) {
            mapA.put(num, mapA.getOrDefault(num, 0) + 1);
        }
        for (int num : array_b) {
            if (mapA.containsKey(num)) {
                int to_put = mapA.get(num) - 1;
                if (to_put == 0)
                    mapA.remove(num);
                else
                    mapA.put(num, to_put);
            } else
                return false;
        }
        return mapA.isEmpty();
    }

    boolean areTheyEqual2(int[] array_a, int[] array_b) {
        // Write your code here
        int a = 0;
        if (array_a.length != array_b.length) return false;
        for (int i = 0; i < array_a.length; ++i) {
            a ^= array_a[i];
            a ^= array_b[i];
        }
        return a == 0;

    }


}
//Given two arrays A and B of length N,
// determine if there is a way to make A equal
// to B by reversing any subarrays from array B any number of times.