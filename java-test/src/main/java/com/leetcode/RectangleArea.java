package com.leetcode;

public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax2 < bx1 || bx2 < ax1)
            return (bx2 - bx1) * (by2 - by1) + (ax2 - ax1) * (ay2 - ay1);
        if (ay2 < by1 || by2 < ay1)
            return (bx2 - bx1) * (by2 - by1) + (ax2 - ax1) * (ay2 - ay1);
        int right = Math.min(ax2, bx2);
        int left = Math.max(ax1, bx1);
        int top = Math.min(by2, ay2);
        int bottom = Math.max(by1, ay1);
        return (bx2 - bx1) * (by2 - by1) + (ax2 - ax1) * (ay2 - ay1) - (right - left) * (top - bottom);

    }
}

// (x2- x1)(y2 - y1)
//Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
//
//The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
//
//The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).