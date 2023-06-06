package com.leet_easy;

//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return ("TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}');
    }
}

public class BinaryTreeInorderTraversal {

    //    public List<Integer> fin = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root){
////        List<Integer> fin = new ArrayList<>();
//        traverse(root);
//        return fin;
//    }
//    private static void traverse(TreeNode root){
//        if(root == null){
//            return;
//        }
//        traverse(root.left);
//        fin.add(root.val);
//        traverse(root.right);
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {//if there is no left element
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {//if there exsit a right and the right is not pointing himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;//create the thread
                    cur = cur.left;
                } else {
                    prev.right = null;  //cut the thread
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}
