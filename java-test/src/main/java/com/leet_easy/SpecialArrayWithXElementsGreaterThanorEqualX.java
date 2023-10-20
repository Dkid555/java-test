package com.leet_easy;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public static int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x + 1];

        for (int elem : nums)
            if (elem >= x)
                counts[x]++;
            else
                counts[elem]++;

        int res = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            res += counts[i];
            if (res == i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0, 4, 3, 0, 4}));
    }
}
