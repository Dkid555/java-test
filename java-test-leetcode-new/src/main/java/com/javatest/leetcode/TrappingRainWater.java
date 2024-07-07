package com.javatest.leetcode;


//Given n non-negative integers representing
// an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.


//(Waterlevel-barHeight)*width of bar= TrappedWater


//Step1- calculate left max boundary-Auxiliary Array
//
//Step2- calculate right max boundary-Auxiliary Array loop
//
//Step3- waterLevel =min(left max bound, right max bound)
//
//Step4- trapped water= waterlevel-height[i]
public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        //calculate left max boundary-Auxiliary Array
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            //after loop complted, leftMax[]={4,4,4,6,6,6,6}
        }

        //calculate right max boundary-Auxiliary Array
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            //after loop complted, leftMax[]={6,6,6,6,5,5,5}
        }

        int trappedWater = 0;
        //loop
        for (int i = 0; i < n; i++) {
            //waterLevel =min(left max bound, right max bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //waterLevel ={4,4,4,6,5,5,5}

            //trapped water= waterlevel-height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
