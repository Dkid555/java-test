package com.javatest.leet_easy;

public class RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        int[] position = {0, 0};// x, y
        char direction = 'N';

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'G') {
                switch (direction) {
                    case 'N' -> position[1]++;
                    case 'S' -> position[1]--;
                    case 'W' -> position[0]--;
                    case 'E' -> position[0]++;
                }
            } else if (instructions.charAt(i) == 'L') {
                switch (direction) {
                    case 'N' -> direction = 'W';
                    case 'S' -> direction = 'E';
                    case 'W' -> direction = 'S';
                    case 'E' -> direction = 'N';
                }
            } else switch (direction) {
                case 'N' -> direction = 'E';
                case 'S' -> direction = 'W';
                case 'W' -> direction = 'N';
                case 'E' -> direction = 'S';
            }
        }

        if (position[0] == 0 && position[1] == 0) return true;
        return direction != 'N';
    }


    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLRRRGG"));
    }
}
//class Solution {
//    func isRobotBounded(_ instructions: String) -> Bool {
//
//        let potentialMovements = [[0, 1], [1, 0], [0, -1], [-1, 0]]
//        var directionIndex = 0
//        var currX = 0, currY = 0
//
//        for instruction in instructions {
//            switch instruction {
//            case "L":
//                directionIndex = (directionIndex + 3) % 4
//            case "R":
//                directionIndex = (directionIndex + 1) % 4
//            default:
//                currX += potentialMovements[directionIndex][0]
//                currY += potentialMovements[directionIndex][1]
//            }
//        }
//
//        return directionIndex != 0 || (currX == 0 && currY == 0)
//    }
//}
//Previous
//C++ || Brute Force || Easy approach
//Next