package com.meta.other;

public class StackStabilization {
    public static long getMinimumSecondsRequired(int N, int[] R, int A, int B) { // A - time to blew, B -time small
        // Write your code here

        int R_min = Integer.MAX_VALUE;
        int R_max = Integer.MIN_VALUE;

        for (int r : R) {
            R_min = Math.min(R_min, r);
            R_max = Math.max(R_max, r);
        }


        var min = Math.max(0, R_min - N);
        var max = R_max;
        var size = max - min + N;
        var dp = new long[size];
        long prevRowDiag = 0;
        for (int i = 0; i < N; i++) {
            prevRowDiag = dp[i];
            for (int j = i + 1; j < size; j++) {
                var prev = (i > 0 ? prevRowDiag : 0);  //for 0-th row no pervious MIN value
                var val = min + j;
                var curr = (val < R[i] ? (R[i] - val) * B : (val - R[i]) * A);
                prevRowDiag = dp[j];
                dp[j] = prev + curr;
                if (j > i + 1)  //first value in a row has to be calculated
                    dp[j] = Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {

    }
}

//There's a stack of N inflatable discs, with the ith disc from the top having an initial radius
// of Ri inches. The stack is considered unstable if it includes at least one disc whose
// radius is larger than or equal to that of the disc directly under it. In other words,
// for the stack to be stable, each disc must have a strictly smaller radius than that of
// the disc directly under it. As long as the stack is unstable,
// you can repeatedly choose a disc and perform one of the following operations:
//
//Inflate the disc, increasing its radius by 1 inch. This operation takes
// A seconds and may be performed on discs of any radius (even those that exceed 10^9 inches).
//Deflate the disc, decreasing its radius by 1 inch. This operation takes
// B seconds and may only be performed if the resulting radius is a positive integer
// number of inches (that is, if the disc has a radius of at least 2 inches before being deflated).
//
//Determine the minimum number of seconds needed in order to make the stack stable,
// given N discs, A seconds for inflation, and B seconds for deflation.
