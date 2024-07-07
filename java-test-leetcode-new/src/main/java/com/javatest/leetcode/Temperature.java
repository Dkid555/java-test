package com.javatest.leetcode;


import java.util.Stack;

/*
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day for which
 * this is possible, keep answer[i] == 0 instead.*/
public class Temperature {

    public static int[] waitdays(int[] temperatures) {
        int[] wait = new int[temperatures.length];
        Stack<TemperatureDays> stack = new Stack<>();
        int end = temperatures.length - 1;
        stack.push(new TemperatureDays(temperatures[end], end));
        end--;
        while (end >= 0) {
            if (!stack.isEmpty())
                while (!stack.isEmpty() && stack.peek().value < temperatures[end]) {
                    stack.pop();
                }
            if (!stack.isEmpty())
                wait[end] = stack.peek().index - end;
            stack.push(new TemperatureDays(temperatures[end], end));

            end--;
        }
        return wait;

    }

    public static void main(String[] args) {
        waitdays(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
    }
}

class TemperatureDays {
    int value;
    int index;

    public TemperatureDays(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
