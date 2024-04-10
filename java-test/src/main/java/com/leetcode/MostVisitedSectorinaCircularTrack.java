package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorinaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        final int start = rounds[0];
        final int end = rounds[rounds.length - 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            if (start <= end) {
                if (start <= i && i <= end)
                    ans.add(i);
            } else {
                if (i >= start || i <= end)
                    ans.add(i);
            }
        return ans;
    }
}
//Given an integer n and an integer array rounds.
// We have a circular track which consists of n sectors
// labeled from 1 to n. A marathon will be held on this track,
// the marathon consists of m rounds. The ith round starts at sector
// rounds[i - 1] and ends at sector rounds[i]. For example,
// round 1 starts at sector rounds[0] and ends at sector rounds[1]
//
//Return an array of the most visited sectors sorted in ascending order.
//
//Notice that you circulate the track in ascending order of sector numbers
// in the counter-clockwise direction (See the first example).