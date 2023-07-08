package com.leetcode;

import java.util.PriorityQueue;


//Given a positive integer num, split it into two non-negative integers num1 and num2 such that:
//
//The concatenation of num1 and num2 is a permutation of num.
//In other words, the sum of the number of occurrences of each
// digit in num1 and num2 is equal to the number of occurrences of that digit in num.
//num1 and num2 can contain leading zeros.
//Return the minimum possible sum of num1 and num2.
//
//Notes:
//
//It is guaranteed that num does not contain any leading zeros.
//The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.
public class SplitwithMinimumSum {
    public static int splitNum(int num) {
        String number = String.valueOf(num);
        String num1 = "";
        String num2 = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < number.length(); i++) {
            pq.add(number.charAt(i) - '0');
        }
        while (!pq.isEmpty()) {
            num1 += pq.poll();
            if (!pq.isEmpty()) num2 += pq.poll();
        }
        return (!num2.isEmpty()) ?
                Integer.parseInt(num1) + Integer.parseInt(num2) : Integer.parseInt(num1);

    }

    public static void main(String[] args) {
        System.out.println(splitNum(4325));
    }
}
