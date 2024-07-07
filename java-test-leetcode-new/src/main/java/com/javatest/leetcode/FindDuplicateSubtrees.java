package com.javatest.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        diveIntoSearch(root, new HashMap<>(), result);
        return result;
    }

    private static String diveIntoSearch(TreeNode root, Map<String, Integer> mapSearch, List<TreeNode> result) {
        if (root == null)
            return "#";
        String tree = root.val + "," + diveIntoSearch(root.left, mapSearch, result) + "," + diveIntoSearch(root.right, mapSearch, result);
        int frequency = mapSearch.getOrDefault(tree, 0);
        mapSearch.put(tree, ++frequency);
        if (frequency == 2)
            result.add(root);
        return tree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));

        System.out.println(findDuplicateSubtrees(root));
    }

}
//Given the root of a binary tree, return all duplicate subtrees.
//
//For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//Two trees are duplicate if they have the same structure with the same node values.