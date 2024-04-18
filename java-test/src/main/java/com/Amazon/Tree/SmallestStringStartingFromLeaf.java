package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SmallestStringStartingFromLeaf {
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        //0,1,2,3,4,3,4
        TreeNode tree = new TreeNode(0,
                null,
//                new TreeNode(1, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2,new TreeNode(3), new TreeNode(4)));
        System.out.println(smallestFromLeaf(tree));
    }
    public static String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }

    private static void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;
        // Append current node's character to the path
        path.append((char)('a' + node.val));
        // If it's a leaf node, compare and update smallest
        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.isEmpty() || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse(); // backtrack by reversing again
        }

        // Recursively traverse left and right subtrees
        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);

        // Backtrack: remove the current node's character from the path
        path.setLength(path.length() - 1);
    }
}
