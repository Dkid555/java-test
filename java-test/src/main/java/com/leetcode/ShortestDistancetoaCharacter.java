package com.leetcode;

import java.util.Arrays;

public class ShortestDistancetoaCharacter {
    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int countBefore = 0;
        int first_finded = 0;
        for (int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            if (current == c) {
                ++first_finded;
                if (countBefore > 0) {
                    while (countBefore != 0) {
                        if (result[i - countBefore] != 0) {
                            result[i - countBefore] = Math.min(result[i - countBefore], countBefore--);
                        } else
                            result[i - countBefore] = countBefore--;
                    }
                }
                result[i] = 0;
            } else {
                ++countBefore;
                if (first_finded > 0) {
                    result[i] = countBefore;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
