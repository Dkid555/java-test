package com.javatest.meta.other;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] wordS = new int[200];
        int[] wordT = new int[200];
        for(int i = 0; i < s.length(); i++){
            if(wordS[s.charAt(i)] != wordT[t.charAt(i)]) return false;
            wordS[s.charAt(i)] = i+1;
            wordT[t.charAt(i)] = i+1;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
