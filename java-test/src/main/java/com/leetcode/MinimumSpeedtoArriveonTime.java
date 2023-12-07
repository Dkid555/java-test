package com.leetcode;

public class MinimumSpeedtoArriveonTime {
    public boolean isPossible(double speed, int[] dist, double hour) {
        double totalHoursRequired = 0;
        for (int i = 0; i < dist.length - 1; ++i) {
            totalHoursRequired += Math.ceil(dist[i] / speed);
            if (totalHoursRequired > hour)
                return false;
        }
        totalHoursRequired += dist[dist.length - 1] / speed;
        return totalHoursRequired <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int) 1e7;
        int ans = -1;

//        int max = dist[0];
//        for (int i = 1; i < dist.length; i ++) {
//            max = Math.max(dist[i], max);
//        }
//        int right = max > (dist[dist.length - 1] / (hour + 1 - dist.length)) ? max : (int)((double)dist[dist.length - 1] / (double)(hour + 1 - dist.length)) + 1;

        while (left <= right) {
            int mid_speed = left + ((right - left) / 2);
            if (isPossible((double) mid_speed, dist, hour)) {
                ans = mid_speed;
                right = mid_speed - 1;
            } else
                left = mid_speed + 1;
        }
        return ans;
    }

}

class Main2 {
    public static void main(String[] args) {
        System.out.println(new MinimumSpeedtoArriveonTime().minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
    }
}
//public boolean isPossible(double speed, int[] dist, double hour){
//        double total_hour_so_far = 0;
//        for(int it = 0; it < dist.length - 1; ++it){
//            double h = dist[it]/speed;
//            total_hour_so_far += Math.ceil(h);
//
//            if(total_hour_so_far > hour)
//                return false;
//        }
//            total_hour_so_far += dist[dist.length - 1] / speed;
//        return total_hour_so_far <= hour;
//    }
//    public int minSpeedOnTime(int[] dist, double hour) {
//        int low = 1;
//        int high = (int)1e7;
//        int ans = -1;
//
//        while(low <= high){
//            int mid_speed = low + (high - low)/2;
//            if(isPossible((double) mid_speed, dist, hour)){
//                ans = mid_speed;
//                high = mid_speed - 1;
//            }else{
//                low = mid_speed + 1;
//            }
//        }
//        return ans;
//    }