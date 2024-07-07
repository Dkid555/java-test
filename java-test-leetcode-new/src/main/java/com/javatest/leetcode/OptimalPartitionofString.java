package com.javatest.leetcode;

public class OptimalPartitionofString {
    public int partitionString(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int count = 0;

        while (i < arr.length) {
            int j = i + 1;
            boolean[] seen = new boolean[26];

            seen[arr[i] - 'a'] = true;

            while (j < arr.length && !seen[arr[j] - 'a']) {
                seen[arr[j] - 'a'] = true;
                j++;
            }
            count++;
            i = j;
        }

        return count;
    }
}
