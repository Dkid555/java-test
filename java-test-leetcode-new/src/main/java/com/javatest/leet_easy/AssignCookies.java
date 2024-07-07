package com.javatest.leet_easy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] greed, int[] sizeOfCookies) {
        if (sizeOfCookies.length == 0) return 0;
        Arrays.sort(greed);
        Arrays.sort(sizeOfCookies);
        int maxCookieIndex = sizeOfCookies.length - 1;
        int count = 0;
        for (int i = greed.length - 1; i > -1; --i) {
            greed[i] = greed[i] - sizeOfCookies[maxCookieIndex--];
            if (greed[i] > 0) maxCookieIndex++;
            if (greed[i] <= 0) count++;
            if (maxCookieIndex < 0) break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}

//Assume you are an awesome parent and want to give your
// children some cookies. But, you should give each child at most one cookie.
//
//Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
// and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
// Your goal is to maximize the number of your content children and output the maximum number.