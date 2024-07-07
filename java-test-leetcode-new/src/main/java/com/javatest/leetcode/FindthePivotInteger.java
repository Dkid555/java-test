package com.javatest.leetcode;

import java.util.stream.IntStream;

public class FindthePivotInteger {
    public int pivotInteger(int n) {
        int sumLeft = 1;
        int sumRight = IntStream.rangeClosed(1, n).sum();
        if (sumRight == sumLeft)
            return 1;
        for (int i = 2; i < n; ++i) {
            sumLeft += i;
            sumRight -= (i - 1);
            if (sumRight == sumLeft)
                return i;
        }
        return -1;
    }

    public int pivotInteger2(int n) {
        int a = (n * n + n) / 2;
        int x = (int) Math.sqrt(a);
        return x * x == a ? x : -1;
    }
}
