package com.Amazon;

import java.util.*;
import java.util.stream.IntStream;

public class log {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        Set<String> resultSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String log : logs) {
            String[] data = log.split(" ");
            Set<String> set = new HashSet<>();
            IntStream.range(0, 2).forEach(i -> {
                set.add(data[i]);
            });

            // int curr = Integer.parseInt(data[2]);

            for (String str : set) {
                map.put(str, map.getOrDefault(str, 0) + 1);
                if (map.get(str) > threshold)
                    resultSet.add(str);
            }

        }
        List<String> res = new ArrayList<>(resultSet);
        Collections.sort(res, Comparator.comparing(a -> Integer.parseInt(a)));
        return res;
//        return new ArrayList<>(resultSet).sort(Comparator.comparingInt((a) -> Integer.parseInt(a)));
    }

    public static void main(String[] args) {
        System.out.println(processLogs(List.of("1 2 50", "1 7 70", "1 3 20", "2 2 17"), 2));
    }
}
