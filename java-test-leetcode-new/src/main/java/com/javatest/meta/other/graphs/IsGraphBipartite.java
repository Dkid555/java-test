package com.javatest.meta.other.graphs;

public class IsGraphBipartite {


    public boolean isBipartite(int[][] graph) {
        // Массив цветов вершин. 0 - не окрашена, 1 - красный, 2 - синий
        int[] colors = new int[graph.length];

        // Обход всех вершин графа
        for (int current = 0; current < graph.length; current++) {
            // Если вершина не окрашена и при обходе её обнаруживается нарушение двудольности, возвращаем false
            if (colors[current] == 0 && dfs(current, graph, colors, true)) {
                return false;
            }
        }
        // Все вершины графа удовлетворяют двудольности, возвращаем true
        return true;
    }

    // Рекурсивный метод для обхода графа с помощью поиска в глубину
    private boolean dfs(int current, int[][] graph, int[] colors, boolean red) {
        // Окрашиваем текущую вершину в соответствующий цвет
        if (red) colors[current] = 1;
        else colors[current] = 2;

        // Рекурсивно обходим смежные вершины текущей
        for (int v : graph[current])
            // Если смежная вершина уже окрашена в такой же цвет, как текущая,
            // или если она не окрашена и при её посещении обнаруживается нарушение двудольности, возвращаем true
            if (colors[v] == (red ? 1 : 2) || (colors[v] == 0 && dfs(v, graph, colors, !red)))
                return true;

        // Нет нарушений двудольности, возвращаем false
        return false;
    }


}
