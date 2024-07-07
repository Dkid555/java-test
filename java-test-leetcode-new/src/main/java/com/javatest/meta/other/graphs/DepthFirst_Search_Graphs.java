package com.javatest.meta.other.graphs;


import java.util.HashSet;
import java.util.Set;

public class DepthFirst_Search_Graphs {


    private static void dfs(Graph<Character> graph, Set<Character> visited, char node) {
        if (!visited.contains(node)) {
            System.out.println(node);
            visited.add(node);
            var temp = graph.getNeighbors(node);
            for (var neigbour : temp) {
                dfs(graph, visited, neigbour);
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


        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('E', 'F');
//        char vertex = 'A';
//        System.out.println("Neighbors of vertex " + vertex + ": " + graph.getNeighbors(vertex));
        dfs(graph, new HashSet<>(), 'A');
    }
}
//Implement the Depth-First Search algorithm
//
// on a given graph represented as an adjacency list.