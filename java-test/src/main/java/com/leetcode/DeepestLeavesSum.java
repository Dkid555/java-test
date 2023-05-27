package com.leetcode;

public class DeepestLeavesSum {
    protected static int sum = 0;
    protected static int maxheight = 0;

    public static void find(int height, TreeNode root) {
        if (root == null) return;
        if (root.right == null && root.left == null) {
            if (maxheight < height) {
                sum = root.val;
                maxheight = height;
            } else if (maxheight == height) {
                sum += root.val;

            }
        }
        //z = root.val;

        find(height + 1, root.left);
        find(height + 1, root.right);
        //return sum;
    }

    public static void main(String[] args) {
        //int sum = 0;

        //TreeNode root7 = new TreeNode(3, null, null);
        //TreeNode root6 = new TreeNode(4, null, null);
        TreeNode root5 = new TreeNode(4, null, null);
        TreeNode root4 = new TreeNode(3, null, null);
        TreeNode root3 = new TreeNode(2, null, null);
        TreeNode root2 = new TreeNode(2, root4, root5);
        TreeNode root = new TreeNode(2, root2, root3);
        //TreeNode q11 = new TreeNode(4, null, null);
        TreeNode q11 = new TreeNode(5, null, null);
        TreeNode q10 = new TreeNode(3, null, q11);
        TreeNode q9 = new TreeNode(1, null, null);
        TreeNode q8 = new TreeNode(4, null, null);
        TreeNode q7 = new TreeNode(1, null, null);
        TreeNode q6 = new TreeNode(9, null, null);
        TreeNode q5 = new TreeNode(7, q7, q8);
        TreeNode q4 = new TreeNode(2, q6, null);
        TreeNode q3 = new TreeNode(8, q9, q10);
        TreeNode q2 = new TreeNode(7, q4, q5);
        TreeNode q = new TreeNode(6, q2, q3);
        find(0, root);
        System.out.println(sum);
        //sum = 0;
        //find(0,0, root);
        //System.out.println(sum);

    }
}
