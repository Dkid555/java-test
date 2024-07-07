package com.javatest.leet_easy;

public class MaxDepthOfBinTree {
//    int i = 1;

    static int Depth(TreeNode tree) {
        if (tree == null) return 0;
        // Hypothesis
        int left = Depth(tree.left);
        int right = Depth(tree.right);
        // Induction
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2));
        int i = Depth(tree);
        System.out.println(i);
    }
}
