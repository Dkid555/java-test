package com.javatest.leetcode;

import java.util.*;

public class Podholes {
    public static int podholesCount(String S, int B) {
        Map<Integer, Integer> podHoles = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == 'x') {
                int count = 1;
                ++i;
                while (i < S.length() && S.charAt(i) == 'x') {
                    ++count;
                    ++i;
                }
                podHoles.put(count, podHoles.getOrDefault(count, 0) + 1);
                max = Math.max(max, count);
            }
        }
        if (max > B) {
            return B - 1;
        }

        List<Integer> keys = new ArrayList<>(podHoles.keySet());
        Collections.sort(keys);
        int result = 0;
        for (int i = keys.size() - 1; i >= 0; --i) {
            int podConsec = keys.get(i);
            while (podHoles.get(podConsec) > 0) {
                podHoles.put(podConsec, podHoles.get(podConsec) - 1);
                if (B >= podConsec + 1) {
                    result += podConsec;
                    B -= (podConsec + 1);
                } else {
                    result += B - 1;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(podholesCount("..", 5));
    }
}
