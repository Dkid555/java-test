package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class XofaKindinaDeckofCards {
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        int gcd = 0; // Greatest Common Deviser
        for (int i : map.values()) {
            gcd = gcd(i, gcd);
        }
        return gcd > 1;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }
}
//You are given an integer array deck where deck[i] represents the number written on the ith card.
//
//Partition the cards into one or more groups such that:
//
//Each group has exactly x cards where x > 1, and
//All the cards in one group have the same integer written on them.
//Return true if such partition is possible, or false otherwise.