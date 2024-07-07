package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
//        Map<Integer,Integer> pocket = new HashMap<>();
//
//        for (int i = 0; i < bills.length; i++){
//            if(bills[i] == 5){
//                pocket.put(bills[i], pocket.getOrDefault(bills[i],0)+1);
//            }else {
//                if(pocket.containsKey(bills[i] - 5)){
//                    pocket.put(bills[i] - 5, pocket.get(bills[i] - 5) - 1);
//                    if(pocket.get(bills[i] - 5) == 0)
//                        pocket.remove(bills[i] - 5);
//                    pocket.put(bills[i], pocket.getOrDefault(bills[i] - 5,0)+1);
//                } else if (pocket.containsKey(bills[i] - 10)) {
//                    pocket.put(bills[i] - 10, pocket.get(bills[i] - 10) - 1);
//                    if(pocket.get(bills[i] - 10) == 0)
//                        pocket.remove(bills[i] - 10);
//                    if(pocket.containsKey(bills[i] - 15)){
//                        while(pocket.get(bills[i] - 15) > 0)
//                            pocket.put(bills[i] -15, pocket.get(bills[i] - 15) - 1);
//                        if(pocket.get(bills[i] - 15) == 0)
//                            pocket.remove(bills[i] - 15);
//                    }
//                    else
//                        return false;
//                    pocket.put(bills[i], pocket.getOrDefault(bills[i] - 10,0)+1);
//                }else return false;
//
//            }
//
//        }
//        return true;


        Map<Integer, Integer> pocket = new HashMap<>();

        pocket.put(5, 0);
        pocket.put(10, 0);
        pocket.put(20, 0);

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5)
                pocket.put(5, pocket.get(5) + 1);

            if (bills[i] == 10) {
                if (pocket.get(5) == 0)
                    return false;
                pocket.put(5, pocket.get(5) - 1);
                pocket.put(10, pocket.get(10) + 1);
            }

            if (bills[i] == 20) {

                if (pocket.get(5) == 0 && pocket.get(10) == 0) return false;

                if (pocket.get(5) > 0 && pocket.get(10) > 0) {
                    pocket.put(5, pocket.get(5) - 1);
                    pocket.put(10, pocket.get(10) - 1);
                    pocket.put(20, pocket.get(20) + 1);
                    continue;
                }

                if (pocket.get(10) == 0 && pocket.get(5) >= 3) {
                    pocket.put(5, pocket.get(5) - 3);
                    pocket.put(20, pocket.get(20) + 1);
                    continue;
                }
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 5, 10, 5, 20, 10, 5, 5}));
    }

    public boolean lemonadeChange2(int[] bills) {
        int fives = 0, tens = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                tens++;
                fives--;
            } else if (bill == 20) {
                if (tens == 0) {
                    fives -= 3;
                } else {
                    tens--;
                    fives--;
                }
            }
            if (tens < 0 || fives < 0) {
                return false;
            }
        }
        return true;
    }

}
