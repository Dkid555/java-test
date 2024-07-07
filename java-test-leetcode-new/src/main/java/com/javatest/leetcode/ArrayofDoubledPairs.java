package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ArrayofDoubledPairs {

    public static boolean canReorderDoubled(int[] arr) {
        var count = new HashMap<Integer, Integer>();
        var nums = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(nums, Comparator.comparing(Math::abs));
        Arrays.stream(nums)
                .forEach(x -> count.compute(x, (k, v) -> v == null ? 1 : ++v));

        for (var n : nums) {
            if (count.get(n) == 0)
                continue;
            if (count.getOrDefault(2 * n, 0) == 0 || (n == 0 && count.getOrDefault(0, 0) < 2))
                return false;
            count.compute(n, (k, v) -> --v);
            count.compute(2 * n, (k, v) -> --v);
        }
        return true;
    }

    public boolean canReorderDoubled2(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int offset = min < 0 ? -min : 0;
        max = Math.max(max, offset);

        int[] counts = new int[max + offset + 1];
        for (int num : arr) {
            counts[num + offset]++;
        }

        // Zero is a special case
        if (counts[offset] % 2 != 0) {
            return false;
        }

        counts[offset] = 0;

        // Positives
        for (int i = offset + 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                int doubledValue = 2 * (i - offset) + offset;
                if (doubledValue < 0 || doubledValue > counts.length || counts[doubledValue] < counts[i]) {
                    return false;
                }

                counts[doubledValue] -= counts[i];
                counts[i] = 0;
            }
        }

        // Negatives
        for (int i = offset - 1; i >= 0; i--) {
            if (counts[i] > 0) {
                int doubledValue = 2 * (i - offset) + offset;
                if (doubledValue < 0 || doubledValue > counts.length || counts[doubledValue] < counts[i]) {
                    return false;
                }

                counts[doubledValue] -= counts[i];
                counts[i] = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

}
