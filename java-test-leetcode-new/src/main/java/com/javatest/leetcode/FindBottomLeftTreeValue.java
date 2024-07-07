package com.javatest.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        var node = root;

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }
        return node.val;
    }
}
