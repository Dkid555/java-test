package com.javatest.meta.other;

import java.util.stream.IntStream;

public class FindthePivotInteger {
    public int pivotInteger(int n) {
        int sumLeft = 1;
        int sumRight = IntStream.rangeClosed(1, n).sum();
        if(sumRight == sumLeft)
            return 1;
        for (int i = 2; i < n; ++i){
            sumLeft += i;
            sumRight -= (i - 1);
            if(sumRight == sumLeft)
                return i;
        }
        return -1;
    }
}
