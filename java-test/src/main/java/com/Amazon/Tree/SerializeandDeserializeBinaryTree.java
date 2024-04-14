package com.Amazon.Tree;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    @AllArgsConstructor
    @NoArgsConstructor
//    @ToString
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public String toString() {
            return toStringHelper(this);
        }

        private String toStringHelper(TreeNode node) {
            if (node == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(node.val);
            sb.append(" l-");
            sb.append(toStringHelper(node.left));
            sb.append(",");
            sb.append(toStringHelper(node.right));
            sb.append("-r ");
            return sb.toString();
        }
    }


    private static class Codec {

        private static int index = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    res.append("n ");
                    continue;
                }
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == "") return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }

//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null) ,null), new TreeNode(3, null, null));
//        String data = new Codec().serialize(treeNode);
//
//        System.out.println(Codec.deserialize(data));
//    }

}
