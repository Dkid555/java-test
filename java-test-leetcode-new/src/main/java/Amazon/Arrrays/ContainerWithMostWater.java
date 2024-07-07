package com.Amazon.Arrrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int size = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int min_height = Math.min(height[left], height[right]);
            size = Math.max(size, min_height * (right - left));
            while (left < right && height[left] <= min_height)
                ++left;
            while (left < right && height[right] <= min_height)
                --right;
        }
        return size;
    }

    public static void main(String[] args) {

    }
}
//You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.