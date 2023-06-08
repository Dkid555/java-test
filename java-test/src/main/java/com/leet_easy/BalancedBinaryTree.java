package com.leet_easy;

public class BalancedBinaryTree {
    //O(n^2)
    public static boolean check(TreeNode tree) {
        if (tree == null) return true;
        if (Math.abs(height(tree.left) - height(tree.right)) <= 1 && check(tree.right)
                && check(tree.left))
            return true;
        return false;
    }

    public static int height(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    //O(n)
    public static int check2(TreeNode tree) {
        if (tree == null)
            return 0;
        int lh = check2(tree.left);
        if (lh == -1)
            return -1;
        int rh = check2(tree.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(check(tree));
        System.out.println(check2(tree) >= 0);
    }
}
