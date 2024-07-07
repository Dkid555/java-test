package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        List<TreeNode> treeList = new ArrayList<>();

        diveInto(root, treeList);

        for (int i = 0; i < treeList.size() - 1; ++i) {
            treeList.get(i).left = null;
            treeList.get(i).right = treeList.get(i + 1);
        }
        treeList.get(treeList.size() - 1).left = null;
        treeList.get(treeList.size() - 1).right = null;
    }

    private static void diveInto(TreeNode root, List<TreeNode> treeList) {
        if (root == null)
            return;
        treeList.add(root);
        diveInto(root.left, treeList);
        diveInto(root.right, treeList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
    }


    public void flatten2(TreeNode root) {
        TreeNode head = null, curr = root;
        while (head != root) {
            if (curr.right == head) curr.right = null;
            if (curr.left == head) curr.left = null;
            if (curr.right != null) curr = curr.right;
            else if (curr.left != null) curr = curr.left;
            else {
                curr.right = head;
                head = curr;
                curr = root;
            }
        }
    }
}
//Given the root of a binary tree, flatten the tree into a "linked list":
//
//The "linked list" should use the same TreeNode class where the right child pointer
// points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.