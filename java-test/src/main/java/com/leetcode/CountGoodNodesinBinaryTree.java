package com.leetcode;

public class CountGoodNodesinBinaryTree {

    private static class Result {
        int result = 0;

        public Result() {
        }
    }

    public int goodNodes(TreeNode root) {
        Result result = new Result();
        diveInto(root, root.val, result);
        return result.result;
    }

    private void diveInto(TreeNode root, int max, Result result) {
        if (root == null)
            return;
        if (root.val >= max) {
            ++result.result;
            max = root.val;
        }
        diveInto(root.left, max, result);
        diveInto(root.right, max, result);
    }
}
//Given a binary tree root, a node X in the tree is named good
// if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.