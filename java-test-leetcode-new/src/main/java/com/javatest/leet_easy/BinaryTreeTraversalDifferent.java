package com.javatest.leet_easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalDifferent {
    public static List<Integer> Traversal(TreeNode root, int choose) {
        List<Integer> result = new ArrayList<>();
        switch (choose) {
            case 1 -> InOrder(root, result);
            case 2 -> PreOrder(root, result);
            case 3 -> PostOrder(root, result);
        }

        return result;
    }

    public static void InOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        InOrder(root.left, result);
        result.add(root.val);
        InOrder(root.right, result);
        //result.add()
    }

    public static void PreOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        PreOrder(root.left, result);
        PreOrder(root.right, result);
        //result.add()
    }

    public static void PostOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        PostOrder(root.left, result);

        PostOrder(root.right, result);
        result.add(root.val);

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        //InOrder: [4, 2, 5, 1, 6, 3, 7] проход влево до конца
        //PreOrder: [1, 2, 4, 5, 3, 6, 7] проход с самого начала
        //PostOrder: [4, 5, 2, 6, 7, 3, 1]

        System.out.println("InOrder: " + Traversal(root, 1));
        System.out.println("PreOrder: " + Traversal(root, 2));
        System.out.println("PostOrder: " + Traversal(root, 3));
    }
}
