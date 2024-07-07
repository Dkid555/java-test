package com.javatest.leetcode;


//There are n gas stations along a circular route,
//where the amount of gas at the ith station is gas[i].
//
//You have a car with an unlimited gas tank and it
// costs cost[i] of gas to travel from the ith station
// to its next (i + 1)th station. You begin the journey
// with an empty tank at one of the gas stations.
//
//Given two integer arrays gas and cost, return the starting gas station's
//index if you can travel around the circuit once in the clockwise direction,
// otherwise return -1. If there exists a solution, it is guaranteed to be unique

public class GasStation {


    // our formula is connected with total -> if it at the end is negative - return false(-1)
    //and available is an start and check if it becomes negative
    //index - ours starting position - changes by the available
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, available = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            available += gas[i] - cost[i];
            if (available < 0) {
                available = 0;
                index = i + 1;
            }
        }
        if (total < 0) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
