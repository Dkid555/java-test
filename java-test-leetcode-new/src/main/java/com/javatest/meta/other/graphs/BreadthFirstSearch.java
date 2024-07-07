package com.javatest.meta.other.graphs;

import java.util.*;

import static com.javatest.meta.other.graphs.allAvailablePaths.findAllPaths;

public class BreadthFirstSearch {

    public static void bfs(Graph<Character> graph, char start) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            if (!visited.contains(vertex)) {
                System.out.println(vertex);
                visited.add(vertex);
//                Collections.addAll(queue, graph.getNeighbors(vertex));
                queue.addAll(graph.getNeighbors(vertex));
            }
        }
    }


    public static void main(String[] args) {

        Graph<Character> graph = new Graph<>();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');


        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('E', 'F');
        graph.addEdge('F', 'G');
//        char vertex = 'A';
//        System.out.println("Neighbors of vertex " + vertex + ": " + graph.getNeighbors(vertex));
//        dfs(graph, new HashSet<>(), 'A');

        bfs(graph, 'A');

        System.out.println(pathExistance.checkPathExistance(graph, 'A', 'A', new HashSet<>(), new LinkedList<>()));

        List<Set<Character>> paths = new LinkedList<>();
        findAllPaths(graph, 'A', 'G', new HashSet<>(), paths);
        System.out.println(paths);
    }
}
