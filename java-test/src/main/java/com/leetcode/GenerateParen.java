package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {
    public static void Gen(List<String> fin, String s, int left, int right) {
        if (left == 0 && right == 0) { // base case: no more parentheses to add
            fin.add(s);// add the generated string to the result list
            return;// exit the current recursive call
        }
        if (left > 0)
            Gen(fin, s + "(", left - 1, right);// if there are still left parentheses to add // add a left parenthesis and recursively call the function
        if (right > left)
            Gen(fin, s + ")", left, right - 1); // if there are still right parentheses to add and there are more left parentheses than right parentheses in the current string
        // add a right parenthesis and recursively call the function
    }


    public static void main(String[] args) {
        int n = 5;
        List<String> fin = new ArrayList<>();
        Gen(fin, "", n, n);
        System.out.println(fin.stream().toString());
    }
}
