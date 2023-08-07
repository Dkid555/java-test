package com.leet_easy;

import java.util.ArrayList;
import java.util.List;


// sum of left leaves (if there is no left and right children)
public class SumofLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        List<Integer> sum = new ArrayList<>();
        pickAllLeft(root, sum, false);
        return sum.stream().reduce(0, Integer::sum);
    }

    static void pickAllLeft(TreeNode root, List<Integer> sum, boolean direction) {
        if (root.left == null && root.right == null && direction) {
            sum.add(root.val);
            return;
        }
        if (root.left != null) pickAllLeft(root.left, sum, true);
        if (root.right != null) pickAllLeft(root.right, sum, false);
    }


    // without list
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        return pickAllLeft(root, false);
    }

    static int pickAllLeft(TreeNode root, boolean direction) {
        if (root.left == null && root.right == null) {
            return direction ? root.val : 0;
        }
        int sum = 0;
        if (root.left != null) sum += pickAllLeft(root.left, true);
        if (root.right != null) sum += pickAllLeft(root.right, false);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(sumOfLeftLeaves2(root));
    }
}
