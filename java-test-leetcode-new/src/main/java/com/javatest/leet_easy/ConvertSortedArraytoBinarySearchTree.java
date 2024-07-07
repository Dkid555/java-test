package com.javatest.leet_easy;

public class ConvertSortedArraytoBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9, 11};
        TreeNode fin = sortedArrayToBST(nums, 0, nums.length - 1);
        System.out.println(fin);
    }
}
