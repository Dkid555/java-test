package com.leetcode;

import java.util.*;

public class QueriesonaPermutationWithKey {
    static public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> Permutations = new HashMap<>();
        int index = 0;
        for (int i = 1; i <= m; ++i)
            Permutations.put(i, index++);
        index = 0;
        for (int position : queries) {
            result[index++] = Permutations.get(position);
            Permutations.put(position, 0);
            for (int i = 1; i < position; ++i)
                if (i < position)
                    Permutations.put(i, Permutations.get(i) + 1);
                else if (i > position)
                    Permutations.put(i, Permutations.get(i) - 1);
        }
        return result;
    }

    static public int[] processQueries2(int[] queries, int m) {
        List<Integer> permutations = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            permutations.add(i);
        int[] result = new int[queries.length];
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            result[index++] = permutations.indexOf(queries[i]);
            permutations.remove((Integer) queries[i]);
            permutations.add(0, queries[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(processQueries2(new int[]{3, 1, 2, 1}, 5)));
    }
}
//Given the array queries of positive integers between 1 and m, you have to process all
// queries[i] (from i=0 to i=queries.length-1) according to the following rules:
//
//In the beginning, you have the permutation P=[1,2,3,...,m].
//For the current i, find the position of queries[i] in the permutation P (indexing from 0)
// and then move this at the beginning of the permutation P. Notice that the position of queries[i]
// in P is the result for queries[i].
//Return an array containing the result for the given queries.