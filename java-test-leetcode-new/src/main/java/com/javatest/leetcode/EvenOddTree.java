package com.javatest.leetcode;

import java.util.HashMap;

public class EvenOddTree {

    private static class Count {
        int count = 0;

        public Count(int count) {
            this.count = count;
        }
    }

    public static boolean isEvenOddTree(TreeNode root) {
        return diveInto(root, new Count(0), new HashMap<>());
    }

    private static boolean diveInto(TreeNode root, Count count, HashMap<Integer, Integer> map) {
        if (root == null) {
            return true;
        }
        if ((count.count % 2 == 0 && root.val % 2 == 0) || (count.count % 2 == 1 && root.val % 2 == 1))
            return false;
        if ((count.count % 2 == 0 && root.val % 2 == 1)) { // нечетный odd
            if (!map.containsKey(count.count)) {
                map.put(count.count, root.val);
            } else {
                int previous = map.get(count.count);
                if (previous >= root.val)
                    return false;
                map.put(count.count, root.val);
            }
        } else if ((count.count % 2 == 1 && root.val % 2 == 0)) { // четный - even
            if (!map.containsKey(count.count)) {
                map.put(count.count, root.val);
            } else {
                int previous = map.get(count.count);
                if (previous <= root.val)
                    return false;
                map.put(count.count, root.val);
            }
        }
        return diveInto(root.left, new Count(++count.count), map) && diveInto(root.right, new Count(count.count), map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null), new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))));
        TreeNode root2 = new TreeNode(5, new TreeNode(4, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7), null));
        System.out.println(isEvenOddTree(root2));
    }
}
