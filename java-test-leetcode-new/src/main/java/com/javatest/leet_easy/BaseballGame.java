package com.javatest.leet_easy;

import java.util.LinkedList;
import java.util.List;

public class BaseballGame {
    public static int calPoints(String[] operations) {
        List<Integer> result = new LinkedList<>();
        int sum = 0;
        for (String str : operations) {
            switch (str) {
                case "D" -> {
                    result.add(result.get(result.size() - 1) * 2);
                    sum += result.get(result.size() - 1);
                }
                case "C" -> {
                    sum -= result.get(result.size() - 1);
                    result.remove(result.size() - 1);
                }
                case "+" -> {
                    result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
                    sum += result.get(result.size() - 1);
                }
                default -> {
                    result.add(Integer.parseInt(str));
                    sum += result.get(result.size() - 1);
                }
            }
        }
        return sum;
//        return result.stream().mapToInt(Integer::valueOf).sum();
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
