package com.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangleII {
    public static void main(String[] args) {
        int[][] points = {{1,2},{2,1},{1,0},{0,1}};
        System.out.println(minAreaFreeRect(points));
    }
    public static double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        double min = Double.MAX_VALUE;

        // group points in pairs by deltaX and deltaY
        // 2 pairs with same deltaX and deltaY are PARALLEL!!!!
        HashMap<Integer, Map<Integer, List<int[]>>> deltaXtoYToPair = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {                               // IMPORTANT !!!!!!!
                if (i == j) continue;
                int dX = points[i][0] - points[j][0]; // расстояние по оси X
                int dY = points[i][1] - points[j][1]; // расстояние по оси Y
                deltaXtoYToPair
                        .computeIfAbsent(dX, m -> new HashMap<>())
                        .computeIfAbsent(dY, s -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }

        for (int dx : deltaXtoYToPair.keySet()) {
            for (int dy : deltaXtoYToPair.get(dx).keySet()) {
                List<int[]> parallelPoints = deltaXtoYToPair.get(dx).get(dy);
                for (int i = 0; i < parallelPoints.size(); i++) {
                    for (int j = i + 1; j < parallelPoints.size(); j++) {
                        int[] pair1 = parallelPoints.get(i);
                        int a = pair1[0];
                        int b = pair1[1];
                        int[] pair2 = parallelPoints.get(j);
                        int c = pair2[0];
                        int d = pair2[1];

                        int x1 = points[a][0];
                        int x2 = points[b][0];
                        int x3 = points[c][0];
                        int x4 = points[d][0];

                        int y1 = points[a][1];
                        int y2 = points[b][1];
                        int y3 = points[c][1];
                        int y4 = points[d][1];

                        int v1x = x2 - x1; // vector 1 -> 2  v(1->2) = v(x2-x1,y2-y1)
                        int v1y = y2 - y1; // v(destinationX - originX, destinationY - originY)

                        int v2x = x1 - x3; // vector 3->1
                        int v2y = y1 - y3;

                        int v3x = x1 - x4; // vector 4->1
                        int v3y = y1 - y4;

                        int v4x = x2 - x3; // vector 3->2
                        int v4y = y2 - y3;

                        int v5x = x2 - x4; // vector 4->2
                        int v5y = y2 - y4;



                        if (isPerp(v1x, v2x, v1y, v2y) && isPerp(v1x, v5x, v1y, v5y)) {// 1->2 perpendicular to 3->1 && 4 -> 2
                            min = Math.min(min, dist(x1, x2, y1, y2) * dist(x1, x3, y1, y3));
                        } else if (isPerp(v1x, v3x, v1y, v3y) && isPerp(v1x, v4x, v1y, v4y)) {// 1->2 perpendicular to 4->1 3 ->2
                            min = Math.min(min, dist(x1, x2, y1, y2) * dist(x1, x4, y1, y4));
                        }
                    }
                }
            }
        }

        return min == Double.MAX_VALUE ? 0 : min;
    }

    static boolean isPerp(int x1, int x2, int y1, int y2) {
        return x1 * x2 + y1 * y2 == 0;
    }

    static double dist(int x1, int x2, int y1, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
