package com.leet_easy;

public class TitleToNumber {
    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = (ans * 26) + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("X"));
    }
}
//Just thought of checking over characters iteraing forward.
//Some test cases:
//
//A - 1 (can be seen as - (0+1))
//AA - 27 (can be seen as - ((26+1))
//CA - 79 (can be seen as -(3*26+1))