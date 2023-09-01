package com.leet_easy;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double result = 0;
        for (int[] A : points)
            for (int[] B : points)
                for (int[] C : points)
                    result = Math.max(result,
                            0.5 * Math.abs(A[0] * B[1] + B[0] * C[1] + C[0] * A[1] - B[0] * A[1] - C[0] * B[1] - A[0] * C[1]));
        return result;
    }

}


// s = 1/2( (x2 - x1)(y3 - y1) - (x3 - x1)(y2 - y1) )

// s = 1/2 (xa * yb + xb * yc + xc * ya - xa * yc - xc * yb - xb * ya)