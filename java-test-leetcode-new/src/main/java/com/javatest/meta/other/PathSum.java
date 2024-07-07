package com.javatest.meta.other;


public class PathSum {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;


        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
//Given the root of a binary tree and an integer targetSum, return true
// if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
//A leaf is a node with no children.