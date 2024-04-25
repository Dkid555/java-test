package com.Amazon.Dynamic_Programming;

import java.util.ArrayDeque;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
//    public static int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//
//        int n = matrix[0].length;
//        int[] current_Row = new int[n];
//        int maxAns = 0; // Initialize the maximum answer
//
//        for (char[] row : matrix) {
//            for (int column = 0; column < n; column++) {
//                if (row[column] == '1') {
//                    current_Row[column] += 1;
//                } else {
//                    current_Row[column] = 0;
//                }
//            }
//
//            // Calculate the largest area in histogram for the current row
//            int curAns = largestAreaHistogram(current_Row);
//
//            // Update maxAns with the maximum of maxAns and curAns
//            maxAns = Math.max(maxAns, curAns);
//        }
//
//        return maxAns;
//    }
//
//    private static int largestAreaHistogram(int[] a) {
//        int n = a.length;
//        ArrayDeque<Integer> st = new ArrayDeque<>();
//        int[] leftSmall = new int[n];
//        int[] rightSmall = new int[n];
//
//        // Calculate leftSmalls
//        for (int i = 0; i < n; i++) {
//            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
//                st.pop();
//            }
//            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
//            st.push(i);
//        }
//
//        // Clear the stack
//        st.clear();
//
//        // Calculate rightSmalls
//        for (int i = n - 1; i >= 0; i--) {
//            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
//                st.pop();
//            }
//            rightSmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
//            st.push(i);
//        }
//
//        // Calculate the maximum area
//        int maxA = 0;
//        for (int i = 0; i < n; i++) {
//            maxA = Math.max(maxA, a[i] * (rightSmall[i] - leftSmall[i] + 1));
//        }
//        return maxA;
//    }
    public static int maximalRectangle(char[][] matrix) {
        int[] current_Row = new int[matrix[0].length];
        int max_Rectangle = 0;

        for (char[] row : matrix){
            for(int column = 0; column < row.length; ++column){
                if(row[column] == '1'){
                    ++current_Row[column];
                }
                if(row[column] == '0')
                    current_Row[column] = 0;
            }
            max_Rectangle = Math.max(calculate_for_this(current_Row), max_Rectangle);
        }
        return max_Rectangle;
    }
    private static int calculate_for_this(int[] current_Row){
        int n = current_Row.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        // Calculate leftSmalls
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && current_Row[stack.peek()] >= current_Row[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        // Clear the stack
        stack.clear();

        // Calculate rightSmalls
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && current_Row[stack.peek()] >= current_Row[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        // Calculate the maximum area
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, current_Row[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return max;
    }

}
