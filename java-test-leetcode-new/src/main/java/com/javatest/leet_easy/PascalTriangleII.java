package com.javatest.leet_easy;

import java.util.ArrayList;
import java.util.List;

//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//rowIndex = 3
//Output: [1,3,3,1]
public class PascalTriangleII {
    static List<Integer> generate(int rowIndex) {

        List<Integer> Base = new ArrayList<>();

        if (rowIndex == 0) {
            Base.add(1);
            return Base;
        }
//        Base.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(Base.get(j - 1) + Base.get(j));
            }
            temp.add(1);
            Base = temp;
        }
        return Base;
    }

    // Faster solution
    static List<Integer> generate2(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        long first = 1;
        result.add((int) first);
        for (int i = 1; i <= rowIndex; i++) {
            long second = ((first * (rowIndex - i + 1)) / i);
            result.add((int) second);
            first = second;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate2(3));
    }
}
