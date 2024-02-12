package com.leetcode;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 0, len = 0; i < s.length(); i++){
            if(len > 0 && Math.abs(s.charAt(i) - result.charAt(len - 1)) == 32)
                result.setLength(--len);
            else{
                result.append(s.charAt(i));
                len++;
            }
        }
        return result.toString();
    }
}
