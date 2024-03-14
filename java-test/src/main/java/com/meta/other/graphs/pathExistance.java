package com.meta.other.graphs;

import java.util.List;
import java.util.Set;

public class pathExistance {
    public static boolean checkPathExistance(Graph<Character> graph, char start, char end, Set<Character> visited, List<Character> path) {
        if (start == end) {
            path.add(start);
            return true;
        }
        visited.add(start);
        for (Character edge : graph.getNeighbors(start)) {
            if (!visited.contains(edge)) {
                if (checkPathExistance(graph, edge, end, visited, path)) {
                    path.add(start);
                    return true;
                }
            }
        }
        return false;
    }
}
