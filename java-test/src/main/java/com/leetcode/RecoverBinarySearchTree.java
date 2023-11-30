package com.leetcode;

public class RecoverBinarySearchTree {
    private static class HelpTrees {
        TreeNode prev = null, first = null, second = null;

        public HelpTrees() {
        }
    }

    void diveInto(TreeNode root, TreeNode first, TreeNode second, TreeNode prev) {
        if (root == null)
            return;
        diveInto(root.left, first, second, prev);
        if (prev != null && root.val < prev.val) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        diveInto(root.right, first, second, prev);
    }

    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
//        HelpTrees helpTrees = new HelpTrees();

        diveInto(root, first, second, prev);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
