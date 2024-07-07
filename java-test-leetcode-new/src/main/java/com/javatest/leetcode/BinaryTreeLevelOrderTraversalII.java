package com.javatest.leetcode;

//import org.assertj.core.data.Index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, root, 0);
        Collections.reverse(list);
        return list;
    }

    static void dfs(List<List<Integer>> list, TreeNode root, int index){
        if(root == null)
            return;
        if(index >= list.size())
            list.add(index, new ArrayList<>());
        list.get(index).add(root.val);

        dfs(list, root.left, index+1);
        dfs(list, root.right, index + 1);
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrderBottom(root));
    }
}
