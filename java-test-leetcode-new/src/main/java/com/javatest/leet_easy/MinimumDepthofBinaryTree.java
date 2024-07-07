package com.javatest.leet_easy;

import java.util.Set;
import java.util.TreeSet;

public class MinimumDepthofBinaryTree {
    public static int minDepth(TreeNode root) {
        // Base case...
        // If the subtree is empty i.e. root is NULL, return depth as 0...

        if (root == null) return 0;

        // Initialize the depth of two subtrees...
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // If the both subtrees are empty...

        if (root.left == null && root.right == null)
            return 1;

        // If the left subtree is empty, return the depth of right subtree after adding 1 to it...
        if (root.left == null)
            return 1 + rightDepth;
        // If the right subtree is empty, return the depth of left subtree after adding 1 to it...
        if (root.right == null)
            return 1 + leftDepth;

        // When the two child function return its depth...
        // Pick the minimum out of these two subtrees and return this value after adding 1 to it...
        return Math.min(leftDepth, rightDepth) + 1;    // Adding 1 is the current node which is the parent of the two subtrees...
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Check check = new Check();
        check.Depth(treeNode);
        System.out.println(check.high);
    }
}

class Check {
    Set<Integer> high = new TreeSet<>();

    int Depth(TreeNode root) {
        if (root == null) return 1;
        int lh = 1 + Depth(root.left);
        int rh = 1 + Depth(root.right);
        high.add(lh);
        high.add(rh);
        return 0;
    }
}
