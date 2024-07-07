package com.javatest.leetcode;

public class SubrectangleQueries {

    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row = row1; row <= row2; ++row) {
            for (int column = col1; column <= col2; ++column)
                this.rectangle[row][column] = newValue;
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }


}

class rere {
    public static void main(String[] args) {
        SubrectangleQueries sub = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        sub.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(sub.getValue(0, 2));
    }
}

//Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:
//
//1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
//
//Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
//2. getValue(int row, int col)
//
//Returns the current value of the coordinate (row,col) from the rectangle.