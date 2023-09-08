package com.leet_easy;

public class CountCompleteTreeNodes {
    //    int count = 0;
    public int countNodes(TreeNode root) {
//        if(root != null){
//            countNodes(root.left);
//            count++;
//            countNodes(root.right);
//        }
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
//Given the root of a complete binary tree, return the number of the nodes in the tree.
//
//According to Wikipedia, every level, except possibly the last,
// is completely filled in a complete binary tree, and all nodes
// in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//Design an algorithm that runs in less than O(n) time complexity.