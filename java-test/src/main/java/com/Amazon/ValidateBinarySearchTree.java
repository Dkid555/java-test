package com.Amazon;

//import javax.swing.tree.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ValidateBinarySearchTree {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private static long minVal = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(minVal >= root.val)
            return false;
        minVal = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(0), new TreeNode(3, new TreeNode(2),
                new TreeNode(4)));
        System.out.println(isValidBST(tree));
    }
}
