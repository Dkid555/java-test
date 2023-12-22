package com.leetcode;

public class RootEqualsSumofChildren {
    public boolean checkTree(TreeNode root) {
        if (root.left != null && root.right != null)
            return root.val == root.left.val + root.right.val;
        return false;
    }
}
