package com.Amazon;

import java.lang.ref.PhantomReference;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(decodeString("100[leetcode]"));
        //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
    }
    public static String decodeString(String s) {
        return decodeString(s, 0, 1, new int[]{0});
    }
    private static String decodeString(String s, int Start, int multiply, int[] max_reached) {
        StringBuilder result = new StringBuilder();
        int multiply_next = 0;
        for (int i = Start; i < s.length(); ++i){
            if(Character.isDigit(s.charAt(i))){
                multiply_next = multiply_next * 10 +  (s.charAt(i) - '0');
                continue;
            }
            if(s.charAt(i) == '['){
                result.append(decodeString(s, i + 1, multiply_next != 0 ? multiply_next : 1, max_reached));
                i = max_reached[0];
                multiply_next = 0;
                continue;
            }
            if(s.charAt(i) == ']'){
                max_reached[0] = Math.max(i, max_reached[0]);
                break;
            }else
                result.append(s.charAt(i));
            max_reached[0] = Math.max(i, max_reached[0]);
        }
        return result.toString().repeat(multiply);
    }

}
//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string],
// where the encoded_string inside the square
// brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always
// valid; there are no extra white spaces, square
// brackets are well-formed, etc. Furthermore, you may
// assume that the original data does not contain any digits
// and that digits are only for those repeat numbers, k. For
// example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output
// will never exceed 105.