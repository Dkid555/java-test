package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckifTheNumberisFascinating {

    public static boolean isFascinating(int n) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(
                1, 1,
                2, 1,
                3, 1,
                4, 1,
                5, 1,
                6, 1,
                7, 1,
                8, 1,
                9, 1
        ));
        String num = String.valueOf(n) + String.valueOf(n * 2) + String.valueOf(n * 3);

        for (int i = 0; i < num.length(); i++) {
            if (map.containsKey(num.charAt(i) - '0')) {
                map.remove(num.charAt(i) - '0');
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isFascinating(100));
    }
}
