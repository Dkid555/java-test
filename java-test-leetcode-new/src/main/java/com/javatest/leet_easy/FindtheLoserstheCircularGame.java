package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindtheLoserstheCircularGame {
    public static int[] circularGameLosers(int n, int k) {
        Set<Integer> friends = new HashSet<>();
        int i = 0, rem = 0;
        while (true) {
            rem = (rem + i++ * k) % n;
            if (!friends.add(rem)) break;
        }
        int[] result = new int[n - friends.size()];
        int j = 0;
        for (i = 0; i < n; i++) {
            if (!friends.contains(i)) result[j++] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(4, 4)));
    }
}
