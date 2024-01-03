package com.leetcode;

public class QueriesonNumberofPointsInsideaCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        // h k - center points, r - radius
        int[] result = new int[queries.length];
        int i = 0;
        for (int[] querie : queries) {
            for (int[] point : points) {
                if (Math.pow((point[0] - querie[0]), 2) + Math.pow((point[1] - querie[1]), 2) <= querie[2] * querie[2])
                    ++result[i];
            }
            ++i;
        }
        return result;
    }
}
