package com.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Determineifthesumoftwointegersisequaltothegivenvalue {
    static boolean findSumOfTwo(int[] A, int val) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()){
            int diff = val - key;
            map.put(key, map.get(key) - 1);
            if(map.containsKey(diff) && map.get(diff) > 0)
                return true;
            map.put(key, map.get(key) + 1);
        }

        //TODO: Write - Your - Code
        return false;
    }
    static boolean findSumOfTwo2(int[] A, int val) {
        Set<Integer> set = new HashSet<>();
        for (int num : A){
            if(set.contains(val - num))
                return true;
            set.add(num);
        }

        //TODO: Write - Your - Code
        return false;
    }
}
