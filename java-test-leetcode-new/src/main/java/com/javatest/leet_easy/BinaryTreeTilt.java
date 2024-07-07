package com.javatest.leet_easy;

public class BinaryTreeTilt {
    public static int findTilt(TreeNode root) {
        Tilt tilt = new Tilt();
        SumOFDown(root, tilt);
        return tilt.sum;
    }

    private static class Tilt {
        int sum = 0;
    }

    static int SumOFDown(TreeNode root, Tilt tilt) {
        if (root == null) return 0;
        int left = SumOFDown(root.left, tilt);
        int right = SumOFDown(root.right, tilt);
        tilt.sum += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, null, new TreeNode(7)));
        System.out.println(findTilt(root));
    }
}
//Given the root of a binary tree, return the sum of every tree node's tilt.
//
//The tilt of a tree node is the absolute difference between
// the sum of all left subtree node values and all right subtree node values.
// If a node does not have a left child, then the sum of the left subtree
// node values is treated as 0. The rule is similar if the node does not have a right child.