package com.javatest.leet_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEvenandOddIndicesIndependently {
    static int[] sortEvenOdd(int[] nums) {
        if (nums.length < 3) return nums;
        int[] fin = new int[nums.length];
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) == 1) odd.add(nums[i]);
            else even.add(nums[i]);
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        int j = 0;

        for (int i = 0; i < odd.size(); i++) {
            fin[j++] = even.get(i);
            fin[j++] = odd.get(i);
        }
        if (odd.size() < even.size()) {
            fin[j] = even.get(even.size() - 1);
        }

        return fin;
    }

    //if we have 1 <= nums.length <= 100
    //1 <= nums[i] <= 100
    static int[] sortEvenOdd2(int[] nums) {
        if (nums.length < 3) return nums;
        int[] odd = new int[101];
        int[] even = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                even[nums[i]]++;
            } else odd[nums[i]]++;
        }
        int ev = 0;
        int od = 100;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                while (even[ev] == 0) {
                    ev++;
                }
                nums[i] = ev;
                even[ev]--;
            } else {
                while (odd[od] == 0) {
                    od--;
                }
                nums[i] = od;
                odd[od]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21};
        nums = sortEvenOdd2(nums);
    }
}
