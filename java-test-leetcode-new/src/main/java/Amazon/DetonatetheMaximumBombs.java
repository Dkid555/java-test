package com.Amazon;

import java.util.HashSet;
import java.util.Set;

public class DetonatetheMaximumBombs {
    public static void main(String[] args) {
        int[][] bombs = {
                {1,2,3},
                {2,3,1},
                {3,4,2},
                {4,5,3},
                {5,6,4}
        };
        int[][] data = {
                {647, 457, 91}, {483, 716, 37}, {426, 119, 35}, {355, 588, 40},
                {850, 874, 49}, {232, 568, 46}, {886, 1, 30}, {54, 377, 3},
                {933, 986, 50}, {305, 790, 49}, {372, 961, 67}, {671, 314, 58},
                {577, 221, 29}, {380, 147, 91}, {600, 535, 1}, {806, 329, 64},
                {536, 753, 18}, {906, 88, 23}, {436, 783, 82}, {652, 674, 45},
                {449, 668, 20}, {419, 13, 66}, {853, 767, 60}, {169, 288, 33},
                {871, 608, 66}, {337, 445, 35}, {388, 623, 39}, {723, 503, 81},
                {14, 19, 19}, {98, 648, 72}, {147, 565, 93}, {655, 434, 1},
                {407, 663, 22}, {805, 947, 83}, {942, 160, 70}, {959, 496, 93},
                {30, 988, 53}, {187, 849, 60}, {980, 483, 41}, {663, 150, 76},
                {268, 39, 50}, {513, 522, 75}, {61, 450, 90}, {115, 231, 12},
                {346, 304, 74}, {385, 540, 23}, {905, 178, 19}, {336, 896, 81},
                {751, 811, 94}, {527, 783, 78}, {635, 965, 19}, {334, 290, 39},
                {748, 460, 77}, {414, 134, 22}, {955, 485, 29}, {925, 787, 43},
                {243, 771, 75}, {675, 223, 29}, {788, 618, 82}, {462, 544, 30},
                {999, 259, 50}, {210, 146, 12}, {789, 442, 70}, {286, 36, 55},
                {451, 953, 6}, {719, 914, 14}, {664, 452, 14}, {933, 637, 29},
                {206, 926, 16}, {100, 422, 98}, {97, 333, 4}, {505, 631, 26},
                {908, 287, 65}, {907, 316, 86}, {949, 185, 16}, {639, 735, 62},
                {401, 739, 18}, {605, 926, 21}, {25, 391, 69}, {80, 24, 9},
                {435, 874, 92}, {940, 381, 18}, {260, 740, 87}, {727, 515, 17},
                {361, 152, 16}, {512, 470, 67}, {189, 27, 27}, {517, 439, 94},
                {159, 543, 76}, {373, 698, 38}, {781, 836, 97}, {584, 190, 23},
                {383, 367, 86}, {825, 141, 63}, {117, 926, 85}, {169, 588, 60},
                {56, 981, 100}, {294, 716, 100}, {781, 370, 89}, {373, 44, 78}
        };
        System.out.println(maximumDetonation(data));
    }

    public static int maximumDetonation(int[][] bombs) {
        int max_blown = 0;
        for(int i = 0; i < bombs.length; ++i){
            max_blown = Math.max(max_blown, detonate(bombs, bombs[i], i, new HashSet<>()).size());
            if(max_blown == bombs.length)
                break;
        }
        return max_blown;
    }

    private static Set<Integer> detonate(int[][] bombs, int[] bomb, int index, Set<Integer> detonated){
        detonated.add(index);
        for (int i = 0; i < bombs.length; ++i){
            if(!detonated.contains(i) && will_detonate(bomb[0], bombs[i][0], bomb[1], bombs[i][1], bomb[2]))
                detonate(bombs, bombs[i], i, detonated);
        }
        return detonated;
    }
    private static boolean will_detonate(int x1, int x2, int y1, int y2, int radius){
        return (long) (x2 - x1) * (long) (x2 - x1) + (long) (y2 - y1) * (long) (y2 - y1) <= (long) radius * (long) radius;
    }
}
//You are given a list of bombs. The range of a bomb
// is defined as the area where its effect can be felt.
// This area is in the shape of a circle with the center as the location of the bomb.
//
//The bombs are represented by a 0-indexed 2D integer array bombs where
// bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and
// Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.
//
//You may choose to detonate a single bomb. When a bomb is detonated,
// it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.
//
//Given the list of bombs, return the maximum number of bombs
// that can be detonated if you are allowed to detonate only one bomb.