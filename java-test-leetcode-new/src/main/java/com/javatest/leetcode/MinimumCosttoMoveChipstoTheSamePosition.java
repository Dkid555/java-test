package com.javatest.leetcode;

public class MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int length = position.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {

    }
}
