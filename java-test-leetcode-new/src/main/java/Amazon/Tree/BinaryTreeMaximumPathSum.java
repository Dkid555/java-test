package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.swing.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode{
        @NonNull int val;
        TreeNode left;
        TreeNode right;
    }
    int max = Integer.MIN_VALUE;

//    public int maxPath(TreeNode root) {
//
//        if(root == null)
//            return 0;
//
//        int value = root.val;
//
//        int left_sum = Math.max(maxPath(root.left),0);
//        int right_sum = Math.max(maxPath(root.right),0);
//
//        max = Math.max(max, left_sum + right_sum + value);
//
//        return Math.max(left_sum, right_sum) + value;
//    }
    public int maxPath(TreeNode root){
        if(root == null)
            return 0;
        int value = root.val;
        int left_sum = Math.max(maxPath(root.left), 0);
        int right_sum = Math.max(maxPath(root.right), 0);
        max = Math.max(value + left_sum + right_sum, max);
        return Math.max(left_sum, right_sum) + value;
    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
}
//A path in a binary tree is a sequence of nodes
// where each pair of adjacent nodes in the sequence has an
// edge connecting them. A node can only appear in the sequence
// at most once. Note that the path does not need to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any non-empty path.