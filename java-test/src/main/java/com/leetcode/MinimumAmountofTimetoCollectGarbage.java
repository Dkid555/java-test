package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAmountofTimetoCollectGarbage {

    private static class TruckPickup {
        int collected;
        int maxDriveTime;

        public TruckPickup(int collected, int maxDriveTime) {
            this.collected = collected;
            this.maxDriveTime = maxDriveTime;
        }

        public void change(int collected, int maxDriveTime) {
            this.collected += collected;
            this.maxDriveTime = maxDriveTime;
        }
    }


    public static int garbageCollectionBetter(String[] garbage, int[] travel) {
        Map<Character, TruckPickup> mapOfTrucks = new HashMap<>();
        int timeTravel = 0;

        int numOfHouses = garbage.length;

        for (int i = 0; i < numOfHouses; ++i) {
            Set<Character> pickedUp = new HashSet<>();
            for (int chIndex = 0; chIndex < garbage[i].length(); ++chIndex) {
                char Truck = garbage[i].charAt(chIndex);
                TruckPickup temp = mapOfTrucks.getOrDefault(Truck, new TruckPickup(0, 0));
                temp.change(1, timeTravel);
                mapOfTrucks.put(Truck, temp);
            }
            if (i != numOfHouses - 1) {
                timeTravel += travel[i];
            }
        }
        int result = 0;

        for (Map.Entry<Character, TruckPickup> entry : mapOfTrucks.entrySet()) {
            TruckPickup truckPickup = entry.getValue();
            result += truckPickup.collected + truckPickup.maxDriveTime;
        }

//        for (Map.Entry<Character, Integer> entry: visitedHousesTrucks.entrySet()) {
//            int toAdd = 0;
//            for (int i = 0; i <= entry.getValue() - 1; ++i){
//                toAdd += travel[i];
//            }
//            result += toAdd + mapOfTrucks.getOrDefault(entry.getKey(), 0);
//        }
        return result;
    }


    public static int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> mapOfTrucks = new HashMap<>();
        Map<Character, Integer> visitedHousesTrucks = new HashMap<>();
        for (int i = 0; i < garbage.length; ++i) {
            for (int chIndex = 0; chIndex < garbage[i].length(); ++chIndex) {
                char Truck = garbage[i].charAt(chIndex);
                visitedHousesTrucks.put(Truck, Math.max(visitedHousesTrucks.getOrDefault(Truck, 0), i));
                mapOfTrucks.put(Truck, mapOfTrucks.getOrDefault(Truck, 0) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Character, Integer> entry : visitedHousesTrucks.entrySet()) {
            int toAdd = 0;
            for (int i = 0; i <= entry.getValue() - 1; ++i) {
                toAdd += travel[i];
            }
            result += toAdd + mapOfTrucks.getOrDefault(entry.getKey(), 0);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(garbageCollectionBetter(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollectionBetter(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public int garbageCollection2(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += 3 * travel[i];
        }
        for (String s : garbage) {
            ans += s.length();
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("G")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("P")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("M")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        return ans;
    }
}
//You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith
// house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass
// garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
//
//You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house
// i to house i + 1.
//
//There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck
// starts at house 0 and must visit each house in order; however, they do not need to visit every house.
//
//Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other
// two trucks cannot do anything.
//
//Return the minimum number of minutes needed to pick up all the garbage.