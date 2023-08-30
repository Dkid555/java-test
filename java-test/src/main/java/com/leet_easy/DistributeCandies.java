package com.leet_easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        int res = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(res, set.size());
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{6, 6, 6, 6}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
