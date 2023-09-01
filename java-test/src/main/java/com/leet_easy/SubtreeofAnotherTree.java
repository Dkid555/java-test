package com.leet_easy;

public class SubtreeofAnotherTree {
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        return convertTree(root).contains(convertTree(subRoot));
    }

    public static String convertTree(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return ("TreeNode{" +
                "val=" + root.val +
                ", left=" + convertTree(root.left) +
                ", right=" + convertTree(root.right) +
                '}');
    }

    ///

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        return sameTreeCheck(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public static boolean sameTreeCheck(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.val != second.val) return false;
        return sameTreeCheck(first.left, second.left) && sameTreeCheck(first.right, second.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode sub = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(root, sub));
    }
}
//Given the roots of two binary trees root and subRoot, return true if there
// is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all
// of this node's descendants. The tree tree could also be considered as a subtree of itself.