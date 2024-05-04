package com.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ThreeSumWithMultiplicity {
    private static class TwoPoint{
        private int point_1;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TwoPoint twoPoint)) return false;
            return point_1 == twoPoint.point_1 && point_2 == twoPoint.point_2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(point_1, point_2);
        }

        private int point_2;

        public TwoPoint(int point_1, int point_2) {
            this.point_1 = point_1;
            this.point_2 = point_2;
        }
    }
    public static int threeSumMulti2(int[] arr, int target) {
        Map<Integer, Map<TwoPoint, Integer>> map_of_sum = new HashMap<>();
        int max_sum = 0;
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j){
                int sum = arr[i] + arr[j];
                map_of_sum.putIfAbsent(sum, new HashMap<>());
                TwoPoint twoPoint = new TwoPoint(arr[i], arr[j]);
                TwoPoint twoPoint1 = new TwoPoint(arr[j], arr[i]);
                map_of_sum.get(sum).put(twoPoint, map_of_sum.get(sum).getOrDefault(twoPoint, 0) + 1);
                map_of_sum.get(sum).put(twoPoint1, map_of_sum.get(sum).getOrDefault(twoPoint1, 0) + 1);
                max_sum = Math.max(max_sum, sum);
            }

        int[] memo = new int[max_sum];
        int count = 0;
        for (int num : arr){
            if(memo[num] != 0){
                count += memo[num];
                continue;
            }
            int sum = target - num;
            if(map_of_sum.containsKey(sum)){
                int total = 0;
                for (int val : map_of_sum.get(sum).values()){
                    total += val % (1000000007);
                }
                memo[num] = total;
                count += total % (1000000007);
            }
        }
        return count;
    }

    public static int threeSumMulti(int[] arr, int target) {
        long[] nmap = new long[101];
        long ans = 0;
        for (int num : arr) nmap[num]++;
        for (int k = 100; k >= 0; k--)
            for (int j = k; j >= 0; j--) {
                int i = target - k - j;
                if (i > j || i < 0) continue;
                long x = nmap[i], y = nmap[j], z = nmap[k], res = x * y * z;
                if (res == 0) continue;
                if (i == k) res = x * (x-1) * (x-2) / 6;
                else if (i == j) res = x * (x-1) / 2 * z;
                else if (j == k) res = x * y * (y-1) / 2;
                ans += res;
            }
        return (int)(ans % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
