package com.leet_easy;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class Same {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        TreeNode tree2 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(tree1, tree2));
    }
}
