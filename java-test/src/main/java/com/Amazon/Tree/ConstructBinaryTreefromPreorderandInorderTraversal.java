package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode{
        @NonNull int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private int i = 0;
    private int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}
