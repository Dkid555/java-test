package com.leetcode;

import java.util.Stack;

public class ConvertBSTtoGreaterTree {
    static public TreeNode convertBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Stack<Integer> sum = new Stack<>();
        sum.push(0);
        reverseInorder(root, sum);
        return root;
    }

    static private void reverseInorder(TreeNode root, Stack<Integer> sum) {
        if (root == null)
            return;
        reverseInorder(root.right, sum);
        root.val = root.val + sum.pop();
        sum.push(root.val);
        reverseInorder(root.left, sum);
    }

    private class SUM {
        int toAdd = 0;

        public SUM() {
        }
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        SUM sum = new SUM();
        diveInto(root, sum);
        return root;
    }

    private void diveInto(TreeNode root, SUM sum) {
        if (root == null)
            return;
        diveInto(root.right, sum);
        root.val = root.val + sum.toAdd;
        sum.toAdd = root.val;
        diveInto(root.left, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        convertBST(root);
    }

}
//Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
//
//As a reminder, a binary search tree is a tree that satisfies these constraints:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.