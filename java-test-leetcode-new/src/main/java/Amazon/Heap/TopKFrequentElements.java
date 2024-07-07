package com.Amazon.Heap;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentElements {

//    @AllArgsConstructor
    private static class Element{
        public Element(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
        private int value;
        private int frequency;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> frequencies = new HashMap<>();
        for (int num : nums){
            frequencies.putIfAbsent(num, new Element(num, 0));
            ++frequencies.get(num).frequency;
        }
        List<Integer> result = new ArrayList<>();
        List<Element> elements = frequencies.values().stream().
                sorted(Comparator.comparing(a -> a.frequency, Comparator.reverseOrder())).toList();
        IntStream.range(0, k).forEach(i -> result.add(elements.get(i).value));
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
