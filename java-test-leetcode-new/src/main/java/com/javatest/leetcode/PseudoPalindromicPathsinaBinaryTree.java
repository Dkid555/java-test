package com.javatest.leetcode;

public class PseudoPalindromicPathsinaBinaryTree {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }
        mask ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }
        return dfs(root.left, mask) + dfs(root.right, mask);
    }
}
//Given a binary tree where node values are digits from 1 to 9.
// A path in the binary tree is said to be pseudo-palindromic
// if at least one permutation of the node values in the path is a palindrome.
//
//Return the number of pseudo-palindromic paths going from the root node to leaf nodes.