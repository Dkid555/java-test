package com.javatest.leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, difference;
        for (; i < heights.length - 1; ++i) {
            difference = heights[i + 1] - heights[i];
            if (difference <= 0) {
                continue;
            }
            bricks -= difference;
            p.offer(difference);
            if (bricks < 0) {
                bricks += p.poll();
                ladders--;
            }

            if (ladders < 0) {
                break;
            }
        }

        return i;
    }
}
//You are given an integer array heights representing
// the heights of buildings, some bricks, and some ladders.
//
//You start your journey from building 0 and move to the
// next building by possibly using bricks or ladders.
//
//While moving from building i to building i+1 (0-indexed),
//
//If the current building's height is greater than or equal
// to the next building's height, you do not need a ladder or bricks.
//If the current building's height is less than the next
// building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
//Return the furthest building index (0-indexed) you can reach
// if you use the given ladders and bricks optimally.