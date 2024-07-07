package com.javatest.meta;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
    int numberOfWays(int[] arr, int k) {
        // Create a hashmap to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int pairCount = 0;

        // Count the frequency of each number in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Calculate the number of pairs that sum up to k
        for (int num : arr) {
            int complement = k - num;
            if (frequencyMap.containsKey(complement)) {
                pairCount += frequencyMap.get(complement);
            }
            // If complement is equal to num, we need to decrement the count by 1
            if (complement == num) {
                pairCount--;
            }
        }

        // Divide the total count by 2 as each pair is counted twice
        return pairCount / 2;
    }
}
//Given a list of n integers arr[0..(n-1)],
// determine the number of different pairs of elements within it which sum to k.
//If an integer appears in the list multiple times, each copy is considered to be different; that is,
// two pairs are considered different if one pair includes at
// least one array index which the other doesn't, even if they include the same values.