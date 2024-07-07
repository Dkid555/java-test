package com.Amazon.Tree;

public class splitArray {
    static int minDiffSubArray(int arr[]){
        int total_sum = 0;
        for(int num : arr)
            total_sum += num;

        int prefix_sum = 0;
        int min_diff = Integer.MAX_VALUE;

        for (int num : arr){
            prefix_sum += num;

            int diff = Math.abs((total_sum - prefix_sum) - prefix_sum);

            min_diff = Math.min(diff, min_diff);
        }
        return min_diff;
    }

    static int minDiffSubArrayAVG(int arr[]){
        int total_sum = 0;
        for(int num : arr)
            total_sum += num;

        int total_am_in_arr = arr.length;
        int count = 0;
        int prefix_sum = 0;
        double min_diff = Double.MAX_VALUE;
        int result = 0;
        for (int num : arr){
            prefix_sum += num;
            ++count;
            if(count == total_am_in_arr) break;
            double avg_pref_sum = (double)prefix_sum / count;

            double diff = Math.abs((((double) total_sum - (double)prefix_sum)/(total_am_in_arr - count)) - avg_pref_sum);
            double prev_min = min_diff;
            min_diff = Math.min(diff, min_diff);
            if(prev_min != min_diff){
                result = count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minDiffSubArrayAVG(new int[]{1, 1, 1, -2}));
    }

}
//Split array into two subarrays such that difference of their sum is minimum