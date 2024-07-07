package com.javatest.meta.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesinaSubtree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }





    // Метод для обхода дерева в глубину (DFS) и подсчета количества символов в поддереве узла
    private Map<Character, Integer> dfs(Node node, String s, Map<Integer, Map<Character, Integer>> countMap) {
        // Создаем отображение для подсчета количества символов в поддереве текущего узла
        Map<Character, Integer> charCountMap = new HashMap<>();
        // Добавляем символ текущего узла с начальным количеством 1
        charCountMap.put(s.charAt(node.val - 1), 1);

        // Рекурсивно обходим всех детей текущего узла
        for (Node child : node.children) {
            // Рекурсивно вызываем dfs для каждого ребенка и обновляем charCountMap
            for (Map.Entry<Character, Integer> entry : dfs(child, s, countMap).entrySet()) {
                charCountMap.put(entry.getKey(), charCountMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        // Добавляем charCountMap в отображение countMap для текущего узла
        countMap.put(node.val, charCountMap);
        // Возвращаем charCountMap для текущего узла
        return charCountMap;
    }

    // Метод для подсчета количества символов в поддеревьях указанных узлов
    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Создаем массив для хранения результатов подсчета количества символов в поддеревьях указанных узлов
        int[] result = new int[queries.size()];

        // Создаем отображение для хранения подсчитанных значений для каждого узла
        Map<Integer, Map<Character, Integer>> countMap = new HashMap<>();
        // Выполняем обход дерева в глубину, начиная с корня root
        dfs(root, s, countMap);

        // Заполняем массив результатов подсчета для каждого запроса в массиве queries
        int index = 0;
        for (Query q : queries) {
            // Получаем подсчитанное значение для узла q.u и символа q.c из отображения countMap
            result[index++] = countMap.get(q.u).getOrDefault(q.c, 0);
        }

        // Возвращаем массив результатов подсчета
        return result;
    }
}
//TODO Nodes in a Subtree
// You are given a tree that contains N nodes,
// each containing an integer u which corresponds
// to a lowercase character c in the string s using 1-based indexing.
// You are required to answer Q queries of type [u, c],
// where u is an integer and c is a lowercase letter.
// The query result is the number of nodes in the subtree of node u containing c.
// Signature int[] countOfNodes(Node root, ArrayList<Query> queries, String s)