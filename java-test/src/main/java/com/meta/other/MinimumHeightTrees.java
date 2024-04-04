package com.meta.other;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> edge_conn = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            edge_conn.add(new HashSet<>());
        for (int[] edge : edges) {
            edge_conn.get(edge[0]).add(edge[1]);
            edge_conn.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (edge_conn.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = edge_conn.get(i).iterator().next();
                edge_conn.get(j).remove(i);
                if (edge_conn.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
