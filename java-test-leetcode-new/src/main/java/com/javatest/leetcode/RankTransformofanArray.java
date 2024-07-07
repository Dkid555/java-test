package com.javatest.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformofanArray {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] ans = new int[arr.length];
        ans = arr.clone();
        Arrays.sort(arr);
        int[] res = Arrays.stream(arr)
                .distinct()
                .toArray();
        for (int i = 1; i <= res.length; i++)
            hmap.put(res[i - 1], i);

        for (int i = 0; i < ans.length; i++)
            ans[i] = hmap.get(ans[i]);

        return ans;
    }
}
//Given an array of integers arr, replace each element with its rank.
//
//The rank represents how large the element is. The rank has the following rules:
//
//Rank is an integer starting from 1.
//The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//Rank should be as small as possible.
//