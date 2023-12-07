package com.leetcode;

import java.util.List;

public class MaximumDepthofNaryTree {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    private static class Max {
        int max = Integer.MIN_VALUE;

        public Max() {
        }
    }


    public static int maxDepth(Node root) {
        int count = 0;
        Max max = new Max();
        diveInto(root, count, max);
        return max.max;
    }

    private static void diveInto(Node root, int count, Max max) {
        if (root.children == null) {
            max.max = Math.max(max.max, count);
            return;
        }
        for (Node child : root.children) {
            diveInto(child, ++count, max);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));
        System.out.println(maxDepth(root));
    }


    public int maxDepth2(Node root) {

        if (root == null) {
            return 0;
        } else {
            int depth = 0;
            for (Node node : root.children) {
                depth = Math.max(depth, maxDepth(node));
            }
            return depth + 1;
        }
    }
}
//Given a n-ary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Nary-Tree input serialization is represented in their level order traversal, each group of children
// is separated by the null value (See examples).