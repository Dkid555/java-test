package com.javatest.leetcode;

public class SumofNodeswithEvenValuedGrandparent {
//    int sum = 0;
    private class SUM{
        int sum;
        public SUM (int sum){
            this.sum = sum;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        SUM sum = new SUM(0);
        sumVal(root, sum);
        return sum.sum;
    }

    public void sumVal(TreeNode root, SUM sum) {
        if (root == null) return;
        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) sum.sum += root.left.left.val;
            if (root.left != null && root.left.right != null) sum.sum += root.left.right.val;
            if (root.right != null && root.right.left != null) sum.sum += root.right.left.val;
            if (root.right != null && root.right.right != null) sum.sum += root.right.right.val;
        }
        sumVal(root.left,sum);
        sumVal(root.right,sum);
    }
}
