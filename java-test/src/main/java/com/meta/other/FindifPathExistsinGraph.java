package com.meta.other;

import com.leetcode.IntegerReplacement;
import com.meta.other.graphs.Graph;
import com.oop.Generics;

import java.util.*;

public class FindifPathExistsinGraph {
    public boolean bfs(Map<Integer,Set<Integer>> graph, Integer start, Integer End) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if(vertex == End)
                return true;
            if (!visited.contains(vertex)) {
//                System.out.println(vertex);
                visited.add(vertex);
//                Collections.addAll(queue, graph.getNeighbors(vertex));
                queue.addAll(graph.get(vertex));
            }
        }
        return false;
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> Graph = new HashMap<>();

        for (int i = 0; i < n; ++i){
            Graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges){
            Graph.get(edge[0]).add(edge[1]);
            Graph.get(edge[1]).add(edge[0]);
        }

        return bfs(Graph, source, destination);

    }
}
