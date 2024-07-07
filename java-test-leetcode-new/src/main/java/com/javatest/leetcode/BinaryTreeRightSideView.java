package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        diveRight(result, root, 0);
        return result;
    }

    private void diveRight(List<Integer> result, TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(root.val);
        }
        diveRight(result, root.right, depth + 1);
        diveRight(result, root.left, depth + 1);
    }
}
