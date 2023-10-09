package com.leet_easy;

import java.util.Arrays;

public class DefusetheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        return k > 0
                ? decrypt(code, new int[n], k, 1, k + 1)
                : decrypt(code, new int[n], k, n + k, n);
    }

    private int[] decrypt(int[] code, int[] decode, int k, int left, int right) {
        if (k == 0)
            return decode;
        int sum = decode[0] = Arrays.stream(code, left, right).sum();

        for (int i = 1, n = decode.length; i < n; i++, left++, right++)
            decode[i] = sum += code[right % n] - code[left % n];

        return decode;
    }
}
