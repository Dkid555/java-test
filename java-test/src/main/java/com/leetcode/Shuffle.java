package com.leetcode;

public class Shuffle {
    static int[] shuff(int[] nums, int n) {
        //Queue<Integer> q = new LinkedList<>();
        int[] fin = new int[2 * n];
        int j = n;
        int i = 0;
        int z = 0;
        while (j < 2 * n && i < n) {
            fin[z] = nums[i];
            z++;
            fin[z] = nums[j];
            z++;
            i++;
            j++;

        }
        return fin;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int n = 3;
        nums = shuff(nums, n);
        String[] operations = new String[]{"x--", "x++"};
        System.out.println(operations.length);


    }
}
