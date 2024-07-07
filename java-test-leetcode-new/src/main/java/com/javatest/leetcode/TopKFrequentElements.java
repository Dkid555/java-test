package com.javatest.leetcode;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> NumFreq = new HashMap<>();
        Map<Integer, HashSet<Integer>> Freq_Numbers = new HashMap<>();
        for (int number : nums) {
            if (NumFreq.containsKey(number)) {
                int previous = NumFreq.get(number);
                int newFreq = NumFreq.get(number) + 1;
                NumFreq.put(number, newFreq);
                HashSet<Integer> integers = Freq_Numbers.getOrDefault(previous, new HashSet<>());
                integers.remove(number);
                if (integers.isEmpty())
                    Freq_Numbers.remove(previous);
                else
                    Freq_Numbers.put(previous, integers);
                integers = Freq_Numbers.getOrDefault(newFreq, new HashSet<>());
                integers.add(number);
                Freq_Numbers.put(newFreq, integers);
            } else {
                NumFreq.put(number, 1);
                HashSet<Integer> integers = Freq_Numbers.getOrDefault(1, new HashSet<>());
                integers.add(number);
                Freq_Numbers.put(1, integers);
            }
        }
        List<Integer> keysFreq = Freq_Numbers.keySet().stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> result = new ArrayList<>();
        for (int key : keysFreq) {
            for (int val : Freq_Numbers.get(key)) {
                if (k != 0) {
                    result.add(val);
                    --k;
                }
                if (k == 0)
                    break;
            }
            if (k == 0)
                break;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 2, 3, 3}, 2)));
    }
}
