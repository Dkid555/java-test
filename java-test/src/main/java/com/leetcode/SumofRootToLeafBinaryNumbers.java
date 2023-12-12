package com.leetcode;

public class SumofRootToLeafBinaryNumbers {
    public static int sumRootToLeaf(TreeNode root) {
        return diveInto(root, 0);
    }

    public static int diveInto(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = (sum * 2) + node.val;
        if (node.left == null && node.right == null)
            return sum;
        return diveInto(node.left, sum) + diveInto(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(sumRootToLeaf(root));
    }
}
