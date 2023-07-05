package com.leetcode;


import java.math.BigInteger;

/*
* You are given a 0-indexed two-dimensional integer array nums.

Return the largest prime number that lies on at
* least one of the diagonals of nums. In case, no prime is present on any of the diagonals, return 0.

Note that:

An integer is prime if it is greater than 1 and
has no positive integer divisors other than 1 and itself.
An integer val is on one of the diagonals of nums if there
exists an integer i for which nums[i][i] = val or an i for which nums[i][nums.length - i - 1] = val.

*
* */
public class PrimeInDiagonal {
    public static int diagonalPrime(int[][] nums) {
        int max = 0;
        for (int row = 0, column = 0, columnright = nums[0].length - 1; row < nums.length && columnright >= 0 && column < nums[0].length; ) {
            BigInteger integer = BigInteger.valueOf(nums[row][column]);
            BigInteger integerRight = BigInteger.valueOf(nums[row][columnright]);
            Boolean left = integer.isProbablePrime((int) Math.log(nums[row][column]));
            Boolean right = integerRight.isProbablePrime((int) Math.log(nums[row][columnright]));
            if (left && right)
                max = Math.max(max, Math.max(nums[row][column], nums[row][columnright]));
            else {
                if (left) max = Math.max(max, nums[row][column]);
                if (right) max = Math.max(max, nums[row][columnright]);
            }


//            if(integer.isProbablePrime((int) Math.log(nums[row][column])))
//                max = Math.max(max, nums[row][column]);
            row++;
            column++;
            columnright--;
        }
//        for(int row = 0, column = nums[0].length - 1; row < nums.length && column >= 0;){
//            BigInteger integer = BigInteger.valueOf(nums[row][column]);
//            if(integer.isProbablePrime((int) Math.log(nums[row][column])))
//                max = Math.max(max, nums[row][column]);
//            row++;
//            column--;
//        }
        if (max == 1) return 0;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(diagonalPrime(new int[][]{new int[]{1, 2, 3}, new int[]{5, 6, 7}, new int[]{9, 10, 11}}));
        System.out.println(new secondSol().diagonalPrime(new int[][]{new int[]{1, 2, 3}, new int[]{5, 6, 7}, new int[]{9, 10, 11}}));
    }


}


class secondSol {
    public int diagonalPrime(int[][] nums) {
        int a = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a; i++) {
            if (nums[i][i] > max && isPrime(nums[i][i])) {
                max = nums[i][i];
            }
        }

        for (int i = a - 1; i >= 0; i--) {
            if (nums[i][nums.length - i - 1] > max && isPrime(nums[i][nums.length - i - 1])) {
                max = nums[i][nums.length - i - 1];
            }
        }

        return max != Integer.MIN_VALUE ? max : 0;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
