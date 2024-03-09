package com.meta;

public class RotaryLock1 {
    public long getMinCodeEntryTime(int N, int M, int[] C) {
        long seconds = 0L;
        int start = 1;

        for (int pick : C) {
            seconds += Math.min(Math.min(start, N - start) + Math.min(N - pick, pick), Math.abs(start - pick));
            start = pick;
        }

        return seconds;
    }

}
