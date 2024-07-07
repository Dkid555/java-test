package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null)
            return new ArrayList<>();
        Set<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        root = diveInto(root, toDelete, result);
        if (root != null && !toDelete.contains(root.val))
            result.add(root);
        return result;

    }

    private static TreeNode diveInto(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null)
            return null;
        root.left = diveInto(root.left, toDelete, result);
        root.right = diveInto(root.right, toDelete, result);
        if (toDelete.contains(root.val)) {
            if (root.left != null)
                result.add(root.left);
            if (root.right != null)
                result.add(root.right);
            toDelete.remove(root.val);
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(delNodes(root2, new int[]{2, 1}));
    }
}
//Given the root of a binary tree, each node in the tree has a distinct value.
//
//After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
//Return the roots of the trees in the remaining forest. You may return the result in any order.
//
//
