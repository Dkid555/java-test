package com.javatest.leetcode;

public class CountTestedDevicesAfterTestOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        int result = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - result > 0) {
                ++result;
            }
        }
        return result;
    }
}
