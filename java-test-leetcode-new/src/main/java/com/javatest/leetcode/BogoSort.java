package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class BogoSort {

    public static void Bogo(int[] arr) {
        while (true) {
            if (isSorted(arr))
                return;
            shuffle(arr);
        }
    }

    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int random = new Random().ints(0, arr.length).findFirst().getAsInt();
            int temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;
        }
    }

    public static boolean isSorted(int[] arr) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < prev)
                return false;
            prev = arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 45, -10, 15, 20, 21, -100, 15, 33};
        Bogo(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

    }
}
