package com.leetcode;

import java.util.HashMap;
import java.util.Map;


/*
*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given
* number of rows like this: (you may want to display this pattern in a fixed
* font for better legibility)

* Input: s = "PAYPALISHIRING", numRows = 3
* Output: "PAHNAPLSIIGYIR"
*
*
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
*
* */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        String str = new String();
        Map<Integer, String> ZigZag = new HashMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); ) {
            if (index == numRows) {
                index -= 2;
                while (index != 0 && i < s.length()) {
                    ZigZag.put(index, ZigZag.getOrDefault(index, "") + s.charAt(i));
                    index--;
                    i++;
                }
                continue;
            }
            ZigZag.put(index, ZigZag.getOrDefault(index, "") + s.charAt(i));
            index++;
            i++;

        }
        for (Integer key : ZigZag.keySet()) {
            str += ZigZag.get(key);
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(convert("ISITWORLDSCOLLIDINGISITGONABE", 4));
    }
}
