package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(new int[][]{{5,8},{3,9},{5,12},{16,5}}));
    }
    public static int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] heigh_width : rectangles){
            int hw = Math.min(heigh_width[0], heigh_width[1]);
            max = Math.max(hw, max);
            map.put(hw, map.getOrDefault(hw, 0) + 1);
        }
        return map.get(max);
    }
}
