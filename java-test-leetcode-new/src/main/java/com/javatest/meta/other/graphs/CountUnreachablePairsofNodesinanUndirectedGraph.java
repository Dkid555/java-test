package com.javatest.meta.other.graphs;

import java.util.*;

public class CountUnreachablePairsofNodesinanUndirectedGraph {

    private static class Graph<T> {
        Map<T, Map<T, Integer>> graphMap;

        public Graph() {
            graphMap = new HashMap<>();
        }

        public void addVertex(T vertex) {
            if (!graphMap.containsKey(vertex)) {
                graphMap.put(vertex, new HashMap<>());
            }
        }

        public void addEdge(T source, T destination, int weight, boolean two_sided_conection) {
            if (!graphMap.containsKey(source)) {
                graphMap.put(source, new HashMap<>());
            }
            if (!graphMap.containsKey(destination)) {
                graphMap.put(destination, new HashMap<>());
            }
            graphMap.get(source).put(destination, weight);

            if (two_sided_conection) {
                graphMap.get(destination).put(source, weight);
            }

        }


    }


    //    public static long countPairs(int n, int[][] edges) {
//
//        Graph<Integer> graph = new Graph<>();
//        Set<Integer> vertexes = new HashSet<>();
//        for (int i = 0; i < n; ++i){
//            graph.addVertex(i);
//            vertexes.add(i);
//        }
//        for (int [] edge : edges){
//            graph.addEdge(edge[0], edge[1], 0, false);
//        }
//
//        return 0L;
//    }
    public static long countPairs(int n, int[][] edges) {
        List<Integer>[] neighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (var edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        long sum = 0, squaresum = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long ans = dfs(i, neighbors, visited);
                sum += ans;
                squaresum += ans * ans;
            }
        }

        return (sum * sum - squaresum) / 2;
    }

    private static long dfs(int node, List<Integer>[] neighbors, boolean[] visited) {
        visited[node] = true;
        int ans = 1;

        for (var neighbor : neighbors[node]) {
            if (!visited[neighbor]) {
                ans += dfs(neighbor, neighbors, visited);
            }
        }

        return ans;
    }

    public static long countPairs2(int n, int[][] edges) {
        // Создание массива множеств для хранения связей между узлами
        Set<Integer>[] connections = new Set[n];
        for (int i = 0; i < n; ++i)
            connections[i] = new HashSet<>();

        // Заполнение массива множеств связей на основе переданных ребер
        for (int[] edge : edges) {
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }

        // Массив для отслеживания посещенных узлов
        boolean[] visited = new boolean[n];

        // Список для хранения количества узлов в каждом "острове"
        List<Integer> numNodesInIslands = new ArrayList<>();

        // Обход всех узлов графа
        for (int i = 0; i < n; ++i) {
            // Пропустить узлы, которые уже были посещены
            if (visited[i])
                continue;

            // Обход "острова" с помощью BFS (поиск в ширину)
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.add(i);
            int nodes = 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int x : connections[current]) {
                    if (!visited[x]) {
                        visited[x] = true;
                        ++nodes;
                        queue.add(x);
                    }
                }
            }
            numNodesInIslands.add(nodes);
        }


        // Вычисление количества пар узлов с помощью формулы
        long otherNodes = n;
        long pairs = 0;
        for (int x : numNodesInIslands) {
            pairs += x * (otherNodes - x);// считаем количество пар,
            // не сцепленных между собой (1 -> 0 -> 2 -> 1 образуют 3 * 3 пар
            // => 3 * (all - 3) - количество не сцепленных пар )
            otherNodes -= x;
        }
        return pairs;
    }
    //For each node, keep track of all reachable nodes from a node in the form of list
    //Keep a boolean visited array of length n to keep track of nodes visited - initially no node is visited
    //initialise a list of Integers numNodesInIslandList which will store the no of elements in each island.
    // The size of this list at the end will be equal to no of islands.

    //Starting from node 0 to node n-1, perform following
    //a. if node is not visited, this node will the first one in this island.
    // visit and add to the queue and initialise integer numNodesInIsland to 1
    //b. Until queue is not empty, poll element from queue and for each reachable node from
    // this node, add to queue if it is not visited. Also increment numNodesInIsland whenever a new node is added to the queue
    //c. Once queue is exhausted, we would have visited all elements in this island.

    //For each node, we can never reach any node which is not present in its island. So the no of pairs of unreachable nodes is sum of product of no of nodes in an island and (n - no of nodes in that island) / 2


    public static long countPairs3(int n, int[][] edges) {

        Set<Integer>[] connections = new Set[n];
        for (int i = 0; i < n; ++i) {
            connections[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> Amount_of_available_nodes = new ArrayList<>();
        for (int i = 1; i < n; ++i) {

            if (visited[i])
                continue;

            visited[i] = true;
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(i);
            int amount_of_nodes = 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int vertex : connections[current]) {
                    if (!visited[vertex]) {
                        queue.add(vertex);
                        visited[vertex] = true;
                        ++amount_of_nodes;
                    }
                }
            }
            Amount_of_available_nodes.add(amount_of_nodes);
        }

        long otherNodes = n;
        long pairs = 0;
        for (int x : Amount_of_available_nodes) {
            pairs += x * (otherNodes - x); // считаем количество пар,
            // не сцепленных между собой (1 -> 0 -> 2 -> 1 образуют 3 * 3 пар
            // => 3 * (all - 3) - количество не сцепленных пар )
            otherNodes -= x;
        }
        return pairs;

    }


    public static void main(String[] args) {
        System.out.println(countPairs3(5,
                new int[][]{{0, 1}, {0, 1}, {1, 2}, {3, 4}}));
    }
}
