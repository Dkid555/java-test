package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, row, result);
        return result;
    }

    public static void helper(List<Integer> list, List<Integer> row, List<List<Integer>> result) {
        if (list.size() == 0) {
            result.add(new ArrayList<>(row));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> copy = new ArrayList<>(list);
            copy.remove(i);
            row.add(list.get(i));
            helper(copy, row, result);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}

