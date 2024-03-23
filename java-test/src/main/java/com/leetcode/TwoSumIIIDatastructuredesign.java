package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDatastructuredesign {

    private class TwoSum {
        Map<Integer, Integer> numbers;

        public TwoSum() {
            this.numbers = new HashMap<>();
        }

        public void add(int number) {
            this.numbers.put(number, this.numbers.getOrDefault(number, 0) + 1);
        }

        public boolean find(int target) {
            if (!this.numbers.isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : this.numbers.entrySet()) {
                    int current = entry.getKey();
                    int diff = target - current;
                    if ((diff == current && entry.getValue() > 1) ||
                            (diff != current && this.numbers.containsKey(diff))) return true;
                }
            }
            return false;
        }
    }
}
//Design and implement a TwoSum class. It should support the following operations:addandfind.
//
//add- Add the number to an internal data structure.
//find- Find if there exists any pair of numbers which sum is equal to the value.