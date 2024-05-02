package com.Amazon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortIntegersbyTheNumberof1Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits2(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));

        for (var num : new int[] {1024,512,256,128,64,32,16,8,4,2,1}){
            System.out.println("num " + num + " bits " + Integer.bitCount(num));
        }
    }
    public static int[] sortByBits(int[] arr) {
         return Arrays.stream(arr).boxed().sorted(Comparator.comparing(Integer::bitCount).thenComparing(a -> a)).
                 mapToInt(Integer::intValue).toArray();
    }
    public static int[] sortByBits2(int[] arr) {
        return Arrays.stream(arr).mapToObj(a -> new int[] {a, Integer.bitCount(a)})
                .sorted(Comparator.comparing((int[] a) -> a[1]).thenComparing(a -> a[0]))
                .mapToInt(a -> a[0])
                .toArray();
    }
}
