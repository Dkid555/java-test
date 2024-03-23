package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root,int position, List<List<Integer>> list){
        if(root == null)
            return;
        else {
            if (position > list.size() || list.isEmpty()){
                list.add(new ArrayList<>());
            }
            list.get(position).add(root.val);
        }

        dfs(root.left, position + 1, list);
        dfs(root.right, position + 1, list);

    }
}
