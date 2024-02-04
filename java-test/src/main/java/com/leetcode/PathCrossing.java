package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
    public static boolean isPathCrossing(String path) {
        int[] start = new int[2];
        Map<Integer, Set<Integer>> visitedPoints = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        visitedPoints.put(0, set);
        Map<Integer, int[]> mapMoves = Map.of(
                'N' - 'a', new int[]{0,1},
                'S' - 'a', new int[]{0,-1},
                'E' - 'a', new int[]{1, 0},
                'W' - 'a', new int[]{-1, 0}
        );

        for (int i = 0; i < path.length(); ++i){
            int[] move = mapMoves.getOrDefault(path.charAt(i) - 'a', new int[2]);
            start[0] += move[0];
            start[1] += move[1];
            Set<Integer> temp = visitedPoints.getOrDefault(start[0], new HashSet<>());
            if(temp.contains(start[1]))
                return true;
            temp.add(start[1]);
            visitedPoints.put(start[0], temp);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES")); // Output: false
        System.out.println(isPathCrossing("NESWW"));
    }
}
//Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north,
// south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
//
//Return true if the path crosses itself at any point, that is, if at any
// time you are on a location you have previously visited. Return false otherwise.