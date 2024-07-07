package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class BeautifulArray {
    public static int[] beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while (ans.size() < n) {
            // create for store the formula
            ArrayList<Integer> temp = new ArrayList<>();
            //   odd
            ans.forEach(x -> {
                if (x * 2 - 1 <= n)
                    temp.add(x * 2 - 1);
            });
            //Even
            ans.forEach(x ->
            {
                if (x * 2 <= n)
                    temp.add(x * 2);
            });
            ans = temp;
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(5)));
    }
}
