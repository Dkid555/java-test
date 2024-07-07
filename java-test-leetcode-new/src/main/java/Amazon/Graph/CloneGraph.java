package com.Amazon.Graph;

import java.util.*;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if (node == null)
            return null;
        if (map.containsKey(node)){
            return map.get(node);
        }
        map.put(node, new Node(node.val));//if the node is not copy yet,copy it
        for (Node val : node.neighbors) {//go to the neibours node
            map.get(node).neighbors.add(dfs(val, map));
        }
        return map.get(node);
    }
}
