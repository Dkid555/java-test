package com.leetcode;

import java.util.ArrayList;

public class IncreasingOrderSearchTree {
    public ArrayList<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        //Dummy Node
        TreeNode temp = new TreeNode(-1);
        TreeNode ans = temp;

        //Logic
        for (int i = 0; i < list.size(); i++) {
            TreeNode r = new TreeNode(list.get(i));
            temp.left = null;
            temp.right = r;
            temp = temp.right;

        }
        return ans.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
