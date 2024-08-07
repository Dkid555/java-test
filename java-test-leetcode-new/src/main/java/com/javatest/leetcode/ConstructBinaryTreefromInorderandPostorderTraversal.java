package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd,
                               Map<Integer, Integer> map){
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1, map);
        root.right = buildTree(inorder, postorder, inStart + leftSize + 1, inEnd, postStart + leftSize, postEnd - 1, map);
        return root;
    }
}
