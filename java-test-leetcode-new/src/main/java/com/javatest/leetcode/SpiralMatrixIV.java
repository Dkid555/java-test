package com.javatest.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SpiralMatrixIV {
    public static int[][] generateMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            //right
            for (int i = left; i <= right; i++) {
                if (head != null) {
                    res[top][i] = head.val;
                    head = head.next;
                } else
                    res[top][i] = -1;

            }
            top++;
            //bottom
            for (int i = top; i <= bottom; i++) {
                if (head != null) {
                    res[i][right] = head.val;
                    head = head.next;
                } else
                    res[i][right] = -1;
            }
            right--;
            if (top <= bottom) {
                //left
                for (int i = right; i >= left; i--) {
                    if (head != null) {
                        res[bottom][i] = head.val;
                        head = head.next;
                    } else
                        res[bottom][i] = -1;
                }
                bottom--;
            }
            if (left <= right) {
                //top
                for (int i = bottom; i >= top; i--) {
                    if (head != null) {
                        res[i][left] = head.val;
                        head = head.next;
                    } else
                        res[i][left] = -1;

                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntStream stream = Arrays.stream(generateMatrix(3, 4, new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(0, new ListNode(7)))))))).flatMapToInt(Arrays::stream);
        stream.forEachOrdered(n -> System.out.print(n + " "));
    }
}
//You are given two integers m and n, which represent the dimensions of a matrix.
//
//You are also given the head of a linked list of integers.
//
//Generate an m x n matrix that contains the integers in the linked list presented in spiral
// order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.
//
//Return the generated matrix.