package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        return helper(root, 0, targetSum, new ArrayList<>(), new LinkedList<>());
    }

    private static List<List<Integer>> helper(TreeNode node, int totalSum, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if (node == null) return result;
        temp.add(node.val);
        if (node.left == null && node.right == null && totalSum + node.val == targetSum) {
            result.add(new ArrayList<>(temp));
        }
        helper(node.left, totalSum + node.val, targetSum, result, temp);
        helper(node.right, totalSum + node.val, targetSum, result, temp);
        temp.remove(temp.size() - 1);
        return result;
    }

    public static void main(String[] args) {

    }
}
//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
// values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//
//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.