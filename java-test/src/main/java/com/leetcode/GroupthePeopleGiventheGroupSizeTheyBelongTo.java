package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int ID = 0; ID < groupSizes.length; ++ID) {
            int size = groupSizes[ID];
            if (map.containsKey(size)) {
                List<Integer> currentSizelist = map.get(size);
                currentSizelist.add(ID);
                if (currentSizelist.size() == size) {
                    result.add(currentSizelist);
                    map.remove(size);
                } else {
                    map.put(size, currentSizelist);
                }
            } else {
                if (size == 1) {
                    result.add(List.of(ID));
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ID);
                    map.put(size, temp);
                }
            }
        }
        return result;
    }
}
//There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
//
//You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
//
//Return a list of groups such that each person i is in a group of size groupSizes[i].
//
//Each person should appear in exactly one group, and every person must be in a group.
// If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.