package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;


/*
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] counts = new int[51];
        for (int num : candidates) {
            counts[num]++;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(counts, temp, 1, target, result);
        return result;
    }

    private static void helper(int[] counts, List<Integer> temp, int i, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < counts.length; j++) {
            if (j <= target && counts[j] > 0) {
                counts[j]--;
                temp.add(j);
                helper(counts, temp, j, target - j, result);
                temp.remove(temp.size() - 1);
                counts[j]++;
            } else if (j > target) return;
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
