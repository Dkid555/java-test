package com.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

public class NumberofEquivalentDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        var count = new Object() {
            int sum = 0;
        };
        Map<List<Integer>, Integer> moreThanTwo = new HashMap<>();
        Map<List<Integer>, Integer> domino = new HashMap<>();
        stream(dominoes).forEach(pair -> {
            List<Integer> temp = pair[0] > pair[1] ? Arrays.asList(pair[0], pair[1]) : Arrays.asList(pair[1], pair[0]);
            domino.put(temp, domino.getOrDefault(temp, 0) + 1);
            if (domino.get(temp) > 1)
                moreThanTwo.put(temp, domino.get(temp));
        });
        moreThanTwo.forEach((key, value) -> {
            count.sum += value * (value - 1) / 2;
        });
        return count.sum;
    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs2(new int[][]{{1, 2}, {2, 1}, {1, 2}, {2, 3}, {1, 2}, {1, 4}, {2, 1}}));
    }

    public static int numEquivDominoPairs2(int[][] dominoes) {
        int[][] counts = new int[10][10];
        var res = new Object() {
            int sum = 0;
        };
        stream(dominoes).forEach(pair -> {
            res.sum += counts[pair[0]][pair[1]];
            res.sum += pair[0] != pair[1] ? counts[pair[1]][pair[0]] : 0;
            counts[pair[1]][pair[0]]++;
        });
        return res.sum;
    }

}


