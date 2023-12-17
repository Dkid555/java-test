package com.leetcode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructDiveInto(0, nums.length - 1, nums);
    }

    public TreeNode constructDiveInto(int start, int end, int[] nums) {
        if (start > end)
            return null;

        int root = 0;
        int rootIndex = 0;
        for (int i = start; i < end; ++i) {
            if (nums[i] >= root) {
                root = nums[i];
                rootIndex = i;
            }
        }

        return new TreeNode(root, constructDiveInto(start, rootIndex - 1, nums),
                constructDiveInto(rootIndex + 1, end, nums));

//        TreeNode head = new TreeNode(root);
//        head.left = constructDiveInto(start, rootIndex - 1, nums);
//        head.right = constructDiveInto(rootIndex + 1, end, nums);
//        return head;
    }
}
