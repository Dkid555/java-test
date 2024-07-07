package com.javatest.leetcode;

public class RangeSumQueryImmutable {
    class NumArray {

        int[] previous;

        public NumArray(int[] nums) {
            this.previous = new int[nums.length];
            this.previous[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                this.previous[i] = this.previous[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left > 0) {
                return this.previous[right] - this.previous[left - 1];
            } else {
                return this.previous[right];
            }
        }
    }

}
