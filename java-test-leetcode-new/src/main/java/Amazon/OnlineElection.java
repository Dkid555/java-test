package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
                new int[]{0, 5, 10, 15, 20, 25, 30});

        System.out.println(topVotedCandidate.q(3));//3], [12], [25], [15], [24], [8
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));

    }
    private static class TopVotedCandidate {

        Map<Integer, Integer> top_per_time;
        int[] times;
        public TopVotedCandidate(int[] persons, int[] times) { // times отсортирован
            top_per_time = new HashMap<>();
            this.times = times;
            int[] dp = new int[persons.length];
            int max = 0;
            int prev = -1;

            for(int i = 0; i < persons.length; ++i){
                ++dp[persons[i]];
                if(top_per_time.containsKey(prev)){
                    prev = top_per_time.get(prev);
                }

                if(dp[persons[i]] == max){
                    top_per_time.put(times[i], persons[i]);
                }
                else if(dp[persons[i]] < max){
                    top_per_time.put(times[i], prev);
                }
                else {
                    top_per_time.put(times[i], persons[i]);
                    max = dp[persons[i]];
                }

                prev = times[i];
            }

        }


        public int q(int t) {
            if(t < times[0])
                return 0;
            int index = findClosestLeft(times, t);
            return top_per_time.getOrDefault(times[index], 0);
        }
        public static int findClosestLeft(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // Target not found, return closest element on the left
            return high;
        }
    }
}
