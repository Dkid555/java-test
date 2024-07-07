package com.javatest.leetcode;

import java.util.*;

public class FindCenterofStarGraph {
    public static int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> inedexes = List.of(0, 1);
        int size = edges.length;
        for (int[] edge : edges) {
            for (int i : inedexes) {
                List<Integer> temp = map.getOrDefault(edge[i], new ArrayList<>());
                temp.add(edge[1 - i]);
                if (temp.size() == size)
                    return edge[i];
                map.put(edge[i], temp);
            }
        }
        return -1;
    }

    public static int findCenter2(int[][] edges) {
        List<Integer> inedexes = List.of(0, 1);
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            for (int i : inedexes) {
                if (!set.add(edge[i]))
                    return edge[i];
            }
        }
        return -1;
    }

    public static int findCenter3(int[][] edges) {
        return edges[0][0] == edges[1][0] ? edges[0][0] : (edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1]);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }
}
