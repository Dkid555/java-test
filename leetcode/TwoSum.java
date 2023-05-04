package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {

    public static <target> int[] twoSum(int[] nums, int target){
        HashMap m = new HashMap<Integer,Integer>();
        int n, diff;
        ArrayList list = new ArrayList<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; ++i){
            n = nums[i];
            diff = target - n;
            if (m.containsKey(Integer.valueOf(diff))) {
                list.add(m.get(diff));
                list.add(i);
                break;
            }
            m.put(n, i);
        }
        if (list.isEmpty() != true){
            arr[0] = (int) list.get(0);
            arr[1] = (int) list.get(1);

            return arr;
        }

        return null;
    }


    public static void main(String[] args) {

        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 2;

        System.out.println(twoSum(nums,3));

    }
}
