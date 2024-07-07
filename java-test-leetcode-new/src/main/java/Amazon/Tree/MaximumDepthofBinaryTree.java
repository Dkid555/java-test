package com.Amazon.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class MaximumDepthofBinaryTree {
    private class TreeNode{
        TreeNode left;
        TreeNode right;
    }
    public int maxDepth(TreeNode root) {
        Stack<Integer> max = new Stack<>();
        max.push(0);
        dfs(root, 1, max);
        return max.pop();
    }
    void dfs(TreeNode root, int count, Stack<Integer> max){
        if(root == null)
            return;
        max.push(Math.max(count, max.pop()));
        dfs(root.left, count+1, max);
        dfs(root.right, count+1, max);
    }

}
//Given the root of
// a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is
// the number of nodes along the longest path from the root node down to the farthest leaf node.