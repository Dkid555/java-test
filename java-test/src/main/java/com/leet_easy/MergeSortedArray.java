package com.leet_easy;

import java.util.ArrayList;
import java.util.Iterator;

public class MergeSortedArray {
    //    static int[] merge(int[] nums1, int m, int[] nums2, int n){
//        int[] fin = new int[n + m];
//        int i = 0;
//        while(i != n+m){
//        if(nums1[i] > nums2[i]) fin[i] = nums2[i]);
//            else fin[i] = nums1[i];
//            i++;
//        }
////        for(int i = n + m - 1; i >= 0; i++){
////            if()
////        }
//        return fin;
//    }
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = nums2.length;
//        merge(nums1,m,nums2,n);

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Get the iterator
        Iterator<String> it = cars.iterator();

        // Print the first item
        System.out.println(it.next());
        System.out.println(it.next());


    }
}
