package com.meta.other;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, available = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            available += gas[i] - cost[i];
            if (available < 0) {
                available = 0;
                index = i + 1;
            }
        }
        if (total < 0) {
            return -1;
        }
        return index;
    }
}
