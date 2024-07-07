package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stone = new HashMap<>();
        int result = 0;
        for (int i = 0; i < stones.length(); i++)
            stone.put(stones.charAt(i), stone.getOrDefault(stones.charAt(i), 0) + 1);
        for (int i = 0; i < jewels.length(); i++) {
            result += stone.getOrDefault(jewels.charAt(i), 0);
        }
        return result;
    }

    public static int numJewelsInStones2(String jewels, String stones) {
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
