package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KthSmallestElementinaBST {
    private void helper(Set<Integer> values, TreeNode root) {
        if (root == null)
            return;
        values.add(root.val);
        helper(values, root.left);
        helper(values, root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        Set<Integer> values = new HashSet<>();
        helper(values, root);
        if (values.size() < k)
            return -1;
        return values.stream().sorted().toList().get(k - 1);
    }

    private static class resultAndKth {
        int result;
        int kth;

        public resultAndKth(int result, int kth) {
            this.result = result;
            this.kth = kth;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        resultAndKth result = new resultAndKth(-1, 1);
        dfs(root, k, result);
        return result.result;
    }

    private void dfs(TreeNode root, int k, resultAndKth result) {
        if (root == null || result.result != -1)
            return;
        dfs(root.left, k, result);
        if (k == result.kth)
            result.result = root.val;
        ++result.kth;
        dfs(root.right, k, result);
    }


}
//Given the root of a binary search tree, and an integer k,
// return the kth smallest value (1-indexed) of all the values of the nodes in the tree.