package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;


public class SecondMinimumNodeInaBinaryTree {

    private void helper(Set<Integer> values, TreeNode root) {
        if (root == null)
            return;
        values.add(root.val);
        helper(values, root.left);
        helper(values, root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> values = new HashSet<>();
        helper(values, root);
        if (values.size() <= 1)
            return -1;
        return values.stream().sorted().toList().get(1);
    }
}
