package com.leetcode;

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.*/
public class ContainerWithMostWater {
    //Brute Force
    public static int maxArea(int[] height) {
        int size = 0;
        for (int end = height.length - 1; end >= 0; end--) {
            for (int end_sec = end - 1; end_sec >= 0; end_sec--) {
                size = Math.max(size, Math.min(height[end_sec], height[end]) * (end - end_sec));
            }
        }
        return size;
    }


    //Better
    public static int maxArea2(int[] height) {
        int size = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int CurrCont = Math.min(height[left], height[right]) * (right - left);
            size = Math.max(size, CurrCont);
            if (height[left] < height[right])
                left++;
            else if (height[left] > height[right])
                right--;
            else {
                left++;
                right--;
            }
        }


        return size;
    }

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
