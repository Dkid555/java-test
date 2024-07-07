package com.Amazon;

public class MinimumDifficultyofaJobSchedule {
    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{1,4,5,6,5,1,5}, 4));
    }
    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int len = jobDifficulty.length;
        int sum_of_difficulties = 0;
        for (int job : jobDifficulty) {
            sum_of_difficulties += job;
        }
        if (sum_of_difficulties == 0) {
            return 0;
        }
        int[][] memory = new int[d + 1][len];
        helper(jobDifficulty, d, 0, memory);

        return memory[d][0];
    }

    private static void helper(int[] jobDifficulty, int daysLeft, int idx, int[][] memory) {
        int len = jobDifficulty.length;
        if (memory[daysLeft][idx] != 0) {
            return;
        }
        if (daysLeft == 1) {
            int num = 0;
            for (int i = idx; i < len; i++) {
                num = Math.max(num, jobDifficulty[i]);
            }
            memory[daysLeft][idx] = num; // записываем в индекс от такого-то - num
            return;
        }
        int max = jobDifficulty[idx];
        daysLeft--;
        int stop = len - idx - daysLeft + 1;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < stop; i++) {
            max = Math.max(max, jobDifficulty[idx + i - 1]);
            int other = memory[daysLeft][idx + i];
            if (other == 0) {
                helper(jobDifficulty, daysLeft, idx + i, memory);
                other = memory[daysLeft][idx + i];
            }
            res = Math.min(res, other + max);
        }
        memory[daysLeft + 1][idx] = res;
    }
}
//You want to schedule a list of jobs in d days.
// Jobs are dependent (i.e To work on the ith job,
// you have to finish all the jobs j where 0 <= j < i).
//
//You have to finish at least one task every day.
// The difficulty of a job schedule is the sum of difficulties
// of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
//
//You are given an integer array jobDifficulty and an integer d.
// The difficulty of the ith job is jobDifficulty[i].
//
//Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.