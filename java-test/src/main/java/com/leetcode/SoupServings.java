package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoupServings {
    public static double soupServings(int n) {
        Map<String, Double> map = new HashMap<>();
        if (n >= 4800) {
            return 1;
        }
        return recursion(n, n, map);
    }

    private static double recursion(int a, int b, Map<String, Double> map) {
        if (a <= 0 && b <= 0)
            return 0;
        if (a <= 0)
            return 1;
        if (b <= 0)
            return 0;
        if (map.containsKey(a + "_" + b)) {
            return map.get(a + "_" + b);
        }
        List<Double> recurs = List.of(
                recursion(a - 100, b, map),
                recursion(a - 75, b - 25, map),
                recursion(a - 50, b - 50, map),
                recursion(a - 25, b - 75, map)
        );
        double result = 0.25 * recurs.stream().reduce(0.0, Double::sum);
        map.put(a + "_" + b, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(soupServings(50));
    }
}
//1- (a-100), b
//2- (a-75), (b-25)
//3- (a-25), (b-75)
//4- (a-50), (b-50)