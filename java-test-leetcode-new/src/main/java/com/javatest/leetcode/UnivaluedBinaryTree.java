package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        diveInto(root, set);
        return set.size() <= 1;
    }

    private void diveInto(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;
        set.add(root.val);
        diveInto(root.left, set);
        diveInto(root.right, set);

    }
}
