package com.leetcode;

import java.util.*;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(node.right.val);
                }
            }
            count += helper(list);
        }

        return count;
    }

    int helper(List<Integer> list) {
        int swaps = 0;
        int[] sorted = new int[list.size()];
        for (int i = 0; i < sorted.length; i++) sorted[i] = list.get(i);
        Arrays.sort(sorted);
        Map<Integer, Integer> ind = new HashMap<>();
        for (int i = 0; i < list.size(); i++) ind.put(list.get(i), i);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != sorted[i]) {
                swaps++;
                ind.put(list.get(i), ind.get(sorted[i]));
                list.set(ind.get(sorted[i]), list.get(i));
            }
        }
        return swaps;
    }
}
