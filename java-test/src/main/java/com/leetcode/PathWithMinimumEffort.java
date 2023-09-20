package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0, 0});
        Arrays.stream(dist).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE)); // filling it with Integer.MaxValue
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];

            if (effort > dist[x][y]) continue;

            if (x == rows - 1 && y == cols - 1) return effort;

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        minHeap.add(new int[]{new_effort, nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(mat));

    }
}
//You are a hiker preparing for an upcoming hike. You are given heights,
// a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col).
// You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1)
// (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
//
//A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
//
//Return the minimum effort required to travel from the top-left cell to the bottom-right cell.