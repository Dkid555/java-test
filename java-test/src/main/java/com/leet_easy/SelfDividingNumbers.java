package com.leet_easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean check = true;
            for (char c : String.valueOf(i).toCharArray()) {
                if (c == '0' || i % (c - '0') != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }
}
