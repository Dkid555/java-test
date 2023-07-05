package com.leetcode;


//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//countAndSay(1) = "1"
//countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
//
//For example, the saying and conversion for digit string "3322251":
public class CountandSay {
    //    static int counter;
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder strbuild = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            counter++;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                strbuild.append(counter).append(str.charAt(i));
                counter = 0;
            }
        }
        return strbuild.toString();
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
