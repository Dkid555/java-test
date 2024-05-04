package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceinNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0, s = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += num;
        }
        for (int j = n - 1; j >= 0; j--) {
            s += nums[j];
            sum = sum - nums[j];
            list.add(nums[j]);
            if (s > sum) {
                break;
            }
        }
        return list;
    }
}
//Given the array nums, obtain a subsequence
// of the array whose sum of elements is strictly
// greater than the sum of the non included elements in such subsequence.
//
//If there are multiple solutions, return the subsequence
// with minimum size and if there still exist multiple solutions,
// return the subsequence with the maximum total sum of all its
// elements. A subsequence of an array can be
// obtained by erasing some (possibly zero) elements from the array.
//
//Note that the solution with the given constraints is guaranteed
// to be unique. Also return the answer sorted in non-increasing order.