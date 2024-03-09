package com.meta;

public class Battleship {
    public double getHitProbability(int R, int C, int[][] G) {
        // Write your code here
        double ones = 0.0;
        //double all = 0.0;
        for (int[] ints : G) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    ++ones;
                }
            }
        }


        return ones / (R * C);
    }
}
