package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CousinsinBinaryTree {
    private static class PrevValCount {
        int previous;
        int count;

        public PrevValCount(int previous, int count) {
            this.count = count;
            this.previous = previous;
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, PrevValCount> map = new HashMap<>();
        search(root, x, y, 0, root.val, map);
        return map.get(x).count == map.get(y).count && map.get(x).previous != map.get(y).previous;
    }

    private static void search(TreeNode root, int x, int y, int count, int previous, Map<Integer, PrevValCount> map) {
        if (map.size() == 2)
            return;
        if (root == null)
            return;
        if (root.val == x) {
            map.put(x, new PrevValCount(previous, count));
        }
        if (root.val == y) {
            map.put(y, new PrevValCount(previous, count));
        }
        search(root.left, x, y, ++count, root.val, map);
        --count;
        search(root.right, x, y, ++count, root.val, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));

        System.out.println(isCousins(root, 1, 2));
    }
}
