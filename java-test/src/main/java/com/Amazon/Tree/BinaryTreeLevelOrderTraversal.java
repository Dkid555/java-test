package com.Amazon.Tree;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode {
        @NonNull int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> list){
        if(root == null)
            return;
        if(list.size() <= level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }
}
//Given the root of a binary tree,
// return the level order traversal
// of its nodes' values. (i.e., from left to right, level by level).