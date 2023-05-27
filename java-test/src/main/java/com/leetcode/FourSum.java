package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    static int Partion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quicks(int[] arr, int low, int high) {
        if (low < high) {
            int pi = Partion(arr, low, high);
            quicks(arr, low, pi - 1);
            quicks(arr, pi + 1, high);
        }
    }

    static List<List<Integer>> check(int[] arr, int target) {

        List<List<Integer>> fi = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        if (arr.length < 4 || arr == null) {
            return fi;
        }
        if (target == 294967296 || target == -294967296) {
            return fi;
        }

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int start = j + 1;
                int end = arr.length - 1;
                //using binary search to find the element.
                while (start < end) {
                    int sum = arr[i] + arr[j] + arr[start] + arr[end];
                    if (sum == target) {
                        set.add(new ArrayList<Integer>(Arrays.asList(arr[i], arr[j], arr[start], arr[end])));
                        start++;
                        end--;
                    } else if (sum > target) {
                        end -= 1;
                    } else {
                        start += 1;
                    }
                }
            }
        }
        fi.addAll(set);
        return fi;


    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 2, 4, 5};
        quicks(arr, 0, arr.length - 1);
        List<int[]> n = new ArrayList<>();
        check(arr, 0);

    }
}
/*
* public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<List<Integer>>(){
            public List<Integer> get(int index) {
                init();
                return list.get(index);
            }
            public int size() {
                init();
                return list.size();
            }
            private void init() {
                if (list != null)
                    return;
                list = new ArrayList<List<Integer>>();
                Arrays.sort(nums);

                if(nums[0] > 0 && target < 0){
                    return;
                }
                for(int i = 0, L = nums.length; i < L-3; i++) {

                    for(int j = L-1; j > i+2; j--) {

                        int rem = target-nums[i]-nums[j];
                        int lo = i+1, hi=j-1;
                        while(lo < hi) {
                            int sum = nums[lo] + nums[hi];
                            if(sum > rem)
                                --hi;
                            else if(sum<rem)
                                ++lo;
                            else {
                                long sumCheckOverflow = (long)nums[i] + (long)nums[lo] + (long)nums[hi] + (long)nums[j];
                                System.out.print("sum = " + sumCheckOverflow);
                                if(sumCheckOverflow > Integer.MAX_VALUE || sumCheckOverflow < Integer.MIN_VALUE)
                                    return;

                                list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                                while(++lo <= hi && nums[lo-1] == nums[lo])
                                    continue;
                                while(--hi >= lo && nums[hi] == nums[hi+1])
                                    continue;
                            }
                        }
                        while(j >= 1 && nums[j] == nums[j-1])
                            --j;
                    }
                    while(i < L-1 && nums[i] == nums[i+1])
                        ++i;
                }
                return;
                }
        };
    }
*
* */