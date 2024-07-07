package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
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

    ;

    public List<Integer> preorder(Node root) {
        List<Integer> resultTree = new ArrayList<>();
        if (root != null)
            diveInto(root, resultTree);
        return resultTree;
    }

    private void diveInto(Node root, List<Integer> resultTree) {
        resultTree.add(root.val);
        for (Node child : root.children
        ) {
            if (child != null)
                diveInto(child, resultTree);
        }
    }
}
