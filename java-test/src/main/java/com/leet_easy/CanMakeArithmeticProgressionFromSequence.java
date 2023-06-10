package com.leet_easy;

//A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
//
//Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    static int Partion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                ++i;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        ++i;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pi = Partion(arr, low, high);
            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    static boolean canMakeArithmeticProgression(int[] arr) {
        quick(arr, 0, arr.length - 1);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) return false;
        }
        return true;
    }

    //    OR sort with collections
    static boolean canMakeArithmeticProgression2(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] f = new int[]{13, 45, 5, 7, 1, 9};
        quick(f, 0, f.length - 1);
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(canMakeArithmeticProgression2(new int[]{3, 5, 1}));

    }
}
