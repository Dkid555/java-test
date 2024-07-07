package com.javatest.leet_easy;

import java.util.Arrays;

public class DivideaStringIntoGroupsofSizek {

    public static String[] divideString(String s, int k, char fill) {
        int length = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] res = new String[length];
        int i = 0;
        int index = 0;
        for (; i < s.length(); i += k) {
            if (i + k > s.length())
                break;
            res[index++] = s.substring(i, i + k);
        }
        if (i < s.length()) {
            res[index] = s.substring(i);
            res[index] = res[index] + String.valueOf(fill).repeat(k - res[index].length());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
}
//A string s can be partitioned into groups of size k using the following procedure:
//
//The first group consists of the first k characters
// of the string, the second group consists of the next k characters of the string,
// and so on. Each character can be a part of exactly one group.
//For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
//Note that the partition is done so that after removing the fill character from the last group (if it exists)
// and concatenating all the groups in order, the resultant string should be s.
//
//Given the string s, the size of each group k and the character fill, return a string array denoting
// the composition of every group s has been divided into, using the above procedure.