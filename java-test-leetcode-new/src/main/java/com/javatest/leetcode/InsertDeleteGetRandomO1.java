package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    class RandomizedSet {

        Random random;
        Map<Integer, Integer> randomMap;

        int[] map;
        int current;

        public RandomizedSet() {
            randomMap = new HashMap<Integer, Integer>();
            random = new Random();
            map = new int[10000];
            current = 0;
        }

        public boolean insert(int val) {
            if (randomMap.containsKey(val)) return false;

            randomMap.put(val, current);
            map[current] = val;
            current++;
            return true;
        }

        public boolean remove(int val) {
            if (!randomMap.containsKey(val)) return false;

            int removed = randomMap.get(val);
            int temp = map[current - 1];

            map[removed] = temp;
            current--;

            randomMap.put(temp, removed);
            randomMap.remove(val);

            return true;
        }

        public int getRandom() {
            int selected = (random.nextInt() & Integer.MAX_VALUE) % current;
            return map[selected];
        }
    }
}
