package com.javatest.meta.other;

import java.util.*;

public class AnotherPreparation {

    public int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);
        int start = 0;
        for (int i = 1; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            // мы сравниваем начало и концы  (конец последнего интервала в merged больше чем начало следующего)
            if (interval[0] == merged.get(start)[0] || merged.get(start)[1] >= interval[0]) {
                merged.get(start)[1] = Math.max(merged.get(start)[1], interval[1]);
            } else {
                merged.add(interval);
                ++start;
            }

        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int subArraySumEqualsK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int first = nums[i];
            int diff = k - first;
            if (diff > 0) {
                for (int j = i + 1; j < nums.length; ++j) {
                    diff -= nums[j];
                    if (diff == 0) {
                        ++count;
                        break;
                    } else if (diff < 0) {
                        break;
                    }

                }
            } else if (diff == 0) {
                ++count;
            }
        }
        return count;
    }

    //Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    //
    //A subarray is a contiguous non-empty sequence of elements within an array.
    public static int subArraySumEqualsK_Better(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int sum = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static int[][] K_closest_points(int[][] Points, int k) {
        // default point = {0, 0}
        // d = sqrt((x2 - x1)^2 + (y2 - y1) ^ 2)

        Map<Double, List<int[]>> map_of = new HashMap<>();

        for (int[] Point : Points) {
            double d = Math.sqrt(Math.pow((Point[0]), 2) + Math.pow((Point[1]), 2));
            List<int[]> temp = map_of.getOrDefault(d, new ArrayList<>());
            temp.add(Point);
            map_of.put(d, temp);
        }
        Set<Double> keys = map_of.keySet();

        List<Double> key_list = new ArrayList<>(keys);
        Collections.sort(key_list);
        List<int[]> result = new ArrayList<>();
        for (double key : key_list) {
            List<int[]> temp = map_of.get(key);
            for (int[] r : temp) {
                result.add(r);
                if (--k == 0)
                    break;
            }
            if (k == 0)
                break;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] K_closest_points2(int[][] Points, int k) {
        // default point = {0, 0}
        // d = sqrt((x2 - x1)^2 + (y2 - y1) ^ 2)

//        Arrays.sort(Points, (a , b) ->
//                ( (a[0] * a[0] + a[1] * a[1])  - (b[0] * b[0] + b[1] * b[1])));
        Arrays.sort(Points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        return Arrays.copyOfRange(Points, 0, k);
    }

//    public int basicCalculator(String toCompute){
//        //+ - * /, ' '
//        int result = 0;
//
//
//
//    }


    public static void main(String[] args) {
        System.out.println(subArraySumEqualsK(new int[]{5, 1, 2, 3}, 5));
    }

}
