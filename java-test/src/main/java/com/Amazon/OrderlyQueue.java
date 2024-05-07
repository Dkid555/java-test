package com.Amazon;

import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String result = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length() - 1; ++i) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(result) < 0) {
                    result = sb.toString();
                }
            }
            return result;
        }
        char[] x = s.toCharArray();
        Arrays.sort(x);
        return String.valueOf(x);
    }
}
