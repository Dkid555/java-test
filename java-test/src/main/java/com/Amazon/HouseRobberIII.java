package com.Amazon;

import java.util.Arrays;

public class HouseRobberIII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)),new TreeNode(3, null, new TreeNode(1)));
        System.out.println(rob(root));
    }
    public static int rob(TreeNode root) {
        int[] options = traverse(root);
        return Math.max(options[0], options[1]);
//        return Arrays.stream(traverse(root)).max().getAsInt();
    }

    private static int[] traverse(TreeNode root){
        if(root == null)
            return new int[2];
        /**
         * возвращаем пустой массив
         * 0 - если мы выбрали текущий root.val,
         * 1 - если нет, то пары после
         */
        int[] leftChildChoices = traverse(root.left);
        int[] rightChildChoices = traverse(root.right);
        return new int[] {
                root.val + leftChildChoices[1] + rightChildChoices[1], /**
                                                                           * если мы выбрали текущий рут вал,
                                                                           * (зазор должен быть) */
                Math.max(leftChildChoices[0], leftChildChoices[1])
                        + Math.max(rightChildChoices[0], rightChildChoices[1])
                /**
                 * если рассматриваем только детей, если текущий не добавляем (зазор должен быть)
                */
        };
    }
    private static int[] travel(TreeNode root) {
        // Return [0, 0] for base case;
        if (root == null) {
            return new int[2];
        }
        int[] leftNodeChoices = travel(root.left);
        int[] rightNodeChoices = travel(root.right);
        int[] options = new int[2];

        // Store if robbed in 0 index
        options[0] = root.val + leftNodeChoices[1] + rightNodeChoices[1];

        // Store if not robbed in 1 index
        options[1] = Math.max(leftNodeChoices[0], leftNodeChoices[1]) + Math.max(rightNodeChoices[0], rightNodeChoices[1]);

        return options;
    }
}
//The thief has found himself a new place for his thievery again.
// There is only one entrance to this area, called root.
//
//Besides the root, each house has one and only one parent house.
// After a tour, the smart thief realized that all houses
// in this place form a binary tree. It will automatically
// contact the police if two directly-linked houses were broken into on the same night.
//
//Given the root of the binary tree, return the maximum amount
// of money the thief can rob without alerting the police.
