package com.javatest.leetcode;

public class NumberofSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int cnt_a = -1, cnt_b = -1, cnt_c = -1;

        int i = 0, res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                cnt_a = i;
            else if (ch == 'b')
                cnt_b = i;
            else
                cnt_c = i;

            if (i > 1)
                res += (Math.min(cnt_a, Math.min(cnt_b, cnt_c)) + 1);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
//Given a string s consisting only of characters a, b and c.
//
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.