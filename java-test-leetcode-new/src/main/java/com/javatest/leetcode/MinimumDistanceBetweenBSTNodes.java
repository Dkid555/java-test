package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        diveInto(root, result);
        Collections.sort(result);
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < result.size() - 1; ++i)
            minDistance = Math.min(minDistance, result.get(i + 1) - result.get(i));
        return minDistance;
    }

    private void diveInto(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        diveInto(root.left, result);
        diveInto(root.right, result);
    }


    int min = Integer.MAX_VALUE;
    TreeNode prevNode = null;

    public int minDiffInBST2(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (prevNode != null) {
            min = Math.min(min, root.val - prevNode.val);
        }

        prevNode = root;

        helper(root.right);
    }
}
