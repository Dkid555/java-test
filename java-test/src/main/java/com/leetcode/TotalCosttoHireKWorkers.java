package com.leetcode;


//You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
//
//You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
//
//You will run k sessions and hire exactly one worker in each session.
//In each hiring session, choose the worker with the lowest cost from either the first
// candidates workers or the last candidates workers. Break the tie by the smallest index.
//For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session,
// we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
//In the second hiring session, we will choose 1st worker because they have the same lowest
// cost as 4th worker but they have the smallest index [3,2,7,7,2].
// Please note that the indexing may be changed in the process.
//If there are fewer than candidates workers remaining, choose the worker
// with the lowest cost among them. Break the tie by the smallest index.
//A worker can only be chosen once.
//Return the total cost to hire exactly k workers.

import java.util.PriorityQueue;

public class TotalCosttoHireKWorkers {
    public static long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> leftCandidates = new PriorityQueue<>();
        PriorityQueue<Integer> rightCandidates = new PriorityQueue<>();

        long ans = 0;
        while (k-- > 0) {
            while (leftCandidates.size() < candidates && i <= j) {
                leftCandidates.offer(costs[i++]);
                // можно и add (это одно и тоже по доку)
            }
            while (rightCandidates.size() < candidates && i <= j) {
                rightCandidates.offer(costs[j--]);
            }

            int t1 = leftCandidates.size() > 0 ? leftCandidates.peek() : Integer.MAX_VALUE;
            int t2 = rightCandidates.size() > 0 ? rightCandidates.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                leftCandidates.poll();
            } else {
                ans += t2;
                rightCandidates.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75}, 13, 23));
    }
}
