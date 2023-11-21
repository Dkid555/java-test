package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> helper = new HashMap<>();

        int result = 0;

        for (int answer : answers) {
            if (answer == 0) {
                ++result;
                continue;
            }
            helper.put(answer, helper.getOrDefault(answer, 0) + 1);
        }


        for (int a : helper.keySet()) {
            int x = helper.get(a);
            result += (a + 1) * (int) Math.ceil((double) x / (double) (a + 1));
        }
        return result;
    }

    public int numRabbits2(int[] answers) {
        int[] m = new int[1000];
        int result = 0;
        for (int i : answers) {
            if (m[i] == 0) {
                m[i] = i + 1;
                result += i + 1;
            }
            m[i]--;
        }
        return result;
    }
}
//There is a forest with an unknown number of rabbits. We asked n rabbits
// "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i]
// is the answer of the ith rabbit.
//
//Given the array answers, return the minimum number of rabbits that could be in the forest.