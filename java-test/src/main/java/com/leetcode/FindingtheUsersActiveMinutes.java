package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingtheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> usersUniqueTimes = new HashMap<>();
        int[] answer = new int[k];
        for (int[] log : logs) {
            Set<Integer> set = usersUniqueTimes.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            usersUniqueTimes.put(log[0], set);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : usersUniqueTimes.entrySet()) {
            ++answer[entry.getValue().size() - 1];
        }
        return answer;
    }
}
//You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer
// array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute time i.
//
//Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
//
//The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed
// an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.
//
//You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
//
//Return the array answer as described above.