package com.javatest.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    int best = 0;
    Map<Integer, Integer> freq = new HashMap<>();

    public int leastBricks(List<List<Integer>> wall) {
        for (int i = 0; i < wall.size(); i++)
            processRow(wall.get(i));
        return wall.size() - best;
    }

    public void processRow(List<Integer> row) {
        int rowSum = row.get(0);
        for (int j = 1; j < row.size(); j++) {
            int f = freq.getOrDefault(rowSum, 0) + 1;
            freq.put(rowSum, f);
            if (f > best) best = f;
            rowSum += row.get(j);
        }
    }
}
//There is a rectangular brick wall in front of you with n rows of bricks.
// The ith row has some number of bricks each of the same height (i.e., one unit)
// but they can be of different widths. The total width of each row is the same.
//
//Draw a vertical line from the top to the bottom and cross the least bricks.
// If your line goes through the edge of a brick, then the brick is not considered as crossed.
// You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
//
//Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.