package com.leetcode;

public class CountNodesEqualtoAverageofSubtree {
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        diveInto(root, result);
        return result[0];
    }

    public int[] diveInto(TreeNode root, int[] result) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = diveInto(root.left, result);
        int[] right = diveInto(root.right, result);
        int currentSum = root.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];
        if (currentSum / currentCount == root.val)
            ++result[0];
        return new int[]{currentSum, currentCount};
    }
}
