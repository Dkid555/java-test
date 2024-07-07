package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceNameSystem {
    public static List<String> deviceNamesSystem(List<String> devicenames) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String device : devicenames) {
            int current = map.getOrDefault(device, 0);
            map.put(device, current + 1);
            if (current > 0)
                device += current;
            result.add(device);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(deviceNamesSystem(List.of("mixer", "toaster", "toaster", "toaster", "mixer", "tv")));
    }
}
