package com.leet_easy;

public class DiameterofBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        maxHeight(root, result);
        return result[0];
    }

    public static int maxHeight(TreeNode root, int[] result) {
        if (root == null) return 0;
        int left = maxHeight(root.left, result);
        int right = maxHeight(root.right, result);
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
