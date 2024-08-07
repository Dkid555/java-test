package com.javatest.leetcode;

public class MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        return n % 2 == 0 ? (n / 2) * (n / 2) : ((n - 1) / 2) * ((n - 1) / 2);
    }
    public int minOperBetter(int n){
        return n*n/4;
    }
}

//You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e., 0 <= i < n).
//
//In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and
// add 1 to arr[y] (i.e., perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal.
// It is guaranteed that all the elements of the array can be made equal using some operations.
//
//Given an integer n, the length of the array, return the minimum number of operations needed to make all
// the elements of arr equal.