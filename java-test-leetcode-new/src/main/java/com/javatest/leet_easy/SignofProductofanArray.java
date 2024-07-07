package com.javatest.leet_easy;

public class SignofProductofanArray {

    public static int arraySign(int[] nums) {
        int minus = 0;
        for (int x : nums) {
            if (x == 0) return 0;
            minus += (x < 0) ? 1 : 0;
        }
        return (minus & 1) == 1 ? -1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41}));
    }
}

//There is a function signFunc(x) that returns:
//
//1 if x is positive.
//-1 if x is negative.
//0 if x is equal to 0.
//You are given an integer array nums. Let product be the product of all values in the array nums.
//
//Return signFunc(product).