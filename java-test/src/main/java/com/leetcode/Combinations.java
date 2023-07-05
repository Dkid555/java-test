package com.leetcode;


//Given two integers n and k, return all possible combinations
// of k numbers chosen from the range [1, n].
//
//You may return the answer in any order.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> result = new HashSet<>();
        for (int current = 1; current <= n; current++) {
            List<Integer> temp = new ArrayList<>();
            helper(current, k, n, temp, result);
        }
        return new ArrayList<>(result);
    }

    private static void helper(int current, int k, int n, List<Integer> temp, Set<List<Integer>> result) {
        if (temp.size() > k) {
            return;
        }

        temp.add(current);

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = current + 1; i <= n; i++) {
            helper(i, k, n, temp, result);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}


/*
* List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
      // if (n<=0||k<=0||k>n)
      //   return res;
      dfs(n, k, 1, new ArrayList<>());
      return res;
    }

    private void dfs(int n, int k, int start, List<Integer> prev) {
      if (k == 0) {
        res.add(new ArrayList<>(prev));
        return;
      }
      for (int i=start ; i<=n-(k-1) ; i++){
        prev.add(i);
        dfs(n, k - 1, i + 1, prev);
        prev.remove(prev.size()-1);
      }
    }
    * */
