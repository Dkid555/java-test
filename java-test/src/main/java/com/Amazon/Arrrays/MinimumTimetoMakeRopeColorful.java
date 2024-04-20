package com.Amazon.Arrrays;

import java.util.Stack;

public class MinimumTimetoMakeRopeColorful {

    public static int minCost(String colors, int[] neededTime) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < colors.length(); ++i) {
            if (!stack.isEmpty() && colors.charAt(stack.peek()) == colors.charAt(i)) {
                if (neededTime[stack.peek()] < neededTime[i]) {
                    res += neededTime[stack.peek()];
                    stack.pop();
                    stack.push(i);
                } else {
                    res += neededTime[i];
                }
            } else stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }
}
//Alice has n balloons arranged on a rope. You are given a
// 0-indexed string colors where colors[i] is the color of the ith balloon.
//
//Alice wants the rope to be colorful. She does not want
// two consecutive balloons to be of the same color, so she asks
// Bob for help. Bob can remove some balloons from the rope to
// make it colorful. You are given a 0-indexed integer array
// neededTime where neededTime[i] is the time (in seconds)
// that Bob needs to remove the ith balloon from the rope.
//
//Return the minimum time Bob needs to make the rope colorful.