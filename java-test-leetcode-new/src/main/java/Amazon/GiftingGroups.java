package com.Amazon;

import java.util.*;

public class GiftingGroups {
    public static int countGroups_(List<String> related) {
        Set<String> set_check = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> groups = new HashMap<>();
        int group_id = 0;
        groups.put(0, group_id);
        int user = 0;
        for (String user_books : related) {
            for (int book = 0; book < user_books.length(); ++book) {
                if (user_books.charAt(book) == '1') {
                    if (set_check.contains(book + "RC" + user)) {
                        groups.put(user, groups.get(user - 1));
                    }
                    set_check.add(user + "RC" + book);
                }
            }
            if (!groups.containsKey(user)) {
                ++group_id;
                groups.put(user, group_id);
            }
            result.add(groups.get(user));
            ++user;
        }
        return result.size();
    }

    public static int countGroups(List<String> related) {
        if (related == null || related.isEmpty())
            return 0;
        int count = 0;
        int[][] isConnected = new int[related.size()][related.size()];
        int row = 0;

        for (String user : related) {
            for (int column = 0; column < user.length(); ++column) {
                isConnected[row][column] = user.charAt(column) - '0';
            }
            ++row;
        }
        boolean[] isReachead = new boolean[isConnected.length];
        for (row = 0; row < isConnected.length; ++row) {
            if (!isReachead[row]) {
                ++count;
                alignedGroups(isConnected, isReachead, row);
            }
        }
        return count;
    }

    private static void alignedGroups(int[][] isConnected, boolean[] isReached, int row) {
        isReached[row] = true;
        for (int column = 0; column < isConnected[row].length; ++column) {
            if (!isReached[column] && isConnected[row][column] == 1) {
                alignedGroups(isConnected, isReached, column);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countGroups_(List.of("1100", "1110", "0110", "0001")));
    }
}
