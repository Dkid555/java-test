package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CountZeroRequestServers {
    public static int[] countServers(int totalServers, int[][] logs, int interval, int[] queries) {
        // Create a map to store the indices of queries in the queries array
        Map<Integer, Integer> queryMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            queryMap.put(queries[i], i);
        }

        // Sort the logs array based on the time of requests
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(queries);

        int[] result = new int[queries.length];
        Arrays.fill(result, totalServers);

        int queryIndex = 0, rightPtr = 0, leftPtr = 0;
        Map<Integer, Integer> serverRequests = new HashMap<>();

        // Iterate through the logs and queries arrays using pointers to update the count of requests within the time interval
        while (queryIndex < queries.length && leftPtr < logs.length) {
            if (logs[leftPtr][1] >= queries[queryIndex] - interval) {
                // Update the count of requests for each server within the current time interval
                while (rightPtr < logs.length && logs[rightPtr][1] <= queries[queryIndex]) {
                    serverRequests.put(logs[rightPtr][0], serverRequests.getOrDefault(logs[rightPtr][0], 0) + 1);
                    rightPtr++;
                }
                // Update the results for the current query
                result[queryMap.get(queries[queryIndex])] = totalServers - serverRequests.size();
                queryIndex++;
            } else {
                // Remove a request from the interval if it goes out of the specified interval
                if (serverRequests.containsKey(logs[leftPtr][0])) {
                    int currentCount = serverRequests.get(logs[leftPtr][0]);
                    if (currentCount == 1) {
                        serverRequests.remove(logs[leftPtr][0]);
                    } else {
                        serverRequests.put(logs[leftPtr][0], currentCount - 1);
                    }
                }
                leftPtr++;
                if (leftPtr > rightPtr) {
                    rightPtr = leftPtr;
                }
            }
        }
        return result;
    }
}
//You are given an integer n denoting the total
// number of servers and a 2D 0-indexed integer array
// logs, where logs[i] = [server_id, time] denotes that
// the server with id server_id received a request at time time.
//
//You are also given an integer x and a 0-indexed integer array queries.
//
//Return a 0-indexed integer array arr of length queries.length where arr[i]
// represents the number of servers that did not receive any requests during
// the time interval [queries[i] - x, queries[i]].
//
//Note that the time intervals are inclusive.