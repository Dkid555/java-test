package com.Amazon;

import java.util.Map;

public class BoatstoSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{2,1}, 3));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int[] people_map = new int[30001];
        int max_weight = 0;
        int min_weight = Integer.MAX_VALUE;
        for(int man : people){
            ++people_map[man];
            max_weight = Math.max(max_weight, man);
            min_weight = Math.min(min_weight, man);
        }
        if(min_weight > limit / 2){
            return people.length;
        }
        int count = 0;
        while (min_weight < max_weight){


            if(max_weight + min_weight > limit){
                while (max_weight + min_weight > limit && max_weight != min_weight){
                    count += people_map[max_weight];
                    --max_weight;
                }

            }else if(people_map[max_weight] > 0 &&
                    max_weight + min_weight <= limit){
                --people_map[min_weight];
                --people_map[max_weight];
                ++count;
            }


            if(people_map[min_weight] == 0)
                while (people_map[min_weight] == 0 && min_weight != max_weight)
                    ++min_weight;

            if(people_map[max_weight] == 0){
                while (people_map[max_weight] == 0 && min_weight != max_weight)
                    --max_weight;
            }

        }
        return count + (min_weight > limit / 2 ? people_map[min_weight]
                : (int) Math.ceil((double) people_map[min_weight] / 2));
    }
}
//You are given an array people where people[i] is the weight of the ith person,
// and an infinite number of boats where each boat can carry a maximum weight of limit.
// Each boat carries at most two people at the same time,
// provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.