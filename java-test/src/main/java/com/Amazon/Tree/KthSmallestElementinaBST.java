package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode{
        @NonNull int val;
        TreeNode left;
        TreeNode right;
    }
    private static class resultAndKth{
        int result;
        int kth;
        public resultAndKth(int result, int kth) {
            this.result = result;
            this.kth = kth;
        }
    }

    private static void dfs(TreeNode root, int k, resultAndKth result) {
        if(root==null || result.result!=-1)
            return;
        dfs(root.left,k, result);
        if(k==result.kth)
            result.result=root.val;
        ++result.kth;
        dfs(root.right,k,  result);
    }

    public static int kthSmallest(TreeNode root, int k) {
        resultAndKth result = new resultAndKth(-1, 1);
        dfs(root,k, result);
        return result.result;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null,null)), new TreeNode(4, null,null));

        System.out.println(kthSmallest(tree, 3));
    }
}
//Given the root of a binary search tree, and an integer k,
// return the kth smallest value (1-indexed) of all the values of the nodes in the tree.