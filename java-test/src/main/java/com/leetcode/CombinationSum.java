package com.leetcode;


import java.util.ArrayList;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of
// all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        helper(0, candidates, target, res, list);
        return res;
    }

    public static void helper(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list) {
        if (index == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (arr[index] <= target) {
            //pick the index value
            list.add(arr[index]);
            helper(index, arr, target - arr[index], res, list);
            list.remove(list.size() - 1);
        }
        //not picking
        helper(index + 1, arr, target, res, list);
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 5}, 8);

        combinationSum_2(new int[]{2, 3, 5}, 8);

    }


    public static List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        List<List<Integer>> mainRet = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        combSumHelper(candidates, mainRet, 0, target, tempList);
        return mainRet;
    }

    public static void combSumHelper(int[] candidates, List<List<Integer>> mainList, int i, int target, List<Integer> tempList) {
        if (target == 0) {
            mainList.add(new ArrayList<>(tempList));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) continue;

            tempList.add(candidates[j]);
            combSumHelper(candidates, mainList, j, target - candidates[j], tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

}
