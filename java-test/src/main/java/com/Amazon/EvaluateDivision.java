package com.Amazon;

import java.util.*;

public class EvaluateDivision {
//    Map<String, Map<String, Double>> map = new HashMap<>();
//    Set<String> seen = new HashSet<>();
//
//    private double dfs(String s, String target, double num) {
//        if (!map.containsKey(s)) return -1.0;
//        if (s.equals(target)) return num;
//        seen.add(s);
//
//        for (var div : map.get(s).entrySet()) {
//            if (!seen.contains(div.getKey())) {
//                double ans = dfs(div.getKey(), target, div.getValue());
//                if (ans != -1.0) return num * ans;
//            }
//        }
//        return -1.0;
//    }
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        var n = queries.size();
//        var ans = new double[n];
//
//        for (var i = 0; i < equations.size(); ++i) {
//            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
//            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
//
//            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
//            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
//        }
//        for (var i = 0; i < n; ++i) {
//            seen.clear();
//            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
//        }
//        return ans;
//    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map_of_division = new HashMap<>();
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); ++i){
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);
            map_of_division.putIfAbsent(val1, new HashMap<>());
            map_of_division.putIfAbsent(val2, new HashMap<>());
            map_of_division.get(val1).put(val2, values[i]); // A / B
            map_of_division.get(val2).put(val1, 1 / values[i]);  // B / A
        }

        for (int i = 0; i < result.length; ++i){
            Set<String> visited = new HashSet<>();
            result[i] = dfs(map_of_division, visited, queries.get(i).get(0), queries.get(i).get(1), 1.0);
        }
        return result;
    }
    private double dfs(Map<String, Map<String, Double>> map_of_division, Set<String> visited ,String gona_be_divided,
                       String target_divisor, double num){
        if(!map_of_division.containsKey(gona_be_divided))
            return -1.0;
        if(gona_be_divided.equals(target_divisor))
            return num;
        visited.add(gona_be_divided);

        for (var div : map_of_division.get(gona_be_divided).entrySet()){
            if(!visited.contains(div.getKey())){
                double answer = dfs(map_of_division, visited, div.getKey(), target_divisor, div.getValue());
                if (answer != -1.0) return num * answer;
            }
        }
        return -1.0;
    }


}
