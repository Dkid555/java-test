package com.javatest.leetcode;

public class NumberofChangingKeys {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int switches = 0;
        for (int i = 1; i < s.length(); ++i){
            if(s.charAt(i - 1) == s.charAt(i))
                ++switches;
        }
        return switches;
    }
}
