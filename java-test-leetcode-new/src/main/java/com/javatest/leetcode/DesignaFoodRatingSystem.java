package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignaFoodRatingSystem {
    class FoodRatings {

        private Map<String, FoodInfo> foodInfos;

        private Map<String, TreeSet<FoodInfo>> cuisinesMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodInfos = new HashMap<>();
            cuisinesMap = new HashMap<>();

            for (int i = 0; i < foods.length; i += 1) {
                String name = foods[i], cuisine = cuisines[i];
                int rating = ratings[i];

                FoodInfo foodObj = new FoodInfo(name, cuisine, rating);

                cuisinesMap.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                    if (a.rating == b.rating)
                        return a.food.compareTo(b.food);
                    return Integer.compare(b.rating, a.rating);
                }));

                cuisinesMap.get(cuisine).add(foodObj);
                foodInfos.put(name, foodObj);
            }
        }

        public void changeRating(String food, int newRating) {
            FoodInfo obj = foodInfos.get(food);
            TreeSet<FoodInfo> nameRatings = cuisinesMap.get(obj.cuisine);
            nameRatings.remove(obj);
            obj.rating = newRating;
            nameRatings.add(obj);
        }

        public String highestRated(String cuisine) {
            return cuisinesMap.get(cuisine).first().food;
        }

        private class FoodInfo {
            String food;
            String cuisine;
            int rating;

            FoodInfo(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("qnvseohnoe".compareTo("emgqdbo"));
    }
}
//Design a food rating system that can do the following:
//
//Modify the rating of a food item listed in the system.
//Return the highest-rated food item for a type of cuisine in the system.
//Implement the FoodRatings class:
//
//FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system.
// The food items are described by foods, cuisines and ratings, all of which have a length of n.
//foods[i] is the name of the ith food,
//cuisines[i] is the type of cuisine of the ith food, and
//ratings[i] is the initial rating of the ith food.
//void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
//String highestRated(String cuisine) Returns the name of the food item that has the highest rating for
// the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
//Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
// that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes
// before y[i] in alphabetic order.