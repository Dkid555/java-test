package com.meta.other.graphs;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class allAvailablePaths {
    public static void findAllPaths(Graph<Character> graph, char start, char end, Set<Character> visited,
                                    List<Set<Character>> paths) {
        if (start == end) {
            paths.add(new LinkedHashSet<>(visited));
            paths.get(paths.size() - 1).add(end);
        }
        visited.add(start);
        for (Character edge : graph.getNeighbors(start)) {
            if (!visited.contains(edge)) {
                findAllPaths(graph, edge, end, visited, paths);
            }
        }
        visited.remove(start);
    }
}
