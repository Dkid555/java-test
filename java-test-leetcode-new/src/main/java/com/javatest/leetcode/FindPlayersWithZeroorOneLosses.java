package com.javatest.leetcode;

import java.util.*;

public class FindPlayersWithZeroorOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();

        for (int[] match : matches) {
            hashMap.put(match[0], hashMap.getOrDefault(match[0], 0));
            hashMap.put(match[1], hashMap.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() == 0) winner.add(map.getKey());
            else if (map.getValue() == 1) loser.add(map.getKey());
        }

        Collections.sort(winner);
        Collections.sort(loser);
        result.add(winner);
        result.add(loser);

        return result;
    }
}
