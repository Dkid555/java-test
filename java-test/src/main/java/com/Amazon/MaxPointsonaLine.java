package com.Amazon;

import java.util.*;

public class MaxPointsonaLine {
    /**
     * (x - x1) / (y - y1) = (x2 - x1) / (y2 - y1)
     * Given an array of points where points[i] = [xi, yi] represents a point on the
     * X-Y plane, return the maximum number of points that lie on the same straight line.
     * */

    private static class Point{
        private float x;
        private float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point point)) return false;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static int maxPoints(int[][] points) {
        if(points.length <= 1)
            return points.length;
        int max = 0;
        for(int i = 0; i < points.length; ++i){
            Map<Float, Integer> lines = new HashMap<>();
            float x1 = points[i][0];
            float y1 = points[i][1];

            for (int j = i + 1; j < points.length; ++j){
                float x2 = points[j][0];
                float y2 = points[j][1];
                float diff;
                if(y2 == y1){
                    diff = Float.MIN_VALUE;
                }else{
                    diff = (x2 - x1) / (y2 - y1);
                    diff = diff == -0f ? 0f : diff;
                }

                lines.put(diff, lines.getOrDefault(diff, 1) + 1);
                max = Math.max(lines.get(diff), max);
            }
            if(max > points.length / 2)
                break;
        }
        return max;

    }
    public static int maxPoints2(int[][] points) {
        if(points.length <= 1)
            return points.length;
        int max = 0;
        for(int i = 0; i < points.length; ++i){
            Map<Float, Set<Point>> lines = new HashMap<>();
            float x1 = points[i][0];
            float y1 = points[i][1];

            for (int j = i + 1; j < points.length; ++j){
                float x2 = points[j][0];
                float y2 = points[j][1];
                float diff;
                if(y2 == y1){
                    diff = Float.MIN_VALUE;
                }else{
                    diff = (x2 - x1) / (y2 - y1);
                    diff = diff == -0f ? 0f : diff;
                }

                lines.putIfAbsent(diff,new HashSet<>());
                if (lines.get(diff).isEmpty()){
                    lines.get(diff).add(new Point(x1, y1));
                }
                lines.get(diff).add(new Point(x2, y2));

                max = Math.max(lines.get(diff).size(), max);
            }
            if(max > points.length / 2)
                break;
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] points = {{9,-25},{-4,1},{-1,5},{-7,7}};

        int[][] points2 = {{0,1},{0,0},{0,4},{0,-2},{0,-1},{0,3},{0,-4}};
        System.out.println(maxPoints(points2));
    }
}
