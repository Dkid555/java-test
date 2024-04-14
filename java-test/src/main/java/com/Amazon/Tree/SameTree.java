package com.Amazon.Tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.TreeNode;

public class SameTree {

    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode{
        @NonNull int val;
        TreeNode left;
        TreeNode right;
    }

    private static boolean equalsCurrent(TreeNode p, TreeNode q){
        if((p.val == q.val)){
            return true;
        }
        return false;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null)
            return true;
        else if(q == null || p == null)
            return false;
        if(!equalsCurrent(p, q))
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(isSameTree(treeNode1, treeNode2));
    }
}
