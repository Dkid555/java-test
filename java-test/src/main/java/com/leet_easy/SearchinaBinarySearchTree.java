package com.leet_easy;

public class SearchinaBinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        System.out.println(searchBST(tree, 2));
    }
}
