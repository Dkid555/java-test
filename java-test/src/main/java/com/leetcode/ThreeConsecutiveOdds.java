package com.leetcode;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int check = 0;
        for (int num : arr){
            if((num & 1) == 1){
                ++check;
                if (check == 3)
                    return true;
            }else
                check = 0;
        }
        return false;

    }
}
