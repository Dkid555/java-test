package com.leet_easy;

import java.util.*;

public class PositionsofLargeGroups {
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> temp = new ArrayDeque<>();
        int count = 1;
        if (s.length() < 3) return new ArrayList<>();
        int prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (prev == s.charAt(i)) {
                ++count;
                if (count == 2) {
                    temp.addFirst(i - 1);
                }
                temp.addLast(i);
            } else {
                prev = s.charAt(i);
                if (count > 2)
                    res.add(Arrays.asList(temp.getFirst(), temp.getLast()));
                count = 1;
                temp = new ArrayDeque<>();
            }
        }
        if (count > 2 && !temp.isEmpty()) {
            res.add(Arrays.asList(temp.getFirst(), temp.getLast()));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
    }
}
