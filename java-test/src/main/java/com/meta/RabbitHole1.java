package com.meta;

import java.util.*;

public class RabbitHole1 {
    public static int getMaxVisitableWebpages(int N, int[] L) {
        // Write your code here
        int max_visited = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            Set<Integer> vistied_pages = new HashSet<>();
            int curr_page = i + 1;
            while (!vistied_pages.contains(curr_page)) {
                vistied_pages.add(curr_page);
                curr_page = L[curr_page - 1];
            }
            max_visited = Math.max(max_visited, vistied_pages.size());
        }
        return max_visited;
    }

    public static int getMaxVisitableWebpagesBetter(int N, int[] L) {
        // Write your code here
        int max_visited = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            Set<Integer> vistied_pages = new HashSet<>();
            int curr_page = i + 1;
            while (!vistied_pages.contains(curr_page)) {
                if (map.containsKey(curr_page)) {
                    break;
                }
                vistied_pages.add(curr_page);
                curr_page = L[curr_page - 1];
            }

            vistied_pages.addAll(map.getOrDefault(curr_page, new HashSet<>()));

            int size = vistied_pages.size();
//            size += map.getOrDefault(curr_page, new HashSet<>()).size();
            map.put(i + 1, vistied_pages);
            max_visited = Math.max(max_visited, size);
        }
        return max_visited;
    }


    private static class Node {
        int n;
        Node next;
        int depth = 0;

        Node(int n) {
            this.n = n;
        }

        public int hashCode() {
            return n;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Node)) {
                return false;
            }
            Node another = (Node) obj;

            return this.n == another.n;
        }
    }

    public static int getMaxVisitableWebpagesBest(int N, int[] L) {
        List<Node> array_of_nodes = new ArrayList<>(N); // Инициализируем список узлов размера N.
        for (int web_page = 1; web_page <= N; ++web_page) {
            array_of_nodes.add(new Node(web_page)); // Создаем узел с индексами от 1 до N.
        }

        // Создаем ссылки между узлами в соответствии с массивом L.
        for (int i = 0; i < N; i++) {
            Node node = array_of_nodes.get(i); // Получаем узел с индексом i.
            node.next = array_of_nodes.get(L[i] - 1); // Устанавливаем ссылку на узел, указанный в массиве L.
        }

        int maxLen = 0;
        // Проходим по всем узлам для вычисления максимальной глубины с учетом циклов.
        for (Node node : array_of_nodes) {
            if (node.depth > 0) {
                continue; // Если глубина уже просчитана, пропускаем узел.
            }

            Node level = node; // Текущий узел для обхода.
            Set<Node> visited = new LinkedHashSet<>(); // Множество для отслеживания посещенных узлов.
            while (level != null && level.depth == 0) { // Пока есть следующий узел и глубина не просчитана.

                if (visited.contains(level)) { // Если узел уже был посещен (цикл замкнулся).

                    Node cycleNode = level;
                    int cycleDepth = 1;
                    while (cycleNode.next != level) {
                        ++cycleDepth; // Вычисляем глубину цикла.
                        cycleNode = cycleNode.next;
                    }

                    cycleNode = level.next;
                    level.depth = cycleDepth; // Устанавливаем глубину цикла для узла.
                    visited.remove(cycleNode); // Удаляем узел из множества.
                    while (cycleNode != level) {
                        cycleNode.depth = cycleDepth; // Устанавливаем глубину цикла для остальных узлов цикла.
                        cycleNode = cycleNode.next;
                        visited.remove(cycleNode); // Удаляем узел из множества.
                    }

                    break;
                }

                visited.add(level); // Добавляем узел в множество посещенных.
                level = level.next; // Переходим к следующему узлу.
            }

            int depth = level == null ? visited.size() : level.depth + visited.size(); // Вычисляем глубину узла.
            maxLen = Math.max(depth, maxLen); // Обновляем максимальную глубину.

            // Устанавливаем глубину для всех узлов в посещенном множестве.
            for (Node visitedNode : visited) { // до цикла
                if (visitedNode.depth > 0) {
                    break;
                }
                visitedNode.depth = depth;
                --depth;
            }
        }
        return maxLen; // Возвращаем максимальную глубину.
    }

    public static int getMaxVisitableWebpagesBest2(int N, int[] L) {
        List<Node> array_of_web_Pages = new ArrayList<>();
        for (int wep_page = 1; wep_page <= N; ++wep_page)
            array_of_web_Pages.add(new Node(wep_page));
        for (int i = 0; i < N; ++i)
            array_of_web_Pages.get(i).next = array_of_web_Pages.get(L[i] - 1);


        int max_visited = 0;

        for (Node page : array_of_web_Pages) {

            if (page.depth > 0)
                continue;
            Set<Node> visited = new HashSet<>();
            Node level = page;

            while (level != null && level.depth == 0) {
                if (visited.contains(level)) { // Если узел уже был посещен (цикл замкнулся).

                    Node cycleNode = level;
                    int cycleDepth = 1;
                    while (cycleNode.next != level) {
                        ++cycleDepth; // Вычисляем глубину цикла.
                        cycleNode = cycleNode.next;
                    }

                    cycleNode = level.next;
                    level.depth = cycleDepth; // Устанавливаем глубину цикла для узла.
                    visited.remove(cycleNode); // Удаляем узел из множества.
                    while (cycleNode != level) {
                        cycleNode.depth = cycleDepth; // Устанавливаем глубину цикла для остальных узлов цикла.
                        cycleNode = cycleNode.next;
                        visited.remove(cycleNode); // Удаляем узел из множества.
                    }

                    break;
                }

                visited.add(level); // Добавляем узел в множество посещенных.
                level = level.next; // Переходим к следующему узлу.
            }
            int depth = level == null ? visited.size() : level.depth + visited.size(); // Вычисляем глубину узла.
            max_visited = Math.max(depth, max_visited); // Обновляем максимальную глубину.

            // Устанавливаем глубину для всех узлов в посещенном множестве.
            for (Node visitedNode : visited) { // до цикла
                if (visitedNode.depth > 0) {
                    break;
                }
                visitedNode.depth = depth;
                --depth;
            }

        }


        return max_visited;


    }


    public static void main(String[] args) {
        System.out.println(getMaxVisitableWebpagesBest2(5, new int[]{4, 3, 5, 1, 2}));
    }//


}
//You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
//The encyclopedia consists of N different web pages, numbered from 1 to N. Each page i contains nothing
//but a single link to a different page L-i.
//A session spent on this website involves beginning on one of the N pages, and then
// navigating around using the links until you decide to stop. That is, while on page i,
// you may either move to page L-i, or stop your browsing session.
//Assuming you can choose which page you begin the session on, what's the maximum number of different
// pages you can visit in a single session?
// Note that a page only counts once even if visited multiple times during the session.