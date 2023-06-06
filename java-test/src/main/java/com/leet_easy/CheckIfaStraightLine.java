package com.leet_easy;
//You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
// Check if these points make a straight line in the XY plane.


// Formula : (x - x1)/(x2 - x1) == (y - y1)/(y2 - y1)
// where (x1,y1) (x2, y2) - coordinates of two points;
public class CheckIfaStraightLine {
    public static boolean check(int[][] cordinates) {
        int x1 = cordinates[0][0];
        int y1 = cordinates[0][1];
        int x2 = cordinates[1][0];
        int y2 = cordinates[1][1];
        if (cordinates[1][0] == cordinates[0][0]) {
            for (int i = 2; i < cordinates.length; i++)
                if (cordinates[i][0] != cordinates[0][0])
                    return false;
            return true;
        } else if (cordinates[1][1] == cordinates[0][1]) {
            for (int i = 2; i < cordinates.length; i++)
                if (cordinates[i][1] != cordinates[0][1])
                    return false;
            return true;
        }
        for (int i = 2; i < cordinates.length; i++) {
            if ((cordinates[i][0] - x1) / (x2 - x1) != (cordinates[i][1] - y1) / (y2 - y1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(check(coordinates));
        System.out.println(check(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
    }
}
