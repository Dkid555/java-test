package com.javatest.leetcode;

public class DistanceBetweenBusStops {
    static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum = 0;
        for(int i = start; i <  destination; i++){
            sum += distance[i];
        }
        int disSum = 0;
        for(int dis : distance){
            disSum += dis;
        }
        return Math.min(sum, disSum-sum);
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4}, 0 ,3));
    }
}
