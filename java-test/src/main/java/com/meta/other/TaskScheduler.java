package com.meta.other;

import java.util.Arrays;

public class TaskScheduler {
    // Method to calculate the minimum number of intervals required to complete all tasks
    public int leastInterval(char[] tasks, int n) {
        int []taskFreqMp = new int[26];
        for(char c : tasks){
            taskFreqMp[c- 'A']++;
        }
        Arrays.sort(taskFreqMp);
        int batchCnt = taskFreqMp[25];
        int vacantSlots = --batchCnt * n;
        for(int indx = 0; indx < 25; indx++){
            vacantSlots -= Math.min(taskFreqMp[indx], batchCnt);
        }
        return vacantSlots > 0 ? tasks.length + vacantSlots : tasks.length;

    }
}
//You are given an array of CPU tasks, each represented by letters A to Z,
// and a cooling time, n. Each cycle or interval allows the completion of one task.
// Tasks can be completed in any order, but there's a constraint:
// identical tasks must be separated by at least n intervals due to cooling time.
//
//​Return the minimum number of intervals required to complete all tasks.