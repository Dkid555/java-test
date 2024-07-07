package com.javatest.leetcode;

public class MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public int[] minOperations2(String boxes) {
        char[] array = boxes.toCharArray();
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int count = array[0] - '0';
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + count;
            count = count + (array[i] - '0');
        }
        count = array[array.length - 1] - '0';
        right[right.length - 1] = 0;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count = count + (array[i] - '0');
        }
        for (int i = 0; i < array.length; i++) {
            left[i] = left[i] + right[i];
        }
        return left;
    }
}
//You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0'
// if the ith box is empty, and '1' if it contains one ball.
//
//In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
// Note that after doing so, there may be more than one ball in some boxes.
//
//Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls
// to the ith box.
//
//Each answer[i] is calculated considering the initial state of the boxes.