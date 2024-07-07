package com.javatest.leetcode;

public class DeleteNodeinaBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.val == key && root.left == null && root.right == null)) {
            root = null;
            return root;
        }
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.right == null)
                return root.left;
            else {
                root.val = minHelper(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public static int minHelper(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        deleteNode(root, 3);
    }
}
