package com.javatest.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddtoArrayFormofInteger {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> numK = Arrays.stream(num).boxed().collect(Collectors.toList());
        List<Integer> kString = Arrays.stream(String.valueOf(k).split("")).map(Integer::parseInt).collect(Collectors.toList());
        return numK.size() >= kString.size() ? helper(numK, kString) : helper(kString, numK);
    }

    public static List<Integer> helper(List<Integer> arr1, List<Integer> arr2) {
        // arr1 >= arr2;
        int size1 = arr1.size() - 1;
        int size2 = arr2.size() - 1;
        int fromPrev = 0;
        while (size1 >= 0 && size2 >= 0) {
            int temp = arr1.get(size1) + arr2.get(size2--) + fromPrev;
            fromPrev = temp / 10 > 0 ? 1 : 0;
            temp = temp % 10;
            arr1.set(size1--, temp);
        }
        if (fromPrev != 0) {
            while (size1 >= 0) {
                int temp = arr1.get(size1) + fromPrev;
                fromPrev = temp / 10 > 0 ? 1 : 0;
                temp = temp % 10;
                arr1.set(size1--, temp);
            }
            if (fromPrev > 0)
                arr1.add(0, fromPrev);
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }
}
