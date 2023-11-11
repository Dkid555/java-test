package com.leetcode;

public class ValidateBinarySearchTree {
    private static long minVal = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (minVal >= root.val)
            return false;
        minVal = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(treeNode));
    }
}
