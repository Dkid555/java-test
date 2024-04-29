package com.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker_Task {
    private static class FrequencyTracker {

        Map<Integer, Integer> frequencie_count;
        Map<Integer, Set<Integer>> frequencies_map;

        public FrequencyTracker() {
            frequencie_count = new HashMap<>();
            frequencies_map = new HashMap<>();
        }


        private void add_delete(int number, int change){
            int previous_freq = this.frequencie_count.getOrDefault(number, 0);
            if(this.frequencies_map.containsKey(previous_freq)){
                this.frequencies_map.get(previous_freq).remove(number);
            }

            int new_freq = Math.max(previous_freq + change, 0);
            this.frequencie_count.put(number, new_freq);

            this.frequencies_map.putIfAbsent(new_freq, new HashSet<>());
            this.frequencies_map.get(new_freq).add(number);
        }
        public void add(int number) {
            add_delete(number, 1);
        }

        public void deleteOne(int number) {
            add_delete(number, -1);

        }

        public boolean hasFrequency(int frequency) {
            return this.frequencies_map.containsKey(frequency) && !this.frequencies_map.get(frequency).isEmpty();
        }
    }

}
