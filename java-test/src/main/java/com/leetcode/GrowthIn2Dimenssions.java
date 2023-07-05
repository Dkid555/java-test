package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
* Can anybody provide a solution to the problem below?

Start with an infinite two dimensional grid filled with zeros, indexed from (1,1)
* at the bottom left corner with coordinates increasing toward the top and right. Given a series of coordinates (r,c) where r is the
* ending row and c is the ending column, add 1 to each element in the range from (1,1) to (r,c) inclusive. Once all coordinates are processed,
* determine how many cells contain the maximal value in the grid.

Example: upRight = ["1 4", "2 3", "4 1"]

The two space-separated integers
*  within each string represent r and c respectively. The diagrams the attached images show each iteration starting at zero.
* The maximal value in the grid is 3, and there is 1 occurence at cell (1,1).

grid image 1

grid image 2

Complete a function countMax to return the number of occurrences of
* teh final grid's maximal element. countMax has the following parameter(s): string upRight[n]: an a
* rray of strings made of two space-seperated integers, r and c.*/
public class GrowthIn2Dimenssions {
    public static long count(List<String> upRight) {

        //xl - vertical
        //yl - horizontal
        long xl = Integer.parseInt(upRight.get(0).split(" ")[0]);
        long yl = Integer.parseInt(upRight.get(0).split(" ")[1]);

        for (int i = 1; i < upRight.size(); i++) {
            if (xl > Integer.parseInt(upRight.get((int) i).split(" ")[0]))
                xl = Integer.parseInt(upRight.get((int) i).split(" ")[0]);
            if (yl > Integer.parseInt(upRight.get((int) i).split(" ")[1]))
                yl = Integer.parseInt(upRight.get((int) i).split(" ")[1]);
        }

        return yl * xl;
    }


    public static long count2(List<String> upRight) {
        long x = Integer.parseInt(upRight.get(0).split(" ")[0]);
        long y = Integer.parseInt(upRight.get(0).split(" ")[1]);
        for (String coordinates : upRight
        ) {
            if (x > Integer.parseInt(coordinates.split(" ")[0]))
                x = (Integer.parseInt(coordinates.split(" ")[0]));
            if (y > Integer.parseInt(coordinates.split(" ")[1]))
                y = (Integer.parseInt(coordinates.split(" ")[1]));
        }
        return x * y;
    }


    public static void main(String[] args) {
        List<String> upRight = new ArrayList<>();
        Collections.addAll(upRight, "2 3", "3 4", "4 1");
        System.out.println(count(upRight));
    }
}
