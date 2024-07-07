package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    public static Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    private static Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, new Node(node.val));//if the node is not copy yet,copy it
        for (Node temp : node.neighbors) {//go to the neibours node
            map.get(node).neighbors.add(dfs(temp, map));
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(List.of(node2, node4));
        node2.neighbors.addAll(List.of(node1, node3));
        node3.neighbors.addAll(List.of(node2, node4));
        node4.neighbors.addAll(List.of(node1, node3));

        System.out.println(cloneGraph(node1));
    }

}


