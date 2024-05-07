package com.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> hashmap = new HashMap<>();  // Key => Integer | Value => Set

        for(int[] single_point : points) // Iterate through every single point & store the coordinates in map
        {
            if(!hashmap.containsKey(single_point[0])){ // Check if x coordinate of the single point already exisits as a Key in hasmap.
                hashmap.put(single_point[0], new HashSet<Integer>()); // Insert a new Key (equal to x coordinate) in the hashmap with corresponding Value (equal to newly created empty HashSet).
            }
            hashmap.get(single_point[0]).add(single_point[1]); // Insert y coordinate into Value (HashSet) corresponding to Key (equal to x coordinate)
        }

        int minimum_area = Integer.MAX_VALUE; // Vairable to store the minimum area

        for (int[] PointA : points) {  // Iterator corresponding to different A points
            for (int[] PointB : points) { // Iterator corresponding to different B points

                int x1 = PointA[0], y1 = PointA[1]; // Coordinates of Point A

                int x2 = PointB[0], y2 = PointB[1]; // Coordinates of Point B

                if (x1 != x2 && y1 != y2) // Point A & B must form a diagonal of the rectangle.
                    if (hashmap.get(x1).contains(y2)  // Check if D exists in hashmap
                            &&
                            hashmap.get(x2).contains(y1)) // Check if C exists in hashmap
                        minimum_area = Math.min(minimum_area, Math.abs(x1 - x2) * Math.abs(y1 - y2)); // Store the minimum area possible
            }
        }
        return minimum_area != Integer.MAX_VALUE ? minimum_area : 0; // Return 0 if no rectangle exists
    }
}
