package com.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        final var sum = new AtomicInteger();
        sum(root, 0, sum);
        return sum.get();
    }

    private void sum(final TreeNode node, final int parentVal, final AtomicInteger sum) {
        if (node == null) {
            return;
        }

        final var val = parentVal * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum.addAndGet(val);
        } else {
            sum(node.left, val, sum);
            sum(node.right, val, sum);
        }
    }
}
