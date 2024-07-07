package com.javatest.meta.other;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersinEachNodeII {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private void form_levels(Node root, int level, List<List<Node>> list){
        if(root == null)
            return;
        if(list.size() <= level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root);

        form_levels(root.left, level + 1, list);
        form_levels(root.right, level + 1, list);

    }

    public Node connect(Node root) {
        List<List<Node>> list = new ArrayList<>();
        form_levels(root, 0, list);

        for (List<Node> level : list){
            for(int i = 0; i < level.size() - 1; i++){
                level.get(i).next = level.get(i + 1);
            }
            level.get(level.size() - 1).next = null;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
