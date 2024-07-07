package com.javatest.leetcode;

import java.util.ArrayList;

public class BinarySearch {
    //rivate static int c;
    private int c;

    private static Object search(ArrayList<Integer> lst, int target) {
        int j = lst.size() - 1;
        int i = 0;
        int mid;
        while (i <= j) {
            mid = (j + i) / 2;
            if (lst.get(mid) == target) {
                return mid;
            } else if (lst.get(mid) < target) {
                i = mid + 1;
            } else j = mid - 1;

        }
        return null;
    }

    private static Object search2(ArrayList<Integer> lst, int target, int i, int j, int mid) {
        if (i > j) return null;
        mid = (i + j) / 2;
        if (lst.get(mid) == target) {
            return mid;
        } else if (lst.get(mid) < target) {
            i = mid + 1;
        } else j = mid - 1;
        return search2(lst, target, i, j, mid);
    }

    private static int Smallest(ArrayList<Integer> lst) {
        int small = lst.get(0);
        int small_index = 0;
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i) < small) {
                small = lst.get(i);
                small_index = i;
            }

        }
        return small_index;
    }

    private static ArrayList<Integer> BadSort(ArrayList<Integer> lst) {
        ArrayList<Integer> newlst = new ArrayList<Integer>();
        int small_index;
        int len = lst.size();
        for (int i = 0; i < len; i++) {
            small_index = Smallest(lst);
            newlst.add(i, lst.get(small_index));
            lst.remove(small_index);

        }
        return newlst;
    }

    public static void main(String[] args) {


        ArrayList<Integer> lst = new ArrayList<>();
        int[] val = {0, 10, 5, 99, -10, 15};
        for (int j = 0; j < val.length; j++) lst.add(val[j]);
        lst.add(20);
        lst.add(40);
        lst.add(90);
        lst.add(-2200);
        lst.add(500);
        lst.add(60);

        System.out.println(lst);

        lst = BadSort(lst);
        System.out.println(lst);

        System.out.println(search(lst, 0));
        System.out.println(search2(lst, 500, 0, lst.size() - 1, 0));
        ///System.out.println(lst.get(10));
    }
}
