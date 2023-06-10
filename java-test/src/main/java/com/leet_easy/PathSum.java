package com.leet_easy;

//Find path in tree that equals to target
public class PathSum {
    static boolean sum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        return sum(root.left, targetSum - root.val) || sum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11,
                new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        System.out.println(sum(root, 22));
    }
}
