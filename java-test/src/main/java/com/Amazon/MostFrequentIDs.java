package com.Amazon;

import java.util.*;

public class MostFrequentIDs {
    HashMap<Integer, Long> idToFreq = new HashMap<>();
    TreeMap<Long, Set<Integer>> freqToIds = new TreeMap<>();

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int size = nums.length;
        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            int id = nums[i];
            long addedFreq = freq[i];
            long oldFreq = idToFreq.getOrDefault(id, 0L);
            long newFreq = addedFreq + oldFreq;
            updateIdToFreq(id, newFreq);
            updateFreqToIds(id, oldFreq, newFreq);
            result[i] = freqToIds.lastKey();
        }
        return result;
    }

    private void updateIdToFreq(int id, long newFreq) {
        idToFreq.put(id, newFreq);
    }

    private void updateFreqToIds(int id, long oldFreq, long newFreq) {
        if (oldFreq != 0) {
            freqToIds.get(oldFreq).remove(id);
            if(freqToIds.get(oldFreq).isEmpty())
                freqToIds.remove(oldFreq);
        }
        if (!freqToIds.containsKey(newFreq))
            freqToIds.put(newFreq, new HashSet<>());
        freqToIds.get(newFreq).add(id);
    }
}
///The problem involves tracking the frequency of IDs in a collection that changes over time. You have two
// integer arrays, nums and freq, of equal length n. Each element in nums represents an ID,
// and the corresponding element in freq indicates how many times that ID should be added to
// or removed from the collection at each step.
//
//Addition of IDs: If freq[i] is positive, it means freq[i] IDs with the value nums[i] are
// added to the collection at step i.
//Removal of IDs: If freq[i] is negative, it means -freq[i] IDs with the value nums[i] are
// removed from the collection at step i.
//Return an array ans of length n, where ans[i] represents the count of the most frequent
// ID in the collection after the ith step. If the collection is empty at any step, ans[i] should be 0 for that step.