package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.swing.tree.TreeNode;

public class InvertBinaryTree {
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode{
        @NonNull int val;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
