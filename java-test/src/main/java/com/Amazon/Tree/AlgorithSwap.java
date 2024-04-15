package com.Amazon.Tree;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class AlgorithSwap {


    public static int minSwaps(int[] nums)
    {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], i);

        Arrays.sort(nums);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        // Initialize result
        int ans = 0;
        for (int i = 0; i < len; i++) {

            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(nums[i]) == i)
                continue; // на своем месте // индекс отсортированного совпадает с индексом в мапе

            int j = i, cycle_size = 0;
            while (!visited[j]) {
                visited[j] = true;

                // move to next node
                j = map.get(nums[j]);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1,7,5,2}));
    }
}
