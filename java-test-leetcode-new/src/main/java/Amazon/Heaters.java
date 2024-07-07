package com.Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Heaters {


//    private int min_radius_calculation(int start, int end)
    public static void main(String[] args) {
        int[] houses = {1, 3, 5, 6 , 10, 12};
        int[] heaters = {4, 11, 9, 2};
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(heaters[heaters.length - 1], houses[houses.length - 1] - houses[0]);
        int min = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;

//            int heaterId = 0;
            int houseID = 0;
            for (int heaterID = 0; houseID < houses.length && heaterID < heaters.length; ++houseID) {
                if (houses[houseID] < heaters[heaterID] - mid) break; // если не достает текущий heater  до предыдущего дома
                if (houses[houseID] > heaters[heaterID] + mid) {
                    ++heaterID; // идем к следующему разогревателю
                    --houseID; // возращаем предыдущий для итерации
                }
            }

            if (houseID == houses.length) {
                min = Math.min(mid, min);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left = 0;
        int radius = Math.max(heaters[heaters.length - 1], houses[houses.length - 1] - houses[0]); // либо самый
        // дальний heater, либо расстояние между домами
        int min = radius;
        while (left <= radius){
            int mid_radius = left + (radius - left) / 2;
            int houseID = 0;
            for(int heaterID = 0; heaterID < heaters.length && houseID < houses.length; ++houseID){
                if(houses[houseID] < heaters[heaterID] - mid_radius) break; // если радиус текущего heater-a недостаточен для предыдущего дома, то дальше нет смысла
                else if(houses[houseID] > heaters[heaterID] + mid_radius){
                    --houseID; // возвращаемся к предыдущему дому, чтобы его повторно рассмотреть
                    ++heaterID; // идем к следующему обогревателю
                }
            }

            if(houseID == houses.length){ // все дома покрыли
                min = Math.min(min, mid_radius);
                radius = mid_radius - 1;
            }else{
                left = mid_radius + 1;
            }
        }
        return min;
    }

}
//Winter is coming! During the contest, your first job is to design a
// standard heater with a fixed warm radius to warm all the houses.
//
//Every house can be warmed, as long as the house is within the heater's warm radius range.
//
//Given the positions of houses and heaters on a horizontal line, return the
// minimum radius standard of heaters so that those heaters could cover all houses.
//
//Notice that all the heaters follow your radius standard, and the warm radius will the same.

//Example 1:
//
//Input: houses = [1,2,3], heaters = [2]
//Output: 1
//Explanation: The only heater was placed in the position 2,
// and if we use the radius 1 standard, then all the houses can be warmed.
//Example 2:
//
//Input: houses = [1,2,3,4], heaters = [1,4]
//Output: 1
//Explanation: The two heaters were placed at positions 1 and 4.
// We need to use a radius 1 standard, then all the houses can be warmed.
//Example 3:
//
//Input: houses = [1,5], heaters = [2]
//Output: 3