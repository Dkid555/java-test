package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskMaster {

    public static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public static boolean union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }

    public static int tasks(int n, List<Integer> a, List<Integer> b) {

        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (!union(a.get(i), b.get(i), parent)) {
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Collections.addAll(a, 1, 2, 3, 4, 6, 5);
        Collections.addAll(b, 7, 6, 4, 1, 2, 1);
        System.out.println(tasks(7, a, b));
    }

}

