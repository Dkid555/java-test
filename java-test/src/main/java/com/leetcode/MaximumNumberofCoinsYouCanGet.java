package com.leetcode;

import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {

    static public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int start = 0;
        int end = piles.length;
        int sumMax = 0;
        while (start < end){
            --end;
            sumMax += piles[--end];
            ++start;
        }
        return sumMax;
    }
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,3,4,6,1,8})); // => 1.2.3.4.6.8
    }
}
