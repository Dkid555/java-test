package com.Amazon.Graph;

import java.util.*;
import java.util.stream.IntStream;

public class FindifPathExistsinGraph {

    private boolean bfs_search(Map<Integer, Set<Integer>> graph, int source, int destination){
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
//        Set<Integer> search = new LinkedHashSet<>();
        queue.add(source);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            if(visited.add(vertex)){
                queue.addAll(graph.get(vertex));
            }
            if(visited.contains(destination))
                return true;
        }
        return false;
    }

    private boolean bfs_search_hashSet(Map<Integer, Set<Integer>> graph, int source, int destination){
        if(source == destination)
            return true;
//        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> search = new LinkedHashSet<>();
        search.add(source);
        while (!search.isEmpty()){
            Iterator<Integer> iterator = search.iterator();
            int vertex = iterator.next();
            iterator.remove();
            if(visited.add(vertex)){
                search.addAll(graph.get(vertex));
            }
            if(search.contains(destination))
                return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
//        IntStream.range(0, n).forEach(i-> graph.put(i, new HashSet<>()));
        for (int i = 0; i < n; ++i)
            graph.put(i, new HashSet<>());
        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return bfs_search_hashSet(graph, source, destination);
    }
}
