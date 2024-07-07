package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        int len = pattern.length();
        for (String query : queries) {
            int start = 0;
            int j;
            for (j = 0; j < query.length(); j++) {
                if (start < len && query.charAt(j) == pattern.charAt(start)) {
                    start++;
                } else {
                    if ((int) query.charAt(j) >= 65 && (int) query.charAt(j) <= 90) {
                        ans.add(false);
                        break;
                    }
                }
            }

            if (j == query.length() && start == len) ans.add(true);
            if (j == query.length() && start != len) ans.add(false);
        }
        return ans;
    }
}
