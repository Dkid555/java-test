package com.javatest.leetcode;

import java.util.Arrays;

public class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        int i = 1;
        for (int encode : encoded) {
            result[i] = result[i++ - 1] ^ encode;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
