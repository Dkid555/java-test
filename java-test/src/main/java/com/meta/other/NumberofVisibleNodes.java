package com.meta.other;

import java.util.ArrayList;
import java.util.List;

public class NumberofVisibleNodes {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        diveRight(result, root, 0);
        return result;
    }

    public static int visibleNodes(Node root) {
        List<Integer> result = new ArrayList<>();
        diveRight(result, root, 0);
        return result.size();
    }

    private static void diveRight(List<Integer> result, Node root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            // This is the first node we encounter at this depth
            result.add(root.data);
        }

        // Visit the right child first если нам нужны левые значения, если правые то наоборот
        diveRight(result, root.left, depth + 1);
        diveRight(result, root.right, depth + 1);
    }

    public static void main(String[] args) {

        Node node = new Node(8,
                new Node(3,
                        new Node(1),
                        new Node(6,
                                new Node(4),
                                new Node(7))
                ),
                new Node(10, null, new Node(14, new Node(13), null)));
        System.out.println(visibleNodes(node));
    }
}
