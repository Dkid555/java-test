package com.Amazon;

public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{3, 5, 7});
    }
    private static class NumArray {
        private final int[] tree;
        private final int[] nums;

        public NumArray(int[] nums) {
            tree = new int[nums.length + 1];
            this.nums = nums;
            // copy the array into the tree
            System.arraycopy(nums, 0, tree, 1, nums.length);
            for (int i = 1; i < tree.length; i++) {
                int parent = i + (i & -i);
                if (parent < tree.length) {
                    tree[parent] += tree[i];
                }
            }
        }

        public void update(int index, int val) {
            int currValue = nums[index];
            nums[index] = val;
            index++;
            while (index < tree.length) {
                tree[index] = tree[index] - currValue + val;
                index = index + (index & -index);
            }
        }

        private int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= (i & -i);
            }
            return sum;
        }

        public int sumRange(int left, int right) {
            return sum(right + 1) - sum(left);
        }
    }

}
