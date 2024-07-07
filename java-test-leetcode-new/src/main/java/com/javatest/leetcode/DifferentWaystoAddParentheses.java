package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses {
    static Map<String, List<Integer>> map = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String p1 = expression.substring(0, i);
                String p2 = expression.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(p1, diffWaysToCompute(p1));
                List<Integer> l2 = map.getOrDefault(p2, diffWaysToCompute(p2));
                for (Integer i1 : l1) {
                    for (Integer i2 : l2) {
                        int r = switch (c) {
                            case '+' -> i1 + i2;
                            case '-' -> i1 - i2;
                            case '*' -> i1 * i2;
                            default -> 0;
                        };
                        res.add(r);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        map.put(expression, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

}
