package com.javatest.leetcode;

import java.util.Arrays;

public class H_index {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i++)
            result = Math.max(result, Math.min(citations[i], citations.length - i));
        return result;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int start = 0;
        int end = citations.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations.length - mid >= citations[mid]) {
                ans = Math.max(ans, citations[mid]);
                start = mid + 1;
            } else {
                ans = Math.max(ans, citations.length - mid);
                end = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
//H-index
//Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
//
//According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
