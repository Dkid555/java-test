package com.Amazon;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0;
            int j = n - 1;
            for (int[] row : matrix) {
                while (j >= 0 && row[j] > mid)
                    j--;
                count += j + 1;
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}


//Given an n x n matrix where each of the rows and columns is sorted in
// ascending order, return the kth smallest element in the matrix.
//
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//You must find a solution with a memory complexity better than O(n2).