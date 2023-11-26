package com.leetcode;

public class SmallestStringStartingFromLeaf {
    static String res = "";

    static public String smallestFromLeaf(TreeNode root) {
        diveInto(root, "");
        return res;
    }

    static public void diveInto(TreeNode root, String sb) {
        if (root == null)
            return;
        char currChar = (char) (root.val + 'a');
        if (root.left == null && root.right == null) {
            String whatToCompare = new StringBuilder(sb + currChar).reverse().toString();
            if (res == "" || res.compareTo(whatToCompare) > 0)
                res = whatToCompare;
        } else {
            diveInto(root.left, sb + currChar);
            diveInto(root.right, sb + currChar);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)));

        System.out.println(smallestFromLeaf(root));
    }
}
