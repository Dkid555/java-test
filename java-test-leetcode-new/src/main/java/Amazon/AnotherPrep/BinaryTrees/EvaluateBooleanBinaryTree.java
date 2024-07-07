package Amazon.AnotherPrep.BinaryTrees;

import javax.swing.tree.TreeNode;

public class EvaluateBooleanBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean evaluateTree(TreeNode node) {
        if (node.val == 0) return false;
        if (node.val == 1) return true;

        var left = evaluateTree(node.left);
        var right = evaluateTree(node.right);

        if (node.val == 2) return left || right;
        return left && right;
    }
}
