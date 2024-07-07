package com.javatest.leetcode;

import java.util.Stack;

public class KthMissingPositiveNumber {

    private static int fillStack(Stack<Integer> stack, int k, int start, int end){
        while(start < end - 1 && stack.size() < k){
            stack.push(++start);
        }
        return stack.size() == k ? stack.pop() : -1;
    }

    public static int findKthPositive(int[] arr, int k) {
        int first = arr[0];
        Stack<Integer> stack = new Stack<>();
        int result = -1;
        if(first > 1)
            result = fillStack(stack, k, 0, first);
        if(result != -1)
            return result;

        for (int i = 1; i < arr.length; ++i){
            int second = arr[i];
            if(first < second)
                result = fillStack(stack, k, first ,second);
            if(result != -1)
                return result;
            first = second;
        }
        if(result == -1){
            int last = arr[arr.length - 1];
            result = fillStack(stack, k, last, 10000);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }
}
