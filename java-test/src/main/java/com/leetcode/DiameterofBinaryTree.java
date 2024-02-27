package com.leetcode;

public class DiameterofBinaryTree {
    private class DiameterData {
        int diameter;
        int height;
        DiameterData(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public DiameterData calculateDiameterAndHeight(TreeNode root) {
        if (root == null) {
            return new DiameterData(0, 0);
        }

        DiameterData leftChild = calculateDiameterAndHeight(root.left);
        DiameterData rightChild = calculateDiameterAndHeight(root.right);

        int currentDiameter = Math.max(leftChild.height + rightChild.height,
                Math.max(leftChild.diameter, rightChild.diameter));
        int currentHeight = Math.max(leftChild.height, rightChild.height) + 1;

        return new DiameterData(currentDiameter, currentHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Calculate diameter and height using helper function
        DiameterData data = calculateDiameterAndHeight(root);

        // Return the diameter (maximum path length)
        return data.diameter;
    }
}
