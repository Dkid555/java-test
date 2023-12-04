package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignParkingSystem {

    private class ParkingSystem {

        Map<Integer, Integer> parking;
        Map<Integer, Integer> sizes;

        public ParkingSystem(int big, int medium, int small) {
            this.parking = new HashMap<>();
            this.parking.put(1, 0);
            this.parking.put(2, 0);
            this.parking.put(3, 0);
            this.sizes = Map.of(1, big, 2, medium, 3, small);
        }

        public boolean addCar(int carType) {
            if (this.parking.containsKey(carType)) {
                if (this.parking.get(carType) < this.sizes.get(carType)) {
                    this.parking.put(carType, this.parking.get(carType) + 1);
                    return true;
                } else
                    return false;
            } else
                return false;
        }
    }

    private class ParkingSystem2 {
        private int[] cnt;

        public ParkingSystem2(int big, int medium, int small) {
            this.cnt = new int[]{0, big, medium, small};
        }

        public boolean addCar(int carType) {
            if (this.cnt[carType] == 0) {
                return false;
            }
            --this.cnt[carType];
            return true;
        }
    }

}
