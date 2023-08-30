package com.leet_easy;

public class ConstructStringfromBinaryTree {


    public static String tree2str(TreeNode root) {
        if (root == null)
            return "";

        if (root.left == null && root.right == null)
            return String.valueOf(root.val);

        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
//        if(root.left == null)
//            return root.val+"(" +tree2str(root.right)+")";

        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
//        @Override
        System.out.println(tree2str(tree));
    }

}

