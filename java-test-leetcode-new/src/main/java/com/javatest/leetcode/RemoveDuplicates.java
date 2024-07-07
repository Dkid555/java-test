package com.javatest.leetcode;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            //set.();
        }
        int i = 0;

        for (int ele : set) {
            nums[i++] = ele;
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);

        }
        System.out.println(set.size());

    }

}

/* OR
public int removeDuplicates(int[] nums) {
        int i =0;
        for(int j=0 ;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }

        }
        return ++i;
    }
 */
