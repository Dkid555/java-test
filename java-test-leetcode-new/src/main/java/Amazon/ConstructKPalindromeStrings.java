package com.Amazon;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(len < k)
            return false;
        int[] char_map = new int[26];
        for(int i = 0; i < len; ++i){
            int ch = s.charAt(i) - 'a';
            ++char_map[ch];
        }
        int result = 0;
        for(int char_count : char_map){
            if((char_count & 1) == 1)
                ++result; /** мы всегда можем добавить пары,
                            а вот если нечетный то он полюбому формирует отдельный палинром (a x 3 -> 'xax') */
        }
        return result <= k;
    }
}
//Given a string s and an integer k,
// return true if you can use all the characters in s to construct k palindrome strings or false otherwise.