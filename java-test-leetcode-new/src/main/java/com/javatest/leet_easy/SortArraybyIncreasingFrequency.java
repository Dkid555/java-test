package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArraybyIncreasingFrequency {

    private static class Freaq {
        public void setFreaquence(int freaquence) {
            this.freaquence = freaquence;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getFreaquence() {
            return freaquence;
        }

        public int getVal() {
            return val;
        }

        private int freaquence;
        private int val;

        public Freaq(int val, int freaquence) {
            this.freaquence = freaquence;
            this.val = val;
        }

    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Freaq> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Freaq temp = map.get(num);
                temp.setFreaquence(temp.getFreaquence() + 1);
                map.put(num, temp);
            } else map.put(num, new Freaq(num, 1));
        }
        PriorityQueue<Freaq> freaqs = new PriorityQueue<>((p1, p2) -> {
            if (p2.freaquence < p1.freaquence)
                return 1;
            else if (p2.freaquence > p1.freaquence)
                return -1;
            else {
                return Integer.compare(p2.val, p1.val);
            }
        });
        for (int key : map.keySet()) {
            freaqs.add(map.get(key));
        }
        int i = 0;
        while (!freaqs.isEmpty()) {
            Freaq temp = freaqs.poll();
            int count = 1;
            while (count <= temp.getFreaquence()) {
                count++;
                nums[i++] = temp.getVal();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));
    }
}
