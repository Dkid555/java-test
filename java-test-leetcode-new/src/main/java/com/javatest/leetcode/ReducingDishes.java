package com.javatest.leetcode;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0, total = 0, max = 0;
        for(int i = satisfaction.length - 1; i >= 0 && sum >= 0; --i){
            total += sum + satisfaction[i];
            sum += satisfaction[i];
            max = Math.max(total, max);
        }

        return max;
    }
}
//A chef has collected data on the satisfaction level of his n dishes.
// Chef can cook any dish in 1 unit of time.
//
//Like-time coefficient of a dish is defined as the time taken to cook that
// dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
//
//Return the maximum sum of like-time coefficient that the chef can obtain
// after preparing some amount of dishes.
//
//Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.