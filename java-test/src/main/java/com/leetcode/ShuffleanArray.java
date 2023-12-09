package com.leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleanArray {

    private static class Solution {
        int[] reset;
        int[] current;

        Random random;

        public Solution(int[] nums) {
            this.reset = Arrays.copyOf(nums, nums.length);
            this.current = Arrays.copyOf(nums, nums.length);
            this.random = new Random();
        }

        public int getRandomIndex(int start, int end) {
            int randomNumber = this.random.nextInt(end - start + 1);
            return start + randomNumber;
        }

        public int[] reset() {
            this.current = Arrays.copyOf(this.reset, this.reset.length);
            return this.current;
        }

        public int[] shuffle() {
            int totalNumbers = this.current.length;
            for (int index = 0; index < totalNumbers; ++index) {
                int randomIndex = getRandomIndex(index, totalNumbers - 1);
                int temp = this.current[randomIndex];
                this.current[randomIndex] = this.current[index];
                this.current[index] = temp;
            }
            return this.current;
        }
    }

    public static void main(String[] args) {
        Solution shuffle = new Solution(new int[]{1, 2, 3});

        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.reset()));
    }

}
