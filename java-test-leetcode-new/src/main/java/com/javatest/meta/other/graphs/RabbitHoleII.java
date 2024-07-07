package com.javatest.meta.other.graphs;

import java.util.*;

public class RabbitHoleII {

    //    void bfs()
    private static void dfs(Graph<Integer> graph, Set<Integer> visited, int node, Stack<Integer> max_global, int count,
                            Set<Integer> totalToExclude, Map<Integer, Integer> maxCurrent, Stack<Integer> max_currentST) {
        if (!visited.contains(node)) {
            if (maxCurrent.containsKey(node)) {
                max_global.add(max_global.pop() + maxCurrent.get(node) - 1);
                max_currentST.add(max_currentST.pop() + maxCurrent.get(node) - 1);
                return;
            }
            visited.add(node);
            totalToExclude.add(node);
            max_global.add(Math.max(max_global.pop(), count));
            max_currentST.add(Math.max(max_currentST.pop(), count));

            Set<Integer> temp = graph.getNeighbors(node);
            for (int neigbour : temp) {
                dfs(graph, visited, neigbour, max_global, count + 1, totalToExclude, maxCurrent, max_currentST);
                visited.remove(neigbour);
            }
        }
    }

    public static int getMaxVisitableWebpages(int N, int M, int[] A, int[] B) {
        // Write your code here
        Graph<Integer> graph = new Graph<>();

        for (int i = 0; i < M; ++i) {
            graph.addEdge(A[i], B[i]);
        }
        Stack<Integer> max = new Stack<>();
        Set<Integer> totalToExclude = new HashSet<>();
        max.add(Integer.MIN_VALUE);
        Map<Integer, Integer> maxCurrent = new HashMap<>();
        for (int page : graph.getAllVertexes()) {
            if (!totalToExclude.contains(page)) {
                Stack<Integer> max_currentST = new Stack<>();
                max_currentST.add(Integer.MIN_VALUE);
                dfs(graph, new HashSet<>(), page, max, 1, totalToExclude, maxCurrent, max_currentST);
                maxCurrent.put(page, max_currentST.pop());
            }
        }

        return max.peek() == Integer.MIN_VALUE ? 1 : max.pop();
    }

    public static void main(String[] args) {
        System.out.println(getMaxVisitableWebpages(10, 9, new int[]{3, 2, 5, 9, 10, 3, 3, 9, 4}, new int[]{9, 5, 7, 8, 6, 4, 5, 3, 9}));
    }

}
