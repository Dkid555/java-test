package com.leet_easy;

import java.util.Arrays;

//Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
//
//To flip an image horizontally means that each row of the image is reversed.
//
//For example, flipping [1,1,0] horizontally results in [0,1,1].
//To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
//
//For example, inverting [0,1,1] results in [1,0,0].
public class FlippinganImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++)
            for (int column = 0; column < image[row].length; column++) {
                if (column > ((int) Math.ceil(image[row].length / 2.0)) - 1) {
                    break;
                }
                int temp = image[row][column];
                image[row][column] = image[row][image[row].length - 1 - column] == 1 ? 0 : 1;
                image[row][image[row].length - 1 - column] = temp == 1 ? 0 : 1;
            }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));

    }
}
