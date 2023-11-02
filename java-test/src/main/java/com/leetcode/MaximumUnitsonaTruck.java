package com.leetcode;

import java.util.Arrays;

public class MaximumUnitsonaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort the array in ascending order according to the second column(i.e numberOfUnitsPerBox)
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            if (truckSize == 0)
                return ans;
            if (boxTypes[i][0] <= truckSize) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        return ans;
    }
}
//You are assigned to put some amount of boxes onto one truck.
// You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//
//numberOfBoxesi is the number of boxes of type i.
//numberOfUnitsPerBoxi is the number of units in each box of the type i.
//You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
// You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
//
//Return the maximum total number of units that can be put on the truck.