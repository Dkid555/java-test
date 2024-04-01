package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int level)
    {
        if(root == null)
            return;
        if(list.size() <= level) {
            list.add(new ArrayList<>());
        }
        if(level % 2 == 0)
            list.get(level).add(root.val);
        else
            list.get(level).add(0, root.val);

        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
    }
}
