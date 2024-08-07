package com.javatest.leet_easy;

public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        return (points[2][0] - points[0][0]) * (points[1][1] - points[0][1]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }
}
// (y2 - y1)/(x2 - x1) == (y3 - y2)/(x3 - x2)
//
//
//Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
//
//A boomerang is a set of three points that are all distinct and not in a straight line.
//
//