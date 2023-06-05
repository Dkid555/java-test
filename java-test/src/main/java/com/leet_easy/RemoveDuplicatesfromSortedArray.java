package com.leet_easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        //copy unique element back to array
        int i = 0;

        for(int ele:set){
            nums[i++] = ele;
        }
        return set.size();
    }*/

public class RemoveDuplicatesfromSortedArray {

    // If you just need to find size of set from list)
    static void find(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        System.out.println(set.size());
    }

    static int removeDuplicates(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pointer] != nums[i]) {
                nums[++pointer] = nums[i];
            }
        }
        return ++pointer;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 0, 0, 0, 3, 3};
        find(nums);
        System.out.println(removeDuplicates(nums));
    }
}
