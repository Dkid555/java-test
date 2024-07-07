package com.javatest.leet_easy;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.right);
        invertTree(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(invertTree(node));
        //System.out.println(node);
    }
}
