package com.javatest.leet_easy;

public class RobotReturntoOrigin {
    public static boolean judgeCircle(String moves) {
        int[] start = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'D' -> --start[0];
                case 'U' -> ++start[0];
                case 'R' -> ++start[1];
                case 'L' -> --start[1];
            }
        }
        return (start[0] == 0 && start[1] == 0);
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }
}
//There is a robot starting at the position (0, 0), the origin, on a 2D plane.
// Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
//
//You are given a string moves that represents the move sequence of the robot
// where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
//
//Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
//
//Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move
// to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.