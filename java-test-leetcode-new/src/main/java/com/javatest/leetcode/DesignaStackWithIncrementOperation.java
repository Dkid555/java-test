package com.javatest.leetcode;

public class DesignaStackWithIncrementOperation {
    private static class CustomStack {
        int[] arr;
        int filled;
        int maxSize;

        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            filled = -1;
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (filled < maxSize - 1) {
                arr[++filled] = x;
            }
        }

        public int pop() {
            if (filled == -1) {
                return -1;
            }
            return arr[filled--];
        }

        public void increment(int k, int val) {
            int margin = (int) Math.min(k, arr.length);
            for (int i = 0; i < margin; i++) {
                arr[i] += val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.increment(4, 100);
        System.out.println(stack.pop());
        ;

    }
}
