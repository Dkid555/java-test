package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {

        int maxHeight = maxHeight(root);
        int sizeOfRow = (int) Math.pow(2, maxHeight) - 1;
        List<List<String>> result = new ArrayList<>();
        List<String> singlerow = new ArrayList<>();

        for (int i = 0; i < sizeOfRow; i++) {
            singlerow.add("");
        }
        for (int i = 0; i < maxHeight; i++) {
            result.add(new ArrayList<>(singlerow));
        }
        diveInto(root, 0, 0, sizeOfRow - 1, result);
        return result;
    }

    static void diveInto(TreeNode root, int row, int left, int right, List<List<String>> result) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        result.get(row).set(mid, Integer.toString(root.val));
        diveInto(root.left, row + 1, left, mid - 1, result);
        diveInto(root.right, row + 1, mid + 1, right, result);
    }

    static int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public static void main(String[] args) {

    }
}
