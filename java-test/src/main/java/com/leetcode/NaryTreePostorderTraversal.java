package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    private class Node {
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


    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        traverseTree(root, result);

        return result;
    }

    private void traverseTree(Node root, List<Integer> result) {
        if (root.children == null) {
            result.add(root.val);
            return;
        }

        for (Node n : root.children) {
            traverseTree(n, result);
        }

        result.add(root.val);
    }
}
