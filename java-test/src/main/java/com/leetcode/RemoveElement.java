/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:
*/

package com.leetcode;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int[] nums = new int[]{3, 3, 2, 2, 2, 2, 3};
        int val = myObj.nextInt();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println(i);
    }
}
