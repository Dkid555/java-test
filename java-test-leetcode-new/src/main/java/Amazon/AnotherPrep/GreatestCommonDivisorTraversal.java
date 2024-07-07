package Amazon.AnotherPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreatestCommonDivisorTraversal {
    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);  // Path compression
            }
            return parent[u];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Union-Find data structure
        UnionFind uf = new UnionFind(n);

        // Map from prime factor to all indices in nums that contain this prime factor
        Map<Integer, List<Integer>> factorMap = new HashMap<>();

        // Sieve-like process to union indices by common prime factors
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    factorMap.computeIfAbsent(factor, k -> new ArrayList<>()).add(i);
                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }
            if (num > 1) {
                factorMap.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
            }
        }

        // Union all indices that share the same prime factor
        for (List<Integer> indices : factorMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
                uf.union(indices.get(0), indices.get(i));
            }
        }

        // Check if all indices are in the same connected component
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }

        return true;
    }


}
/**
 * You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices.
 * You can traverse between index i and index j, i != j, if and
 * only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common divisor.
 *
 * Your task is to determine if for every pair of indices i and j in nums,
 * where i < j, there exists a sequence of traversals that can take us from i to j.
 *
 * Return true if it is possible to traverse between all such pairs of indices, or false otherwise.
 *
 * */