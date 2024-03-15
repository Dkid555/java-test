package com.meta.other.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private Map<T, Set<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyList.put(vertex, new HashSet<>());
    }

    public Set<T> getAllVertexes() {
        return adjacencyList.keySet();
    }

    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }
    public void addEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
    }

    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.get(vertex);
    }
}