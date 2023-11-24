package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        diveInto(root1, result1);
        diveInto(root2, result2);
        if (result1.size() != result2.size())
            return false;
        for (int i = 0; i < result1.size(); ++i) {
            if (result1.get(i) != result2.get(i))
                return false;
        }
        return true;
    }

    private void diveInto(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        diveInto(root.left, result);
        diveInto(root.right, result);
    }
}
