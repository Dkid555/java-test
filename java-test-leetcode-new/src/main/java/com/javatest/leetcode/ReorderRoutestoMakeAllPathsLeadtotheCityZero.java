package com.javatest.leetcode;

import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] c : connections) {
            set.add(c[0] + "," + c[1]);
            map.computeIfAbsent(c[0], k -> new HashSet<>());
            map.computeIfAbsent(c[1], k -> new HashSet<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int result = 0;
        boolean[] checking = new boolean[n];
        checking[0] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int next : map.getOrDefault(c, new HashSet<>())) {
                if (checking[next]) continue;
                checking[next] = true;
                if (!set.contains(next + "," + c)) result++;
                q.offer(next);
            }
        }
        return result;
    }
}
//There are n cities numbered from 0 to n - 1 and n - 1 roads
// such that there is only one way to travel between two
// different cities (this network form a tree). Last year,
// The ministry of transport decided to orient the roads in
// one direction because they are too narrow.
//
//Roads are represented by connections where
// connections[i] = [ai, bi] represents a road from city ai to city bi.
//
//This year, there will be a big event in the capital (city 0),
// and many people want to travel to this city.
//
//Your task consists of reorienting some roads such that each city
// can visit the city 0. Return the minimum number of edges changed.
//
//It's guaranteed that each city can reach city 0 after reorder.