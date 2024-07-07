package com.javatest.leetcode;

public class MinimumAbsoluteDifferenceinBST {
    int min = Integer.MAX_VALUE;
    TreeNode previous;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return this.min;
        getMinimumDifference(root.left);
        if (previous != null)
            this.min = Math.min(this.min, root.val - this.previous.val);
        this.previous = root;
        getMinimumDifference(root.right);
        return this.min;
    }
}
