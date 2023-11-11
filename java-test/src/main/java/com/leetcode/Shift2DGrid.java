package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        k = k % (grid.length * grid[0].length);
        int[] array = new int[grid.length * grid[0].length];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                array[index++] = grid[i][j];
            }
        }
        //Reverse The Entire Array
        reverseArray(array, 0, array.length - 1);
        //Reverse First K Elements
        reverseArray(array, 0, k - 1);
        //Reverse Rest Elements
        reverseArray(array, k, array.length - 1);
        int index1 = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < grid[i].length; j++) {
                temp.add(array[index1++]);
            }
            list.add(temp);
        }
        return list;
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
