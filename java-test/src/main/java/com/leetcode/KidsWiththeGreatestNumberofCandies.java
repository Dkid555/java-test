package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
*
* There are n kids with candies. You are given an integer array candies,
* where each candies[i] represents the number of candies the ith kid has,
*  and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving
* the ith kid all the extraCandies, they will have the greatest number of candies among
* all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.
* */

public class KidsWiththeGreatestNumberofCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> give = new ArrayList<>();
        int max = 0;
        for (int candi : candies) {
            max = Math.max(max, candi);
        }
        for (int candi : candies) {
            if (candi + extraCandies < max) give.add(false);
            else give.add(true);
        }
        return give;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }
}
