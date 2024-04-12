package com.Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Findthemissingnumberinthearray {
    public static int find_missing(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= arr.length + 1; ++i){
            set.add(i);
        }
        for(int num : arr){
            set.remove(num);
        }
        return set.stream().findFirst().get();
    }
    public static int find_missing2(List<Integer> arr){
        int sum = 0;

        for (int num : arr){
            sum += num;
        }

        return (arr.size() * (arr.size() + 1)) / 2 - sum;

    }

    public static void main(String[] args) {
        System.out.println(find_missing(new int[]{1, 3}));
    }
}
//You are given an array of positive numbers from 1 to n, such that all
// numbers from 1 to n are present except one number x. You have to find x.
// The input array is not sorted. Look at the below array and give it a try before checking the solution