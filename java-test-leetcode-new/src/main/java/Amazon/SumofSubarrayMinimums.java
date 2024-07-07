package com.Amazon;

import java.util.Stack;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        Stack<Integer> s = new Stack<>();

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.peek();
            }
            s.add(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = n;
            } else {
                right[i] = s.peek();
            }
            s.add(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long contribution = ((long) arr[i] * (i - left[i]) * (right[i] - i)) % mod;
            result = (result + contribution + mod) % mod;
        }

        return (int) result;
    }
}
