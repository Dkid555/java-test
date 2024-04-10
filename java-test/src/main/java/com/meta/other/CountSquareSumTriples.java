package com.meta.other;

import java.util.HashSet;

public class CountSquareSumTriples {
    public int countTriples(int n) {
// collect all squares
        var squares = new HashSet<Integer>();
        for (var i = 1; i <= n; i++)
            squares.add(i * i);

        var count = 0;
        // check if the sum of squares of i and j is in the set,
        // if yes then count (i, j) and (j, i) as 2 distinct ordered pairs
        for (var i = 1; i < n; i++)
            for (var j = i; i * i + j * j <= n * n; j++)
                if (squares.contains(i * i + j * j))
                    count += 2;
        return count;
    }
}
