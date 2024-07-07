package com.javatest.leetcode;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int max = 0;
        int currentMax = 0;
        int prevCurrTree = -1;
        int prevTree = -1;
        int prevCount = 0;

        for (int fruit : fruits) {
            if (fruit == prevCurrTree || fruit == prevTree) {
                ++currentMax;
            } else {
                max = Math.max(max, currentMax);
                currentMax = prevCount + 1;
            }
            if (fruit == prevCurrTree) {
                ++prevCount;
            } else {
                prevCount = 1;
                prevTree = prevCurrTree;
                prevCurrTree = fruit;
            }
        }
        return Math.max(max, currentMax);
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}
