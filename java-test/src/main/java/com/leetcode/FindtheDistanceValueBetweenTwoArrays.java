package com.leetcode;

import java.util.Arrays;

public class FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return (int) Arrays.stream(arr1)
                .filter(num1 -> Arrays.stream(arr2).noneMatch(num2 -> Math.abs(num1 - num2) <= d))
                .count();
    }
}
