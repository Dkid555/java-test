package com.leet_easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        getAllPaths(root, "", result);
        return result;
    }

    static void getAllPaths(TreeNode root, String path, List<String> result) {
//        if(root != null) path += root.val + "->";
        if (root == null) return;
        if (root.left == null && root.right == null) {
            //result.add(path.substring(0, path.length() - 2));
            result.add(path + root.val);
            return;
        }
        path += root.val + "->";
        getAllPaths(root.left, path, result);
        getAllPaths(root.right, path, result);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(5), null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(binaryTreePaths(root));

    }
}
//Given the root of a binary tree,
// return all root-to-leaf paths in any order.
//
//A leaf is a node with no children.