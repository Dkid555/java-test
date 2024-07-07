package com.Amazon;

import java.util.Arrays;

public class ReorderedPowerof2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(61));
    }
    public static boolean reorderedPowerOf2(int n) {
        char[] car1 = ("" + n).toCharArray();
        Arrays.sort(car1);

        for(int i = 0; i < 30;i++){
            char[] car2 = ("" + (1 << i)).toCharArray();
            Arrays.sort(car2);
            if(Arrays.equals(car1, car2)) return true;
        }

        return false;
    }
}
//You are given an integer n. We reorder the
// digits in any order (including the original order) such that the leading digit is not zero.
//
//Return true if and only if we can do this so
// that the resulting number is a power of two.