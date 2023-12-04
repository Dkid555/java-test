package com.leetcode;

import java.util.List;
import java.util.Map;

public class CountItemsMatchingaRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> mapOfRules = Map.of("type", 0, "color", 1, "name", 2);
        int indexRule = mapOfRules.get(ruleKey);
        return items.stream().filter(item -> item.get(indexRule).equals(ruleValue)).toList().size();
    }
}
