package com.javatest.leetcode;

public class LinkedListinBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return diveInto(head, root);
    }

    private boolean diveInto(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        if (helper_DFS(head, root)) {
            return true;
        }
        if (diveInto(head, root.left))
            return true;
        return diveInto(head, root.right);
    }

    private boolean helper_DFS(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null || head.val != root.val)
            return false;
        if (helper_DFS(head.next, root.left))
            return true;
        return helper_DFS(head.next, root.right);
    }
}
//Given a binary tree root and a linked list with head as the first node.
//
//Return True if all the elements in the linked list starting from the head correspond to some downward
// path connected in the binary tree otherwise return False.
//
//In this context downward path means a path that starts at some node and goes downwards.