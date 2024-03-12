package com.meta.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SlowSums {
    static int getTotalTime(int[] arr) {
        // Write your code here
        if(arr.length == 0)
            return -1;
        else if(arr.length == 1)
            return arr[0];



        // Sort the array in descending order using streams
        arr = Arrays.stream(arr)
                .boxed() // Convert int to Integer
                .sorted(Comparator.reverseOrder()) // Sort in reverse order
                .mapToInt(Integer::intValue) // Convert back to int
                .toArray();
        int penalty = 0;
        // Perform the operations and calculate penalties
        for (int i = 1; i < arr.length; i++) {
            penalty += arr[i - 1] + arr[i];
            arr[i] += arr[i - 1];
        }

        return penalty;
    }

    public static void main(String[] args) {
        System.out.println(getTotalTime(new int[]{1, 2, 3, 4, 5}));
    }
}
//arr = [4, 2, 1, 3]
//output = 26
//First, add 4 + 3 for a penalty of 7. Now the array is [7, 2, 1]
//Add 7 + 2 for a penalty of 9. Now the array is [9, 1]
//Add 9 + 1 for a penalty of 10. The penalties sum to 26.

//Suppose we have a list of N numbers, and repeat the following
// operation until we're left with only a single number:
// Choose any two numbers and replace them with their sum.
// Moreover, we associate a penalty with each operation equal
// to the value of the new number, and call the penalty for the
// entire list as the sum of the penalties of each operation.
//For example, given the list [1, 2, 3, 4, 5], we could choose
// 2 and 3 for the first operation, which would transform the
// list into [1, 5, 4, 5] and incur a penalty of 5. The goal in
// this problem is to find the highest possible penalty for a given input.