package com.Amazon.Arrrays;

import java.util.Arrays;

public class Merge_two_Arrays_O1 {

    static void merge(int arr1[], int arr2[], int arr1_size, int arr2_size)
    {
        // three pointers to iterate
        int i = 0, j = 0, k = 0;

        // for euclid's division lemma
        int x = 10000000 + 7;

        // in this loop we are rearranging the elements of
        // arr1
        while (i < arr1_size && (j < arr1_size && k < arr2_size)) {

            // if both arr1 and arr2 elements are modified
            if (arr1[j] >= x && arr2[k] >= x) {
                if (arr1[j] % x <= arr2[k] % x) {
                    arr1[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr1[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr1 elements are modified
            else if (arr1[j] >= x) {
                if (arr1[j] % x <= arr2[k]) {
                    arr1[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr1[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr2 elements are modified
            else if (arr2[k] >= x) {
                if (arr1[j] <= arr2[k] % x) {
                    arr1[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr1[i] += (arr2[k++] % x) * x;
                }
            }

            // if none elements are modified
            else {
                if (arr1[j] <= arr2[k]) {
                    arr1[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr1[i] += (arr2[k++] % x) * x;
                }
            }
            i++;
        }

        // we can copy the elements directly as the other
        // array is exchausted
        while (j < arr1_size && i < arr1_size) {
            arr1[i++] += (arr1[j++] % x) * x;
        }
        while (k < arr2_size && i < arr1_size) {
            arr1[i++] += (arr2[k++] % x) * x;
        }

        // we need to reset i
        i = 0;

        // in this loop we are rearranging the elements of
        // arr2
        while (i < arr2_size && (j < arr1_size && k < arr2_size)) {

            // if both arr1 and arr2 elements are modified
            if (arr1[j] >= x && arr2[k] >= x) {
                if (arr1[j] % x <= arr2[k] % x) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr1 elements are modified
            else if (arr1[j] >= x) {
                if (arr1[j] % x <= arr2[k]) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr2 elements are modified
            else if (arr2[k] >= x) {
                if (arr1[j] <= arr2[k] % x) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }
            else {

                // if none elements are modified
                if (arr1[j] <= arr2[k]) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }
            i++;
        }

        // we can copy the elements directly as the other
        // array is exhausted
        while (j < arr1_size && i < arr2_size) {
            arr2[i++] += (arr1[j++] % x) * x;
        }
        while (k < arr2_size && i < arr2_size) {
            arr2[i++] += (arr2[k++] % x) * x;
        }

        // we need to reset i
        i = 0;

        // we need to divide the whole arr1 by x
        while (i < arr1_size) {
            arr1[i++] /= x;
        }

        // we need to reset i
        i = 0;

        // we need to divide the whole arr2 by x
        while (i < arr2_size) {
            arr2[i++] /= x;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 10, 12, 11};
        int[] arr2 = new int[]{1, 4, 5, 6, 6};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

}
