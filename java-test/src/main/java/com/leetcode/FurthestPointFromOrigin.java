package com.leetcode;

public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int leftC = 0;
        int rightC = 0;
        int blankC = 0;

        for (int i = 0; i < moves.toCharArray().length; i++) {
            switch (moves.charAt(i)) {
                case 'L' -> {
                    ++leftC;
                }
                case 'R' -> {
                    ++rightC;
                }
                default -> {
                    blankC++;
                }
            }
        }

        return Math.abs(leftC - rightC) + blankC;
    }
}
