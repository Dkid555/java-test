package com.meta.other;

public class RangeSumofBST {
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null)
            return 0;
        if (root.val >= low && root.val <= high)
            sum += root.val;

        if (root.val > low) {
            sum += rangeSumBST2(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST2(root.right, low, high);
        }
        return sum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return root == null ? 0 : (root.val > low ? rangeSumBST(root.left, low, high) : 0) +
                (root.val < high ? rangeSumBST(root.right, low, high) : 0) +
                (root.val >= low && root.val <= high ? root.val : 0);
    }

}
