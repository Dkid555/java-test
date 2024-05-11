package com.Amazon;

import java.util.*;

public class MinimumCosttoHireKWorkers {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wages = {70,50,30};

        System.out.println(mincostToHireWorkers(quality, wages, 2));
    }

    private record Worker(int quality, int wage) implements Comparable<Worker> {
        @Override
            public int compareTo(Worker other) {
                return Integer.compare(wage * other.quality, quality * other.wage);
            }
    }
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        int s = 0;
        double res = 1e15;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (Worker worker: workers) {
            PQ.add(-worker.quality);
            s += worker.quality;
            if (PQ.size() > k) s += PQ.poll();
            if (PQ.size() == k) res = Math.min(res, (double) s * worker.wage / worker.quality);
        }
        return res;
    }
}
//There are n workers. You are given two integer arrays quality and
// wage where quality[i] is the quality of the ith worker and
// wage[i] is the minimum wage expectation for the ith worker.
//
//We want to hire exactly k workers to form a paid group.
// To hire a group of k workers, we must pay them according to the following rules:
//
//Every worker in the paid group must be paid at least their minimum wage expectation.
//In the group, each worker's pay must be directly proportional to their quality.
// This means if a worker’s quality is double that of another worker in the group,
// then they must be paid twice as much as the other worker.
//Given the integer k, return the least amount of money needed to form a paid group
// satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.