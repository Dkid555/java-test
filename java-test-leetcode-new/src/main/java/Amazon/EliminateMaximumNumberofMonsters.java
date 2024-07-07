package com.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliminateMaximumNumberofMonsters {

    public static void main(String[] args) {
        int[] dist = {3,2,4};
        int[] time = {5,3,2};
        System.out.println(eliminateMaximum(dist, time));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        List<Float> time_to_reach_city = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < dist.length; ++i){
            time_to_reach_city.add( ((float) dist[i]/(float) speed[i]));
        }
        Collections.sort(time_to_reach_city);
        int compare = 0;
        for(int i = 0; i < time_to_reach_city.size(); ++i){
            if(time_to_reach_city.get(i) > compare){
                ++count;
                ++compare;
            }else
                break;
        }
        return count;

    }

}
